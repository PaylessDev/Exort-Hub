package me.nerm.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChat implements Listener {

	@EventHandler
	public void playerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String m = e.getMessage();

		if (p.hasPermission("hub.chat") && !p.isOp()) {
			p.sendMessage(ChatColor.DARK_RED.toString() + ChatColor.BOLD + "ERROR " + ChatColor.RED
					+ "Chat is currently restricted to your rank. Purchase a rank at " + ChatColor.GOLD.toString()
					+ ChatColor.UNDERLINE + "store.exorthq.net" + ChatColor.RED + " to bypass this Restriction.");
			e.setCancelled(true);
		}

		/*
		 * Other Ranks
		 */

		if (p.hasPermission("hub.pro")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.GOLD + "Pro" + ChatColor.GRAY + "] " + ChatColor.GOLD
					+ p.getName() + ChatColor.DARK_AQUA + " ➡ " + ChatColor.WHITE + m.toString());
		}

		if (p.hasPermission("hub.elite")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.BLUE + "Elite" + ChatColor.GRAY + "] " + ChatColor.BLUE
					+ p.getName() + ChatColor.DARK_AQUA + " ➡ " + ChatColor.WHITE + m.toString());
		}

		if (p.hasPermission("hub.supreme")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.YELLOW + "Supreme" + ChatColor.GRAY + "] " + ChatColor.YELLOW
					+ p.getName() + ChatColor.DARK_AQUA + " ➡ " + ChatColor.WHITE + m.toString());
		}

		if (p.hasPermission("hub.exort")) {
			e.setFormat(
					ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "Exort" + ChatColor.GRAY + "] " + ChatColor.DARK_GREEN
							+ p.getName() + ChatColor.DARK_AQUA + " ➡ " + ChatColor.WHITE + m.toString());
		}

		if (p.hasPermission("hub.media")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.LIGHT_PURPLE + "Media" + ChatColor.GRAY + "] "
					+ ChatColor.LIGHT_PURPLE + p.getName() + ChatColor.DARK_AQUA + " ➡ " + ChatColor.WHITE
					+ m.toString());
		}

		if (p.hasPermission("hub.famous")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "Famous" + ChatColor.GRAY + "] "
					+ ChatColor.DARK_PURPLE + p.getName() + ChatColor.DARK_AQUA + " ➡ " + ChatColor.WHITE
					+ m.toString());
		}

		/*
		 * Staff Ranks
		 */

		if (p.hasPermission("hub.mod")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.DARK_AQUA + "Moderator" + ChatColor.GRAY + "] "
					+ ChatColor.DARK_AQUA + p.getName() + ChatColor.DARK_AQUA + " ➡ " + ChatColor.WHITE + m.toString());
		}

		if (p.hasPermission("hub.mod+")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.DARK_AQUA + "Senior Moderator" + ChatColor.GRAY + "] "
					+ ChatColor.DARK_AQUA + p.getName() + ChatColor.DARK_AQUA + " ➡ " + ChatColor.WHITE + m.toString());
		}

		if (p.hasPermission("hub.admin")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.RED + "Administrator" + ChatColor.GRAY + "] " + ChatColor.RED
					+ p.getName() + ChatColor.DARK_AQUA + " ➡ " + ChatColor.WHITE + m.toString());
		}

		if (p.hasPermission("hub.admin+")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.RED + "Senior Administrator" + ChatColor.GRAY + "] "
					+ ChatColor.RED + p.getName() + ChatColor.DARK_AQUA + " ➡ " + ChatColor.WHITE + m.toString());
		}

		if (p.hasPermission("hub.dev")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.GREEN + "Developer" + ChatColor.GRAY + "] " + ChatColor.GREEN
					+ p.getName() + ChatColor.DARK_AQUA + " ➡ " + ChatColor.WHITE + m.toString());
		}

		if (p.hasPermission("hub.owner")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.AQUA + "Owner" + ChatColor.GRAY + "] " + ChatColor.AQUA
					+ p.getName() + ChatColor.DARK_AQUA + " ➡ " + ChatColor.WHITE + m.toString());
		}
	}
}
