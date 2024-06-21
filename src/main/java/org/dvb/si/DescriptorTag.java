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

public interface DescriptorTag {

    short NETWORK_NAME = 0x40;

    short SERVICE_LIST = 0x41;

    short STUFFING = 0x42;

    short SATELLITE_DELIVERY_SYSTEM = 0x43;

    short CABLE_DELIVERY_SYSTEM = 0x44;

    short BOUQUET_NAME = 0x47;

    short SERVICE = 0x48;

    short COUNTRY_AVAILABILITY = 0x49;

    short LINKAGE = 0x4A;

    short NVOD_REFERENCE = 0x4B;

    short TIME_SHIFTED_SERVICE = 0x4C;

    short SHORT_EVENT = 0x4D;

    short EXTENDED_EVENT = 0x4E;

    short TIME_SHIFTED_EVENT = 0x4F;

    short COMPONENT = 0x50;

    short MOSAIC = 0x51;

    short STREAM_IDENTIFIER = 0x52;

    short CA_IDENTIFIER = 0x53;

    short CONTENT = 0x54;

    short PARENTAL_RATING = 0x55;

    short TELETEXT = 0x56;

    short TELEPHONE = 0x57;

    short LOCAL_TIME_OFFSET = 0x58;

    short SUBTITLING = 0x59;

    short TERRESTRIAL_DELIVERY_SYSTEM = 0x5A;

    short MULTILINGUAL_NETWORK_NAME = 0x5B;

    short MULTILINGUAL_BOUQUET_NAME = 0x5C;

    short MULTILINGUAL_SERVICE_NAME = 0x5D;

    short MULTILINGUAL_COMPONENT = 0x5E;

    short PRIVATE_DATA_SPECIFIER = 0x5F;

    short SERVICE_MOVE = 0x60;

    short SHORT_SMOOTHING_BUFFER = 0x61;

    short FREQUENCY_LIST = 0x62;

    short PARTIAL_TRANSPORT_STREAM = 0x63;

    short DATA_BROADCAST = 0x64;
}

