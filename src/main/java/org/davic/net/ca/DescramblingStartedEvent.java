/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.net.ca;

public class DescramblingStartedEvent extends org.davic.resources.ResourceStatusEvent {

	public DescramblingStartedEvent(Object caModule) {
		super(caModule);
	}

	public org.davic.net.Locator getServiceLocator() {
		return null;
	}

	public Object getSource() {
	    return null;
	}

}
