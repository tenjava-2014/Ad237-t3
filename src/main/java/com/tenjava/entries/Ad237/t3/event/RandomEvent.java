package com.tenjava.entries.Ad237.t3.event;

import org.bukkit.event.Listener;

import java.util.Random;

public abstract class RandomEvent implements Listener {

    private final static Random rand = new Random();

    private String name;
    private double chance;
    private String[] description;
    private boolean enabled;

    public RandomEvent(String name, double chance, boolean enabled, String... description) {
        this.name = name;
        this.chance = chance;
        this.enabled = enabled;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String[] getDescription() {
        return description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public double getChance() {
        return chance;
    }

    public boolean shouldHappen() {
        return rand.nextDouble() < getChance();
    }

}
