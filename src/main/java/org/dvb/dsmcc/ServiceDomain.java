/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.dsmcc;

import java.io.FileNotFoundException;
import java.io.InterruptedIOException;

import org.davic.net.InvalidLocatorException;
import org.davic.net.Locator;

public class ServiceDomain {

	public ServiceDomain() {
	}

	public void attach(org.davic.net.Locator aDVBService, int aCarouselId) throws ServiceXFRException, InterruptedIOException, MPEGDeliveryException {
	}

	public void attach (org.davic.net.Locator l) throws DSMCCException, InterruptedIOException, MPEGDeliveryException  {
	}

	public void attach(byte[] NSAPAddress) throws DSMCCException, InterruptedIOException, InvalidAddressException, MPEGDeliveryException  {
	}

	public void detach() throws NotLoadedException {}

	public byte[] getNSAPAddress() throws NotLoadedException {
		return null;
	}

	public static java.net.URL getURL( org.davic.net.Locator l) throws NotLoadedException, InvalidLocatorException, FileNotFoundException{ return null; }

	public DSMCCObject getMountPoint() { return null;}

	public boolean isNetworkConnectionAvailable() { return false; }

	public boolean isAttached() { return false ;}

	public Locator getLocator() { return null; }
}
