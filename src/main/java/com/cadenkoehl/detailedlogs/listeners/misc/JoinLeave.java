package com.cadenkoehl.detailedlogs.listeners.misc;

import com.cadenkoehl.detailedlogs.DetailedLogs;
import com.cadenkoehl.detailedlogs.util.LogType;
import com.cadenkoehl.detailedlogs.util.Logger;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.net.InetSocketAddress;

public class JoinLeave implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String joinMessage = player.getName() + " joined the game";
        InetSocketAddress address = player.getAddress();
        String hostName = "[unknown]";
        if (address != null) {
            hostName = address.getHostName();
        }
        int players = Bukkit.getServer().getOnlinePlayers().size();
        Logger.log(LogType.MISC, player.getLocation(), joinMessage + " from the IP " + hostName);
        Logger.logInfo(LogType.MISC, "The current player count is " + players);
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String quitMessage = player.getName() + " left the game";
        InetSocketAddress address = player.getAddress();
        String hostName = "[unknown]";
        if (address != null) {
            hostName = address.getHostName();
        }
        Logger.log(LogType.MISC, player.getLocation(), quitMessage + " from the IP " + hostName);
        int players = Bukkit.getServer().getOnlinePlayers().size();
        Logger.logInfo(LogType.MISC, "The current player count is " + players);
    }
}