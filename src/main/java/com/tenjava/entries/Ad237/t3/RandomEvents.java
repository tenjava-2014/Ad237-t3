package com.tenjava.entries.Ad237.t3;

import com.tenjava.entries.Ad237.t3.event.RandomEvent;
import com.tenjava.entries.Ad237.t3.event.events.DiscoSheep;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class RandomEvents extends JavaPlugin {

    private static RandomEvents instance;

    private ArrayList<RandomEvent> randomEvents = new ArrayList<RandomEvent>();

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        registerEvent(new DiscoSheep(getConfig().getDouble("disco-sheep.chance"), getConfig().getBoolean("disco-sheep.enabled")));
    }

    public static RandomEvents getInstance() {
        return instance;
    }

    public ArrayList<RandomEvent> getRandomEvents() {
        return randomEvents;
    }

    public RandomEvent getRandomEvent(String name) {
        for(RandomEvent event : getRandomEvents()) {
            if(event.getName().equalsIgnoreCase(name)) {
                return event;
            }
        }
        return null;
    }

    public void registerEvent(RandomEvent event) {
        randomEvents.add(event);
        Bukkit.getPluginManager().registerEvents(event, this);
    }
}
