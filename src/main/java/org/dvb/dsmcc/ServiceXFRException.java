/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.dsmcc;

import org.davic.net.Locator;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class ServiceXFRException extends DSMCCException {

	private ServiceXFRReference ref;
	
	public ServiceXFRException(Locator service, int carouselId, String pathName) {
		ref = new ServiceXFRReference(service, carouselId, pathName);
	}
   
	public ServiceXFRException(byte[] NSAPAddress, String pathName){
		ref = new ServiceXFRReference(NSAPAddress, pathName);
	}
   
	public ServiceXFRReference getServiceXFR(){
		return ref;
	}
}
