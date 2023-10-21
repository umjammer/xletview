/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.si;

public interface SINetwork extends SIInformation {

    @Override
    SIRequest retrieveDescriptors(short retrieveMode, Object appData, SIRetrievalListener listener) throws SIIllegalArgumentException;

    @Override
    SIRequest retrieveDescriptors(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags) throws SIIllegalArgumentException;

    @Override
    short[] getDescriptorTags();

    int getNetworkID();

    java.lang.String getName();

    String getShortNetworkName();

    SIRequest retrieveSITransportStreams(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags) throws SIIllegalArgumentException;

}









