/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Sved�n
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.dsmcc ;


/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class InvalidPathnameEvent extends AsynchronousLoadingEvent {

	public InvalidPathnameEvent (DSMCCObject o) {
		super(o);
	}

	public java.lang.Object getSource() {
		return super.getSource();
	}
}
