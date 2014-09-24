/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
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
public class HScreenPoint extends Object{    
    
	public float x;
    public float y;

    public HScreenPoint(float x, float y){
    	this.x = x;
    	this.y = y;
    }

    public void setLocation(float x, float y){
    	this.x = x;
    	this.y = y;
    }
}
