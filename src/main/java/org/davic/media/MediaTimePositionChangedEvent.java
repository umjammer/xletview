/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.media;

public class MediaTimePositionChangedEvent extends javax.media.RestartingEvent {
	
	public MediaTimePositionChangedEvent(javax.media.Controller source)	{
		super(source,0,0,0,null);
	}
	
	public MediaTimePositionChangedEvent (javax.media.Controller from,	int previous, int current, int target, javax.media.Time mediaTime){
		super(from,previous,current,target,mediaTime);
	}
}

