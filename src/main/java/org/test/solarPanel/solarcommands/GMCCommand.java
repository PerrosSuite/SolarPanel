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

import java.lang.annotation.Target;
import java.util.ArrayList;

public class GMCCommand implements CommandExecutor {
    String prefix = "§e§lꜱᴏʟᴀʀᴘᴀɴᴇʟ §8»§r ";
    private SolarPanel plugin;
    public GMCCommand(SolarPanel plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 0 && player.hasPermission("solarpanel.gmc")) {
                if (player.hasPermission("solarpanel.gmc")) {
                    if (player.getGameMode() == GameMode.CREATIVE) {
                        player.sendActionBar(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("gmc-off-message")));
                        player.setGameMode(GameMode.SURVIVAL);
                    } else {
                        player.sendActionBar(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("gmc-on-message")));
                        player.setGameMode(GameMode.CREATIVE);
                    }
                }else{
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',prefix + plugin.getConfig().getString( "no-permission")));
                }
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if(target == null){
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',prefix + plugin.getConfig().getString("no-permission")));
                    return true;
                }
                if (player.hasPermission("solarpanel.gmc")) {
                    if (target.getGameMode() == GameMode.CREATIVE) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',prefix + plugin.getConfig().getString("gmc-off-message-player").replace("%player%", target.getName())));
                        target.sendActionBar(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("gmc-off-message")));
                        target.setGameMode(GameMode.SURVIVAL);
                    } else if (target.getGameMode() == GameMode.SURVIVAL) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',prefix + plugin.getConfig().getString("gmc-on-message-player").replace("%player%", target.getName())));
                        target.setGameMode(GameMode.CREATIVE);
                        target.sendActionBar(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("gmc-on-message")));
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