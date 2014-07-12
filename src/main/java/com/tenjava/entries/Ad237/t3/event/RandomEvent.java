package com.tenjava.entries.Ad237.t3.event;

import org.bukkit.event.Listener;

public abstract class RandomEvent implements Listener {

    private String name;
    private String[] description;
    private boolean enabled;

    public RandomEvent(String name, String[] description, boolean enabled) {
        this.name = name;
        this.description = description;
        this.enabled = enabled;
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

}
