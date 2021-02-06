package com.cadenkoehl.detailedlogs.util;

import com.cadenkoehl.detailedlogs.DetailedLogs;
import org.bukkit.Location;
import org.bukkit.block.Biome;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public class Logger {
    public static void log(String type , Location pos, String message) {
        DetailedLogs plugin = DetailedLogs.getPlugin(DetailedLogs.class);
        String dateRaw = new Date().toString();
        String[] dateSplit = dateRaw.split("\\s+");
        String date = dateSplit[1] + "-" + dateSplit[2] + "-" + dateSplit[5];
        StringBuilder path = new StringBuilder(plugin.getDataFolder().getPath());
        String compiledLogPath = plugin.getDataFolder() + "/compiled-log/";

        path.append(type);

        File dir = new File(String.valueOf(path));
        File compiledLogDir = new File(compiledLogPath);
        if(dir.mkdirs()) {
            System.out.println("[DetailedLogs] Directory \"" + path + "\" has been created");
        }
        if(compiledLogDir.mkdirs()) {
            System.out.println("[DetailedLogs] Directory \"" + path + "\" has been created");
        }
        File log = new File(path + date + ".txt");
        File compiledLog = new File(compiledLogPath + date + ".txt");
        int x = (int) pos.getX();
        int y = (int) pos.getY();
        int z = (int) pos.getZ();
        Biome biome = pos.getWorld().getBiome(x, y, z);
        String biomeName = biome.getKey().getKey();
        try {
            FileWriter write = new FileWriter(log, true);
            FileWriter compiledLogWriter = new FileWriter(compiledLog, true);
            String output = "\n[" + dateRaw + "] " + message + " in biome " + biomeName + " [" + x + " " + y + " " + z + "]";
            write.write(output);
            write.close();
            compiledLogWriter.write(output);
            compiledLogWriter.close();
        } catch (IOException e) {
            System.out.println("A fatal error has occurred in Detailedlogs! Please report this bug ASAP!");
            e.printStackTrace();
        }
    }
    public static void logInfo(String type, String message) {
        DetailedLogs plugin = DetailedLogs.getPlugin(DetailedLogs.class);
        String dateRaw = new Date().toString();
        String[] dateSplit = dateRaw.split("\\s+");
        String date = dateSplit[1] + "-" + dateSplit[2] + "-" + dateSplit[5];
        StringBuilder path = new StringBuilder(plugin.getDataFolder().getPath());
        String compiledLogPath = plugin.getDataFolder() + "/compiled-log/";

        path.append(type);

        File dir = new File(String.valueOf(path));
        File compiledLogDir = new File(compiledLogPath);
        if(dir.mkdirs()) {
            System.out.println("[DetailedLogs] Directory \"" + path + "\" has been created");
        }
        if(compiledLogDir.mkdirs()) {
            System.out.println("[DetailedLogs] Directory \"" + path + "\" has been created");
        }
        File log = new File(path + date + ".txt");
        File compiledLog = new File(compiledLogPath + date + ".txt");
        try {
            FileWriter write = new FileWriter(log, true);
            FileWriter compiledLogWriter = new FileWriter(compiledLog, true);
            String output = "\n[" + dateRaw + "] " + message;
            write.write(output);
            write.close();
            compiledLogWriter.write(output);
            compiledLogWriter.close();
        } catch (IOException e) {
            System.out.println("A fatal error has occurred in Detailedlogs! Please report this bug ASAP!");
            e.printStackTrace();
        }
    }
}
