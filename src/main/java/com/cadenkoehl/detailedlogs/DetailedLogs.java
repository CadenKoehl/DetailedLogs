package com.cadenkoehl.detailedlogs;

import com.cadenkoehl.detailedlogs.listeners.BlockBreak;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class DetailedLogs extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("Detailed Logs has been enabled!");
        testWrite();
        super.getServer().getPluginManager().registerEvents(new BlockBreak(), this);
    }

    @Override
    public void onDisable() {}

    public void testWrite() {
        String date = new Date().toString();
        try {
            File file = new File(getDataFolder(), date + ".txt");
            FileWriter write = new FileWriter(file);
            write.write("Test!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}