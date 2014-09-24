/*

This file is part of XleTView 
Copyright (C) 2003 Martin Svedén

This is free software, and you are 
welcome to redistribute it under 
certain conditions;

See LICENSE document for details.

*/

package net.beiker.xletview.service;

import xjavax.tv.service.Service;

/**
 * Manages the SI. Early in the implementation it will not do much but the idea is that
 * this manager will work as support for other classes working with SI.
 * 
 * @author Martin Sveden
 */
public class ServiceManager {

    private static final ServiceManager THE_INSTANCE = new ServiceManager();
    
    private ServiceManager(){
        
    }
    
    
    /**
     * Returns the singelton system-wide ServiceManager object.
     * @return the singelton ServiceManager object
     */
    public static final ServiceManager getInstance(){
        return THE_INSTANCE;
    }
    
    /**
     * Return the current Service
     * @return the current Service
     */
    public Service getCurrentService(){
        return null;
    }
    
}
