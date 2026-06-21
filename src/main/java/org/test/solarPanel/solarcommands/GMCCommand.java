package org.test.solarPanel.solarcommands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Target;
import java.util.ArrayList;

public class GMCCommand implements CommandExecutor {
    String prefix = "§e§lꜱᴏʟᴀʀᴘᴀɴᴇʟ §8»§r ";

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("solarpanel.gmc")) {
                    if (player.getGameMode() == GameMode.CREATIVE) {
                        player.sendActionBar("§cᴄʀᴇᴀᴛɪᴠᴀ ᴅɪꜱᴀᴛᴛɪᴠᴀᴛᴀ");
                        player.setGameMode(GameMode.SURVIVAL);
                    } else {
                        player.sendActionBar("§eᴄʀᴇᴀᴛɪᴠᴀ ᴀᴛᴛɪᴠᴀᴛᴀ");
                        player.setGameMode(GameMode.CREATIVE);
                    }
                }else{
                    player.sendMessage(prefix + "§cᴄᴏᴍᴀɴᴅᴏ ɴᴏɴ ᴇꜱᴇɢᴜɪʙɪʟᴇ");
                }
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target.hasPermission("solarpanel.gmc")) {
                    if (target.getGameMode() == GameMode.CREATIVE) {
                        player.sendMessage(prefix + "§cᴄʀᴇᴀᴛɪᴠᴀ ᴅɪꜱᴀᴛᴛɪᴠᴀᴛᴀ ᴀ " + target.getName());
                        target.sendActionBar("§cᴄʀᴇᴀᴛɪᴠᴀ ᴅɪꜱᴀᴛᴛɪᴠᴀᴛᴀ");
                        target.setGameMode(GameMode.SURVIVAL);
                    } else if (target.getGameMode() == GameMode.SURVIVAL) {
                        player.sendMessage(prefix + "§eᴄʀᴇᴀᴛɪᴠᴀ ᴀᴛᴛɪᴠᴀᴛᴀ ᴀ " + target.getName());
                        target.setGameMode(GameMode.CREATIVE);
                        target.sendActionBar("§eᴄʀᴇᴀᴛɪᴠᴀ ᴀᴛᴛɪᴠᴀᴛᴀ");
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