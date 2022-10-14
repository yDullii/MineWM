package de.dulli.minewm.utils;

import java.util.List;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
	private ItemStack itemStack;
	private ItemMeta itemMeta;

	public ItemBuilder(Material material) {
		this.itemStack = new ItemStack(material);
		this.itemMeta = this.itemStack.getItemMeta();
	}

	@SuppressWarnings("deprecation")
	public ItemBuilder(Material material, int stack, DyeColor d) {
		this.itemStack = new ItemStack(material, stack, d.getData());
		this.itemMeta = this.itemStack.getItemMeta();
	}

	public ItemBuilder(Material material, int stack) {
		this.itemStack = new ItemStack(material, stack);
		this.itemMeta = this.itemStack.getItemMeta();
	}

	public ItemBuilder setDisplayname(String arg0) {
		this.itemMeta.setDisplayName(arg0);
		return this;
	}

	public ItemBuilder addEnchantment(Enchantment e, Integer strenght, boolean b) {
		this.itemMeta.addEnchant(e, strenght.intValue(), b);
		return this;
	}

	public ItemBuilder setLore(List<String> list) {
		this.itemMeta.setLore(list);
		return this;
	}

	public ItemStack build() {
		this.itemStack.setItemMeta(this.itemMeta);
		return this.itemStack;
	}
}