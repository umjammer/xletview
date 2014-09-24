/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui.event;

import java.awt.Color;
import java.awt.Image;


public class HEventRepresentation extends Object{
    
    public static final int ER_TYPE_NOT_SUPPORTED = 0;
    public static final int ER_TYPE_STRING = 1;
    public static final int ER_TYPE_COLOR = 2;
    public static final int ER_TYPE_SYMBOL = 4;
    
    private int type;
    private Color color;
    private String string;
    private Image symbol;
    
    
    protected HEventRepresentation(){
    }

    public boolean isSupported(){
	    return (false);
    }
    
    protected void setType(int aType){	
    }

    public int getType(){
	    return (0);
    }
   
    protected void setColor(java.awt.Color aColor){
    }

    public Color getColor(){
	    return(null);
    }
   
    protected void setString(String aText){
    }

    public String getString(){
	    return (null);
    }
	    
    protected void setSymbol(java.awt.Image aSymbol){
    }
   
    public Image getSymbol(){
	    return (null);
    }
}
