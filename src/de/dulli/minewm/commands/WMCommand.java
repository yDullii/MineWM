package de.dulli.minewm.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import de.dulli.minewm.utils.CustomConfig;
import de.dulli.minewm.utils.ItemBuilder;

public class WMCommand implements CommandExecutor {

	public String prefix = CustomConfig.get().getString("MineWM.Prefix");

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		Player p = (Player) s;
		if (s instanceof Player) {
			if (args.length == 1) {
				if(args[0].equalsIgnoreCase("menu")) {
					fillMenuInv(p);
				}
			} else
				p.sendMessage(prefix + "§cDEBUG");
		} else
			s.sendMessage(prefix + "§7Dieser §eBefehl §7kann nur von einem §eSpieler §7ausgeführt werden");
		return false;
	}
	
	public static void fillMenuInv(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9*3, "§7WM - Menu");
		
		// glas fill
		inv.setItem(0, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(1, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(2, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(3, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(4, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(5, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(6, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(7, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(8, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(9, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(11, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(13, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(15, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(17, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		
		// Richtige Items
		inv.setItem(10, new ItemBuilder(Material.BOOK).setDisplayname("§eConfig").setLore(Arrays.asList("§8§oLinksclick")).build());
		inv.setItem(12, new ItemBuilder(Material.SKULL_ITEM).setDisplayname("§eSpieler").setLore(Arrays.asList("§8§oLinksclick")).build());
		inv.setItem(14, new ItemBuilder(Material.BANNER, 1, DyeColor.WHITE).setDisplayname("§eTeams").setLore(Arrays.asList("§8§oLinksclick")).build());
		inv.setItem(16, new ItemBuilder(Material.ITEM_FRAME).setDisplayname("§eSpiel").setLore(Arrays.asList("§8§oLinksclick")).build());
		inv.setItem(22, new ItemBuilder(Material.REDSTONE).setDisplayname("§eZurück").setLore(Arrays.asList("§8§oLinksclick")).build());
		
		// glas fill
		inv.setItem(18, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(19, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(20, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(21, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(23, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(24, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(25, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(26, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		
		p.openInventory(inv);
	}

}
