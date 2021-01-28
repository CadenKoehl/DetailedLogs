package com.cadenkoehl.detailedlogs.listeners.blocks;

import com.cadenkoehl.detailedlogs.util.LogType;
import com.cadenkoehl.detailedlogs.util.Logger;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        String name = event.getPlayer().getName();
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Location pos = player.getLocation();

        String blockName = block.getType().name();
        Logger.log(LogType.BLOCK_PLACE, pos,name + " placed block " + blockName);
    }
}
