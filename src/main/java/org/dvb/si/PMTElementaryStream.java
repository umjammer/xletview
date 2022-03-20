/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.si;

public interface PMTElementaryStream extends SIInformation {

    public org.davic.net.dvb.DvbLocator getDvbLocator();

    public int getOriginalNetworkID();

    public int getTransportStreamID();

    public int getServiceID();

    public int getComponentTag();

    public byte getStreamType();

    public short getElementaryPID();
}

