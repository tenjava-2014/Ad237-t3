package com.tenjava.entries.Ad237.t3;

import com.tenjava.entries.Ad237.t3.command.RandomEventsCommand;
import com.tenjava.entries.Ad237.t3.event.RandomEvent;
import com.tenjava.entries.Ad237.t3.event.events.DiscoSheep;
import com.tenjava.entries.Ad237.t3.event.events.ExplodingRedstone;
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

        getCommand("randomevents").setExecutor(new RandomEventsCommand(this));

        registerEvent(new DiscoSheep(this));
        registerEvent(new ExplodingRedstone(this));
    }

    /**
     * Get an instance of the plugin.
     *
     * @return An instance of the plugin.
     */
    public static RandomEvents getInstance() {
        return instance;
    }

    /**
     * Get a list of registered random events.
     *
     * @return A list of random events.
     */
    public ArrayList<RandomEvent> getRandomEvents() {
        return randomEvents;
    }

    /**
     * Get an event by name.
     *
     * @param name Name of the event.
     * @return The event.
     */
    public RandomEvent getRandomEvent(String name) {
        for(RandomEvent event : getRandomEvents()) {
            if(event.getName().equalsIgnoreCase(name)) {
                return event;
            }
        }
        return null;
    }

    /**
     * Register a random event.
     *
     * @param event The event to register.
     */
    public void registerEvent(RandomEvent event) {
        randomEvents.add(event);
        Bukkit.getPluginManager().registerEvents(event, this);
    }
}
