/*
 * This file is part of XleTView
 * Copyright (C) 2003 Martin SvedÈn
 *
 * This is free software, and you are
 * welcome to redistribute it under
 * certain conditions;
 *
 * See LICENSE document for details.
 */

package org.dvb.net.rc;

import org.davic.resources.ResourceStatusEvent;


/**
 * @author Bengt Skogvall
 * @version 14.9.03
 * @statuscode 4
 */
public class RCInterfaceReleasedEvent extends ResourceStatusEvent {

    private final Object connection;

    public RCInterfaceReleasedEvent(Object bg) {
        super(bg);
        connection = bg;
    }

    @Override
    public Object getSource() {
        return connection;
    }
}