package com.cadenkoehl.detailedlogs.listeners.chat;

import com.cadenkoehl.detailedlogs.util.LogType;
import com.cadenkoehl.detailedlogs.util.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Commands implements Listener {
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        String command = event.getMessage();
        String name = event.getPlayer().getName();
        Location pos = event.getPlayer().getLocation();
        Logger.log(LogType.COMMAND, pos, name + " ran command \"" + command + "\"");
    }
}