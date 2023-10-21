/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

import java.util.Arrays;


/**
 * @author Martin Sveden
 * @statuscode 2
 */
public class HBackgroundConfigTemplate extends HScreenConfigTemplate {

    public static final int CHANGEABLE_SINGLE_COLOR = 10;
    public static final int STILL_IMAGE = 11;
    private int[] preferences;

    public HBackgroundConfigTemplate() {
        preferences = new int[12];
        // don't care about anything
        Arrays.fill(preferences, HScreenConfigTemplate.DONT_CARE);
    }

    public boolean isConfigSupported(HBackgroundConfiguration hbc) {
        return true;
    }

    @Override
    public void setPreference(int preference, int priority) {
        preferences[preference] = priority;
    }

    @Override
    public int getPreferencePriority(int preference) {
        return preferences[preference];
    }
}
