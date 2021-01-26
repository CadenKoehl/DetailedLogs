package com.cadenkoehl.detailedlogs.util;

import com.cadenkoehl.detailedlogs.DetailedLogs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public class Logger {
    private static DetailedLogs plugin;
    public static void log(LogType type, String message) {
        plugin = DetailedLogs.getPlugin(DetailedLogs.class);
        String date = new Date().toString();
        String[] day = date.split("\\s+");
        StringBuilder path = new StringBuilder(plugin.getDataFolder().getPath());
        switch (type) {
            case CHAT:
                path.append("/chat/");
            case ITEM:
                path.append("/item/");
            case MISC:
                path.append("/misc/");
            case BLOCK:
                path.append("/block/");
        }
        File dir = new File(String.valueOf(path));
        if(dir.mkdirs()) {
            System.out.println("[DetailedLogs] Directory \"" + path + "\" has been created");
        }
        File log = new File(path + day[1] + "-" + day[2] + "-" + day[5] + ".txt");
        File compiledLogDir = new File(plugin.getDataFolder().getPath() + "compiled-log/");
        if(compiledLogDir.mkdirs()) {
            System.out.println("[DetailedLogs] Directory \"" + path + "\" has been created");
        }
        try {
            FileWriter write = new FileWriter(log, true);
            write.write("\n" + message);
            write.close();
        } catch (IOException e) {
            System.out.println("A fatal error has occurred in Detailedlogs! Please report this bug ASAP!");
            e.printStackTrace();
        }
    }
}
