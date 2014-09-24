/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.ui;

import java.awt.Graphics;

/**
 * 
 * 
 * @author Christian K&ouml;berl
 * @statuscode 4
 */
public abstract class DVBGraphics extends Graphics {

	protected DVBGraphics() {
	}
	
	public abstract int[] getAvailableCompositeRules();

	public DVBColor getBestColorMatch(java.awt.Color c)	{
		return new DVBColor(c);
	}
	
	public abstract java.awt.Color getColor();
	
	public abstract DVBAlphaComposite getDVBComposite();
	
	public int getType() {
		return 0;
	}
	
	public abstract void setColor(java.awt.Color c);
	
	public abstract void setDVBComposite(DVBAlphaComposite comp) throws UnsupportedDrawingOperationException;

	public String toString() {	
		return getClass().getName() + "[font=" + getFont() + ",color=" + getColor() + "]";
	}
	
	public static DVBGraphics getDVBGraphics(Graphics graphics)
	{
		return new DVBGraphicsImpl(graphics);
	}
}
