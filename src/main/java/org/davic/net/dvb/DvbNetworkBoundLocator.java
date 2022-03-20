/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.net.dvb;

import org.davic.net.InvalidLocatorException;
import org.davic.net.TransportDependentLocator;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class DvbNetworkBoundLocator extends DvbLocator implements TransportDependentLocator {

    private int networkId;

    public DvbNetworkBoundLocator(DvbLocator unboundLocator, int networkId) throws InvalidLocatorException {
        super(unboundLocator.toExternalForm());
        this.networkId = networkId;
    }

    public int getNetworkId() {
        return networkId;
    }

}

