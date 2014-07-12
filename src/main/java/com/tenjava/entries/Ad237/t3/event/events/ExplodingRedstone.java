package com.tenjava.entries.Ad237.t3.event.events;

import com.tenjava.entries.Ad237.t3.event.RandomEvent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

public class ExplodingRedstone extends RandomEvent {

    public ExplodingRedstone(double chance, boolean enabled) {
        super("Exploding Redstone", chance, enabled, "Chance for redstone to EXPLODE when", "destroyed!");
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if(!isEnabled()) {
            return;
        }
        
        Block block = event.getBlock();
        if(block.getType() == Material.REDSTONE_ORE || block.getType() == Material.GLOWING_REDSTONE_ORE) {
            if(shouldHappen()) {
                Location loc = block.getLocation();
                loc.getWorld().createExplosion(loc, 3);
            }
        }
    }
}
