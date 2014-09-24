/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.net.tuning;

import org.davic.resources.ResourceStatusEvent;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class NetworkInterfaceReleasedEvent extends ResourceStatusEvent {

	public NetworkInterfaceReleasedEvent(Object ni) {
		super(ni);
	}

	public Object getSource() {
		return super.getSource();
	}
}
