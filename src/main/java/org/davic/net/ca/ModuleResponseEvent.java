/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.net.ca;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public abstract class ModuleResponseEvent extends MessageEvent{

    private byte[] data;

    protected ModuleResponseEvent(CAModule caModule, byte[] data) {
        super(caModule);
        this.data = data;
    }

    public Object getSource() {
        return super.getSource();
    }

    public byte[] getData() {
        return data;
    }


}
