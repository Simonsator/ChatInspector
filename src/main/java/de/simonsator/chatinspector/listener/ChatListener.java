package de.simonsator.chatinspector.listener;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.event.EventHandler;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class ChatListener implements Listener {
	private final List<String> FORBIDDEN;
	private final String SLASH = "/";
	private final TextComponent DO_NOT_WRITE_THAT;
	private final TextComponent YOU_ARE_REPEATING_YOURSELF;
	private final TextComponent WRITING_TO_FAST;
	private final String PERMISSION;
	private final Plugin PLUGIN;
	private Set<ProxiedPlayer> playersWhoWroteFast1 = new HashSet<ProxiedPlayer>();
	private Set<ProxiedPlayer> playersWhoWroteFast2 = new HashSet<ProxiedPlayer>();
	private Map<ProxiedPlayer, String> written = new HashMap<ProxiedPlayer, String>();

	public ChatListener(Plugin pPlugin, List<String> pList, Configuration pConfig) {
		PLUGIN = pPlugin;
		for (int i = 0; i < pList.size(); i++)
			pList.set(i, pList.get(i).toLowerCase());
		FORBIDDEN = pList;
		PERMISSION = pConfig.getString("Permission.Ignore");
		String chatPrefix = pConfig.getString("Messages.ChatPrefix");
		DO_NOT_WRITE_THAT = new TextComponent(chatPrefix + pConfig.getString("Messages.DoNotWriteThat"));
		YOU_ARE_REPEATING_YOURSELF = new TextComponent(chatPrefix + pConfig.getString("Messages.YouAreRepeating"));
		WRITING_TO_FAST = new TextComponent(chatPrefix + pConfig.getString("Messages.WritingToFast"));
	}

	@EventHandler
	public void onChat(ChatEvent pEvent) {
		final ProxiedPlayer p = (ProxiedPlayer) pEvent.getSender();
		if (!p.hasPermission(PERMISSION)) {
			String message = pEvent.getMessage().toLowerCase();
			if (message.startsWith(SLASH))
				return;
			for (String forbiddenWord : FORBIDDEN)
				if (message.contains(forbiddenWord)) {
					p.sendMessage(DO_NOT_WRITE_THAT);
					pEvent.setCancelled(true);
					return;
				}
			if (written.containsKey(p)) {
				if (written.get(p).equals(message)) {
					p.sendMessage(YOU_ARE_REPEATING_YOURSELF);
					pEvent.setCancelled(true);
					return;
				}
			}
			written.put(p, message);
			if (playersWhoWroteFast2.contains(p)) {
				p.sendMessage(WRITING_TO_FAST);
				pEvent.setCancelled(true);
				return;
			}
			if (playersWhoWroteFast1.contains(p)) {
				playersWhoWroteFast2.add(p);
				ProxyServer.getInstance().getScheduler().schedule(PLUGIN, new Runnable() {
					public void run() {
						playersWhoWroteFast2.remove(p);
					}
				}, 2, TimeUnit.SECONDS);
				return;
			}
			playersWhoWroteFast1.add(p);
			ProxyServer.getInstance().getScheduler().schedule(PLUGIN, new Runnable() {
				public void run() {
					playersWhoWroteFast1.remove(p);
				}
			}, 2, TimeUnit.SECONDS);
		}
	}
}