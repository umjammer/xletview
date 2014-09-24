/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.media;

import javax.media.Controller;
import javax.media.MediaLocator;
import javax.media.StopEvent;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class NoComponentSelectedEvent extends StopEvent {

	private MediaLocator stream;
	
	public NoComponentSelectedEvent(Controller source, int previous, int current, int target, MediaLocator stream){
		super(source,0,0,0,null);
		this.stream = stream;
	}

	public MediaLocator getStream(){
		return stream;
	}
}


