/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui.event;

import org.davic.resources.ResourceStatusEvent;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class HScreenDeviceReleasedEvent extends ResourceStatusEvent{

    public HScreenDeviceReleasedEvent(Object source){
        super(source);
    }

    public Object getSource(){
        return super.getSource();
    }

}
