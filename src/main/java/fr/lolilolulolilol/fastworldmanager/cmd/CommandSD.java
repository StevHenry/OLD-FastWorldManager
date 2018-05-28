package fr.lolilolulolilol.fastworldmanager.cmd;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.lolilolulolilol.fastworldmanager.FastWorldManager;

public class CommandSD implements CommandExecutor {

	private final String prefix = FastWorldManager.getInstance().prefix;
	private final String USAGE = FastWorldManager.getInstance().USAGE + " /setday <NombreDeJours>";

	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if(p.getCustomName() == null)
				p.setCustomName(p.getName());
		}

		if (args.length == 1) {
			try {
				World monde = Bukkit.getWorlds().get(0);
				int jours = Integer.parseInt(args[0]);
				long realjours = jours * 24000 + monde.getTime();
				if (jours >= 0 && jours <= 10000) {
					if (sender instanceof Player) {
						Player p = (Player) sender;
						if (jours == 0) {
							Bukkit.broadcastMessage(
									prefix + "§1" + p.getCustomName() + "§b a réglé le jour de la map au premier.");
							return true;
						}
						Bukkit.broadcastMessage(prefix + "§1" + p.getCustomName() + "§b a réglé le jour de la map à "
								+ jours + " jours.");
					} else {
						if (jours == 0) {
							Bukkit.broadcastMessage(prefix + "§bLa §1Console§b a réglé le jour de la map au premier.");
							return true;
						}
						Bukkit.broadcastMessage(
								prefix + "§bLa §1Console§b a réglé le jour de la map à " + jours + " jours.");
					}
					monde.setFullTime(realjours);
				} else if (jours < 0) {
					sender.sendMessage("§cLes ticks doivent être supérieurs ou égaux à 0 !");
				} else if (jours > 24000)
					sender.sendMessage("§cLes ticks doivent être inférieurs ou égaux à 24000 !");

			} catch (Exception e) {
				sender.sendMessage(prefix + "§6" + args[0]
						+ "§cn'est pas un chiffre valable ! Votre argument doit être un nombre compris entre 0 et 24000 !");
			}
		} else {
			sender.sendMessage(USAGE);
		}
		return false;
	}
}