package de.simonsator.chatinspector.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import de.simonsator.chatinspector.listener.ChatListener;
import de.simonsator.chatinspector.utilities.Config;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

public class Main extends Plugin {
	public static Main main;
	public String chatPrefix = "§6[§1ChatController§6] ";
	public Configuration config;

	public void onEnable() {
		main = this;
		try {
			config = Config.ladeConfig();
		} catch (IOException e) {
			e.printStackTrace();
		}
		chatPrefix = config.getString("Messages.ChatPrefix");
		checkForUpdates();
		registerListeners();
		this.getProxy().getConsole().sendMessage(new TextComponent(chatPrefix + "§5ChatController was activated."));
	}

	private void registerListeners() {
		ArrayList<String> verboten = (ArrayList<String>) config.getStringList("ForbiddenWords");
		BungeeCord.getInstance().getPluginManager().registerListener(this, new ChatListener(verboten));
	}

	public void onDisable() {
		this.getProxy().getConsole().sendMessage(new TextComponent(chatPrefix + "§5ChatController was disabled."));
	}

	private void checkForUpdates() {
		String localVersion = getDescription().getVersion();
		try {
			HttpURLConnection con = (HttpURLConnection) new URL("http://www.spigotmc.org/api/general.php")
					.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.getOutputStream()
					.write(("key=98BE0FE67F88AB82B4C197FAF1DC3B69206EFDCC4D3B80FC83A00037510B99B4&resource=12238")
							.getBytes("UTF-8"));
			String version = new BufferedReader(new InputStreamReader(con.getInputStream())).readLine();
			if (localVersion.equalsIgnoreCase(version)) {

			} else {
				this.getProxy().getConsole()
						.sendMessage(new TextComponent(chatPrefix + "You need to update your version"));
			}
		} catch (IOException e) {
			this.getProxy().getConsole()
					.sendMessage(new TextComponent(chatPrefix + "It occourd an error, while searching for updates"));
			e.printStackTrace();
		}
	}

}