package me.nerm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nerm.Main;

public class KickCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (label.equalsIgnoreCase("kick") && p.hasPermission("hub.kick")) {
				if (args.length == 0) {
					p.sendMessage(ChatColor.RED + "Usage: /kick <player>");
					return true;
				} else {
					Player selected = Bukkit.getPlayerExact(args[0]);
					if (selected == null) {
						sender.sendMessage(ChatColor.RED + "That player is not online.");
						return true;
					}
					if (args.length == 1) {
						Bukkit.broadcastMessage(Main.getInstance().LINE);
						Bukkit.broadcastMessage(ChatColor.DARK_GREEN + selected.getName() + ChatColor.GREEN
								+ " was kicked from " + ChatColor.DARK_GREEN + "Exort Network" + ChatColor.GREEN + ".");
						Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "Reason" + ChatColor.DARK_GRAY + " » "
								+ ChatColor.GREEN + "Violation of our Terms of Service.");
						Bukkit.broadcastMessage(Main.getInstance().LINE);
						selected.kickPlayer("\n" + ChatColor.RED + "You were kicked from the Hub.");
						return true;
					}
					return true;
				}
			}
			return true;
		}
		sender.sendMessage(ChatColor.GOLD + "Please run commands as Console.");
		return true;
	}
}
