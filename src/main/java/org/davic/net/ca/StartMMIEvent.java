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
public class StartMMIEvent extends MMIEvent {

	private MMIObject mmiObject;
	
	public StartMMIEvent(MMIObject mmiObject, int dialogueId, Object caModule) {
		super(caModule, dialogueId);
		this.mmiObject = mmiObject;
	}


	public MMIObject getMMIObject() {
		return mmiObject;
	}
}
