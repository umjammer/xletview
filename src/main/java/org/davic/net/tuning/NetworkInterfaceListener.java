/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.net.tuning;

public interface NetworkInterfaceListener extends java.util.EventListener {

    void receiveNIEvent(NetworkInterfaceEvent anEvent);
}



