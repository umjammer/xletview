/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

import java.awt.Dimension;
import java.util.Hashtable;

public class HSceneTemplate{    
    
	public static final int REQUIRED                = 0x01;
    public static final int PREFERRED               = 0x02;
    public static final int UNNECESSARY             = 0x03;
    public static final Dimension LARGEST_PIXEL_DIMENSION = new Dimension(-1, -1);
    
    public static final int GRAPHICS_CONFIGURATION  = 0x00;
    public static final int SCENE_PIXEL_DIMENSION   = 0x01;
    public static final int SCENE_PIXEL_LOCATION    = 0x02;
    public static final int SCENE_SCREEN_DIMENSION  = 0x04;
    public static final int SCENE_SCREEN_LOCATION   = 0x08;

    private Hashtable prefs;
    
    public HSceneTemplate(){
        prefs = new Hashtable();
    }

    public void setPreference(int preference, Object object, int priority){
        
    }

    public Object getPreferenceObject(int preference){
        return null;
    }

    public int getPreferencePriority(int preference){
        return (UNNECESSARY);
    }
}




