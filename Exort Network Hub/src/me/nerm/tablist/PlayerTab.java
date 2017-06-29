package me.nerm.tablist;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerTab implements Listener {

	@EventHandler
	public void playerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (p.isOp()) {
			p.setPlayerListName(ChatColor.DARK_RED + p.getName());
		}

		if (p.hasPermission("hub.pro")) {
			p.setPlayerListName(ChatColor.GOLD + p.getName());
		}

		if (p.hasPermission("hub.elite")) {
			p.setPlayerListName(ChatColor.BLUE + p.getName());
		}

		if (p.hasPermission("hub.supreme")) {
			p.setPlayerListName(ChatColor.YELLOW + p.getName());
		}

		if (p.hasPermission("hub.exort")) {
			p.setPlayerListName(ChatColor.GREEN + p.getName());
		}

		if (p.hasPermission("hub.media")) {
			p.setPlayerListName(ChatColor.LIGHT_PURPLE + p.getName());
		}

		if (p.hasPermission("hub.famous")) {
			p.setPlayerListName(ChatColor.DARK_PURPLE + p.getName());
		}

		if (p.hasPermission("hub.mod")) {
			p.setPlayerListName(ChatColor.DARK_AQUA + p.getName());
		}

		if (p.hasPermission("hub.mod+")) {
			p.setPlayerListName(ChatColor.DARK_AQUA + p.getName());
		}

		if (p.hasPermission("hub.admin")) {
			p.setPlayerListName(ChatColor.RED + p.getName());
		}

		if (p.hasPermission("hub.admin+")) {
			p.setPlayerListName(ChatColor.RED + p.getName());
		}

		if (p.hasPermission("hub.dev")) {
			p.setPlayerListName(ChatColor.GREEN + p.getName());
		}
		
		if (p.hasPermission("hub.owner")) {
			p.setPlayerListName(ChatColor.AQUA + p.getName());
		}
	}
}
