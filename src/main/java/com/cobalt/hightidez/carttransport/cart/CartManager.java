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
    
    /**
     * Registers a new instance of a TransportCart in a static
     * HashMap field for storage purposes
     * @param cart
     * @return 
     */
    public static UUID registerCart(TransportCart cart) {
        UUID currentId = UUID.nameUUIDFromBytes(cart.toString().getBytes());
        if(myRegisteredCarts.containsKey(currentId))
            return null;
        myRegisteredCarts.put(currentId, cart);
        return currentId;
    }
    
    /**
     * Unregister the TransportCart from existence, uses the cart
     * to call parent method which does the actual erasing
     * @param cart
     * @return 
     */
    public static boolean unregisterCart(TransportCart cart) {
        return unregisterCart(cart.getId());
    }
    
    /**
     * Unregister the TransportCart from existence, uses each
     * carts Unique ID to scan and erase from the HashMap
     * @param id
     * @return 
     */
    public static boolean unregisterCart(UUID id) {
        if(myRegisteredCarts.containsKey(id)) {
            myRegisteredCarts.remove(id);
            return true;
        } else
            return false;
    }
    
}
