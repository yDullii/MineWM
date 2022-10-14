package de.dulli.minewm.inventory;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import de.dulli.minewm.commands.WMCommand;
import de.dulli.minewm.utils.CustomConfig;
import de.dulli.minewm.utils.ItemBuilder;

public class WMConfig implements Listener {

	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if(e.getCurrentItem() == null) {
			return;
		}
		
		if (e.getInventory().getName().equals("§7WM - Menu"))
			e.setCancelled(true);
		
		if (e.getInventory().getName().equals("§7Config"))
			e.setCancelled(true);
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§eConfig")) {
				p.closeInventory();

				openConfigInv(p);
				
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§eZurück") && e.getInventory().getName().equals("§7Config")) {
				p.closeInventory();
				e.setCancelled(true);

				WMCommand.fillMenuInv(p);
				
			}else 
				return;
	}

	private void openConfigInv(Player p) {
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 0);
		Inventory inv = Bukkit.createInventory(null, 9 * 3, "§7Config");

		// Richtige Items
		inv.setItem(22, new ItemBuilder(Material.REDSTONE).setDisplayname("§eZurück").setLore(Arrays.asList("§8§oLinksclick")).build());
		inv.setItem(0, new ItemBuilder(Material.BOOK).setDisplayname("§7Projekt Name").setLore(Arrays.asList("§8§o" + CustomConfig.get().getString("MineWM.ProjektName"))).build());
		inv.setItem(1, new ItemBuilder(Material.BOOK).setDisplayname("§7Start Countdown").setLore(Arrays.asList("§8§o" + CustomConfig.get().getInt("MineWM.StartCountdown"))).build());
		inv.setItem(2, new ItemBuilder(Material.BOOK).setDisplayname("§7Spielzeit 1. Halbzeit").setLore(Arrays.asList("§8§o" + CustomConfig.get().getInt("MineWM.FirstHalf"))).build());
		inv.setItem(3, new ItemBuilder(Material.BOOK).setDisplayname("§7Spielzeit 2. Halbzeit").setLore(Arrays.asList("§8§o" + CustomConfig.get().getInt("MineWM.SecondHalf"))).build());
		inv.setItem(4, new ItemBuilder(Material.BOOK).setDisplayname("§7Combatlog Zeit").setLore(Arrays.asList("§8§o" + CustomConfig.get().getInt("MineWM.CombatLogTime"))).build());
		inv.setItem(5, new ItemBuilder(Material.BOOK).setDisplayname("§7Spawn Team 1").setLore(Arrays.asList("§8§o" + CustomConfig.get().getString("MineWM.TeamSpawn.1"))).build());
		inv.setItem(6, new ItemBuilder(Material.BOOK).setDisplayname("§7Spawn Team 2").setLore(Arrays.asList("§8§o" + CustomConfig.get().getString("MineWM.TeamSpawn.2"))).build());
		inv.setItem(6, new ItemBuilder(Material.BOOK).setDisplayname("§7Spawn Spectator").setLore(Arrays.asList("§8§o" + CustomConfig.get().getString("MineWM.SpecSpawn"))).build());
		
		// glas fill
		inv.setItem(8, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(9, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(10, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(11, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(12, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(13, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(14, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(15, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(16, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
		inv.setItem(17, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY).setDisplayname(" ").build());
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
