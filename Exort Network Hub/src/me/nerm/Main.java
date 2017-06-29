package me.nerm;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.nerm.commands.AdventureCommand;
import me.nerm.commands.BroadcastCommand;
import me.nerm.commands.ClearChatCommand;
import me.nerm.commands.CreativeCommand;
import me.nerm.commands.FlightCommand;
import me.nerm.commands.HelpCommand;
import me.nerm.commands.KickCommand;
import me.nerm.commands.ListCommand;
import me.nerm.commands.SetSlotsCommand;
import me.nerm.commands.StoreCommand;
import me.nerm.commands.SurvivalCommand;
import me.nerm.commands.TeamSpeakCommand;
import me.nerm.commands.WhoCommand;
import me.nerm.listeners.AsyncPlayerChat;
import me.nerm.listeners.BlockBreak;
import me.nerm.listeners.BlockPlace;
import me.nerm.listeners.DoubleJump;
import me.nerm.listeners.DropItem;
import me.nerm.listeners.PickupItem;
import me.nerm.listeners.PlayerJoin;
import me.nerm.listeners.PlayerQuit;
import me.nerm.listeners.useless.CraftItem;
import me.nerm.listeners.useless.CreatureSpawn;
import me.nerm.listeners.useless.EntityDamage;
import me.nerm.listeners.useless.ExplosionPrime;
import me.nerm.listeners.useless.FoodLevelChange;
import me.nerm.listeners.useless.InventoryOpen;
import me.nerm.listeners.useless.LightningStrike;
import me.nerm.listeners.useless.PlayerExpChange;
import me.nerm.listeners.useless.PortalCreate;
import me.nerm.listeners.useless.WeatherChange;
import me.nerm.scoreboard.Scoreboard;
import me.nerm.selector.SelectorClass;
import me.nerm.tablist.PlayerTab;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin implements Listener {

	private static Permission perms = null;
	private static Main instance;
	private static Chat chat;
	public String LINE = ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH
			+ "---*---------------------------------------------*---";

	public void onEnable() {
		instance = this;
		this.getServer().getPluginManager().registerEvents(new CraftItem(), this);
		this.getServer().getPluginManager().registerEvents(new CreatureSpawn(), this);
		this.getServer().getPluginManager().registerEvents(new DoubleJump(), this);
		this.getServer().getPluginManager().registerEvents(new EntityDamage(), this);
		this.getServer().getPluginManager().registerEvents(new ExplosionPrime(), this);
		this.getServer().getPluginManager().registerEvents(new FoodLevelChange(), this);
		this.getServer().getPluginManager().registerEvents(new InventoryOpen(), this);
		this.getServer().getPluginManager().registerEvents(new LightningStrike(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerExpChange(), this);
		this.getServer().getPluginManager().registerEvents(new PortalCreate(), this);
		this.getServer().getPluginManager().registerEvents(new WeatherChange(), this);
		this.getServer().getPluginManager().registerEvents(new AsyncPlayerChat(), this);
		this.getServer().getPluginManager().registerEvents(new BlockBreak(), this);
		this.getServer().getPluginManager().registerEvents(new BlockPlace(), this);
		this.getServer().getPluginManager().registerEvents(new DropItem(), this);
		this.getServer().getPluginManager().registerEvents(new PickupItem(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerTab(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
		this.getServer().getPluginManager().registerEvents(new SelectorClass(), this);
		this.getServer().getPluginManager().registerEvents(new Scoreboard(), this);

		getCommand("gma").setExecutor(new AdventureCommand());
		getCommand("gms").setExecutor(new SurvivalCommand());
		getCommand("gmc").setExecutor(new CreativeCommand());
		getCommand("broadcast").setExecutor(new BroadcastCommand());
		getCommand("alert").setExecutor(new BroadcastCommand());
		getCommand("cc").setExecutor(new ClearChatCommand());
		getCommand("fly").setExecutor(new FlightCommand());
		getCommand("help").setExecutor(new HelpCommand());
		getCommand("?").setExecutor(new HelpCommand());
		getCommand("list").setExecutor(new ListCommand());
		getCommand("setslots").setExecutor(new SetSlotsCommand());
		getCommand("setmaxslots").setExecutor(new SetSlotsCommand());
		getCommand("setcapslots").setExecutor(new SetSlotsCommand());
		getCommand("store").setExecutor(new StoreCommand());
		getCommand("buy").setExecutor(new StoreCommand());
		getCommand("ts").setExecutor(new TeamSpeakCommand());
		getCommand("teamspeak").setExecutor(new TeamSpeakCommand());
		getCommand("who").setExecutor(new WhoCommand());
		getCommand("kick").setExecutor(new KickCommand());
		setupPermissions();
	}

	private boolean setupPermissions() {
		RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
		perms = rsp.getProvider();
		return perms != null;
	}

	@SuppressWarnings("unused")
	private boolean setupChat() {
		RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
		chat = rsp.getProvider();
		return chat != null;
	}

	public static Chat getChat() {
		return chat;
	}

	public static Permission getPerms() {
		return perms;
	}

	public static Main getInstance() {
		return instance;
	}
}