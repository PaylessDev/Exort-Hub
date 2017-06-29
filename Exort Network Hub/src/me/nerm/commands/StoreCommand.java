package me.nerm.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StoreCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (label.equalsIgnoreCase("store") || label.equalsIgnoreCase("buy")) {
				p.sendMessage(ChatColor.GREEN + "You may visit our store to buy some goods at "
						+ ChatColor.DARK_GREEN.toString() + ChatColor.BOLD + "store.exorthq.net" + ChatColor.GREEN
						+ ".");
			}
			return true;
		}
		sender.sendMessage(ChatColor.GOLD + "Please run commands as a player.");
		return true;
	}
}
