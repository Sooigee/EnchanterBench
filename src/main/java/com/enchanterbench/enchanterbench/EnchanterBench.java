package com.enchanterbench.enchanterbench;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.network.chat.Component;


import java.util.Collections;
import java.util.Map;
import java.util.List;
import java.util.HashMap;


import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.EventPriority;

@Mod("enchanterbench")
public class EnchanterBench {

	public EnchanterBench() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
	}

	private void setup(final FMLCommonSetupEvent event) {
		ConfigManager.loadConfig();
		net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
		Player player = (Player) event.getEntity();

		ItemStack craftedItem = event.getCrafting();
		String itemId = ForgeRegistries.ITEMS.getKey(craftedItem.getItem()).toString();

		List<String> enchantmentConfigs = ConfigManager.getEnchantmentForItem(itemId);
		if (enchantmentConfigs != null && !enchantmentConfigs.isEmpty()) {
			applyEnchantments(craftedItem, enchantmentConfigs, player);
		}
	}

	private static void applyEnchantments(ItemStack item, List<String> enchantmentConfigs, Player player) {
		Map<Enchantment, Integer> enchantmentsToApply = new HashMap<>();
		boolean hasEnchantmentFailed = false;

		for (String enchantmentConfig : enchantmentConfigs) {
			String[] parts = enchantmentConfig.split(":");
			if (parts.length != 3) {
				if (ConfigManager.areMessagesEnabled()) {
					player.displayClientMessage(Component.literal("Failed to apply enchantments due to incorrect format. Expected format: 'modid:enchantment_name:level'"), false);
				}
				hasEnchantmentFailed = true;
				continue;
			}

			String enchantmentId = parts[1];
			int level;
			try {
				level = Integer.parseInt(parts[2]);
			} catch (NumberFormatException e) {
				if (ConfigManager.areMessagesEnabled()) {
					player.displayClientMessage(Component.literal("Failed to parse enchantment level as a number for " + enchantmentId), false);
				}
				hasEnchantmentFailed = true;
				continue;
			}

			ResourceLocation resourceLocation = new ResourceLocation(enchantmentId);
			Enchantment enchantment = ForgeRegistries.ENCHANTMENTS.getValue(resourceLocation);
			if (enchantment == null) {
				if (ConfigManager.areMessagesEnabled()) {
					player.displayClientMessage(Component.literal("Enchantment not found: " + enchantmentId), false);
				}
				hasEnchantmentFailed = true;
				continue;
			}

			enchantmentsToApply.put(enchantment, level);
		}

		if (!enchantmentsToApply.isEmpty()) {
			EnchantmentHelper.setEnchantments(enchantmentsToApply, item);
			if (ConfigManager.areMessagesEnabled()) {
				player.displayClientMessage(Component.literal("Your item has been enchanted!"), false);
			}
		} else if (!hasEnchantmentFailed && ConfigManager.areMessagesEnabled()) {
			player.displayClientMessage(Component.literal("No enchantments were applied."), false);
		}
	}


	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onServerStarting(RegisterCommandsEvent event) {
		CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

		dispatcher.register(Commands.literal("enchanterbench")
				.then(Commands.literal("reload")
						.requires(cs -> cs.hasPermission(2))
						.executes(context -> {
							ConfigManager.loadConfig();

							try {
								Entity entity = context.getSource().getEntity();
								if (entity instanceof Player) {
									Player player = (Player) entity;
									player.displayClientMessage(Component.literal("EnchanterBench configuration reloaded."), true);
								} else {
									;
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

							return 1;
						})
				)
		);
	}
}

