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

    org.davic.net.dvb.DvbLocator getDvbLocator();

    int getOriginalNetworkID();

    int getTransportStreamID();

    int getServiceID();

    int getEventID();

    java.util.Date getStartTime();

    long getDuration();

    byte getRunningStatus();

    boolean getFreeCAMode();

    java.lang.String getName();

    String getShortEventName();

    java.lang.String getShortDescription();

    byte[] getLevel1ContentNibbles();

    byte[] getContentNibbles();

    SIRequest retrieveSIService(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags) throws SIIllegalArgumentException;
}


