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
public class HScreenRectangle extends Object{

    public float x;
    public float y;
    public float width;
    public float height;

    public HScreenRectangle(float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setLocation(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void setSize(float width, float height){
        this.width = width;
        this.height = height;
    }
}
