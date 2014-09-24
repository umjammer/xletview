/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

import java.awt.Image;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class HListElement{
    
	private String label;
	private Image icon;
	
    public HListElement(String label){
    	this.label = label;
    }

    public HListElement(Image icon, String label){
    	this.icon = icon;
    	this.label = label;
    }

    public String getLabel(){
	    return label;
    }

    public Image getIcon(){
	    return icon;
    }

    public void setLabel(String label){
    	this.label = label;
    }

    public void setIcon(Image icon){
    	this.icon = icon;
    }
}
