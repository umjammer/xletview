/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
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
public class ServiceXFRErrorEvent extends AsynchronousLoadingEvent {
   	
	private ServiceXFRReference reference;
	
	public ServiceXFRErrorEvent (DSMCCObject o, ServiceXFRReference ref) {
		super(o);
		this.reference = ref;
	}

	public java.lang.Object getSource() {
		return super.getSource();
	}
	
	public ServiceXFRReference getServiceXFR () {
		return reference;
	}
}
