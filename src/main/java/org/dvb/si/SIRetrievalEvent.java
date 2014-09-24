/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.si;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public abstract class SIRetrievalEvent extends java.util.EventObject {
			    
	private Object appData;
	
	public SIRetrievalEvent(Object appData, SIRequest request) {
		super(request);
		this.appData = appData;
	}

	public Object getAppData() {
	    return appData;
	}

	public Object getSource() {
	    return super.getSource();
	}

}
