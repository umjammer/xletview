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

    public final static short UNKNOWN = -1;

    public final static short DIGITAL_TELEVISION = 0x01;

    public final static short DIGITAL_RADIO_SOUND = 0x02;

    public final static short TELETEXT = 0x03;

    public final static short NVOD_REFERENCE = 0x04;

    public final static short NVOD_TIME_SHIFTED = 0x05;

    public final static short MOSAIC = 0x06;

    public final static short PAL = 0x07;

    public final static short SECAM = 0x08;

    public final static short D_D2_MAC = 0x09;

    public final static short FM_RADIO = 0x0A;

    public final static short NTSC = 0x0B;

    public final static short DATA_BROADCAST = 0x0C;

    public final static short MHP_APPLICATION = 0x10;
}
