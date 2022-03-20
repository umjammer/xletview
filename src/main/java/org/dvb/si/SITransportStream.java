/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.si;

public interface SITransportStream extends SIInformation {

    public org.davic.net.dvb.DvbLocator getDvbLocator();

    public int getOriginalNetworkID();

    public int getTransportStreamID();

    public SIRequest retrieveSIServices(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags) throws SIIllegalArgumentException;

}



