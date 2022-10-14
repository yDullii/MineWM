package de.dulli.minewm.inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class TestInventar implements Listener {

	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if(e.getCurrentItem() == null || e.getCurrentItem().getItemMeta() == null) {
			return;
		}
		
		if (e.getInventory().getName().equals("§7Spieler")) {
			e.setCancelled(true);
		}

		if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§eSpieler")
				&& e.getInventory().getName().equals("§7WM - Menu")) {

			p.openInventory(onlinePlayersSkull());

		} else
			return;
	}

	private Inventory onlinePlayersSkull() {
		Inventory inv = Bukkit.createInventory(null, 54, "§7Spieler");
		int time = 0;
		for (Player p : Bukkit.getOnlinePlayers()) {
			ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
			SkullMeta meta = (SkullMeta) skull.getItemMeta();
			meta.setOwner(p.getName());
			meta.setDisplayName("§7" + p.getName());
			skull.setItemMeta(meta);
			inv.setItem(time, skull);
			time++;
		}
		return inv;
	}

}
