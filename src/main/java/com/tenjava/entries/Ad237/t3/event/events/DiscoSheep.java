package com.tenjava.entries.Ad237.t3.event.events;

import com.tenjava.entries.Ad237.t3.event.RandomEvent;
import com.tenjava.entries.Ad237.t3.utils.EntityUtils;
import org.bukkit.DyeColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.ArrayList;
import java.util.UUID;

public class DiscoSheep extends RandomEvent {

    private ArrayList<UUID> discoSheep = new ArrayList<UUID>();

    public DiscoSheep(double chance, boolean enabled) {
        super("DiscoSheep", chance, enabled, "Chance to spawn a special sheep", "that will change colors!");
    }

    public void updateSheep() {
        for(UUID uuid : discoSheep) {
            Entity entity = EntityUtils.getEntityByUUID(uuid);

            if(entity != null && entity instanceof Sheep) {
                Sheep sheep = (Sheep) entity;
                sheep.setColor(getNextColor(sheep));
            }
        }
    }

    @EventHandler
    public void onSpawn(CreatureSpawnEvent event) {
        LivingEntity entity = event.getEntity();

        if(entity instanceof Sheep) {
            Sheep sheep = (Sheep) entity;

            if(shouldHappen()) {
                discoSheep.add(sheep.getUniqueId());
            }
        }
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();

        if(this.discoSheep.contains(entity.getUniqueId())) {
            this.discoSheep.remove(entity.getUniqueId());
        }
    }

    public DyeColor getNextColor(Sheep sheep) {
        DyeColor nextColor = null;

        if(sheep.getColor() == null || sheep.getColor() == DyeColor.WHITE) {
            nextColor = DyeColor.RED;
        } else if(sheep.getColor() == DyeColor.RED) {
            nextColor = DyeColor.GREEN;
        } else if(sheep.getColor() == DyeColor.GREEN) {
            nextColor = DyeColor.BLUE;
        } else if(sheep.getColor() == DyeColor.BLUE) {
            nextColor = DyeColor.YELLOW;
        } else if(sheep.getColor() == DyeColor.YELLOW) {
            nextColor = DyeColor.PURPLE;
        } else if(sheep.getColor() == DyeColor.PURPLE) {
            nextColor = DyeColor.PINK;
        } else if(sheep.getColor() == DyeColor.PINK) {
            nextColor = DyeColor.RED;
        } else {
            nextColor = DyeColor.RED;
        }

        return nextColor;
    }
}
