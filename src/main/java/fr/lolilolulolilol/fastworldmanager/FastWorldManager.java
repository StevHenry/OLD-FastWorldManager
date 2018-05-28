package fr.lolilolulolilol.fastworldmanager;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import fr.lolilolulolilol.fastworldmanager.cmd.CommandD;
import fr.lolilolulolilol.fastworldmanager.cmd.CommandN;
import fr.lolilolulolilol.fastworldmanager.cmd.CommandSD;
import fr.lolilolulolilol.fastworldmanager.cmd.CommandT;
import fr.lolilolulolilol.fastworldmanager.cmd.CommandWC;
import fr.lolilolulolilol.fastworldmanager.cmd.CommandSetRain;

public class FastWorldManager extends JavaPlugin {

	private static FastWorldManager instance;
	public static FastWorldManager getInstance() {
		return instance;
	}

	public final String prefix = "§a[FWM] §r";
	public final String USAGE = prefix + "§cCommande éronnée. Essayez : §r";
	private final String NO_PERMISSION = prefix + "§cVous n'avez pas la permission d'éxécuter cette commande !";

	@Override
	public void onEnable() {
		super.onEnable();
		instance = this;
		saveDefaultConfig();

		getCommand("wc").setExecutor(new CommandWC());
		getCommand("wc").setPermissionMessage(NO_PERMISSION);
		getCommand("d").setExecutor(new CommandD());
		getCommand("d").setPermissionMessage(NO_PERMISSION);
		getCommand("n").setExecutor(new CommandN());
		getCommand("n").setPermissionMessage(NO_PERMISSION);
		getCommand("t").setExecutor(new CommandT());
		getCommand("t").setPermissionMessage(NO_PERMISSION);
		getCommand("setday").setExecutor(new CommandSD());
		getCommand("setday").setPermissionMessage(NO_PERMISSION);
		getCommand("setrain").setExecutor(new CommandSetRain());
		getCommand("setrain").setPermissionMessage(NO_PERMISSION);
		Bukkit.getPluginManager().registerEvents(new CommandSetRain(), this);
	}
}
