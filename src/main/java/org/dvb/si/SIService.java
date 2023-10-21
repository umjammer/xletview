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

    org.davic.net.dvb.DvbLocator getDvbLocator();

    int getOriginalNetworkID();

    int getTransportStreamID();

    int getServiceID();

    short getSIServiceType();

    String getName();

    String getShortServiceName();

    String getProviderName();

    String getShortProviderName();

    boolean getEITScheduleFlag();

    boolean getEITPresentFollowingFlag();

    byte getRunningStatus();

    boolean getFreeCAMode();

    SIRequest retrievePresentSIEvent(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags) throws SIIllegalArgumentException;

    SIRequest retrieveFollowingSIEvent(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags) throws SIIllegalArgumentException;

    SIRequest retrieveScheduledSIEvents(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags, java.util.Date startTime, java.util.Date endTime) throws SIIllegalArgumentException, SIInvalidPeriodException;

    SIRequest retrievePMTService(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags) throws SIIllegalArgumentException;

    @Override
    String[] getTextualServiceIdentifiers();

}
