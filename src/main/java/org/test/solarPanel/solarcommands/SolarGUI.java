package org.test.solarPanel.solarcommands;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.test.solarPanel.SolarPanel;

public class SolarGUI implements CommandExecutor {

    private SolarPanel plugin;
    public SolarGUI(SolarPanel plugin) {
        this.plugin = plugin;
    }



    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            SolarPanel.SolarPanel(player);
        }
        return true;
    }
}
