/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.si;

public interface SIEvent extends SIInformation {

    public org.davic.net.dvb.DvbLocator getDvbLocator();

    public int getOriginalNetworkID();

    public int getTransportStreamID();

    public int getServiceID();

    public int getEventID();

    public java.util.Date getStartTime();

    public long getDuration();

    public byte getRunningStatus();

    public boolean getFreeCAMode();

    public java.lang.String getName();

    public String getShortEventName();

    public java.lang.String getShortDescription();

    public byte[] getLevel1ContentNibbles();

    public byte[] getContentNibbles();

    public SIRequest retrieveSIService(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags) throws SIIllegalArgumentException;
}


