package com.tenjava.entries.Ad237.t3.command;

import com.tenjava.entries.Ad237.t3.RandomEvents;
import com.tenjava.entries.Ad237.t3.utils.SettingsMenu;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RandomEventsCommand implements CommandExecutor {

    private RandomEvents plugin;
    public RandomEventsCommand(RandomEvents plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be run by a player.");
            return false;
        }

        Player p = (Player) sender;
        if(args.length == 0) {
            p.sendMessage(ChatColor.LIGHT_PURPLE + "==========[" + ChatColor.YELLOW + " Commands " + ChatColor.LIGHT_PURPLE + "]==========");
            return false;
        }

        if(args[0].equalsIgnoreCase("settings") || args[0].equalsIgnoreCase("events")) {
            if(p.hasPermission("randomevents.menu")) {
                new SettingsMenu(plugin).showToPlayer(p);
            } else {
                p.sendMessage(ChatColor.RED + "No permission.");
            }
        }

        return true;
    }
}
