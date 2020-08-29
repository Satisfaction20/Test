package de.ragecraft.activitylogsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {
	
	public static String host = "localhost";
	public static String port = "3306";
	public static String database = "ActivityLogSystem";
	public static String username = "ActivityLogSystem";
	public static String password = "12345678910";
	public static Connection con;
	
	public static void connect() {
		if (!(isConnected())) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
				System.out.println("[MySQL] Connected successfully!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void disconnect() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isConnected() {
		return (con == null ? false : true);
	}
	
	public static void update(String qry) {
		try {
			PreparedStatement ps = con.prepareStatement(qry);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ResultSet getResult(String qry) {
		
		try {
			PreparedStatement ps = con.prepareStatement(qry);
			return ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Connection getConnection() {
		return con;
	}
}
