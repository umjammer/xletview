/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.net.tuning;

import org.davic.mpeg.TransportStream;
import org.davic.resources.ResourceServer;
import org.davic.resources.ResourceStatusListener;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 2
 * @comment very partially implemented, not possible to use yet
 */
public class NetworkInterfaceManager implements ResourceServer {

    private static NetworkInterfaceManager THE_INSTANCE;

    private NetworkInterfaceManager() {
    }

    public static NetworkInterfaceManager getInstance() {
        if(THE_INSTANCE == null){
            THE_INSTANCE = new NetworkInterfaceManager();
        }
        return THE_INSTANCE;
    }


    public NetworkInterface[] getNetworkInterfaces() {
        return null;
    }

    public NetworkInterface getNetworkInterface(TransportStream ts) {
        return null;
    }

    public void addResourceStatusEventListener(ResourceStatusListener listener) {
    }

    public void removeResourceStatusEventListener(ResourceStatusListener listener) {
    }




}


