package org.test.solarPanel;

import org.bukkit.plugin.java.JavaPlugin;
import org.test.solarPanel.solarcommands.FlyCommand;
import org.test.solarPanel.solarcommands.GMCCommand;
import org.test.solarPanel.solarcommands.GMSCommand;

public final class SolarPanel extends JavaPlugin {

    @Override
    public void onEnable() {
        // String prefix = "§e§lꜱᴏʟᴀʀᴘᴀɴᴇʟ §8»§r ";
        getCommand("Fly").setExecutor(new FlyCommand());
        getCommand("gmc").setExecutor(new GMCCommand());
        getCommand("gms").setExecutor(new GMSCommand());


    }
}
