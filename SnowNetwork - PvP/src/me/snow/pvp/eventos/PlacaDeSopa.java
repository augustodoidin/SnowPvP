package me.snow.pvp.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlacaDeSopa implements Listener {
	
	@EventHandler
	public void Escrever(SignChangeEvent e) {
		Player p = e.getPlayer();
		if (p.hasPermission("snow.admin") && e.getLine(0).equalsIgnoreCase("sopa")) {
			e.setLine(0, me.snow.pvp.Main.prefix);
			e.setLine(1, "�a�lSopa!");
			e.setLine(2, "�b�lSopa!");
			e.setLine(3, "�fClique");
			p.sendMessage("�bPlaca criada!");
		}
		
	}
	
	@EventHandler
	public void Inv(PlayerInteractEvent e) {
		Player p = (Player)e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (e.getClickedBlock() != null && (e.getClickedBlock().getType() == Material.WALL_SIGN) 
		|| (e.getClickedBlock().getType() == Material.SIGN_POST))) {
			Sign s = (Sign)e.getClickedBlock().getState();
			String[] lines = s.getLines();
			if ((lines.length > 0) && (lines[0].equals(me.snow.pvp.Main.prefix)) &&
			     (lines.length > 1) && (lines[1].equals("�a�lSopa!")) &&
                 (lines.length > 2) && (lines[2].equals("�b�lSopa!")) &&
                 (lines.length > 3) && (lines[3].equals("�fClique"))) {
			Inventory inv = Bukkit.createInventory(p, 54, me.snow.pvp.Main.prefix + " �b�lSopas");
    	    ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
    	    ItemMeta sopameta = sopa.getItemMeta();
    	    sopameta.setDisplayName("�6�lSopa");
    	    sopa.setItemMeta(sopameta);
    	    for (int i =0; i != 54; i++) {
    	    	inv.setItem(i, sopa);
    	    }
			p.openInventory(inv);
			}
		}
		
	}

}
