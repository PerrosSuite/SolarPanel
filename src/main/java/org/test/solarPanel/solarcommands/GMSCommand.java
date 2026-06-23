package org.test.solarPanel.solarcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.test.solarPanel.SolarPanel;

public class GMSCommand implements CommandExecutor {
    private SolarPanel plugin;

    public GMSCommand(SolarPanel plugin) {
        this.plugin = plugin;
    }
    String prefix = "§e§lꜱᴏʟᴀʀᴘᴀɴᴇʟ §8»§r ";

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Player target = Bukkit.getPlayer(args[0]);
            if(args.length == 0) {
                if (player.hasPermission("solarpanel.gms")) {
                    if (player.getGameMode() != GameMode.SURVIVAL) {
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendActionBar(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("gms-on-message")));
                    } else if (player.getGameMode() == GameMode.SURVIVAL) {
                        player.sendActionBar(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("already-gms")));
                    }
                }else{
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',prefix + plugin.getConfig().getString("no-permission")));
                }

            } else if (args.length == 1) {
                if(target == null){
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',prefix + plugin.getConfig().getString("no-permission")));
                    return true;
                }
                if (player.hasPermission("solarpanel.gms")) {
                    if (target.getGameMode() != GameMode.SURVIVAL) {
                        target.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + plugin.getConfig().getString("gms-on-message-player").replace("%player%", target.getName())));;
                        target.sendActionBar(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("gms-on-message")));
                    } else if (target.getGameMode() == GameMode.SURVIVAL) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',prefix + plugin.getConfig().getString("player-already-gms")));
                    }
                }else{
                    player.sendMessage(prefix + "§cᴄᴏᴍᴀɴᴅᴏ ɴᴏɴ ᴇꜱᴇɢᴜɪʙɪʟᴇ");
                }
            }
            return true;
        }
        return false;
    }
}
