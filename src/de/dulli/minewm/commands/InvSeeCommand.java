package de.dulli.minewm.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.dulli.minewm.utils.CustomConfig;

public class InvSeeCommand implements CommandExecutor {

	public String prefix = CustomConfig.get().getString("MineWM.Prefix");

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		Player p = (Player) s;
		if (s instanceof Player) {
			if (p.hasPermission("minewm.invsee")) {
				if(args.length == 1) {
					Player t = Bukkit.getPlayer(args[0]);
					
					p.openInventory(t.getInventory());
				}else
					p.sendMessage(prefix + "§7Gib einen §eSpieler §7dazu an");
			} else
				p.sendMessage(prefix + "§7Dazu fehlen dir die §cRechte");
		} else
			s.sendMessage(prefix + "§7Dieser §eBefehl §7kann nur von einem §eSpieler §7ausgeführt werden");
		return false;
	}

}
