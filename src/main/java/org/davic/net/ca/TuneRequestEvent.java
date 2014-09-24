/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.net.ca;

import org.davic.net.Locator;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class TuneRequestEvent extends CAEvent {

	private Locator locator;
	
	public TuneRequestEvent(Locator locator, Object caModule) {
		super(caModule);
		this.locator = locator;
	}

	public Locator getLocator() {
	    return locator;
	}

	public Object getSource() {
		return super.getSource();
	}

}
