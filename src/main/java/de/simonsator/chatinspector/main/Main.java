package de.simonsator.chatinspector.main;

import java.io.IOException;

import de.simonsator.chatinspector.listener.ChatListener;
import de.simonsator.chatinspector.utilities.Config;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

public class Main extends Plugin {
	private static Main main;
	private String chatPrefix = "§6[§1ChatController§6] ";
	private Configuration config;

	@Override
	public void onEnable() {
		main = (this);
		try {
			config = (Config.loadConfig());
		} catch (IOException e) {
			e.printStackTrace();
		}
		chatPrefix = getConfig().getString("Messages.ChatPrefix");
		registerListeners();
		this.getProxy().getConsole().sendMessage(new TextComponent(chatPrefix + "§5ChatController was activated."));
	}

	private void registerListeners() {
		ProxyServer.getInstance().getPluginManager().registerListener(this,
				new ChatListener(getConfig().getStringList("ForbiddenWords")));
	}

	public static Main getInstance() {
		return main;
	}

	public Configuration getConfig() {
		return config;
	}

	public String getChatPrefix() {
		return chatPrefix;
	}
}