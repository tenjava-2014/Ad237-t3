package com.tenjava.entries.Ad237.t3.event.events;

import com.tenjava.entries.Ad237.t3.event.RandomEvent;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.ArrayList;
import java.util.UUID;

public class DiscoSheep extends RandomEvent {

    private ArrayList<UUID> discoSheep = new ArrayList<UUID>();

    public DiscoSheep(boolean enabled) {
        super("DiscoSheep", enabled, "Chance to spawn a special sheep", "that will change colors!");
    }

    @EventHandler
    public void onSpawn(CreatureSpawnEvent event) {
        LivingEntity entity = event.getEntity();

        if(entity instanceof Sheep) {
            Sheep sheep = (Sheep) entity;


        }
    }
}
