package de.dulli.minewm.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.dulli.minewm.utils.CustomConfig;

public class GameModeCommand implements CommandExecutor {

	public String prefix = CustomConfig.get().getString("MineWM.Prefix");

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		Player p = (Player) s;
		if (s instanceof Player) {
			if (p.hasPermission("minewm.gamemode")) {
				if (args.length == 1) {
					if (args[0].equals("0")) {
						p.sendMessage(prefix + "§7Du bist nun im §eSurvival-Modus");
						p.setGameMode(GameMode.SURVIVAL);

					} else if (args[0].equals("1")) {
						p.sendMessage(prefix + "§7Du bist nun im §eCreative-Modus");
						p.setGameMode(GameMode.CREATIVE);

					} else if (args[0].equals("2")) {
						p.sendMessage(prefix + "§7Du bist nun im §eAdventure-Modus");
						p.setGameMode(GameMode.ADVENTURE);

					} else if (args[0].equals("3")) {
						p.sendMessage(prefix + "§7Du bist nun im §eSpectator-Modus");
						p.setGameMode(GameMode.SPECTATOR);

					}
				} else if (args.length == 2) {
					if (args[1].equals("@a")) {
						if (args[0].equals("0")) {

							for (Player a : Bukkit.getOnlinePlayers()) {
								a.sendMessage(prefix + "§7Du bist nun im §eSurvival-Modus");
								a.setGameMode(GameMode.SURVIVAL);
							}

						} else if (args[0].equals("1")) {
							for (Player a : Bukkit.getOnlinePlayers()) {
								a.sendMessage(prefix + "§7Du bist nun im §eCreative-Modus");
								a.setGameMode(GameMode.CREATIVE);
							}

						} else if (args[0].equals("2")) {
							for (Player a : Bukkit.getOnlinePlayers()) {
								a.sendMessage(prefix + "§7Du bist nun im §eAdventure-Modus");
								a.setGameMode(GameMode.ADVENTURE);
							}

						} else if (args[0].equals("3")) {
							for (Player a : Bukkit.getOnlinePlayers()) {
								a.sendMessage(prefix + "§7Du bist nun im §eSpectator-Modus");
								a.setGameMode(GameMode.SPECTATOR);
							}

						}
					}
				} else
					p.sendMessage(prefix + "§7Gib einen §eGameMode §7dazu an §7(§e0 - 3§7)");
			} else
				p.sendMessage(prefix + "§7Dazu fehlen dir die §cRechte");
		} else
			s.sendMessage(prefix + "§7Dieser §eBefehl §7kann nur von einem §eSpieler §7ausgeführt werden");
		return false;
	}

}
