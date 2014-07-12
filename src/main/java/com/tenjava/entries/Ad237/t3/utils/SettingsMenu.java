package com.tenjava.entries.Ad237.t3.utils;

import com.tenjava.entries.Ad237.t3.RandomEvents;
import com.tenjava.entries.Ad237.t3.event.RandomEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SettingsMenu {

    private Inventory inv;

    public SettingsMenu(RandomEvents plugin) {
        inv = Bukkit.createInventory(null, 9, "RandomEvents");

        for(RandomEvent event : plugin.getRandomEvents()) {
            ItemStack item = event.getItemstack();
            inv.addItem(item);
        }
    }

    public Inventory getInventory() {
        return this.inv;
    }

    public void showToPlayer(Player p) {
        p.openInventory(inv);
    }
}
