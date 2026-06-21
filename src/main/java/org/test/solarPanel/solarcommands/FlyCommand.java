package org.test.solarPanel.solarcommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.Prefix;
import org.test.solarPanel.SolarPanel;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {

    private SolarPanel plugin;
    public FlyCommand(SolarPanel plugin) {
        this.plugin = plugin;
    }

    private ArrayList<Player> PinVolo = new ArrayList<>();
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        String prefix = "§e§lꜱᴏʟᴀʀᴘᴀɴᴇʟ §8»§r ";

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(args.length == 0) {
                if (player.hasPermission("solarpanel.fly")) {
                    if (PinVolo.contains(player)) {
                        player.setAllowFlight(false);
                        player.sendActionBar(plugin.getConfig().getString("fly-off-message"));
                        PinVolo.remove(player);
                    } else if (!PinVolo.contains(player)) {
                        PinVolo.add(player);
                        player.setAllowFlight(true);
                        player.sendActionBar(plugin.getConfig().getString("fly-on-message"));
                    }
                } else{
                    player.sendMessage(plugin.getConfig().getString(prefix + "no-permission"));
                }
            } else if(args.length == 1){
                Player target = Bukkit.getPlayer(args[0]);
                if (target.hasPermission("solarpanel.fly")) {

                    if (PinVolo.contains(target)) {
                        target.setAllowFlight(false);
                        player.sendMessage(prefix + plugin.getConfig().getString("fly-off-message-player").replace("%player%", target.getName()));
                        target.sendActionBar(plugin.getConfig().getString("fly-off-message"));
                        PinVolo.remove(target);
                    } else if (!PinVolo.contains(target)) {
                        PinVolo.add(target);
                        target.setAllowFlight(true);
                        player.sendMessage(prefix + plugin.getConfig().getString("fly-on-message-player").replace("%player%", target.getName()));;
                        target.sendActionBar(plugin.getConfig().getString("fly-on-message"));

                    }
                } else{
                    player.sendMessage(plugin.getConfig().getString(prefix + "no-permission"));
                }
            }
        }
        return true;
    }
}
