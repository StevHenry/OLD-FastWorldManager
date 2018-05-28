package fr.lolilolulolilol.fastworldmanager.cmd;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.lolilolulolilol.fastworldmanager.FastWorldManager;

public class CommandD implements CommandExecutor {
	
	private final String prefix = FastWorldManager.getInstance().prefix;
	private final String USAGE = FastWorldManager.getInstance().USAGE + " /d" + ChatColor.RED + " !";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if(p.getCustomName() == null)
				p.setCustomName(p.getName());
		}
		if (args.length == 0) {
			if (sender instanceof Player) {
				Player p = (Player)sender;
				Bukkit.broadcastMessage(
						prefix + p.getCustomName() + "§b a réglé l'heure à midi.");
			} else
				Bukkit.broadcastMessage(prefix + "§bLa §1Console§b a réglé l'heure à midi.");
			Bukkit.getWorlds().get(0).setTime(6000);
		} else
			sender.sendMessage(USAGE);
		return false;
	}
}