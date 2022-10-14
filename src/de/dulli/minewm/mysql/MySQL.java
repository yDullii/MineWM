package de.dulli.minewm.mysql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.Bukkit;

import de.dulli.minewm.utils.CustomConfig;

public class MySQL {
	
	public String prefix = CustomConfig.get().getString("MineWM.Prefix");
	
	private Connection con;
	
	private String host;
	private int port;
	private String database;
	private String user;
	private String password;
	
	public MySQL() {
		this.host = CustomConfig.get().getString("MySQL.host");
		this.port = CustomConfig.get().getInt("MySQL.port");
		this.database = CustomConfig.get().getString("MySQL.database");
		this.user = CustomConfig.get().getString("MySQL.username");
		this.password = CustomConfig.get().getString("MySQL.password");
		
		connect();
	}
	
	public void connect() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true", user, password);
			Bukkit.getConsoleSender().sendMessage(prefix +"§aMySQL Connected");
			
//			createTable();
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage(prefix +"§cMySQL Disconnected");
		}
	}
	
//    public void createTable() {
//
//        Statement statement = null;
//
//        try {
//
//            DatabaseMetaData dbm = con.getMetaData();
//            ResultSet tables = dbm.getTables(null, null, "linked", null);
//           
//            if (!tables.next()) {
//               
//                statement = con.createStatement();
//                String createtable = "CREATE TABLE " + "linked" + " " + "(NAME VARCHAR(255) NOT NULL, IP VARCHAR(255) NOT NULL, PRIMARY KEY (NAME))";
//                statement.execute(createtable);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
	
	public void disconnect() {
		if(this.isConnected()) {
			try {
				this.con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean isConnected() {
		if(this.con != null) {
			return true;
		}
		return false;
	}
	
	public Connection getCon() {
		return con;
	}

}
