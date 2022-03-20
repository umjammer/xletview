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

public class NetworkInterface {

    protected NetworkInterface() {
    }

    public TransportStream getCurrentTransportStream() {
        return null;
    }

    public org.davic.net.Locator getLocator() {
        return null;
    }

    public synchronized boolean isReserved() {
        return false;
    }

    public boolean isLocal() {
        return false;
    }

    public TransportStream[] listAccessibleTransportStreams() {
        return null;
    }

    public int getDeliverySystemType() {
        return 0;
    }

    public void addNetworkInterfaceListener(NetworkInterfaceListener listener) {
    }

    public void removeNetworkInterfaceListener(NetworkInterfaceListener listener) {
    }
}

