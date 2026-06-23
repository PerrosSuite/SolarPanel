package org.test.solarPanel;

import org.bukkit.plugin.java.JavaPlugin;
import org.test.solarPanel.solarcommands.FlyCommand;
import org.test.solarPanel.solarcommands.GMCCommand;
import org.test.solarPanel.solarcommands.GMSCommand;
import org.test.solarPanel.solarcommands.TPCommand;

public final class SolarPanel extends JavaPlugin {


    @Override
    public void onEnable() {
        // String prefix = "§e§lꜱᴏʟᴀʀᴘᴀɴᴇʟ §8»§r ";
        getCommand("fly").setExecutor(new FlyCommand(this));
        getCommand("gmc").setExecutor(new GMCCommand(this));
        getCommand("gms").setExecutor(new GMSCommand(this));
        getCommand("tp").setExecutor(new TPCommand(this));

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }
}
