package com.cadenkoehl.detailedlogs.util;

import com.cadenkoehl.detailedlogs.DetailedLogs;
import com.cadenkoehl.detailedlogs.listeners.blocks.BlockBreak;
import com.cadenkoehl.detailedlogs.listeners.blocks.BlockPlace;
import com.cadenkoehl.detailedlogs.listeners.blocks.Bucket;
import com.cadenkoehl.detailedlogs.listeners.chat.Chat;
import com.cadenkoehl.detailedlogs.listeners.chat.Commands;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class Registry {
    public static void registerListeners(DetailedLogs plugin) {
        register(new BlockBreak(), plugin);
        register(new BlockPlace(), plugin);
        register(new Bucket(), plugin);
        register(new Chat(), plugin);
        register(new Commands(), plugin);
    }
    private static void register(Listener listener, DetailedLogs plugin) {
        Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
    }
}