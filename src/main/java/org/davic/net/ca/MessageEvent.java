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
public abstract class MessageEvent extends java.util.EventObject {

	private int sessionId;
	
	MessageEvent(Object object) {
		super(object);
	}
	
	MessageEvent(Object object, int sessionId) {
		this(object);
		this.sessionId = sessionId;
	}

	public int getSessionId() {	
		return sessionId;
	}

	public Object getSource() {
		return super.getSource();
	}

}
