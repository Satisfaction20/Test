package de.ragecraft.activitylogsystem;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {
	
	public static String ingameprefix = "§8[§4ActivityLog-System§8] ";
	public static String consoleprefix = "[ActivityLog-System] ";
	
	@Override
	public void onEnable() {
		System.out.println(Main.consoleprefix + "Das Plugin wird aktiviert...");
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new CommandActivitylog("activitilog"));
		MySQL.connect();
		MySQL.update("CREATE TABLE IF NOT EXISTS Reports (Teammitglied VARCHAR(100),ID VARCHAR(100),Zeitpunkt VARCHAR(100))");
		MySQL.update("CREATE TABLE IF NOT EXISTS Bans (Teammitglied VARCHAR(100),ID VARCHAR(100),Zeitpunkt VARCHAR(100))");
		MySQL.update("CREATE TABLE IF NOT EXISTS Unbans (Teammitglied VARCHAR(100),ID VARCHAR(100),Zeitpunkt VARCHAR(100))");
		MySQL.update("CREATE TABLE IF NOT EXISTS Mutes (Teammitglied VARCHAR(100),ID VARCHAR(100),Zeitpunkt VARCHAR(100))");
		MySQL.update("CREATE TABLE IF NOT EXISTS Unmutes (Teammitglied VARCHAR(100),ID VARCHAR(100),Zeitpunkt VARCHAR(100))");
		MySQL.update("CREATE TABLE IF NOT EXISTS Kicks (Teammitglied VARCHAR(100),ID VARCHAR(100),Zeitpunkt VARCHAR(100))");
		MySQL.update("CREATE TABLE IF NOT EXISTS Chatclears (Teammitglied VARCHAR(100),ID VARCHAR(100),Zeitpunkt VARCHAR(100))");
		MySQL.update("CREATE TABLE IF NOT EXISTS Chatmutes (Teammitglied VARCHAR(100),ID VARCHAR(100),Zeitpunkt VARCHAR(100))");
		MySQL.update("CREATE TABLE IF NOT EXISTS Chatunmutes (Teammitglied VARCHAR(100),ID VARCHAR(100),Zeitpunkt VARCHAR(100))");
		MySQL.update("CREATE TABLE IF NOT EXISTS Supports (Teammitglied VARCHAR(100),ID VARCHAR(100),Zeitpunkt VARCHAR(100))");
		super.onEnable();
		System.out.println(Main.consoleprefix + "Das Plugin wurde erfolgreich aktiviert!");
	}
	
	@Override
	public void onDisable() {
		System.out.println(Main.consoleprefix + "Das Plugin wird deaktiviert...");
		MySQL.disconnect();
		super.onDisable();
		System.out.println(Main.consoleprefix + "Das Plugin wurde erfolgreich deaktiviert!");
	}

}
