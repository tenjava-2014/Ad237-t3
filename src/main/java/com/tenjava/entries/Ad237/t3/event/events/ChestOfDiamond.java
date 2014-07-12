package com.tenjava.entries.Ad237.t3.event.events;

import com.tenjava.entries.Ad237.t3.RandomEvents;
import com.tenjava.entries.Ad237.t3.event.RandomEvent;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class ChestOfDiamond extends RandomEvent {

    public ChestOfDiamond(RandomEvents plugin) {
        super(plugin, "chest-of-diamonds");
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if(!isEnabled()) {
            return;
        }

        Block block = event.getBlock();
        if(block.getType() == Material.DIAMOND_ORE) {
            if(shouldHappen()) {
                event.setCancelled(true);

                block.setType(Material.CHEST);
                Chest chest = (Chest) block.getState();
                for(int x=0; x<chest.getInventory().getSize(); x++) {
                    chest.getInventory().setItem(x, new ItemStack(Material.DIAMOND, 1));
                }

                Firework firework = block.getWorld().spawn(block.getLocation(), Firework.class);
                firework.detonate();
            }
        }
    }
}
