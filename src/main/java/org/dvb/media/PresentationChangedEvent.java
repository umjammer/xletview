/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.media;

import javax.media.Controller;
import javax.media.ControllerEvent;
import javax.media.MediaLocator;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class PresentationChangedEvent extends ControllerEvent {

    public static final int STREAM_UNAVAILABLE = 0x00;
    public static final int CA_FAILURE = 0x01;
    public static final int CA_RETURNED = 0x02;

    private MediaLocator stream;
    private int reason;

    public PresentationChangedEvent (Controller source, MediaLocator stream, int reason) {
        super(source);
        this.stream = stream;
        this.reason = reason;
    }

    public MediaLocator getStream()    {
        return stream;
    }

    public int getReason(){
        return reason;
    }
}


