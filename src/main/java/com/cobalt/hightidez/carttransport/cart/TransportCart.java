/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cobalt.hightidez.carttransport.cart;

import java.util.List;
import java.util.UUID;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.entity.minecart.RideableMinecart;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

/**
 *
 * @author iTidez
 */
public class TransportCart {
    private UUID myId;
    private Minecart myCart;
    private Entity myRider;
    private boolean isReady;
    
    public TransportCart(Minecart mc) {
        myCart = mc;
        myRider = myCart.getPassenger();
        myId = null;
        initialize();
    }
    
    public TransportCart(Location loc) {
        myCart = loc.getWorld().spawn(loc, Minecart.class);
        initialize();
    }
    
    public TransportCart(Player p, Location loc) {
        myRider = p;
        myCart = loc.getWorld().spawn(loc, Minecart.class);
        myId = null;
        initialize();
    }
    
    /**
     * Prepare the TransportCart before use
     */
    private void initialize() {
        myId = CartManager.registerCart(this);
        if(myCart == null || myRider == null)
            isReady = false;
        else
            isReady = true;
    }
    
    /**
     * Returns the unique id of the TransportCart
     * @return 
     */
    public UUID getId() {
        return myId;
    }
}
