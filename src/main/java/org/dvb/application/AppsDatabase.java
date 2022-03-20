/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.application;

import java.util.Enumeration;

public class AppsDatabase {

    AppsDatabase() {
    }


    static public AppsDatabase getAppsDatabase() {
        return null ;
    }


    public int size() {
        return 0 ;
    }

    public Enumeration<?> getAppIDs(AppsDatabaseFilter filter) {
        return null ;
    }

    public Enumeration<?> getAppAttributes(AppsDatabaseFilter filter) {
        return null ;
    }

    public AppAttributes getAppAttributes (AppID key) {
        return  null;
    }

    public AppProxy getAppProxy(AppID key) {
        return  null;
    }

    public void addListener(AppsDatabaseEventListener listener){
    }

    public void removeListener(AppsDatabaseEventListener listener){
    }

}
