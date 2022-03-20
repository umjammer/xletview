/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;


import java.awt.Dimension;

import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceStatusListener;
import org.havi.ui.event.HScreenConfigurationListener;
import org.havi.ui.event.HScreenDeviceReleasedEvent;
import org.havi.ui.event.HScreenDeviceReservedEvent;

import net.beiker.xletview.media.ScreenContainer;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class HScreenDevice implements org.davic.resources.ResourceProxy, org.davic.resources.ResourceServer{

    private HScreenConfigurationListener hScreenConfigurationListener;
    private HScreenConfigTemplate hScreenConfigTemplate;
    private ResourceStatusListener resourceStatusListener;
    private ResourceClient currentResourceClient;

    public HScreenDevice(){
    }

    public String getIDstring(){
        return "HScreenDeviceID";
    }

    public void addScreenConfigurationListener(HScreenConfigurationListener hscl){
        hScreenConfigurationListener = HEventMulticaster.add(hScreenConfigurationListener, hscl);
    }

    public void addScreenConfigurationListener(HScreenConfigurationListener hscl, HScreenConfigTemplate hsct){
        addScreenConfigurationListener(hscl);
        hScreenConfigTemplate = hsct;
    }

    public void removeScreenConfigurationListener(HScreenConfigurationListener hscl){
        hScreenConfigurationListener = HEventMulticaster.remove(hScreenConfigurationListener, hscl);
    }

    public Dimension getScreenAspectRatio(){
        return new Dimension(ScreenContainer.SCREEN_WIDTH, ScreenContainer.SCREEN_HEIGHT);
    }

    public boolean reserveDevice(ResourceClient client){
        /* "Requests the right to call any method which may otherwise throw an HPermissionDeniedException."
         * */
        // at the moment anyone gets the right to call any method, why not?
        currentResourceClient = client;
        if(resourceStatusListener != null){
            resourceStatusListener.statusChanged(new HScreenDeviceReservedEvent(currentResourceClient) );
        }
        boolean reserved = true;
        return reserved;
    }

    public void releaseDevice(){
        if(resourceStatusListener != null){
            resourceStatusListener.statusChanged(new HScreenDeviceReleasedEvent(currentResourceClient) );
        }
        currentResourceClient = null;
    }

    public ResourceClient getClient(){
        return currentResourceClient;
    }

    public void addResourceStatusEventListener(ResourceStatusListener listener){
        resourceStatusListener = HEventMulticaster.add(resourceStatusListener, listener);
    }

    public void removeResourceStatusEventListener(ResourceStatusListener listener){
        resourceStatusListener = HEventMulticaster.remove(resourceStatusListener, listener);
    }
}
