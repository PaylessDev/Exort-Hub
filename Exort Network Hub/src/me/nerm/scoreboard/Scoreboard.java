package me.nerm.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Team;

import me.nerm.Main;
import me.signatured.ezqueueshared.QueueInfo;

public class Scoreboard implements Listener {

	@SuppressWarnings({ "deprecation", "static-access" })
	public void scoreboard(Player p) {
		org.bukkit.scoreboard.Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective objective = board.registerNewObjective("Default", "Test2");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName("    §2§lExortHQ    ");

		Team BAR = board.registerNewTeam("9");
		BAR.addEntry("§9");
		BAR.setPrefix("§7§m---*------");
		BAR.setSuffix("§7§m------*---");
		objective.getScore("§9").setScore(9);

		Team rank = board.registerNewTeam("8");
		rank.addEntry("§8");
		rank.setPrefix("§2§lRank:");
		rank.setSuffix("");
		objective.getScore("§8").setScore(8);

		Team rank_rank = board.registerNewTeam("7");
		rank_rank.addEntry("§7");
		rank_rank.setPrefix(ChatColor.GRAY + " » ");
		rank_rank.setSuffix(ChatColor.WHITE.toString() + Main.getInstance().getPerms().getPrimaryGroup(p));
		objective.getScore("§7").setScore(7);

		Score blank2 = objective.getScore("§b");
		blank2.setScore(6);

		Team online = board.registerNewTeam("5");
		online.addEntry("§5");
		online.setPrefix("§2§lOnline:");
		online.setSuffix("");
		objective.getScore("§5").setScore(5);

		Team online_online = board.registerNewTeam("4");
		online_online.addEntry("§4");
		online_online.setPrefix(ChatColor.GRAY + " » ");
		online_online.setSuffix(ChatColor.WHITE.toString() + Bukkit.getOnlinePlayers().length + "");
		objective.getScore("§4").setScore(4);

		if (QueueInfo.getQueue(p.getName()) != null) {
			Score blank4 = objective.getScore("§m");
			blank4.setScore(3);

			Team QUEUE_SERVER = board.registerNewTeam("-");
			QUEUE_SERVER.addEntry("§a");
			QUEUE_SERVER.setPrefix("§aQueued for: ");
			objective.getScore("§a").setScore(2);
			QUEUE_SERVER.setSuffix("§2§l" + QueueInfo.getQueue(p.getName()));

			Team QUEUE = board.registerNewTeam("1");
			QUEUE.addEntry("§1");
			QUEUE.setPrefix("§n" + getQueue(p));
			QUEUE.setSuffix(getMaxInQueue(p));
			objective.getScore("§1").setScore(1);
		}

		Score blank3 = objective.getScore("§3");
		blank3.setScore(0);

		Team spon = board.registerNewTeam("2");
		spon.addEntry("§2");
		spon.setPrefix("§astore.exorthq");
		spon.setSuffix("§a.net");
		objective.getScore("§2").setScore(-1);

		Team BAR2 = board.registerNewTeam("0");
		BAR2.addEntry("§d");
		BAR2.setPrefix("§7§m---*------");
		BAR2.setSuffix("§7§m------*---");
		objective.getScore("§d").setScore(-2);

		p.setScoreboard(board);
	}

	public void refresh(final Player p) {
		new BukkitRunnable() {
			public void run() {
				if (p == null) {
					this.cancel();
					return;
				}
				scoreboard(p);
			}
		}.runTaskTimer(Main.getInstance(), 20, 20);
	}

	@EventHandler
	public void join(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		refresh(p);
	}

	public String getQueue(Player p) {
		if (QueueInfo.getPosition(p.getName()) == -1) {
			return "";
		}
		return "#" + QueueInfo.getPosition(p.getName()) + " out of #";
	}

	public String getMaxInQueue(Player p) {
		if (QueueInfo.getQueue(p.getName()) == null) {
			return "";
		}
		return "§f§n" + QueueInfo.getQueueInfo(QueueInfo.getQueue(p.getName())).getSize();
	}
}