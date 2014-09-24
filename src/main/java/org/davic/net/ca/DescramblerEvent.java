/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.net.ca;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public abstract class DescramblerEvent extends java.util.EventObject {
  
	DescramblerEvent(Object o) {
		super(o);
	}

	public Object getSource() {
		return super.getSource();
	}
}
