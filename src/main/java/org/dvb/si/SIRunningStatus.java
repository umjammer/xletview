/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.si;

public interface SIRunningStatus {

    byte UNDEFINED = 0;

    byte NOT_RUNNING = 1;

    byte STARTS_IN_A_FEW_SECONDS = 2;

    byte PAUSING = 3;

    byte RUNNING = 4;
}
