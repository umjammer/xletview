/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.dsmcc;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class NPTRateChangeEvent extends java.util.EventObject {

    private NPTRate rate;

    public NPTRateChangeEvent(DSMCCStream source, NPTRate rate){
        super(source);
        this.rate = rate;
    }

    public java.lang.Object getSource() {
        return super.getSource();
    }

    public NPTRate getRate() {
        return rate;
    }
}
