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

public interface SIMonitoringType {

    byte NETWORK = 1;

    byte BOUQUET = 2;

    byte SERVICE = 3;

    byte PMT_SERVICE = 4;

    byte PRESENT_FOLLOWING_EVENT = 5;

    byte SCHEDULED_EVENT = 6;
}
