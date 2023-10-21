/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.application;

import java.util.EventListener;


public interface AppsDatabaseEventListener extends EventListener {

    void newDatabase(AppsDatabaseEvent evt);

    void entryAdded(AppsDatabaseEvent evt);

    void entryRemoved(AppsDatabaseEvent evt);

    void entryChanged(AppsDatabaseEvent evt);
}

