package com.cadenkoehl.detailedlogs;

import com.cadenkoehl.detailedlogs.util.Registry;
import org.bukkit.plugin.java.JavaPlugin;

public class DetailedLogs extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("[DetailedLogs] Thank you for choosing Detailed Logs! To view the server logs, go to your plugins folder, then the detailed logs folder!");
        Registry.registerListeners(this);
    }

    @Override
    public void onDisable() {}
}