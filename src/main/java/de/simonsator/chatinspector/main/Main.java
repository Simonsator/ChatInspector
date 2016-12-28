package de.simonsator.chatinspector.main;

import de.simonsator.chatinspector.listener.ChatListener;
import de.simonsator.chatinspector.utilities.ChatInspectorConfig;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

import java.io.File;
import java.io.IOException;

public class Main extends Plugin {

	@Override
	public void onEnable() {
		try {
			Configuration config = (new ChatInspectorConfig(new File(getDataFolder(), "config.yml"))).getCreatedConfiguration();
			ProxyServer.getInstance().getPluginManager().registerListener(this,
					new ChatListener(this, config.getStringList("ForbiddenWords"), config));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}