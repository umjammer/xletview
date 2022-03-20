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
public class HScreenDimension extends Object{

    public float width;
    public float height;

    public HScreenDimension(float width, float height){
        this.width = width;
        this.height = height;
    }

    public void setSize(float width, float height){
        this.width = width;
        this.height = height;
    }
}
