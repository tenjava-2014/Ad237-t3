package com.tenjava.entries.Ad237.t3.event;

import com.tenjava.entries.Ad237.t3.RandomEvents;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class RandomEvent implements Listener {

    private final static Random rand = new Random();

    private RandomEvents plugin;

    private String section;
    private String name;
    private double chance;
    private List<String> description;
    private boolean enabled;
    private Material type;

    public RandomEvent(RandomEvents plugin, String section) {
        this.plugin = plugin;
        this.section = section;
        this.name = plugin.getConfig().getString(section + ".name");
        this.chance = plugin.getConfig().getDouble(section + ".chance");
        this.enabled = plugin.getConfig().getBoolean(section + ".enabled");
        this.type = Material.getMaterial(plugin.getConfig().getString(section + ".material"));
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

        this.plugin.getConfig().set(section + ".enabled", enabled);
        this.plugin.saveConfig();
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
     * Set the chance of the event occuring.
     *
     * @param chance The chance.
     */
    public void setChance(double chance) {
        this.chance = chance;

        this.plugin.getConfig().set(section + ".chance", chance);
        this.plugin.saveConfig();
    }

    /**
     * Will return whether the event should occur based on a random double compared to the chance of the event.
     *
     * @return Whether the event should happen.
     */
    public boolean shouldHappen() {
        return rand.nextDouble() < getChance();
    }

    /**
     * Generate an itemstack to represent the event.
     *
     * @return The itemstack.
     */
    public ItemStack getItemstack() {
        ItemStack item = new ItemStack(type, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(getName());

        ArrayList<String> lore = new ArrayList<String>();
        for(String line : description) {
            lore.add(ChatColor.GRAY + line);
        }

        lore.add("");
        lore.add(ChatColor.GOLD + "Enabled: " + (isEnabled() ? ChatColor.GREEN + "True" : ChatColor.RED + "False"));
        lore.add(ChatColor.GOLD + "Chance: " + ChatColor.GRAY + ((int) (getChance() * 100)) + "%");
        lore.add("");

        if(isEnabled()) {
            lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Shift click" + ChatColor.GRAY + " to " + ChatColor.RED +  ChatColor.BOLD + "Disable");
        } else {
            lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Shift click" + ChatColor.GRAY + " to " + ChatColor.GREEN +  ChatColor.BOLD + "Enable");
        }

        lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Left click" + ChatColor.GRAY + " to " + ChatColor.RED +  ChatColor.BOLD + "Decrease Chance");
        lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Right click" + ChatColor.GRAY + " to " + ChatColor.GREEN +  ChatColor.BOLD + "Increase Chance");

        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

}
