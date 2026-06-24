package org.test.solarPanel.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.checkerframework.checker.units.qual.A;
import org.test.solarPanel.SolarPanel;
import org.test.solarPanel.solarcommands.SolarGUI;

import java.util.ArrayList;

public class SolarMenuHandler implements Listener {
    String prefix = "§e§lꜱᴏʟᴀʀᴘᴀɴᴇʟ §8»§r ";
    SolarPanel plugin;
    public SolarMenuHandler(SolarPanel plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent event){
        final String Pannello = "§e§l         ꜱᴏʟᴀʀ ᴘᴀɴᴇʟ";
        final String PannelloGMS = "§a§l  ɢɪᴏᴄᴀᴛᴏʀɪ ɪɴ ꜱᴜʀᴠɪᴠᴀʟ";
        final String pannelloTP = "§e§l      ᴛᴇʟᴇᴛʀᴀꜱᴘᴏʀᴛᴀᴛɪ";
        final String pannelloFreeze = "§b§l      ꜰʀᴇᴇᴢᴀ ɢɪᴏᴄᴀᴛᴏʀɪ";
        Player targetting;
        Player player = (Player) event.getWhoClicked();

        if(event.getView().getTitle().equalsIgnoreCase(Pannello)){
            if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            event.setCancelled(true);
            switch(event.getCurrentItem().getType()){
                case DIAMOND_SWORD:
                    player.closeInventory();
                    plugin.openGMSMenu(player);
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
                case ENDER_PEARL:
                    player.closeInventory();
                    plugin.openTPMenu(player);
                    break;
            }
        }
        if (event.getView().getTitle().equalsIgnoreCase(PannelloGMS)){
            if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            switch(event.getCurrentItem().getType()){
                case BARRIER:
                    plugin.SolarPanel(player);
                    break;
                case PLAYER_HEAD:
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    if (meta == null || !meta.hasDisplayName()) {
                        return;
                    }
                    Player target = Bukkit.getPlayer(meta.getDisplayName());
                    target.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',prefix + plugin.getConfig().getString("gmc-on-message-player").replace("%player%", target.getName())));
                    break;
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase(pannelloTP)){
            if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            switch(event.getCurrentItem().getType()){
                case BARRIER:
                    plugin.SolarPanel(player);
                    break;
                case PLAYER_HEAD:
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    if (meta == null || !meta.hasDisplayName()) {
                        return;
                    }
                    Player target = Bukkit.getPlayer(meta.getDisplayName());
                    player.teleport(target.getLocation());
                    player.sendActionBar(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("teleported-to-player").replace("%player%", target.getName())));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + plugin.getConfig().getString("someone-teleported").replace("%player%", player.getName())));
            }

        }
        if (event.getView().getTitle().equalsIgnoreCase(pannelloFreeze)){
            if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            ArrayList<Player> freezed = new ArrayList<>();
            switch(event.getCurrentItem().getType()) {
                case BARRIER:
                    plugin.SolarPanel(player);
                    break;
                case SNOWBALL:
                    plugin.openFreezeMenu(player, freezed);
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    if (meta == null || !meta.hasDisplayName()) {
                        return;
                    }

                    Player target = Bukkit.getPlayer(meta.getDisplayName());
                    if(freezed.contains(target)){
                        target.clearActivePotionEffects();
                        target.setWalkSpeed(4);
                    } else{
                        target.setWalkSpeed(0);
                        target.addPotionEffect(PotionEffectType.BLINDNESS.createEffect(1000, 99));
                        target.addPotionEffect(PotionEffectType.SLOWNESS.createEffect(1000, 99));
                        target.setCanPickupItems(false);
                        target.closeInventory();
                        target.dropItem(false);
                        target.sendActionBar("§b§lꜱᴇɪ ꜱᴛᴀᴛᴏ ꜰʀᴇᴇᴢᴀᴛᴏ!");
                        freezed.add(target);
                    }
            }
            event.setCancelled(true);
            }
    }

}
