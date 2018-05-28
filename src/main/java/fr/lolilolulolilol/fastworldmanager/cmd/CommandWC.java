package fr.lolilolulolilol.fastworldmanager.cmd;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.lolilolulolilol.fastworldmanager.FastWorldManager;

public class CommandWC implements CommandExecutor {

	private final String prefix = FastWorldManager.getInstance().prefix;
	private final String USAGE = FastWorldManager.getInstance().USAGE + "/wc §c!";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.getCustomName() == null)
				p.setCustomName(p.getName());
			return true;
		}

		if (args.length == 0) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				Bukkit.broadcastMessage(prefix + p.getCustomName() + "§b a retiré la pluie.");
			} else
				Bukkit.broadcastMessage(prefix + "§bLa §1Console§b a retiré la pluie.");
			World monde = Bukkit.getWorlds().get(0);
			monde.setThundering(false);
			monde.setStorm(false);
		} else
			sender.sendMessage(USAGE);
		return false;
	}
}