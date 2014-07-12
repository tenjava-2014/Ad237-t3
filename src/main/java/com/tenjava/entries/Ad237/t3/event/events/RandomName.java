package com.tenjava.entries.Ad237.t3.event.events;

import com.tenjava.entries.Ad237.t3.RandomEvents;
import com.tenjava.entries.Ad237.t3.event.RandomEvent;
import com.tenjava.entries.Ad237.t3.utils.EntityUtils;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandomName extends RandomEvent {

    private static Random rand = new Random();
    private ArrayList<String> firstHalf = new ArrayList<String>();

    public RandomName(RandomEvents plugin) {
        super(plugin, "random-name");

        firstHalf.addAll(Arrays.asList("Ultimate", "Super", "Stupid", "Badass", "Raging", "Scary", "Bob the "));
    }

    @EventHandler
    public void onSpawn(CreatureSpawnEvent event) {
        if(!isEnabled()) {
            return;
        }

        if(shouldHappen()) {
            LivingEntity entity = event.getEntity();

            String randomWord = firstHalf.get(rand.nextInt(firstHalf.size()));
            randomWord += EntityUtils.getName(entity);

            entity.setCustomName(randomWord);
            entity.setCustomNameVisible(true);
        }
    }
}
