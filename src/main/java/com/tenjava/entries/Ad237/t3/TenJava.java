package com.tenjava.entries.Ad237.t3;

import org.bukkit.plugin.java.JavaPlugin;

public class TenJava extends JavaPlugin {

    private static TenJava instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    public static TenJava getInstance() {
        return instance;
    }
}
