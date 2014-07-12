package com.tenjava.entries.Ad237.t3;

import org.bukkit.plugin.java.JavaPlugin;

public class TenJava extends JavaPlugin {

    private static TenJava instamce;

    @Override
    public void onEnable() {
        instamce = this;
    }

    public static TenJava getInstamce() {
        return instamce;
    }
}
