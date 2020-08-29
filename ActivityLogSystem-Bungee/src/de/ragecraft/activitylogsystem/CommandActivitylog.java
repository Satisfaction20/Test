package de.ragecraft.activitylogsystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CommandActivitylog extends Command {

	public CommandActivitylog(String name) {
		super(name);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		
		int counter = 0;
		
		if (sender instanceof ProxiedPlayer) {
			ProxiedPlayer pp = (ProxiedPlayer) sender;
			if (pp.hasPermission("activitylogsystem.use")) {
				if (args.length < 2) {
					pp.sendMessage(Main.ingameprefix + "§cBitte verwende §e/activitylog §b<§eSpielername§b> §b<§eTyp§b>§c!");
				} else {
					if (MySQL.isConnected()) {
						if (args[1].equalsIgnoreCase("reports")) {
							DataManager.staffName = args[0];
							DataManager.type = args[1];
							pp.sendMessage(Main.ingameprefix + "§eDer §aReport-Log §edes Spielers §9" + args[0] + " §ewird eingelesen...");
							pp.sendMessage(Main.ingameprefix + "§aReport-Log §edes Spielers §9" + args[0] + "§e:");
							pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
							try {
								PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM reports WHERE Teammitglied = ?");
								ps.setString(1, DataManager.staffName);
								ResultSet rs = ps.executeQuery();
								while (rs.next()) {
									DataManager.id = rs.getString("ReportID");
									DataManager.time = rs.getString("Zeitpunkt");
									pp.sendMessage(Main.ingameprefix + "§6Report-ID §b» §9" + DataManager.id);
									pp.sendMessage(Main.ingameprefix + "§6Zeitpunkt §b» §9" + DataManager.time);
									pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
									counter++;
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
							pp.sendMessage(Main.ingameprefix + "§eEinträge insgesamt §b» §9" + counter);
							pp.sendMessage(Main.ingameprefix + "§cEs sind keine weiteren Einträge vorhanden!");
						} else {
							if (args[1].equalsIgnoreCase("bans")) {
								DataManager.staffName = args[0];
								DataManager.type = args[1];
								pp.sendMessage(Main.ingameprefix + "§eDer §aBan-Log §edes Spielers §9" + args[0] + " §ewird eingelesen...");
								pp.sendMessage(Main.ingameprefix + "§aBan-Log §edes Spielers §9" + args[0] + "§e:");
								pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
								try {
									PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM bans WHERE Teammitglied = ?");
									ps.setString(1, DataManager.staffName);
									ResultSet rs = ps.executeQuery();
									while (rs.next()) {
										DataManager.id = rs.getString("BanID");
										DataManager.time = rs.getString("Zeitpunkt");
										pp.sendMessage(Main.ingameprefix + "§6Ban-ID §b» §9" + DataManager.id);
										pp.sendMessage(Main.ingameprefix + "§6Zeitpunkt §b» §9" + DataManager.time);
										pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
										counter++;
									}
								} catch (SQLException e) {
									e.printStackTrace();
								}
								pp.sendMessage(Main.ingameprefix + "§eEinträge insgesamt §b» §9" + counter);
								pp.sendMessage(Main.ingameprefix + "§cEs sind keine weiteren Einträge vorhanden!");
							} else {
								if (args[1].equalsIgnoreCase("mutes")) {
									DataManager.staffName = args[0];
									DataManager.type = args[1];
									pp.sendMessage(Main.ingameprefix + "§eDer §aMute-Log §edes Spielers §9" + args[0] + " §ewird eingelesen...");
									pp.sendMessage(Main.ingameprefix + "§aMute-Log §edes Spielers §9" + args[0] + "§e:");
									pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
									try {
										PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM mutes WHERE Teammitglied = ?");
										ps.setString(1, DataManager.staffName);
										ResultSet rs = ps.executeQuery();
										while (rs.next()) {
											DataManager.id = rs.getString("MuteID");
											DataManager.time = rs.getString("Zeitpunkt");
											pp.sendMessage(Main.ingameprefix + "§6Mute-ID §b» §9" + DataManager.id);
											pp.sendMessage(Main.ingameprefix + "§6Zeitpunkt §b» §9" + DataManager.time);
											pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
											counter++;
										}
									} catch (SQLException e) {
										e.printStackTrace();
									}
									pp.sendMessage(Main.ingameprefix + "§eEinträge insgesamt §b» §9" + counter);
									pp.sendMessage(Main.ingameprefix + "§cEs sind keine weiteren Einträge vorhanden!");
								} else {
									if (args[1].equalsIgnoreCase("kicks")) {
										DataManager.staffName = args[0];
										DataManager.type = args[1];
										pp.sendMessage(Main.ingameprefix + "§eDer §aKick-Log §edes Spielers §9" + args[0] + " §ewird eingelesen...");
										pp.sendMessage(Main.ingameprefix + "§aKick-Log §edes Spielers §9" + args[0] + "§e:");
										pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
										try {
											PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM kicks WHERE Teammitglied = ?");
											ps.setString(1, DataManager.staffName);
											ResultSet rs = ps.executeQuery();
											while (rs.next()) {
												DataManager.id = rs.getString("KickID");
												DataManager.time = rs.getString("Zeitpunkt");
												pp.sendMessage(Main.ingameprefix + "§6Kick-ID §b» §9" + DataManager.id);
												pp.sendMessage(Main.ingameprefix + "§6Zeitpunkt §b» §9" + DataManager.time);
												pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
												counter++;
											}
										} catch (SQLException e) {
											e.printStackTrace();
										}
										pp.sendMessage(Main.ingameprefix + "§eEinträge insgesamt §b» §9" + counter);
										pp.sendMessage(Main.ingameprefix + "§cEs sind keine weiteren Einträge vorhanden!");
									} else {
										if (args[1].equalsIgnoreCase("chatclears")) {
											DataManager.staffName = args[0];
											DataManager.type = args[1];
											pp.sendMessage(Main.ingameprefix + "§eDer §aChatClear-Log §edes Spielers §9" + args[0] + " §ewird eingelesen...");
											pp.sendMessage(Main.ingameprefix + "§aChatClear-Log §edes Spielers §9" + args[0] + "§e:");
											pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
											try {
												PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM chatclears WHERE Teammitglied = ?");
												ps.setString(1, DataManager.staffName);
												ResultSet rs = ps.executeQuery();
												while (rs.next()) {
													DataManager.id = rs.getString("ID");
													DataManager.time = rs.getString("Zeitpunkt");
													pp.sendMessage(Main.ingameprefix + "§6ChatClear-ID §b» §9" + DataManager.id);
													pp.sendMessage(Main.ingameprefix + "§6Zeitpunkt §b» §9" + DataManager.time);
													pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
													counter++;
												}
											} catch (SQLException e) {
												e.printStackTrace();
											}
											pp.sendMessage(Main.ingameprefix + "§eEinträge insgesamt §b» §9" + counter);
											pp.sendMessage(Main.ingameprefix + "§cEs sind keine weiteren Einträge vorhanden!");
										} else {
											if (args[1].equalsIgnoreCase("chatmutes")) {
												DataManager.staffName = args[0];
												DataManager.type = args[1];
												pp.sendMessage(Main.ingameprefix + "§eDer §aChatMute-Log §edes Spielers §9" + args[0] + " §ewird eingelesen...");
												pp.sendMessage(Main.ingameprefix + "§aChatMute-Log §edes Spielers §9" + args[0] + "§e:");
												pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
												try {
													PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM chatmutes WHERE Teammitglied = ?");
													ps.setString(1, DataManager.staffName);
													ResultSet rs = ps.executeQuery();
													while (rs.next()) {
														DataManager.id = rs.getString("ChatMuteID");
														DataManager.time = rs.getString("Zeitpunkt");
														pp.sendMessage(Main.ingameprefix + "§6ChatMute-ID §b» §9" + DataManager.id);
														pp.sendMessage(Main.ingameprefix + "§6Zeitpunkt §b» §9" + DataManager.time);
														pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
														counter++;
													}
												} catch (SQLException e) {
													e.printStackTrace();
												}
												pp.sendMessage(Main.ingameprefix + "§eEinträge insgesamt §b» §9" + counter);
												pp.sendMessage(Main.ingameprefix + "§cEs sind keine weiteren Einträge vorhanden!");
											} else {
												if (args[1].equalsIgnoreCase("chatunmutes")) {
													DataManager.staffName = args[0];
													DataManager.type = args[1];
													pp.sendMessage(Main.ingameprefix + "§eDer §aChatUnmute-Log §edes Spielers §9" + args[0] + " §ewird eingelesen...");
													pp.sendMessage(Main.ingameprefix + "§aChatUnmute-Log §edes Spielers §9" + args[0] + "§e:");
													pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
													try {
														PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM chatunmutes WHERE Teammitglied = ?");
														ps.setString(1, DataManager.staffName);
														ResultSet rs = ps.executeQuery();
														while (rs.next()) {
															DataManager.id = rs.getString("ChatUnmuteID");
															DataManager.time = rs.getString("Zeitpunkt");
															pp.sendMessage(Main.ingameprefix + "§6ChatUnmute-ID §b» §9" + DataManager.id);
															pp.sendMessage(Main.ingameprefix + "§6Zeitpunkt §b» §9" + DataManager.time);
															pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
															counter++;
														}
													} catch (SQLException e) {
														e.printStackTrace();
													}
													pp.sendMessage(Main.ingameprefix + "§eEinträge insgesamt §b» §9" + counter);
													pp.sendMessage(Main.ingameprefix + "§cEs sind keine weiteren Einträge vorhanden!");
												} else {
													if (args[1].equalsIgnoreCase("unbans")) {
														DataManager.staffName = args[0];
														DataManager.type = args[1];
														pp.sendMessage(Main.ingameprefix + "§eDer §aUnban-Log §edes Spielers §9" + args[0] + " §ewird eingelesen...");
														pp.sendMessage(Main.ingameprefix + "§aUnban-Log §edes Spielers §9" + args[0] + "§e:");
														pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
														try {
															PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM unbans WHERE Teammitglied = ?");
															ps.setString(1, DataManager.staffName);
															ResultSet rs = ps.executeQuery();
															while (rs.next()) {
																DataManager.id = rs.getString("UnbanID");
																DataManager.time = rs.getString("Zeitpunkt");
																pp.sendMessage(Main.ingameprefix + "§6Unban-ID §b» §9" + DataManager.id);
																pp.sendMessage(Main.ingameprefix + "§6Zeitpunkt §b» §9" + DataManager.time);
																pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
																counter++;
															}
														} catch (SQLException e) {
															e.printStackTrace();
														}
														pp.sendMessage(Main.ingameprefix + "§eEinträge insgesamt §b» §9" + counter);
														pp.sendMessage(Main.ingameprefix + "§cEs sind keine weiteren Einträge vorhanden!");
													} else {
														if (args[1].equalsIgnoreCase("unmutes")) {
															DataManager.staffName = args[0];
															DataManager.type = args[1];
															pp.sendMessage(Main.ingameprefix + "§eDer §aUnmute-Log §edes Spielers §9" + args[0] + " §ewird eingelesen...");
															pp.sendMessage(Main.ingameprefix + "§aUnmute-Log §edes Spielers §9" + args[0] + "§e:");
															pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
															try {
																PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM unmutes WHERE Teammitglied = ?");
																ps.setString(1, DataManager.staffName);
																ResultSet rs = ps.executeQuery();
																while (rs.next()) {
																	DataManager.id = rs.getString("UnmuteID");
																	DataManager.time = rs.getString("Zeitpunkt");
																	pp.sendMessage(Main.ingameprefix + "§6Unmute-ID §b» §9" + DataManager.id);
																	pp.sendMessage(Main.ingameprefix + "§6Zeitpunkt §b» §9" + DataManager.time);
																	pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
																	counter++;
																}
															} catch (SQLException e) {
																e.printStackTrace();
															}
															pp.sendMessage(Main.ingameprefix + "§eEinträge insgesamt §b» §9" + counter);
															pp.sendMessage(Main.ingameprefix + "§cEs sind keine weiteren Einträge vorhanden!");
														} else {
															if (args[1].equalsIgnoreCase("supports")) {
																DataManager.staffName = args[0];
																DataManager.type = args[1];
																pp.sendMessage(Main.ingameprefix + "§eDer §aSupport-Log §edes Spielers §9" + args[0] + " §ewird eingelesen...");
																pp.sendMessage(Main.ingameprefix + "§aSupport-Log §edes Spielers §9" + args[0] + "§e:");
																pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
																try {
																	PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM unmutes WHERE Teammitglied = ?");
																	ps.setString(1, DataManager.staffName);
																	ResultSet rs = ps.executeQuery();
																	while (rs.next()) {
																		DataManager.id = rs.getString("SupportID");
																		DataManager.time = rs.getString("Zeitpunkt");
																		pp.sendMessage(Main.ingameprefix + "§6Support-ID §b» §9" + DataManager.id);
																		pp.sendMessage(Main.ingameprefix + "§6Zeitpunkt §b» §9" + DataManager.time);
																		pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
																		counter++;
																	}
																} catch (SQLException e) {
																	e.printStackTrace();
																}
																pp.sendMessage(Main.ingameprefix + "§eEinträge insgesamt §b» §9" + counter);
																pp.sendMessage(Main.ingameprefix + "§cEs sind keine weiteren Einträge vorhanden!");
															} else {
													pp.sendMessage(Main.ingameprefix + "§cBitte verwende eines der folgenden Argumente:\n "
															+ "§eBans§b,\n "
															+ "§eMutes§b,\n "
															+ "§eKicks§b,\n "
															+ "§eReports§b,\n "
															+ "§eChatclears§b,\n "
															+ "§eChatmutes§b,\n "
															+ "§eChatunmutes§b,\n "
															+ "§eUnbans§b,\n "
															+ "§eUnmutes,\n "
															+ "§eSupports");
												}}}}}}}}}}
						} else {
							pp.sendMessage(Main.ingameprefix + "§3Es besteht derzeit ein Problem mit der Verbindung zur Datenbank!");
							pp.sendMessage(Main.ingameprefix + "§3Bitte melde dies §4§lunbedingt §3dem Team!");
							pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
							pp.sendMessage(Main.ingameprefix + "§5Details:");
							pp.sendMessage(Main.ingameprefix + "§6Spielername §b» §7" + pp.getName());
							pp.sendMessage(Main.ingameprefix + "§6Zeitpunkt §b» §7" + DateTimeFormatter.ofPattern("dd.MM.YYYY - HH:mm:ss").format(LocalDateTime.now()));
							pp.sendMessage(Main.ingameprefix + "§6Server §b» §7" + pp.getServer().getInfo());
							pp.sendMessage("\n");
							pp.sendMessage(Main.ingameprefix + "§6Fehlercode §b» §7ALS-NoConnection");
							pp.sendMessage(Main.ingameprefix + "§6Fehlerbeschreibung §b» §7Could not execute 'activitylog', connection error occured  | Database is NOT connected!");
							pp.sendMessage(Main.ingameprefix + "§7- - - - - - - - - - - - - - - - - - - -");
						}
				}
				} else {
					pp.sendMessage(Main.ingameprefix + "§cDu verfügst nicht über die benötigten Berechtigungen, um diesen Befehl auszuführen!");
				}
			} else {
				sender.sendMessage(Main.ingameprefix + "§cDu musst ein Spieler sein, um diesen Befehl auszuführen!");
			}
	}
}