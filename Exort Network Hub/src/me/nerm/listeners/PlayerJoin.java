package me.nerm.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.nerm.Main;

public class PlayerJoin implements Listener {

	@EventHandler
	public void playerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.getInventory().clear();
		p.teleport(new Location(Bukkit.getWorld("Lobby"), 0.5, 100, 0.5, 0, 0));
		
		p.sendMessage(Main.getInstance().LINE);
		p.sendMessage(ChatColor.GREEN + "Welcome to the " + ChatColor.DARK_GREEN.toString() + ChatColor.BOLD
				+ "Exort Network" + ChatColor.GREEN + " enjoy.");
		p.sendMessage("");
		p.sendMessage(ChatColor.GREEN + "Team Speak" + ChatColor.DARK_AQUA + " ➡ " + ChatColor.DARK_GREEN
				+ "ts.exorthq.net" + ChatColor.GREEN + ".");
		p.sendMessage(ChatColor.GREEN + "Twitter" + ChatColor.DARK_AQUA + " ➡ " + ChatColor.DARK_GREEN
				+ "twitter.com/ExortHQ" + ChatColor.GREEN + ".");
		p.sendMessage(ChatColor.GREEN + "Reddit" + ChatColor.DARK_AQUA + " ➡ " + ChatColor.DARK_GREEN
				+ "reddit.com/r/ExortHQ" + ChatColor.GREEN + ".");
		p.sendMessage(ChatColor.GREEN + "Store" + ChatColor.DARK_AQUA + " ➡ " + ChatColor.DARK_GREEN
				+ "store.exorthq.net" + ChatColor.GREEN + ".");
		p.sendMessage(Main.getInstance().LINE);

		ItemStack Selector = new ItemStack(Material.COMPASS, 1);
		ItemMeta Selector_Meta = Selector.getItemMeta();
		Selector_Meta.setDisplayName(ChatColor.GRAY.toString() + ChatColor.BOLD + "» " + ChatColor.DARK_GREEN.toString()
				+ ChatColor.UNDERLINE + "Server Selector" + ChatColor.GRAY.toString() + ChatColor.BOLD + " «");
		Selector.setItemMeta(Selector_Meta);
		p.getInventory().setItem(4, Selector);
		p.setGameMode(GameMode.ADVENTURE);
		e.setJoinMessage(null);

		if (!p.hasPermission("hub.chat")) {
			ItemStack Donator = new ItemStack(Material.GLASS);
			ItemMeta Donator_Meta = Donator.getItemMeta();
			Donator_Meta.setDisplayName(ChatColor.GREEN.toString() + ChatColor.UNDERLINE + "Space Helmet");
			Donator.setItemMeta(Donator_Meta);
			p.getInventory().setHelmet(Donator);
		}
	}
}
