package org.test.solarPanel.solarcommands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GMSCommand implements CommandExecutor {
    String prefix = "§e§lꜱᴏʟᴀʀᴘᴀɴᴇʟ §8»§r ";

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("solarpanel.gms")) {
                    if (player.getGameMode() != GameMode.SURVIVAL) {
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendActionBar("§eꜱᴜʀᴠɪᴠᴀʟ ᴀᴛᴛɪᴠᴀᴛᴀ");
                    } else if (player.getGameMode() == GameMode.SURVIVAL) {
                        player.sendActionBar("§cɢɪᴀ' ɪɴ ꜱᴜʀᴠɪᴠᴀʟ");
                    }
                }else{
                    player.sendMessage(prefix + "§cᴄᴏᴍᴀɴᴅᴏ ɴᴏɴ ᴇꜱᴇɢᴜɪʙɪʟᴇ");
                }

            } else if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target.hasPermission("solarpanel.gms")) {
                    if (target.getGameMode() != GameMode.SURVIVAL) {
                        target.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(prefix + "§eꜱᴜʀᴠɪᴠᴀʟ ᴀᴛᴛɪᴠᴀᴛᴀ ᴀ " + target.getName());
                        target.sendActionBar("§eꜱᴜʀᴠɪᴠᴀʟ ᴀᴛᴛɪᴠᴀᴛᴀ");
                    } else if (target.getGameMode() == GameMode.SURVIVAL) {
                        player.sendMessage(prefix + "§cɪʟ ɢɪᴏᴄᴀᴛᴏʀᴇ ᴇ' ɢɪᴀ ɪɴ ꜱᴜʀᴠɪᴠᴀʟ");
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
