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

    int STARTED    = 0;

    int DESTROYED  = 1;

    int NOT_LOADED = 2;

    int PAUSED     = 3;

    int getState() ;

    void start();

    void start(String[] args);

    void stop(boolean forced);

    void pause();

    void resume() ;

    void addAppStateChangeEventListener(AppStateChangeEventListener listener) ;

    void removeAppStateChangeEventListener(AppStateChangeEventListener listener) ;

}
