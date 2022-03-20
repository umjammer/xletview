/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.



*/


package org.dvb.net.rc;

import org.davic.resources.ResourceStatusEvent;

/**
 *
 *
 * @version  14.9.03
 * @author      Bengt Skogvall
 * @statuscode 4
 */
public class RCInterfaceReservedEvent
    extends ResourceStatusEvent
{
  private Object connection;

  public RCInterfaceReservedEvent(Object bg)
  {
    super(bg);
    connection = bg;
  }

  public Object getSource()
  {
    return connection;
  }
}