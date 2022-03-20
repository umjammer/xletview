/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;


public class HGraphicsConfigTemplate extends HScreenConfigTemplate{


    public static final int VIDEO_MIXING          = 0x0C;

    public static final int MATTE_SUPPORT         = 0x0D;

    public static final int IMAGE_SCALING_SUPPORT = 0x0E;


    public HGraphicsConfigTemplate(){
    }

    public boolean isConfigSupported(HGraphicsConfiguration hgc){
        return (true);
    }

    public void setPreference(int preference, int priority){
    }

    public int getPreferencePriority(int preference){
        return (REQUIRED);
    }

    public void setPreference(int preference, Object object, int priority){
    }

    public Object getPreferenceObject(int preference){
        return (null);
    }
}
