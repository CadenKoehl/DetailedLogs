package com.cadenkoehl.detailedlogs.listeners.blocks;

import com.cadenkoehl.detailedlogs.util.LogType;
import com.cadenkoehl.detailedlogs.util.Logger;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        String name = event.getPlayer().getName();
        Player player = event.getPlayer();
        Block block = event.getBlock();
        String world = player.getWorld().getName();
        Location pos = player.getLocation();
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        String worldName = "the overworld";
        if(world.contains("end")) {
            worldName = "the end";
        }
        if(world.contains("nether")) {
            worldName = "the nether";
        }

        String blockName = block.getType().name();
        Logger.log(LogType.BLOCK,  name + " broke block " + blockName + " in " + worldName + "! [" + x + " " + y + " " + z + "]");
    }
}