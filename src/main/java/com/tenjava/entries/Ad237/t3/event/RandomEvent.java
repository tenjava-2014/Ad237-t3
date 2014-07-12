package com.tenjava.entries.Ad237.t3.event;

import com.tenjava.entries.Ad237.t3.RandomEvents;
import org.bukkit.event.Listener;

import java.util.List;
import java.util.Random;

public abstract class RandomEvent implements Listener {

    private final static Random rand = new Random();

    private String section;
    private String name;
    private double chance;
    private List<String> description;
    private boolean enabled;

    public RandomEvent(RandomEvents plugin, String section) {
        this.section = section;
        this.name = plugin.getConfig().getString(section + ".name");
        this.chance = plugin.getConfig().getDouble(section + ".chance");
        this.enabled = plugin.getConfig().getBoolean(section + ".enabled");
        this.description = plugin.getConfig().getStringList(section + ".description");
    }

    /**
     * Get the name of the event.
     *
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the description of the event. Returned in a list to be used in the lore of items.
     *
     * @return The description.
     */
    public List<String> getDescription() {
        return description;
    }

    /**
     * Get whether the event is enabled.
     *
     * @return Enabled status.
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Set whether the event is enabled.
     *
     * @param enabled State to set the event to.
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Get the chance of the event occuring.
     *
     * @return Chance of event.
     */
    public double getChance() {
        return chance;
    }

    /**
     * Will return whether the event should occur based on a random double compared to the chance of the event.
     *
     * @return Whether the event should happen.
     */
    public boolean shouldHappen() {
        return rand.nextDouble() < getChance();
    }

}
