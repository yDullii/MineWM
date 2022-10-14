package de.dulli.minewm.utils;

import java.util.Arrays;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class SyntaxBlocker implements Listener {
	
	static String[] blockedEquals = {
			"/rl",
			"/reload",
			"/me",
			"/tell"
	};
	
	static String[] blockedStarts = {
			"/minecraft:tell",
			"/minecraft:me"
	};
	
	@EventHandler
	public void onCommandPR(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage();
		String[] args = msg.split(" ");
		
		boolean blocked = false;
		
		if(Arrays.asList(blockedEquals).contains(args[0].toLowerCase()))
			blocked = true;
		
		for(String st : blockedStarts)
			if(args[0].toLowerCase().startsWith(st))
				blocked = true;
		
		if(blocked) {
			e.setCancelled(true);
			p.sendMessage(CustomConfig.get().getString("MineWM.Prefix") + "§7Dieser §eBefehl §7wurde §cblockiert");
		}
	}

}
