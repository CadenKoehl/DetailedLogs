package com.cadenkoehl.detailedlogs.listeners.entity;

import com.cadenkoehl.detailedlogs.util.LogType;
import com.cadenkoehl.detailedlogs.util.Logger;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class Damage implements Listener {
    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        Location pos = entity.getLocation();
        String name;
        if(entity.getType() == EntityType.PLAYER) {
            Player player = (Player) entity;
            name = "Player " + player.getName();
        }
        else {
            name = entity.getType().name().toLowerCase().replace("_", " ");
        }
        String cause = event.getCause().name().toLowerCase().replace("_", " ");
        String message = name + " was damaged by " + cause;
        Logger.log(LogType.DAMAGE, pos, message);
    }
}