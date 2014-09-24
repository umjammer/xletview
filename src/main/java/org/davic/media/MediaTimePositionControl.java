/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.media;

public interface MediaTimePositionControl extends javax.media.Control {
	
	public javax.media.Time setMediaTimePosition(javax.media.Time mediaTime);
	
	public javax.media.Time getMediaTimePosition();
}


