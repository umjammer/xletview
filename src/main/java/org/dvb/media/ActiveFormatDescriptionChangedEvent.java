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
public class ActiveFormatDescriptionChangedEvent extends VideoFormatEvent{

    private int newFormat;

    public ActiveFormatDescriptionChangedEvent(Object source, int newFormat) {
        super(source);
        this.newFormat = newFormat;
    }

    public int getNewFormat() {
        return newFormat;
    }

}
