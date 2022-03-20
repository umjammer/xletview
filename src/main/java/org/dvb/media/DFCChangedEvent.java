/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.media;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class DFCChangedEvent extends VideoFormatEvent{

    private int newDFC;

    public DFCChangedEvent(Object source, int newDFC) {
        super(source);
        this.newDFC = newDFC;
    }

    public int getNewDFC() {
        return newDFC;
    }
}
