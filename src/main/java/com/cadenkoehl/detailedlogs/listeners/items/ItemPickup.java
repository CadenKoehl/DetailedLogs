package com.cadenkoehl.detailedlogs.listeners.items;

import com.cadenkoehl.detailedlogs.util.LogType;
import com.cadenkoehl.detailedlogs.util.Logger;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

import java.util.Locale;

public class ItemPickup implements Listener {
    @EventHandler
    public void onPlayerPickupItem(EntityPickupItemEvent event) {
        if(event.getEntity().getType() == EntityType.PLAYER) {
            Player player = (Player) event.getEntity();
            String item = event.getItem().getItemStack().getType().name().toLowerCase().replace("_", " ");
            if(item.equalsIgnoreCase("air")) {
                return;
            }
            String customName = event.getItem().getCustomName();
            String message = player.getName() + " just picked up the item " + item;
            if(customName != null) {
                message = message + " [" + customName + "]";
            }
            Logger.log(LogType.ITEM_PICKUP, player.getLocation(), message);
        }
    }
}
