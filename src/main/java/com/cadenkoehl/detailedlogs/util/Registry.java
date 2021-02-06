package com.cadenkoehl.detailedlogs.util;

import com.cadenkoehl.detailedlogs.DetailedLogs;
import com.cadenkoehl.detailedlogs.listeners.blocks.BlockBreak;
import com.cadenkoehl.detailedlogs.listeners.blocks.BlockPlace;
import com.cadenkoehl.detailedlogs.listeners.blocks.Bucket;
import com.cadenkoehl.detailedlogs.listeners.chat.Chat;
import com.cadenkoehl.detailedlogs.listeners.chat.Commands;
import com.cadenkoehl.detailedlogs.listeners.chest.ChestInteraction;
import com.cadenkoehl.detailedlogs.listeners.entity.Damage;
import com.cadenkoehl.detailedlogs.listeners.entity.Deaths;
import com.cadenkoehl.detailedlogs.listeners.items.Crafting;
import com.cadenkoehl.detailedlogs.listeners.items.ItemDrop;
import com.cadenkoehl.detailedlogs.listeners.items.ItemPickup;
import com.cadenkoehl.detailedlogs.listeners.misc.JoinLeave;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class Registry {
    public static void registerListeners(DetailedLogs plugin) {
        register(new BlockBreak(), plugin);
        register(new BlockPlace(), plugin);
        register(new Bucket(), plugin);
        register(new Chat(), plugin);
        register(new Commands(), plugin);
        register(new ItemDrop(), plugin);
        register(new JoinLeave(), plugin);
        register(new ItemPickup(), plugin);
        register(new Deaths(), plugin);
        register(new ChestInteraction(), plugin);
        register(new Damage(), plugin);
        register(new Crafting(), plugin);
    }
    private static void register(Listener listener, DetailedLogs plugin) {
        Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
    }
}