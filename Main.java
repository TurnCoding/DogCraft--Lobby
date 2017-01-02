package me.bcnetwork.lobbysystem;


import me.bcnetwork.lobbysystem.Commands.HelpCommand;
import me.bcnetwork.lobbysystem.Commands.SelectorCommand;
import me.bcnetwork.lobbysystem.Commands.StaffCommand;
import me.bcnetwork.lobbysystem.listeners.JoinEvent;
import me.bcnetwork.lobbysystem.listeners.LeaveEvent;
import me.bcnetwork.lobbysystem.listeners.ServerSelector.InteractEvent;
import me.bcnetwork.lobbysystem.listeners.ServerSelector.InvInteractEvent;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	  
	public void onEnable() {
		registerCommands();
		getConfig().set("Enabled", true);
		this.getCommand("help").setExecutor(new HelpCommand());
		this.getCommand("selector").setExecutor(new SelectorCommand());
		this.getCommand("staff").setExecutor(new StaffCommand());
	}
		
	
	


	public void onDisable() {
		
	}
	private void registerCommands() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new JoinEvent(), this);
		pm.registerEvents(new LeaveEvent(), this);
		pm.registerEvents(new InteractEvent(), this);
		pm.registerEvents(new InvInteractEvent(), this);
	}
}
