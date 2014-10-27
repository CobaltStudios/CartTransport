/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cobalt.hightidez.carttransport.cart;

import java.util.HashMap;
import java.util.UUID;
import org.bukkit.event.Listener;

/**
 *
 * @author iTidez
 */
public class CartManager implements Listener {
    private static HashMap<UUID, TransportCart> myRegisteredCarts = new HashMap<UUID, TransportCart>();
    
    public CartManager() {
        
    }
    
    public static UUID registerCart(TransportCart cart) {
        UUID currentId = UUID.nameUUIDFromBytes(cart.toString().getBytes());
        if(myRegisteredCarts.containsKey(currentId))
            return null;
        myRegisteredCarts.put(currentId, cart);
        return currentId;
    }
    
    public static boolean unregisterCart(TransportCart cart) {
        unregisterCart(cart.getId());
    }
    
    public static boolean unregisterCart(UUID id) {
        
    }
    
}
