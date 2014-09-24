/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.application;

import java.util.EventListener;

public interface AppsDatabaseEventListener extends EventListener{
    
    public void newDatabase(AppsDatabaseEvent evt);
    
    public void entryAdded(AppsDatabaseEvent evt);
    
    public void entryRemoved(AppsDatabaseEvent evt);
    
    public void entryChanged(AppsDatabaseEvent evt);
}

