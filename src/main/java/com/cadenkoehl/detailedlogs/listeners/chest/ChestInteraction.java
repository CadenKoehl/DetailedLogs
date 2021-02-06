package com.cadenkoehl.detailedlogs.listeners.chest;

import com.cadenkoehl.detailedlogs.util.LogType;
import com.cadenkoehl.detailedlogs.util.Logger;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ChestInteraction implements Listener {
    @EventHandler
    public void onChestOpen(PlayerInteractEvent event) {
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player player = event.getPlayer();
            Location pos = player.getLocation();
            Block block = event.getClickedBlock();
            if(block != null) {
                if(event.getClickedBlock().getType() == Material.CHEST) {
                    Logger.log(LogType.CHEST, pos, player.getName() + " opened a chest");
                }
            }
        }
    }
}
