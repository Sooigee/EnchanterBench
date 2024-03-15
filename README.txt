#EnchanterCraft Mod for Minecraft Forge 1.20.4


Welcome to the EnchanterCraft Mod! This Forge mod for Minecraft 1.20.4 brings magic right into your crafting table, allowing you to enchant items as you craft them. With customizable configurations, you can specify exactly which items receive which enchantments, making every crafting session a spellbinding experience.

##Features

1. Automatic Enchantment: Items are enchanted automatically upon crafting, based on predefined configurations.

2. Customizable Configurations: Easily specify which items should receive enchantments, and which enchantments they should receive, through a simple config file.

3. Wide Range of Enchantments: Supports all vanilla Minecraft enchantments and is compatible with many custom enchantments from other mods.

##Getting Started

###Prerequisites
Minecraft 1.20.4
Minecraft Forge for 1.20.4 

##Installation

Download the EnchanterCraft mod file from the Releases section.
Place the downloaded .jar file into your Minecraft mods folder.
Windows: %appdata%\.minecraft\mods
macOS/Linux: ~/.minecraft/mods
Launch Minecraft with the Forge profile selected.
Dive in and start crafting enchanted items!

##Configuration

Access the mod's configuration in your game files.
Go to your main files then config, and double click on enchanterbench.json.
Here, you can specify the items and their respective enchantments.

#Example Configuration

{
  "enchants": {
    "minecraft:diamond_sword": [
      "minecraft:sharpness:5",
      "minecraft:unbreaking:3"
    ]
  },
  "messagesEnabled": false
}

##Contact

Sooigee - sebitodd@icloud.com

Project Link: https://github.com/Sooigee/EnchanterBench

Acknowledgments
Minecraft Forge Team, for the powerful modding capabilities.
