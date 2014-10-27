/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cobalt.hightidez.carttransport;

import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author iTidez
 */
public class CartTransport extends JavaPlugin {
    public static CartTransport instance;
    
    /**
     * Called by the main server to start service
     */
    @Override
    public void onEnable() {
        instance = this;
    }
    
    /**
     * Called by the main server to stop service safely
     */
    @Override
    public void onDisable() {
        instance = null;
    }
}
