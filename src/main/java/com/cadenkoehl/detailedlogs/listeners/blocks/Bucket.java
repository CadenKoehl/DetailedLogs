package com.cadenkoehl.detailedlogs.listeners.blocks;

import com.cadenkoehl.detailedlogs.util.LogType;
import com.cadenkoehl.detailedlogs.util.Logger;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.inventory.ItemStack;

public class Bucket implements Listener {
    @EventHandler
    public void onBucketFill(PlayerBucketFillEvent event) {
        String name = event.getPlayer().getName();
        Player player = event.getPlayer();
        ItemStack liquid = event.getItemStack();
        Location pos = player.getLocation();

        String itemName = liquid.getType().name();

        Logger.log(LogType.BUCKET, pos, name + " filled a " + itemName.replace("_", " ").toLowerCase());
    }
    @EventHandler
    public void onBucketEmpty(PlayerBucketEmptyEvent event) {
        String name = event.getPlayer().getName();
        Player player = event.getPlayer();
        ItemStack liquid = event.getItemStack();
        Location pos = player.getLocation();
        String itemName = liquid.getType().name();
        Logger.log(LogType.BUCKET, pos, name + " placed a " + itemName.replace("_", " ").toLowerCase());
    }
}
