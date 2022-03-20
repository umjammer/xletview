/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

import java.awt.Dimension;
import java.awt.Point;

public abstract class HScreenConfiguration extends Object{

    //package scope constructor to stop javadoc generating one
    HScreenConfiguration(){
    }

    public Point convertTo(HScreenConfiguration destination, Point source){
        return (null);
    }

    public boolean getFlickerFilter(){
        return (false);
    }

    public boolean getInterlaced(){
        return (false);
    }

    public Dimension getPixelAspectRatio(){
        return (null);
    }

    public Dimension getPixelResolution(){
        return null;
    }

    public HScreenRectangle getScreenArea(){
        return (null);
    }

    public java.awt.Dimension getOffset(HScreenConfiguration hsc){
        return (null);
    }
}
