# EnchanterBench for Minecraft


Welcome to the EnchanterBench Mod/Plugin! This Forge mod and Paper plugin for Minecraft, that brings magic right into your crafting table, allowing you to enchant items as you craft them. With customizable configurations, you can specify exactly which items receive which enchantments, making every crafting session a spellbinding experience.

## Features

* Automatic Enchantment: Items are enchanted automatically upon crafting, based on predefined configurations.

* Customizable Configurations: Easily specify which items should receive enchantments, and which enchantments they should receive, through a simple config file.

* Wide Range of Enchantments: Supports all vanilla Minecraft enchantments and is compatible with many custom enchantments from other mods/plugins.



## Getting Started

## Prerequisites

* Minecraft (supported plugin version)
  
* Paper Server (supported plugin version)

## Installation

Download the EnchanterBench plugin from the Releases section under Paper.

Place the .jar into your servers plugin folder.

Start up your server and have fun!

## Configuration

Access the plugin's configuration in your server files.

Go to plugins then enchanterbench-plugin (the folder not the .jar) and finally, double click on config.yml.

Here, you can specify the items and their respective enchantments.

### Example Configuration
```
enchantments:
  diamond_sword:
    - enchantment: SHARPNESS
      level: 10
    - enchantment: KNOCKBACK
      level: 2
```

## Commands

* /enchanterbench reload
  
 This command reloads the yml and runs whatever was specified in the new yml.

## Contact

Sooigee - sooigeee@gmail.com
Discord - sooigee

Project Link: https://github.com/Sooigee/EnchanterBench

### Acknowledgments

#### 2. Minecraft PaperMC Team, for the powerful plugin capabilites.

