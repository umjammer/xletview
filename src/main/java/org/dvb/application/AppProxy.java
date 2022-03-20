/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.application ;

public interface AppProxy {

    public static final int STARTED    = 0;

    public static final int DESTROYED  = 1;

    public static final int NOT_LOADED = 2;

    public static final int PAUSED     = 3;

    public int getState () ;

    public void start ();

    public void start (String args[]);

    public void stop(boolean forced);

    public void pause();

    public void resume () ;

    public void addAppStateChangeEventListener (AppStateChangeEventListener listener) ;

    public void removeAppStateChangeEventListener (AppStateChangeEventListener listener) ;

}
