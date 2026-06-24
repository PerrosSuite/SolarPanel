package org.test.solarPanel;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.A;
import org.test.solarPanel.Events.SolarMenuHandler;
import org.test.solarPanel.solarcommands.*;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getOnlinePlayers;

public final class SolarPanel extends JavaPlugin {

    String prefix = "§e§lꜱᴏʟᴀʀᴘᴀɴᴇʟ §8»§r ";

    @Override
    public void onEnable() {
        // String prefix = "§e§lꜱᴏʟᴀʀᴘᴀɴᴇʟ §8»§r ";
        getCommand("fly").setExecutor(new FlyCommand(this));
        getCommand("gmc").setExecutor(new GMCCommand(this));
        getCommand("gms").setExecutor(new GMSCommand(this));
        getCommand("tp").setExecutor(new TPCommand(this));
        getCommand("pannello").setExecutor(new SolarGUI(this));
        getServer().getPluginManager().registerEvents(new SolarMenuHandler(this), this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    public static void SolarPanel(Player player){
            Inventory pannelloSolaris = Bukkit.createInventory(player, 18, "§e§l         ꜱᴏʟᴀʀ ᴘᴀɴᴇʟ");

            // ----------------- Oggetti negli slot -------------
        if(player.hasPermission("solarpanel.gms")){
            ItemStack GMS = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta GMS_meta = GMS.getItemMeta();
            GMS_meta.setDisplayName("§a§lɢɪᴏᴄᴀᴛᴏʀɪ ɪɴ ꜱᴜʀᴠɪᴠᴀʟ");
            ArrayList<String> lore = new ArrayList<>();
            lore.add("§aᴠᴇᴅɪ ᴄʜɪ ᴇ̀ ɪɴ ꜱᴜʀᴠɪᴠᴀʟ ᴇ ᴄᴀᴍʙɪᴀɢʟɪᴇʟᴀ ɪɴ ᴄʀᴇᴀᴛɪᴠᴀ.");
            GMS_meta.setLore(lore);
            GMS.setItemMeta(GMS_meta);
            pannelloSolaris.setItem(0, GMS);
        }

            ItemStack TP = new ItemStack(Material.ENDER_PEARL);
            ItemMeta TP_meta = TP.getItemMeta();
            TP_meta.setDisplayName("§e§lᴛᴇʟᴇᴛʀᴀꜱᴘᴏʀᴛᴀᴛɪ");
            ArrayList<String> lore1 = new ArrayList<>();
            lore1.add("§eᴛᴇʟᴇᴛʀᴀꜱᴘᴏʀᴛᴀᴛɪ ᴅᴀ ᴄʜɪᴜɴǫᴜᴇ!");
            TP_meta.setLore(lore1);
            TP.setItemMeta(TP_meta);
            if(player.hasPermission("solarpanel.gms")){
                pannelloSolaris.setItem(1, TP);
            } else{
                pannelloSolaris.setItem(0, TP);
            }

            ItemStack Close = new ItemStack(Material.BARRIER);
            ItemMeta Close_meta = Close.getItemMeta();
            Close_meta.setDisplayName("§c§lᴄʜɪᴜᴅɪ ꜱᴏʟᴀʀᴘᴀɴᴇʟ");
            Close.setItemMeta(Close_meta);
            pannelloSolaris.setItem(17, Close);

        ItemStack FRZ = new ItemStack(Material.SNOWBALL);
        ItemMeta FRZ_meta = TP.getItemMeta();
        FRZ_meta.setDisplayName("§b§lꜰʀᴇᴇᴢᴀ ɢɪᴏᴄᴀᴛᴏʀɪ");
        ArrayList<String> frz_lore = new ArrayList<>();
        frz_lore.add("ᴄᴏɴɢᴇʟᴀ ɪ ɢɪᴏᴄᴀᴛᴏʀɪ [ꜱᴏʟᴏ ꜱᴛᴀꜰꜰ]");
        FRZ_meta.setLore(frz_lore);
        FRZ.setItemMeta(FRZ_meta);
        if(player.hasPermission("solarpanel.freeze")){
            pannelloSolaris.setItem(2, FRZ);
        }

            // ----------------- Oggetti negli slot -------------


            player.openInventory(pannelloSolaris);
        }

    public void openGMSMenu(Player player){
        Inventory pannelloGMS = Bukkit.createInventory(player, 54, "§a§l  ɢɪᴏᴄᴀᴛᴏʀɪ ɪɴ ꜱᴜʀᴠɪᴠᴀʟ");
        ArrayList <Player> GMS = new ArrayList<>();

        // close
        ItemStack Close = new ItemStack(Material.BARRIER);
        ItemMeta Close_meta = Close.getItemMeta();
        Close_meta.setDisplayName("§c§lᴛᴏʀɴᴀ ᴀ §e§lꜱᴏʟᴀʀᴘᴀɴᴇʟ");
        Close.setItemMeta(Close_meta);
        pannelloGMS.setItem( 53, Close);
        // -----

        for (Player players : getOnlinePlayers()) {
            for(int i = 0; i < 54; i++){
                if (players.getGameMode() == GameMode.SURVIVAL && !GMS.contains(players)) {
                    ItemStack playerhead = new ItemStack(Material.PLAYER_HEAD);
                    SkullMeta playermeta = (SkullMeta) playerhead.getItemMeta();
                    playermeta.setOwningPlayer(players);
                    playermeta.setDisplayName(players.getName());
                    ArrayList<String> targetLore = new ArrayList<>();
                    targetLore.add("§aᴄʟɪᴄᴄᴀ ᴘᴇʀ ɪᴍᴘᴏꜱᴛᴀʀᴇ ᴀ ᴄʀᴇᴀᴛɪᴠᴀ");
                    playermeta.setLore(targetLore);
                    if(players.getGameMode() == GameMode.CREATIVE){
                        ArrayList<String> Lore = new ArrayList<>();
                        Lore.add("§aᴄʀᴇᴀᴛɪᴠᴀ");
                        playermeta.setLore(targetLore);
                    }
                    playerhead.setItemMeta(playermeta);
                    pannelloGMS.setItem(i, playerhead);
                    GMS.add(players);
                }
            }
        }
        if(Bukkit.getOnlinePlayers().size() == 1){
            player.sendMessage(prefix + "§cɴᴇꜱꜱᴜɴ ɢɪᴏᴄᴀᴛᴏʀᴇ ᴛʀᴏᴠᴀᴛᴏ");

        } else {
            player.openInventory(pannelloGMS);
        }

    }

    public void openTPMenu(Player player){
        Inventory pannelloTP = Bukkit.createInventory(player, 54, "§e§l      ᴛᴇʟᴇᴛʀᴀꜱᴘᴏʀᴛᴀᴛɪ");
        // close
        ItemStack Close = new ItemStack(Material.BARRIER);
        ItemMeta Close_meta = Close.getItemMeta();
        Close_meta.setDisplayName("§c§lᴛᴏʀɴᴀ ᴀ §e§lꜱᴏʟᴀʀᴘᴀɴᴇʟ");
        Close.setItemMeta(Close_meta);
        pannelloTP.setItem( 53, Close);
        // -----
        int slot = 0;
        for (Player players : getOnlinePlayers()) {
                if(players != player){
                    if(slot == 53){
                        break;
                    }
                    ItemStack playerhead = new ItemStack(Material.PLAYER_HEAD);
                    SkullMeta playermeta = (SkullMeta) playerhead.getItemMeta();
                    playermeta.setOwningPlayer(players);
                    playermeta.setDisplayName(players.getName());
                    ArrayList<String> targetLore = new ArrayList<>();
                    targetLore.add("§eᴄʟɪᴄᴄᴀ ᴘᴇʀ ᴛᴇʟᴇᴛʀᴀꜱᴘᴏʀᴛᴀᴛɪ");
                    playermeta.setLore(targetLore);
                    playerhead.setItemMeta(playermeta);
                    pannelloTP.setItem(slot, playerhead);
                    slot++;
                }
        }
        if(Bukkit.getOnlinePlayers().size() == 1){
            player.sendMessage(prefix + "§cɴᴇꜱꜱᴜɴ ɢɪᴏᴄᴀᴛᴏʀᴇ ᴛʀᴏᴠᴀᴛᴏ");

        } else {
            player.openInventory(pannelloTP);
        }
    }

    public void openFreezeMenu(Player player, ArrayList freezedPeople){
        Inventory pannelloFreeze = Bukkit.createInventory(player, 54, "§b§l      ꜰʀᴇᴇᴢᴀ ɢɪᴏᴄᴀᴛᴏʀɪ");
        // close
        ItemStack Close = new ItemStack(Material.BARRIER);
        ItemMeta Close_meta = Close.getItemMeta();
        Close_meta.setDisplayName("§c§lᴛᴏʀɴᴀ ᴀ §e§lꜱᴏʟᴀʀᴘᴀɴᴇʟ");
        Close.setItemMeta(Close_meta);
        pannelloFreeze.setItem( 53, Close);
        // -----
        int slot = 0;
        for (Player players : getOnlinePlayers()) {
            if(players != player){
                if(slot == 53){
                    break;
                }
                ItemStack playerhead = new ItemStack(Material.PLAYER_HEAD);
                SkullMeta playermeta = (SkullMeta) playerhead.getItemMeta();
                playermeta.setOwningPlayer(players);
                playermeta.setDisplayName(players.getName());
                ArrayList<String> waaaLore = new ArrayList<>();
                waaaLore.add("§eᴄʟɪᴄᴄᴀ ᴘᴇʀ ꜰʀᴇᴇᴢᴀʀᴇ");
                playermeta.setLore(waaaLore);
                playerhead.setItemMeta(playermeta);
                pannelloFreeze.setItem(slot, playerhead);
                freezedPeople.add(player);
                slot++;
            }
        }
        if(Bukkit.getOnlinePlayers().size() == 1){
            player.sendMessage(prefix + "§cɴᴇꜱꜱᴜɴ ɢɪᴏᴄᴀᴛᴏʀᴇ ᴛʀᴏᴠᴀᴛᴏ");

        } else {
            player.openInventory(pannelloFreeze);
        }
    }
}
