<<<<<<< HEAD
# EnchanterCraft Mod for Minecraft Forge 1.20.4


Welcome to the EnchanterCraft Mod! This Forge mod for Minecraft 1.20.4 brings magic right into your crafting table, allowing you to enchant items as you craft them. With customizable configurations, you can specify exactly which items receive which enchantments, making every crafting session a spellbinding experience.
=======
# EnchanterBench for Minecraft


Welcome to the EnchanterBench Mod/Plugin! This Forge mod and Paper plugin for Minecraft, that brings magic right into your crafting table, allowing you to enchant items as you craft them. With customizable configurations, you can specify exactly which items receive which enchantments, making every crafting session a spellbinding experience.
>>>>>>> 2769a3e3007b696a22f8ec9838f6acf586f16c31

## Features

* Automatic Enchantment: Items are enchanted automatically upon crafting, based on predefined configurations.

* Customizable Configurations: Easily specify which items should receive enchantments, and which enchantments they should receive, through a simple config file.

<<<<<<< HEAD
* Wide Range of Enchantments: Supports all vanilla Minecraft enchantments and is compatible with many custom enchantments from other mods.
=======
* Wide Range of Enchantments: Supports all vanilla Minecraft enchantments and is compatible with many custom enchantments from other mods/plugins.
>>>>>>> 2769a3e3007b696a22f8ec9838f6acf586f16c31


## Getting Started


### Prerequisites

<<<<<<< HEAD
* Minecraft 1.20.4

* Minecraft Forge for 1.20.4 


## Installation

Download the EnchanterCraft mod file from the Releases section.
=======
* Minecraft (supported mod version)

### Forge:

* Minecraft Forge (supported mod version)

### Paper:

* Paper Server (supported mod version)

## Installation

### Forge:

Download the EnchanterBench mod file from the Releases section under Forge.
>>>>>>> 2769a3e3007b696a22f8ec9838f6acf586f16c31

Place the downloaded .jar file into your Minecraft mods folder.

Windows: %appdata%\.minecraft\mods

macOS/Linux: ~/.minecraft/mods

Launch Minecraft with the Forge profile selected.

Dive in and start crafting enchanted items!

<<<<<<< HEAD
## Configuration

Access the mod's configuration in your game files.

Go to your main files then config, and double click on enchanterbench.json.
=======
### Paper:

Download the EnchanterBench plugin from the Releases section under Paper.

Place the .jar into your servers plugin folder.

Start up your server and have fun!

## Configuration

### Forge:

Access the mod's configuration in your game files.

Go to your main files then go under config, and double click on enchanterbench.json.
>>>>>>> 2769a3e3007b696a22f8ec9838f6acf586f16c31

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
<<<<<<< HEAD
## Contact

Sooigee - sebitodd@icloud.com
=======

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
>>>>>>> 2769a3e3007b696a22f8ec9838f6acf586f16c31

Project Link: https://github.com/Sooigee/EnchanterBench

### Acknowledgments
<<<<<<< HEAD
Minecraft Forge Team, for the powerful modding capabilities.
=======
#### 1. Minecraft Forge Team, for the powerful modding capabilities.

#### 2. Minecraft Paper Team, for the powerful plugin capabilites.
>>>>>>> 2769a3e3007b696a22f8ec9838f6acf586f16c31
