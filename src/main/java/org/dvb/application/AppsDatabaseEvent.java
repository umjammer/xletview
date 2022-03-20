/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package org.dvb.application;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class AppsDatabaseEvent extends java.util.EventObject {

    static public final int NEW_DATABASE = 0;
    static public final int APP_CHANGED = 1;
    static public final int APP_ADDED = 2;
    static public final int APP_DELETED = 3;

    private int eventId;
    private AppID appId;

    public AppsDatabaseEvent(int id, AppID appId, Object source) {
        super(source);
        this.eventId = id;
        this.appId = appId;
    }

    public AppID getAppID() {
        return appId;
    }

    public int getEventId() {
        return eventId;
    }

}
