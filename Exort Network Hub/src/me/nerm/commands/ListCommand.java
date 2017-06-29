package me.nerm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (label.equalsIgnoreCase("list")) {
				if (Bukkit.getOnlinePlayers().length == 1) {
					p.sendMessage(ChatColor.GREEN + "There is currently " + ChatColor.DARK_GREEN + "1 player"
							+ ChatColor.GREEN + " connected.");
				}
				if (Bukkit.getOnlinePlayers().length > 1) {
					p.sendMessage(ChatColor.GREEN + "There are " + ChatColor.DARK_GREEN
							+ Bukkit.getOnlinePlayers().length + " players " + ChatColor.GREEN + " connected.");
				}
				return true;
			}
			return true;
		}
		sender.sendMessage(ChatColor.GOLD + "Please run commands as a player.");
		return true;
	}
}
