/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Rectangle;


public class HGraphicsConfiguration extends HScreenConfiguration{

    protected HGraphicsConfiguration(){
    }

    public HGraphicsDevice getDevice(){
        return (null);
    }

    public HGraphicsConfigTemplate getConfigTemplate(){
        return (null);
    }

    public HScreenRectangle getComponentHScreenRectangle(Component component){
        return (null);
    }

    public Rectangle getPixelCoordinatesHScreenRectangle(HScreenRectangle sr, Container cont){
        return (null);
    }

    public java.awt.Image getCompatibleImage(java.awt.Image input, HImageHints ih){
        return (null);
    }

    public Font[] getAllFonts(){
        return (null);
    }

    public Color getPunchThroughToBackgroundColor(int percentage){
        return (null);
    }

    public Color getPunchThroughToBackgroundColor(int percentage, HVideoDevice hvd){
        return (null);
    }

    public Color getPunchThroughToBackgroundColor(Color color, int percentage){
        return (null);
    }

    public Color getPunchThroughToBackgroundColor(Color color, int percentage, HVideoDevice v){
        return (null);
    }

    public void dispose(Color c){
    }
}
