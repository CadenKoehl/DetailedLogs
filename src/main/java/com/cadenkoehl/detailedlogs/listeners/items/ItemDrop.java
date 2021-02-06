package com.cadenkoehl.detailedlogs.listeners.items;

import com.cadenkoehl.detailedlogs.util.LogType;
import com.cadenkoehl.detailedlogs.util.Logger;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDrop implements Listener {
    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        String item = event.getItemDrop().getItemStack().getType().name().toLowerCase().replace("_", " ");
        String customName = event.getItemDrop().getCustomName();
        String message = player.getName() + " just dropped up the item " + item;
        if(item.equalsIgnoreCase("air")) {
            return;
        }
        if(customName != null) {
            message = message + " [" + customName + "]";
        }
        Logger.log(LogType.ITEM_DROP, player.getLocation(), message);
    }
}