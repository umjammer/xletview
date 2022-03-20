/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.user ;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class UserPreferenceChangeEvent extends java.util.EventObject{

    public UserPreferenceChangeEvent (String preferenceName) {
        super(preferenceName);
    }

    public String getName () {
        return "" + getSource();
    }
}

