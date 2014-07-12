package com.tenjava.entries.Ad237.t3.listeners;

import com.tenjava.entries.Ad237.t3.RandomEvents;
import com.tenjava.entries.Ad237.t3.event.RandomEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryListener implements Listener {

    private RandomEvents plugin;
    public InventoryListener(RandomEvents plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if(event.getWhoClicked() instanceof Player) {
            Player p = (Player) event.getWhoClicked();

            if(event.getInventory().getName().equals("RandomEvents")) {
                event.setCancelled(true);

                ItemStack item = event.getCurrentItem();

                if(item != null && item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
                    RandomEvent randomEvent = plugin.getRandomEvent(item.getItemMeta().getDisplayName());

                    if(randomEvent != null) {
                        //TODO
                    }
                }
            }
        }
    }
}
