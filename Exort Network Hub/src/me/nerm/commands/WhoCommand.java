package me.nerm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nerm.Main;

public class WhoCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (label.equalsIgnoreCase("who") || label.equalsIgnoreCase("whois") && p.hasPermission("hub.who")) {
				if (args.length == 0) {
					p.sendMessage(ChatColor.RED + "Usage: /" + label + " <player>");
					return true;
				} else {
					Player selected = Bukkit.getPlayerExact(args[0]);
					if (selected == null) {
						sender.sendMessage(ChatColor.RED + "That player is not online.");
						return true;
					}
					if (args.length == 1) {
						p.sendMessage(Main.getInstance().LINE);
						p.sendMessage(ChatColor.AQUA + "Showing the information of " + ChatColor.BLUE
								+ selected.getName() + ChatColor.AQUA + ".");
						p.sendMessage("");
						p.sendMessage(ChatColor.GREEN + "Player UUID" + ChatColor.DARK_GRAY + " » "
								+ ChatColor.DARK_GREEN + selected.getUniqueId() + ChatColor.GREEN + ".");
						p.sendMessage(ChatColor.GREEN + "Player IP" + ChatColor.DARK_GRAY + " » " + ChatColor.DARK_GREEN
								+ selected.getAddress() + ChatColor.GREEN + ".");
						p.sendMessage(ChatColor.GREEN + "Player Hunger" + ChatColor.DARK_GRAY + " » "
								+ ChatColor.DARK_GREEN + selected.getFoodLevel() + ChatColor.GREEN + ".");
						p.sendMessage(ChatColor.GREEN + "Connected Server" + ChatColor.DARK_GRAY + " » "
								+ ChatColor.DARK_GREEN + "Hub" + ChatColor.GREEN + ".");
						p.sendMessage(Main.getInstance().LINE);
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