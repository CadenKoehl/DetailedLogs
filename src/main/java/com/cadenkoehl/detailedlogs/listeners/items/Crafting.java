package com.cadenkoehl.detailedlogs.listeners.items;

import com.cadenkoehl.detailedlogs.util.LogType;
import com.cadenkoehl.detailedlogs.util.Logger;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class Crafting implements Listener {
    @EventHandler
    public void onPlayerItemCraft(CraftItemEvent event) {
        ItemStack itemStack = event.getCurrentItem();
        if(itemStack == null) {
            return;
        }
        String itemName = itemStack.getType().name().toLowerCase().replace("_", " ");
        String name = event.getWhoClicked().getName();
        Location pos = event.getWhoClicked().getLocation();
        Logger.log(LogType.ITEM_CRAFT, pos, name + " has crafted the item " + itemName);
    }
}