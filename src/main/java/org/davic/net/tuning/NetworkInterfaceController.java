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
import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;

public class NetworkInterfaceController implements ResourceProxy {

    public NetworkInterfaceController(ResourceClient rc) {
    }

    public synchronized void tune(org.davic.net.Locator locator) throws NetworkInterfaceException {
    }

    public synchronized void tune(TransportStream ts) throws NetworkInterfaceException {
    }

    public synchronized void reserve(NetworkInterface ni,  Object requestData) throws NetworkInterfaceException {
    }

    public synchronized void reserveFor(org.davic.net.Locator locator, Object requestData) throws NetworkInterfaceException {
    }

    public synchronized void release() throws NetworkInterfaceException {
    }

    public NetworkInterface getNetworkInterface(){
        return null;
    }

    public ResourceClient getClient() {
        return null;
    }

}
