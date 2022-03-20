/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.si;

public interface SIMonitoringType{

  public final static byte NETWORK = 1;

  public final static byte BOUQUET = 2;

  public final static byte SERVICE = 3;

  public final static byte PMT_SERVICE = 4;

  public final static byte PRESENT_FOLLOWING_EVENT = 5;

  public final static byte SCHEDULED_EVENT = 6;

}
