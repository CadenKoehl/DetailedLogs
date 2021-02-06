package com.cadenkoehl.detailedlogs.listeners.entity;

import com.cadenkoehl.detailedlogs.util.LogType;
import com.cadenkoehl.detailedlogs.util.Logger;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Deaths implements Listener {
    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        Location pos = entity.getLocation();
        if(entity.getType() == EntityType.PLAYER) {
            return;
        }
        String name = entity.getType().name().toLowerCase();
        EntityDamageEvent damageEvent = entity.getLastDamageCause();
        String message = "A " + name + " entity has died";
        if(damageEvent != null) {
            String cause = damageEvent.getCause().name().toLowerCase().replace("_", " ");
            message = message + " because of " + cause;
        }
        Player killer = entity.getKiller();
        if(killer != null) {
            String killerName = killer.getName();
            message = message + " to " + killerName;
        }
        Logger.log(LogType.DEATH, pos, message);
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        String deathMessage = event.getDeathMessage();
        Location pos = event.getEntity().getLocation();
        Logger.log(LogType.DEATH, pos, deathMessage);
    }
}
