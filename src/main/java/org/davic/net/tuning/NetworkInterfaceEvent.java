/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.net.tuning;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public abstract class NetworkInterfaceEvent extends java.util.EventObject {

    public NetworkInterfaceEvent(Object networkInterface) {
        super(networkInterface);
    }

    public Object getSource() {
        return super.getSource();
    }
}



