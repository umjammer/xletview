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
public class CAException extends java.io.IOException {
	
	public CAException(){
		super();
	}
	
	public CAException (String reason){
		super(reason);
	}
}


