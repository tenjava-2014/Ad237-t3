package com.tenjava.entries.Ad237.t3.listeners;

import com.tenjava.entries.Ad237.t3.RandomEvents;
import com.tenjava.entries.Ad237.t3.event.RandomEvent;
import com.tenjava.entries.Ad237.t3.utils.SettingsMenu;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
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
                        if(event.getClick() == ClickType.SHIFT_LEFT || event.getClick() == ClickType.SHIFT_RIGHT) {
                            randomEvent.setEnabled(!randomEvent.isEnabled());
                            p.playSound(p.getLocation(), Sound.NOTE_PLING, 3F, 3F);
                        }
                        else if(event.getClick() == ClickType.RIGHT) {
                            if(randomEvent.getChance() >= 1.0) {
                                p.playSound(p.getLocation(), Sound.ANVIL_USE, 3F, 3F);
                            } else {
                                randomEvent.setChance(randomEvent.getChance() + 0.01);
                                p.playSound(p.getLocation(), Sound.NOTE_PLING, 3F, 3F);
                            }
                        }
                        else if(event.getClick() == ClickType.LEFT) {
                            if(randomEvent.getChance() <= 0.0) {
                                p.playSound(p.getLocation(), Sound.ANVIL_USE, 3F, 3F);
                            } else {
                                randomEvent.setChance(randomEvent.getChance() - 0.01);
                                p.playSound(p.getLocation(), Sound.NOTE_PLING, 3F, 3F);
                            }
                        }

                        SettingsMenu menu = new SettingsMenu(plugin);
                        p.getOpenInventory().getTopInventory().setContents(menu.getInventory().getContents());
                    }
                }
            }
        }
    }
}
