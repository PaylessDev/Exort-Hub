package me.nerm.selector;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SelectorClass implements Listener {

	Inventory selector = Bukkit.createInventory(null, 27, ChatColor.GREEN + "Select a server!");

	@EventHandler
	public void selectorOpen(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getItem() == null || e.getItem().getType().equals(Material.AIR)) {
			return;
		}
		if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if (e.getItem().getType().equals(Material.COMPASS)) {
				ItemStack HCFactions = new ItemStack(Material.FISHING_ROD);
				ItemMeta HCFactions_Meta = HCFactions.getItemMeta();
				HCFactions_Meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.UNDERLINE + "Hardcore Factions");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("");
				lore.add(ChatColor.DARK_AQUA + " " + ChatColor.BOLD + "➡" + ChatColor.GREEN + " 10 Man Factions"
						+ ChatColor.GRAY + "," + ChatColor.GREEN + " 0 Allies" + ChatColor.GRAY + ".");
				lore.add(ChatColor.DARK_AQUA + " " + ChatColor.BOLD + "➡" + ChatColor.GREEN + " Sharpness 2"
						+ ChatColor.GRAY + "," + ChatColor.GREEN + " Protection 1" + ChatColor.GRAY + ".");
				lore.add(ChatColor.DARK_AQUA + " " + ChatColor.BOLD + "➡" + ChatColor.GREEN + " Invisibility Enabled"
						+ ChatColor.GRAY + ".");
				HCFactions_Meta.setLore(lore);
				HCFactions.setItemMeta(HCFactions_Meta);
				selector.setItem(10, HCFactions);

				ItemStack Kits = new ItemStack(Material.POTION, 1, (short) 16421);
				ItemMeta Kits_Meta = Kits.getItemMeta();
				Kits_Meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.UNDERLINE + "Kit Map");
				ArrayList<String> lore2 = new ArrayList<String>();
				lore2.add("");
				lore2.add(ChatColor.DARK_AQUA + " " + ChatColor.BOLD + "➡" + ChatColor.GREEN + " 5 Man Factions"
						+ ChatColor.GRAY + "," + ChatColor.GREEN + " 1 Ally" + ChatColor.GRAY + ".");
				lore2.add(ChatColor.DARK_AQUA + " " + ChatColor.BOLD + "➡" + ChatColor.GREEN + " Sharpness 2"
						+ ChatColor.GRAY + "," + ChatColor.GREEN + " Protection 2" + ChatColor.GRAY + ".");
				lore2.add(ChatColor.DARK_AQUA + " " + ChatColor.BOLD + "➡" + ChatColor.GREEN + " Invisibility Enabled"
						+ ChatColor.GRAY + ".");
				Kits_Meta.setLore(lore2);
				Kits.setItemMeta(Kits_Meta);
				selector.setItem(14, Kits);

				ItemStack Solos = new ItemStack(Material.DIAMOND_SWORD, 1);
				ItemMeta Solos_Meta = Solos.getItemMeta();
				Solos_Meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.UNDERLINE + "Solos");
				ArrayList<String> lore3 = new ArrayList<String>();
				lore3.add("");
				lore3.add(ChatColor.DARK_AQUA + " " + ChatColor.BOLD + "➡" + ChatColor.GREEN + " 1 Man Factions"
						+ ChatColor.GRAY + "," + ChatColor.GREEN + " 0 Ally" + ChatColor.GRAY + ".");
				lore3.add(ChatColor.DARK_AQUA + " " + ChatColor.BOLD + "➡" + ChatColor.GREEN + " Sharpness 2"
						+ ChatColor.GRAY + "," + ChatColor.GREEN + " Protection 1" + ChatColor.GRAY + ".");
				lore3.add(ChatColor.DARK_AQUA + " " + ChatColor.BOLD + "➡" + ChatColor.GREEN + " Invisibility Disabled"
						+ ChatColor.GRAY + ".");
				Solos_Meta.setLore(lore3);
				Solos.setItemMeta(Solos_Meta);
				selector.setItem(12, Solos);

				ItemStack FFA = new ItemStack(Material.GOLD_HELMET, 1);
				ItemMeta FFA_Meta = FFA.getItemMeta();
				FFA_Meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.UNDERLINE + "Free For All");
				FFA.setItemMeta(FFA_Meta);
				ArrayList<String> lore4 = new ArrayList<String>();
				lore4.add("");
				lore4.add(ChatColor.DARK_AQUA + " " + ChatColor.BOLD + "➡" + ChatColor.GREEN + " No Teaming"
						+ ChatColor.GRAY + "," + ChatColor.GREEN + " No Allying" + ChatColor.GRAY + ".");
				lore4.add(ChatColor.DARK_AQUA + " " + ChatColor.BOLD + "➡" + ChatColor.GREEN + " Sharpness 1"
						+ ChatColor.GRAY + "," + ChatColor.GREEN + " Protection 2" + ChatColor.GRAY + ".");
				FFA_Meta.setLore(lore4);
				FFA.setItemMeta(FFA_Meta);

				selector.setItem(16, FFA);
				p.updateInventory();
				p.openInventory(selector);
				return;
			}
		}
	}

	@EventHandler
	public void inventoryEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (!p.hasPermission("hub.click")) {
			e.setCancelled(true);
		}
		if (e.getClickedInventory() == null || (e.getCurrentItem().getType() == Material.AIR)) {
			return;
		}
		if (e.getClickedInventory().equals(selector) && e.getCurrentItem().getType() == Material.FISHING_ROD) {
			p.chat("/play HCFactions");
			p.closeInventory();
			return;
		}
		if (e.getClickedInventory().equals(selector) && e.getCurrentItem().getType() == Material.POTION) {
			p.chat("/play Kits");
			p.closeInventory();
			return;
		}
		if (e.getClickedInventory().equals(selector) && e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
			p.chat("/play Solos");
			p.closeInventory();
			return;
		}
		if (e.getClickedInventory().equals(selector) && e.getCurrentItem().getType() == Material.GOLD_HELMET) {
			p.chat("/play FFA");
			p.closeInventory();
			return;
		}
	}
}
