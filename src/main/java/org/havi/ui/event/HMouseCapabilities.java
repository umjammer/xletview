/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui.event;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class HMouseCapabilities{

    protected HMouseCapabilities(){
    }

    /**
     * Mouse is not supported
     * @return false
     */
    public static boolean getInputDeviceSupported(){
        return false;
    }

}
