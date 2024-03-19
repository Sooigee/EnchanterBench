package org.enchanterbench.ebench;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Map;

public final class EnchanterbenchPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        saveDefaultConfig();
    }

    @EventHandler
    public void onCraftItem(CraftItemEvent event) {
        ItemStack craftedItem = event.getCurrentItem();
        if (craftedItem != null && craftedItem.getType() != Material.AIR) {
            applyEnchantments(craftedItem);
        }
    }

    private void applyEnchantments(ItemStack item) {
        FileConfiguration config = this.getConfig();
        String itemId = item.getType().toString().toLowerCase();
        List<Map<?, ?>> enchantmentConfigs = config.getMapList("enchantments." + itemId);
        for (Map<?, ?> enchantmentConfig : enchantmentConfigs) {
            Enchantment enchantment = Enchantment.getByName((String) enchantmentConfig.get("enchantment"));
            int level = (int) enchantmentConfig.get("level");
            if (enchantment != null) {
                item.addUnsafeEnchantment(enchantment, level);
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("enchanterbench")) {
            if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("enchanterbench.reload")) {
                    reloadConfig();
                    sender.sendMessage("EnchanterBench configuration reloaded.");
                } else {
                    sender.sendMessage("You do not have permission to reload the EnchanterBench configuration.");
                }
                return true;
            } else {
                sender.sendMessage("Usage: /enchanterbench reload");
            }
        }
        return false;
    }
}
