/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.net;

import xjavax.tv.locator.InvalidLocatorException;
import xjavax.tv.locator.Locator;

/**
 * Class <code>InterfaceMap</code> reports the local IP address
 * assigned to a given service component that carries IP data.
 * Applications may use the returned IP address to specify the network
 * interface to which an instance of
 * <code>java.net.DatagramSocket</code> or
 * <code>java.net.MulticastSocket</code> should bind.
 * <CODE>java.net.MulticastSocket.setInterface(java.net.InetAddress)</CODE></DL>
 * <HR>
 * 
 * 
 */
public class InterfaceMap extends java.lang.Object
{
	/**
	 * Reports the local IP address assigned to the given service
	 * component.
	 * 
	 * @param locator - The service component for which the local IP address mapping is required.
	 * @return The IP address assigned to this service component.
	 * @throws InvalidLocatorException - If the given locator does not refer to a valid source of IP data, or if this system does not support the reception of broadcast IP data.
	 * @throws java.io.IOException - If a local IP address is not available to be assigned to the source of IP data.
	 */
	public static java.net.InetAddress getLocalAddress( Locator locator) throws InvalidLocatorException, java.io.IOException
	{
		return null;
		//TODO implement getLocalAddress
	}

}
