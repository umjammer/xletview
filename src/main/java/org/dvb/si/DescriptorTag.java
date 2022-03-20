/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.si;

public interface DescriptorTag{

    public final static short NETWORK_NAME                = 0x40;

    public final static short SERVICE_LIST                = 0x41;

    public final static short STUFFING                    = 0x42;

    public final static short SATELLITE_DELIVERY_SYSTEM   = 0x43;

    public final static short CABLE_DELIVERY_SYSTEM       = 0x44;

    public final static short BOUQUET_NAME                = 0x47;

    public final static short SERVICE                     = 0x48;

    public final static short COUNTRY_AVAILABILITY        = 0x49;

    public final static short LINKAGE                     = 0x4A;

    public final static short NVOD_REFERENCE              = 0x4B;

    public final static short TIME_SHIFTED_SERVICE        = 0x4C;

    public final static short SHORT_EVENT                 = 0x4D;

    public final static short EXTENDED_EVENT              = 0x4E;

    public final static short TIME_SHIFTED_EVENT          = 0x4F;

    public final static short COMPONENT                   = 0x50;

    public final static short MOSAIC                      = 0x51;

    public final static short STREAM_IDENTIFIER           = 0x52;

    public final static short CA_IDENTIFIER               = 0x53;

    public final static short CONTENT                     = 0x54;

    public final static short PARENTAL_RATING             = 0x55;

    public final static short TELETEXT                    = 0x56;

    public final static short TELEPHONE                   = 0x57;

    public final static short LOCAL_TIME_OFFSET           = 0x58;

    public final static short SUBTITLING                  = 0x59;

    public final static short TERRESTRIAL_DELIVERY_SYSTEM = 0x5A;

    public final static short MULTILINGUAL_NETWORK_NAME   = 0x5B;

    public final static short MULTILINGUAL_BOUQUET_NAME   = 0x5C;

    public final static short MULTILINGUAL_SERVICE_NAME   = 0x5D;

    public final static short MULTILINGUAL_COMPONENT      = 0x5E;

    public final static short PRIVATE_DATA_SPECIFIER      = 0x5F;

    public final static short SERVICE_MOVE                = 0x60;

    public final static short SHORT_SMOOTHING_BUFFER      = 0x61;

    public final static short FREQUENCY_LIST              = 0x62;

    public final static short PARTIAL_TRANSPORT_STREAM    = 0x63;

    public final static short DATA_BROADCAST              = 0x64;

}

