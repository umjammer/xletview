/*
 * This file is part of XleTView
 * Copyright (C) 2003 Martin SvedÈn
 *
 * This is free software, and you are
 * welcome to redistribute it under
 * certain conditions;
 *
 * See LICENSE document for details.
 */

package org.dvb.si;

public interface SIInformation {


    short FROM_CACHE_ONLY = 0;

    short FROM_CACHE_OR_STREAM = 1;

    short FROM_STREAM_ONLY = 2;

    SIRequest retrieveDescriptors(short retrieveMode, Object appData, SIRetrievalListener listener) throws SIIllegalArgumentException;

    SIRequest retrieveDescriptors(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags) throws SIIllegalArgumentException;

    short[] getDescriptorTags();

    SIDatabase getSIDatabase();

    java.util.Date getUpdateTime();

    boolean fromActual();

    org.davic.mpeg.TransportStream getDataSource();

}


