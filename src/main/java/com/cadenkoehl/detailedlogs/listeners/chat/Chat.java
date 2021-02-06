package com.cadenkoehl.detailedlogs.listeners.chat;

import com.cadenkoehl.detailedlogs.util.LogType;
import com.cadenkoehl.detailedlogs.util.Logger;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        String name = event.getPlayer().getName();
        Location pos = event.getPlayer().getLocation();
        Logger.log(LogType.CHAT, pos,"[CHAT] <" + name + "> \"" + message + "\"");
    }
}