/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.si;

public interface SIServiceType{

    short UNKNOWN = -1;

    short DIGITAL_TELEVISION = 0x01;

    short DIGITAL_RADIO_SOUND = 0x02;

    short TELETEXT = 0x03;

    short NVOD_REFERENCE = 0x04;

    short NVOD_TIME_SHIFTED = 0x05;

    short MOSAIC = 0x06;

    short PAL = 0x07;

    short SECAM = 0x08;

    short D_D2_MAC = 0x09;

    short FM_RADIO = 0x0A;

    short NTSC = 0x0B;

    short DATA_BROADCAST = 0x0C;

    short MHP_APPLICATION = 0x10;
}
