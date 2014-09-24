/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.media;

import javax.media.Control;

import org.havi.ui.HScreenRectangle;

public interface VideoPresentationControl extends Control {
	
	public abstract java.awt.Dimension getInputVideoSize();

	public abstract java.awt.Dimension getVideoSize();

	public abstract HScreenRectangle getActiveVideoArea();
	
	public abstract HScreenRectangle getActiveVideoAreaOnScreen();	
	
	public abstract HScreenRectangle getTotalVideoArea();
		
	public abstract HScreenRectangle getTotalVideoAreaOnScreen();
	
	public abstract boolean supportsClipping();

	public abstract java.awt.Rectangle setClipRegion(java.awt.Rectangle clipRect);

	public abstract java.awt.Rectangle getClipRegion();
	
	public abstract float[] supportsArbitraryHorizontalScaling();
		
	public abstract float[] supportsArbitraryVerticalScaling();
	
	public abstract float[] getHorizontalScalingFactors();
	
	public abstract float[] getVerticalScalingFactors();
	
	public static final byte POS_CAP_FULL = 0;
	
	public static final byte POS_CAP_FULL_IF_ENTIRE_VIDEO_ON_SCREEN = 1;
	
	public static final byte POS_CAP_FULL_EVEN_LINES = 3;
	
	public static final byte POS_CAP_FULL_EVEN_LINES_IF_ENTIRE_VIDEO_ON_SCREEN = 4;
	
	public static final byte POS_CAP_OTHER = -1;
	
	public byte getPositioningCapability();
}
