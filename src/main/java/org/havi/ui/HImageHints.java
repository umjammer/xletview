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
public class HImageHints extends Object{

    public static final int NATURAL_IMAGE = 0x01;
    public static final int CARTOON = 0x02;
    public static final int BUSINESS_GRAPHICS = 0x03;
    public static final int LINE_ART = 0x04;

    private int type;

    public HImageHints(){
    }

    public void setType(int type){
        this.type = type;
    }

    public int getType(){
        return type;
    }
}








