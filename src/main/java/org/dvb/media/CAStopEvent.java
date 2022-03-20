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
import javax.media.MediaLocator;
import javax.media.StopEvent;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class CAStopEvent extends StopEvent {

    private MediaLocator stream;

    public CAStopEvent(Controller source){
        super(source,0,0,0,null);
    }

    public CAStopEvent(Controller source, int previous, int current, int target, MediaLocator stream){
        super(source, previous, current, target, null);
        this.stream = stream;
    }

    public javax.media.MediaLocator getStream()    {
        return stream;
    }
}


