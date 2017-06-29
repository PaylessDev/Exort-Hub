package me.nerm.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nerm.Main;

public class HelpCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (label.equalsIgnoreCase("help") || label.equalsIgnoreCase("?")) {
				p.sendMessage(Main.getInstance().LINE);
				p.sendMessage(ChatColor.GREEN + "Have fun on our " + ChatColor.DARK_GREEN.toString() + ChatColor.BOLD
						+ "Network" + ChatColor.GREEN + ".");
				p.sendMessage("");
				p.sendMessage(ChatColor.DARK_GREEN.toString() + ChatColor.BOLD + "Useful Commands");
				p.sendMessage(ChatColor.GRAY + " » " + ChatColor.GREEN + "/request" + ChatColor.DARK_AQUA + " ➡ "
						+ ChatColor.DARK_GREEN + "Request assistance from online staff" + ChatColor.GREEN + ".");
				p.sendMessage(ChatColor.GRAY + " » " + ChatColor.GREEN + "/report" + ChatColor.DARK_AQUA + " ➡ "
						+ ChatColor.DARK_GREEN + "Report a rule breaker" + ChatColor.GREEN + ".");
				p.sendMessage(ChatColor.GRAY + " » " + ChatColor.GREEN + "/request" + ChatColor.DARK_AQUA + " ➡ "
						+ ChatColor.DARK_GREEN + "Request assistance from online staff" + ChatColor.GREEN + ".");
				p.sendMessage("");
				p.sendMessage(ChatColor.DARK_GREEN.toString() + ChatColor.BOLD + "Useful Information");
				p.sendMessage(ChatColor.GRAY + " » " + ChatColor.GREEN + "Team Speak" + ChatColor.DARK_AQUA + " ➡ "
						+ ChatColor.DARK_GREEN + "ts.exorthq.net" + ChatColor.GREEN + ".");
				p.sendMessage(ChatColor.GRAY + " » " + ChatColor.GREEN + "Store" + ChatColor.DARK_AQUA + " ➡ "
						+ ChatColor.DARK_GREEN + "store.exorthq.net" + ChatColor.GREEN + ".");
				return true;
			}
			return true;
		}
		sender.sendMessage(ChatColor.GOLD + "Please run commands as Console.");
		return true;
	}
}
