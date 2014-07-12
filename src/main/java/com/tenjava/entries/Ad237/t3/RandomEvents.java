package com.tenjava.entries.Ad237.t3;

import org.bukkit.plugin.java.JavaPlugin;

public class RandomEvents extends JavaPlugin {

    private static RandomEvents instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    public static RandomEvents getInstance() {
        return instance;
    }
}
