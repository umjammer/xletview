/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.ui;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class DVBColor extends java.awt.Color{
	/* 
	 Should inherit from javax.tv.graphics.AlphaColor but since we use the Java 2(tm) platform
	 we can use the java.awt.Color
	 */

	public DVBColor(float r, float g, float b, float a){
		super(r,g,b,a);
	}
	
	public DVBColor(int r, int g, int b, int a){
		super(r,g,b,a);
	}
	
	public DVBColor(int rgba, boolean hasalpha)	{
		super(rgba,hasalpha);
	}
	
	public DVBColor(java.awt.Color c){
		super(c.getRed(), c.getGreen(), c.getBlue());
        //super(c);
	}
	
	public java.awt.Color brighter(){
		return super.brighter();
	}
	
	public java.awt.Color darker(){
		return super.darker();
	}
	
	public boolean equals(java.lang.Object obj)	{
        boolean same = false;
		if(obj != null && obj instanceof DVBColor){
            DVBColor dvbColor = (DVBColor) obj;
            if(dvbColor.getRed() == this.getRed()){
                if(dvbColor.getBlue() == this.getBlue()){
                    if(dvbColor.getGreen() == this.getGreen()){
                        if(dvbColor.getAlpha() == this.getAlpha()){
                            same = true;
                        }            
                    }        
                }    
            }
        }
        return same;
	}
	
	public int getAlpha(){
		return super.getAlpha();
	}
	
	public int getRGB(){
		return super.getRGB();
	}

	public java.lang.String toString(){		
		return this.getClass().getName() + "[r=" + this.getRed() + ",g=" + this.getGreen() + ",b=" + this.getBlue() + ",alpha=" + this.getAlpha() + "]";
	}
}
