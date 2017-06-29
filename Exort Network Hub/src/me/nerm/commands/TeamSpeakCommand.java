package me.nerm.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeamSpeakCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (label.equalsIgnoreCase("ts") || label.equalsIgnoreCase("teamspeak")) {
				p.sendMessage(ChatColor.GREEN + "You may connect to our official Team Speak server at "
						+ ChatColor.DARK_GREEN.toString() + ChatColor.BOLD + "ts.exorthq.net" + ChatColor.GREEN + ".");
				return true;
			}
			return true;
		}
		sender.sendMessage(ChatColor.GOLD + "Please run commands as Console.");
		return true;
	}
}
