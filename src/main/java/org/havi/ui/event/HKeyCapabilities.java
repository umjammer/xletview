/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui.event;

public class HKeyCapabilities{

    protected HKeyCapabilities(){
    }

    public static boolean getInputDeviceSupported(){
        return (true);
    }

    public static boolean isSupported(int keycode){
        return (false);
    }
}

