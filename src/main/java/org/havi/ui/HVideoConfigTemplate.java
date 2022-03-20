/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

public class HVideoConfigTemplate extends HScreenConfigTemplate{

    public static final int GRAPHICS_MIXING = 0x0F;

    public HVideoConfigTemplate(){
    }

    public boolean isConfigSupported(HVideoConfiguration hvc){
        return (true);
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
