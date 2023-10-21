/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.si;

public interface SIBouquet extends SIInformation {

    @Override
    SIRequest retrieveDescriptors(short retrieveMode, Object appData, SIRetrievalListener listener) throws SIIllegalArgumentException;

    @Override
    SIRequest retrieveDescriptors(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags) throws SIIllegalArgumentException;

    @Override
    short[] getDescriptorTags();

    int getBouquetID();

    java.lang.String getName();

    String getShortBouquetName();

    SIRequest retrieveSIBouquetTransportStreams(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags) throws SIIllegalArgumentException;

    org.davic.net.dvb.DvbLocator[] getSIServiceLocators();

}


