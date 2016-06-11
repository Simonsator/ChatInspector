package de.simonsator.chatinspector.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import de.simonsator.chatinspector.main.Main;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ChatListener implements Listener {
	private List<String> forbidden;
	private ArrayList<ProxiedPlayer> playersWhoWroteFast1 = new ArrayList<ProxiedPlayer>();
	private ArrayList<ProxiedPlayer> playersWhoWroteFast2 = new ArrayList<ProxiedPlayer>();

	private HashMap<ProxiedPlayer, String> written = new HashMap<ProxiedPlayer, String>();

	public ChatListener(List<String> list) {
		forbidden = list;
	}

	@EventHandler
	public void onChat(ChatEvent pEvent) {
		final ProxiedPlayer p = (ProxiedPlayer) pEvent.getSender();
		if (!p.hasPermission("chatcontroller.ignore")) {
			String message = pEvent.getMessage().toLowerCase();
			if (message.startsWith("/")) {
				return;
			}
			for (String forbiddenWord : forbidden)
				if (message.contains(forbiddenWord)) {
					p.sendMessage(new TextComponent(Main.getInstance().getChatPrefix()
							+ Main.getInstance().getConfig().getString("Messages.DoNotWriteThat")));
					pEvent.setCancelled(true);
					return;
				}
			if (written.containsKey(p)) {
				if (written.get(p).equals(message)) {
					p.sendMessage(new TextComponent(Main.getInstance().getChatPrefix()
							+ Main.getInstance().getConfig().getString("Messages.YouAreReapiting")));
					pEvent.setCancelled(true);
					return;
				}
			}
			written.put(p, message);
			if (playersWhoWroteFast2.contains(p)) {
				p.sendMessage(new TextComponent(Main.getInstance().getChatPrefix()
						+ Main.getInstance().getConfig().getString("Messages.WritingToFast")));
				pEvent.setCancelled(true);
				return;
			}
			if (playersWhoWroteFast1.contains(p)) {
				playersWhoWroteFast2.add(p);
				ProxyServer.getInstance().getScheduler().schedule(Main.getInstance(), new Runnable() {
					public void run() {
						playersWhoWroteFast2.remove(p);
					}
				}, 2, TimeUnit.SECONDS);
				return;
			}
			playersWhoWroteFast1.add(p);
			ProxyServer.getInstance().getScheduler().schedule(Main.getInstance(), new Runnable() {
				public void run() {
					playersWhoWroteFast1.remove(p);
				}
			}, 2, TimeUnit.SECONDS);
		}
	}
}