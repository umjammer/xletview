/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public abstract class HScreenConfigTemplate{

    public static final int REQUIRED                     = 1;
    public static final int PREFERRED                    = 2;
    public static final int DONT_CARE                    = 3;
    public static final int PREFERRED_NOT                = 4;
    public static final int REQUIRED_NOT                 = 5;

    public static final int ZERO_BACKGROUND_IMPACT       = 1;
    public static final int ZERO_GRAPHICS_IMPACT         = 2;
    public static final int ZERO_VIDEO_IMPACT            = 3;
    public static final int INTERLACED_DISPLAY           = 4;
    public static final int FLICKER_FILTERING            = 5;
    public static final int VIDEO_GRAPHICS_PIXEL_ALIGNED = 6;
    public static final int PIXEL_ASPECT_RATIO           = 7;
    public static final int PIXEL_RESOLUTION             = 8;
    public static final int SCREEN_RECTANGLE             = 9;

    private int[] preferences;
    private Object[] preferenceObjects;

    public HScreenConfigTemplate(){
        preferences = new int[10];
        preferenceObjects = new Object[10];
        for(int i = 0; i < preferences.length; i++){
            // don't care about anything
            preferences[i] = HScreenConfigTemplate.DONT_CARE;
            preferenceObjects[i] = null;
        }
    }

    public void setPreference(int preference, int priority){
        preferences[preference] = priority;
    }

    public void setPreference(int preference, Object object, int priority){
        setPreference(preference, priority);
        preferenceObjects[preference] = object;
    }

    public int getPreferencePriority(int preference){
        return preferences[preference];
    }

    public Object getPreferenceObject(int preference){
        return preferenceObjects[preference];
    }
}
