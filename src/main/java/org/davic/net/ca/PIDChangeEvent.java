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
public class PIDChangeEvent extends CAEvent {

    private short oldPid;
    private short newPid;

    public PIDChangeEvent(short oldPid, short newPid, Object caModule) {
        super(caModule);
        this.oldPid = oldPid;
        this.newPid = newPid;
    }

    public short getReplacedPID() {
        return oldPid;
    }

    public short getReplacementPID() {
        return newPid;
    }

    public Object getSource() {
        return super.getSource();
    }
}


