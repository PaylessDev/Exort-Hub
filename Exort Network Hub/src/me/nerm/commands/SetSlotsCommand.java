package me.nerm.commands;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.minecraft.util.com.google.common.primitives.Ints;

public class SetSlotsCommand implements CommandExecutor {

	public void setMaxPlayers(int amount) throws ReflectiveOperationException {
		String bukkitversion = Bukkit.getServer().getClass().getPackage().getName().substring(23);
		Object playerlist = Class.forName("org.bukkit.craftbukkit." + bukkitversion + ".CraftServer")
				.getDeclaredMethod("getHandle", null).invoke(Bukkit.getServer(), null);
		Field maxplayers = playerlist.getClass().getSuperclass().getDeclaredField("maxPlayers");
		maxplayers.setAccessible(true);
		maxplayers.set(playerlist, amount);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (label.equalsIgnoreCase("setslots") || label.equalsIgnoreCase("capslots")
					|| label.equalsIgnoreCase("setmaxslots") && p.hasPermission("hub.setslots")) {
				if (args.length < 1) {
					sender.sendMessage("§cUsage: /" + label + " <amount>");
				} else {
					Integer amount = Ints.tryParse(args[0]);
					if (amount == null) {
						sender.sendMessage(
								"§c'" + amount + "' is not a valid number! Please enter a number from 1 to 999999999.");
					} else {
						if (amount <= 0) {
							sender.sendMessage("§c'" + amount
									+ "' is not a valid number! Please enter a number from 1 to 999999999.");
							try {
								setMaxPlayers(amount);
							} catch (ReflectiveOperationException expeption) {
								expeption.printStackTrace();
							}
							return true;
						}
						return true;
					}
					return true;
				}
				return true;
			}
			return true;
		}
		sender.sendMessage(ChatColor.GOLD + "Please run commands as a player.");
		return true;
	}
}