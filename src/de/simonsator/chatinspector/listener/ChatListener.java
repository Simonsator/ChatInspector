package de.simonsator.chatinspector.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import de.simonsator.chatinspector.main.Main;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ChatListener implements Listener {
	private ArrayList<String> forbidden;
	private ArrayList<ProxiedPlayer> playersWhoWroteFast1 = new ArrayList<ProxiedPlayer>();
	private ArrayList<ProxiedPlayer> playersWhoWroteFast2 = new ArrayList<ProxiedPlayer>();

	private HashMap<ProxiedPlayer, String> geschrieben = new HashMap<ProxiedPlayer, String>();

	public ChatListener(ArrayList<String> pVerboten) {
		forbidden = pVerboten;
	}

	@EventHandler
	public void onChat(ChatEvent pEvent) {
		final ProxiedPlayer p = (ProxiedPlayer) pEvent.getSender();
		if (!p.hasPermission("chatcontroller.ignore")) {
			String message = pEvent.getMessage().toLowerCase();
			if (message.startsWith("/")) {
				return;
			}
			for (String verbotenesWort : forbidden) {
				if (message.contains(verbotenesWort)) {
					p.sendMessage(new TextComponent(
							Main.main.chatPrefix + Main.main.config.getString("Messages.DoNotWriteThat")));
					pEvent.setCancelled(true);
					return;
				}
			}
			if (geschrieben.containsKey(p)) {
				if (geschrieben.get(p).equals(message)) {
					p.sendMessage(new TextComponent(
							Main.main.chatPrefix + Main.main.config.getString("Messages.YouAreReapiting")));
					pEvent.setCancelled(true);
					return;
				}
			}
			geschrieben.put(p, message);
			if (playersWhoWroteFast2.contains(p)) {
				p.sendMessage(
						new TextComponent(Main.main.chatPrefix + Main.main.config.getString("Messages.WritingToFast")));
				pEvent.setCancelled(true);
				return;
			}
			if (playersWhoWroteFast1.contains(p)) {
				playersWhoWroteFast2.add(p);
				BungeeCord.getInstance().getScheduler().schedule(Main.main, new Runnable() {
					public void run() {
						playersWhoWroteFast2.remove(p);
					}
				}, 2, TimeUnit.SECONDS);
				return;
			}
			playersWhoWroteFast1.add(p);
			BungeeCord.getInstance().getScheduler().schedule(Main.main, new Runnable() {

				public void run() {
					playersWhoWroteFast1.remove(p);
				}
			}, 2, TimeUnit.SECONDS);
		}
	}
}