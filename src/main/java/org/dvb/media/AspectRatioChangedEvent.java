/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.media;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class AspectRatioChangedEvent extends VideoFormatEvent{
	
	private int newRatio;
	
	public AspectRatioChangedEvent(Object source, int newRatio) {
		super(source);
		this.newRatio = newRatio;
	}
	
	public int getNewRatio() {
		return newRatio;
	}
}
