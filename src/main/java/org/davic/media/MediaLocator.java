/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.media;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class MediaLocator extends javax.media.MediaLocator{
	
	public MediaLocator(org.davic.net.Locator locator){
		super(locator.toString());
	}
}
