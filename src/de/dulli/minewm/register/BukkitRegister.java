package de.dulli.minewm.register;

import org.bukkit.Bukkit;

import de.dulli.minewm.Main;
import de.dulli.minewm.commands.GameModeCommand;
import de.dulli.minewm.commands.InvSeeCommand;
import de.dulli.minewm.commands.WMCommand;
import de.dulli.minewm.inventory.TestInventar;
import de.dulli.minewm.inventory.WMConfig;
import de.dulli.minewm.utils.SyntaxBlocker;

public class BukkitRegister {
	
	public void registerListener() {
		Bukkit.getPluginManager().registerEvents(new SyntaxBlocker(), Main.getInstance());
		Bukkit.getPluginManager().registerEvents(new WMConfig(), Main.getInstance());
		Bukkit.getPluginManager().registerEvents(new TestInventar(), Main.getInstance());
		

	}
	
	public void registerCommands() {
		Main.getInstance().getCommand("gm").setExecutor(new GameModeCommand());
		Main.getInstance().getCommand("invsee").setExecutor(new InvSeeCommand());
		Main.getInstance().getCommand("wm").setExecutor(new WMCommand());
	}

}
