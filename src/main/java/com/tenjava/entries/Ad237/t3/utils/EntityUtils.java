package com.tenjava.entries.Ad237.t3.utils;

import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import java.util.UUID;

public class EntityUtils {

    public static Entity getEntityByUUID(UUID uuid) {
        for(World world : Bukkit.getWorlds()) {
            for(Entity entity : world.getEntities()) {
                if(entity.getUniqueId().equals(uuid)) {
                    return entity;
                }
            }
        }
        return null;
    }

    public static String getName(LivingEntity entity) {
        if(entity.getCustomName() != null) {
            return entity.getCustomName();
        }

        return WordUtils.capitalize(entity.getType().toString().toLowerCase().replace("_", " "));
    }
}
