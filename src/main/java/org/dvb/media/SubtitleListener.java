/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.media;

public interface SubtitleListener extends java.util.EventListener {
	public void subtitleStatusChanged(java.util.EventObject event);
}

