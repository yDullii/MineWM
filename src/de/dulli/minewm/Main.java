package de.dulli.minewm;

import org.bukkit.plugin.java.JavaPlugin;

import de.dulli.minewm.mysql.MySQL;
import de.dulli.minewm.register.BukkitRegister;
import de.dulli.minewm.utils.CustomConfig;

public class Main extends JavaPlugin {
	
	public static Main instance;
	public static Main getInstance() {return instance;}
	
	public MySQL mysql;
	
	private BukkitRegister bukkitRegister = new BukkitRegister();
	
	@Override
	public void onLoad() {
		createConfig();
		
		instance = this;
	}
	
	@Override
	public void onEnable() {
		bukkitRegister.registerListener();
		bukkitRegister.registerCommands();
		
		// MySQL Still testing
		mysql = new MySQL();
	}
	
	@Override
	public void onDisable() {
		
	}
	
	private void createConfig() {
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		
		
		CustomConfig.setup();
		CustomConfig.get().addDefault("MySQL.host", "localhost");
		CustomConfig.get().addDefault("MySQL.port", Integer.valueOf(3306));
		CustomConfig.get().addDefault("MySQL.database", "DATABASE");
		CustomConfig.get().addDefault("MySQL.username", "USERNAME");
		CustomConfig.get().addDefault("MySQL.password", "PASSWORD");
		
		CustomConfig.get().addDefault("MineWM.Prefix", "§7[§eMineWM§7] §7");
		CustomConfig.get().addDefault("MineWM.ProjektName", "MINECRAFT WM 2022");
		CustomConfig.get().addDefault("MineWM.StartCountdown", Integer.valueOf(90));
		CustomConfig.get().addDefault("MineWM.FirstHalf", Integer.valueOf(900));
		CustomConfig.get().addDefault("MineWM.SecondHalf", Integer.valueOf(900));
		CustomConfig.get().addDefault("MineWM.CombatLogTime", Integer.valueOf(30));
		
		CustomConfig.get().options().copyDefaults(true);
		CustomConfig.save();
	}

}
