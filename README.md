# EnchanterBench for Minecraft


Welcome to the EnchanterBench Mod/Plugin! This Forge mod and Paper plugin for Minecraft, that brings magic right into your crafting table, allowing you to enchant items as you craft them. With customizable configurations, you can specify exactly which items receive which enchantments, making every crafting session a spellbinding experience.

## Features

* Automatic Enchantment: Items are enchanted automatically upon crafting, based on predefined configurations.

* Customizable Configurations: Easily specify which items should receive enchantments, and which enchantments they should receive, through a simple config file.

* Wide Range of Enchantments: Supports all vanilla Minecraft enchantments and is compatible with many custom enchantments from other mods/plugins.



## Getting Started

## Prerequisites

* Minecraft (supported mod version)

### Forge:

* Minecraft Forge (supported mod version)

### Paper:

* Paper Server (supported mod version)

## Installation

### Forge:

Download the EnchanterBench mod file from the Releases section under Forge.

Place the downloaded .jar file into your Minecraft mods folder.

Windows: %appdata%\.minecraft\mods

macOS/Linux: ~/.minecraft/mods

Launch Minecraft with the Forge profile selected.

Dive in and start crafting enchanted items!

### Paper:

Download the EnchanterBench plugin from the Releases section under Paper.

Place the .jar into your servers plugin folder.

Start up your server and have fun!

## Configuration

### Forge:

Access the mod's configuration in your game files.

Go to your main files then go under config, and double click on enchanterbench.json.

Here, you can specify the items and their respective enchantments.

### Example Configuration
```json
{
  "enchants": {
    "minecraft:diamond_sword": [
      "minecraft:sharpness:5",
      "minecraft:unbreaking:3"
    ]
  },
  "messagesEnabled": false
}
```

### Paper:

Access the plugin's configuration in your server files.

Go to plugins then enchanterbench-plugin and finally, double click on config.yml.

Here, you can specify the items and their respective enchantments (note some enchants will not be vanilla, look at example config).

### Example Configuration
```
enchantments:
  diamond_sword:
    - enchantment: DAMAGE_ALL
      level: 10
    - enchantment: KNOCKBACK
      level: 2
```

## Commands

### Forge/Paper:

* /enchanterbench reload
  
 This command reloads the .json or yml and runs whatever was specified in the new .json or yml.

## Contact

Sooigee - sooigeee@gmail.com

Project Link: https://github.com/Sooigee/EnchanterBench

### Acknowledgments

#### 1. Minecraft Forge Team, for the powerful modding capabilities.

#### 2. Minecraft Paper Team, for the powerful plugin capabilites.

