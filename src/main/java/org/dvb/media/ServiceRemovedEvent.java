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

public class ServiceRemovedEvent extends StopEvent {

	private MediaLocator stream;
	
	public ServiceRemovedEvent(Controller source){
		super(source,0,0,0,null);
	}
	
	public ServiceRemovedEvent(Controller source, int previous, int current, int target, MediaLocator stream){
		super(source,0,0,0,null);
		this.stream = stream;
	}

	public javax.media.MediaLocator getStream()	{
		return stream;
	}
}


