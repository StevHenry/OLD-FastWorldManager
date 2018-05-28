package fr.lolilolulolilol.fastworldmanager.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.lolilolulolilol.fastworldmanager.FastWorldManager;

public class CommandT implements CommandExecutor {

	private final String prefix = FastWorldManager.getInstance().prefix;
	private final String USAGE = FastWorldManager.getInstance().USAGE + "/t <HeureEnTicks> §c!";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.getCustomName() == null)
				p.setCustomName(p.getName());
		}

		if (args.length == 1) {
			try {
				int heure = Integer.parseInt(args[0]);
				if (heure >= 0 && heure <= 24000) {
					if (sender instanceof Player) {
						Player p = (Player) sender;
						Bukkit.broadcastMessage(
								prefix + p.getCustomName() + "§b a réglé l'heure à " + heure + " ticks.");
					} else
						Bukkit.broadcastMessage(prefix + "§bLa §1Console§b a réglé l'heure à " + heure + " ticks.");
					Bukkit.getWorlds().get(0).setTime(heure);
				} else if (heure < 0) {
					sender.sendMessage("§cLes ticks doivent être supérieurs ou égaux à 0 !");
				} else if (heure > 24000)
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