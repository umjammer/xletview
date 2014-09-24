/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
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
public class HBackgroundImageEvent extends java.util.EventObject{
    
    public static final int BACKGROUNDIMAGE_FIRST          = 1;
        
    public static final int BACKGROUNDIMAGE_LOADED         = 1;
    
    public static final int BACKGROUNDIMAGE_FILE_NOT_FOUND = 2;
    
    public static final int BACKGROUNDIMAGE_IOERROR        = 3;
    
    public static final int BACKGROUNDIMAGE_INVALID        = 4;
    
    public static final int BACKGROUNDIMAGE_LAST           = 4;

    private int id;
    
    public HBackgroundImageEvent(Object source, int id){
	    super(source);
	    this.id = id;
    }

    public Object getSource(){
	    return super.getSource();
    }

    public int getID(){
	    return id;
    }
}







