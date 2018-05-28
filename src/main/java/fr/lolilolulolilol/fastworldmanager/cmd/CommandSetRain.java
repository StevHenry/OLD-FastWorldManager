package fr.lolilolulolilol.fastworldmanager.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

import fr.lolilolulolilol.fastworldmanager.FastWorldManager;

public class CommandSetRain implements CommandExecutor, Listener {

	private final String prefix = FastWorldManager.getInstance().prefix;
	private final String USAGE = FastWorldManager.getInstance().USAGE + " /setrain <true/false> §c!";
	private boolean canRain = false;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.getCustomName() == null)
				p.setCustomName(p.getName());
		}

		if (args.length == 1) {
			try {
				canRain = Boolean.parseBoolean(args[0]);
				if (canRain) {
					sender.sendMessage(prefix + "§aLa pluie est activée!");
				} else
					sender.sendMessage(prefix + "§cLa pluie est désactivée!");
			} catch (Exception e) {
				sender.sendMessage(prefix + "§6" + args[0] + "§c doit être §6true §c ou §6false §c!");
			}
		} else {
			sender.sendMessage(USAGE);
		}
		return false;
	}

	@EventHandler
	public void onPluie(WeatherChangeEvent e) {
		if (e.toWeatherState() && !canRain)
			e.setCancelled(true);
	}
}
