package org.test.solarPanel.solarcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.test.solarPanel.SolarPanel;

public class TPCommand implements CommandExecutor {
    private SolarPanel plugin;
    public TPCommand(SolarPanel plugin) {
        this.plugin = plugin;
    }
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {

        String prefix = "§e§lꜱᴏʟᴀʀᴘᴀɴᴇʟ §8»§r ";
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (player.hasPermission("solarpanel.tp")) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target == null) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + plugin.getConfig().getString("target-not-found")));
                        return true;
                    }
                    if (target != player) {
                        player.teleport(target.getLocation());
                        player.sendActionBar(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("teleported-to-player").replace("%player%", target.getName())));
                        target.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + plugin.getConfig().getString("someone-teleported").replace("%player%", player.getName())));
                    } else if (target == player) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + plugin.getConfig().getString("cant-teleport-to-you")));
                    } else if (target.isOnline() == false) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + plugin.getConfig().getString("target-offline")));

                    } else {
                        player.sendMessage(prefix + "§cᴄᴏᴍᴀɴᴅᴏ ɴᴏɴ ᴇꜱᴇɢᴜɪʙɪʟᴇ");
                    }
                }
                return true;
            }
            if (args.length == 2 && player.hasPermission("solarpanel.tp")) {
                Player playeriniziale = Bukkit.getPlayer(args[0]);
                Player target = Bukkit.getPlayer(args[1]);
                if (playeriniziale == null) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + plugin.getConfig().getString("target-not-found")));
                    return true;
                }
                if (target == null) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + plugin.getConfig().getString("target-not-found")));
                    return true;
                }
                if (target != playeriniziale) {
                    playeriniziale.teleport(target.getLocation());
                    playeriniziale.sendActionBar(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("teleported-to-player").replace("%player%", target.getName())));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + plugin.getConfig().getString("someone-teleported").replace("%player%", playeriniziale.getName())));
                } else {
                    playeriniziale.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + plugin.getConfig().getString("cant-teleport-to-you")));
                }
            }
            return false;
        }
        return false;
    }
}
