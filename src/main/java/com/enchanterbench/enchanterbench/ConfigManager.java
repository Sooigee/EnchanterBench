package com.enchanterbench.enchanterbench;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigManager {
    private static Map<String, List<String>> enchantmentsMap = new HashMap<>();
    private static boolean messagesEnabled = true; // Default value
    private static final Path CONFIG_PATH = Paths.get("config/enchanterbench.json");

    public static void loadConfig() {
        try {
            if (!Files.exists(CONFIG_PATH)) {
                createDefaultConfig();
            }

            Gson gson = new Gson();
            Type type = new TypeToken<Config>(){}.getType();
            FileReader reader = new FileReader(CONFIG_PATH.toString());
            Config config = gson.fromJson(reader, type);
            enchantmentsMap = config.enchants;
            messagesEnabled = config.messagesEnabled; // Load the setting
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createDefaultConfig() {
        Map<String, List<String>> defaultEnchantments = new HashMap<>();
        defaultEnchantments.put("minecraft:diamond_sword", List.of("minecraft:sharpness:5", "minecraft:knockback:2"));

        Config defaultConfig = new Config();
        defaultConfig.enchants = defaultEnchantments;
        defaultConfig.messagesEnabled = false; // Default value

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(CONFIG_PATH.toString())) {
            gson.toJson(defaultConfig, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getEnchantmentForItem(String itemId) {
        return enchantmentsMap.getOrDefault(itemId, null);
    }

    // New method to check if messages are enabled
    public static boolean areMessagesEnabled() {
        return messagesEnabled;
    }

    private static class Config {
        Map<String, List<String>> enchants;
        boolean messagesEnabled;
    }
}
