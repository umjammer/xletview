/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.si;

public interface SIService extends SIInformation, TextualServiceIdentifierQuery{

    public org.davic.net.dvb.DvbLocator getDvbLocator();

    public int getOriginalNetworkID();

    public int getTransportStreamID();

    public int getServiceID();

    public short getSIServiceType();

    public String getName();

    public String getShortServiceName();

    public String getProviderName();

    public String getShortProviderName();

    public boolean getEITScheduleFlag();

    public boolean getEITPresentFollowingFlag();

    public byte getRunningStatus();

    public boolean getFreeCAMode();

    public SIRequest retrievePresentSIEvent(short retrieveMode, Object appData, SIRetrievalListener listener, short[]someDescriptorTags) throws SIIllegalArgumentException;

    public SIRequest retrieveFollowingSIEvent(short retrieveMode, Object appData, SIRetrievalListener listener, short[]someDescriptorTags) throws SIIllegalArgumentException;

    public SIRequest retrieveScheduledSIEvents(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags, java.util.Date startTime, java.util.Date endTime) throws SIIllegalArgumentException, SIInvalidPeriodException;

    public SIRequest retrievePMTService(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags) throws SIIllegalArgumentException;

    public String[] getTextualServiceIdentifiers();

}
