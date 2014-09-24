/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.transport;

import xjavax.tv.service.SIChangeType;
import xjavax.tv.service.navigation.ServiceDetails;

/**
 * A <code>ServiceDetailsChangeEvent</code> notifies an
 * <code>ServiceDetailsChangeListener</code> of changes detected to a
 * <code>ServiceDetails</code> on a <code>Transport</code>.
 * Specifically, this event signals the addition, removal, or
 * modification of a <code>ServiceDetails</code>.
 * <A HREF="../../../../javax/tv/service/navigation/ServiceDetails.html"><CODE>ServiceDetails</CODE></A>, <A HREF="../../../../serialized-form.html#javax.tv.service.transport.ServiceDetailsChangeEvent">Serialized Form</A></DL>
 * <HR>
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class ServiceDetailsChangeEvent extends TransportSIChangeEvent{

	/**
	 * Constructs a <code>ServiceDetailsChangeEvent</code>.
	 * 
	 * @param transport - The Transport on which the change occurred.
	 * @param type - The type of change that occurred.
	 * @param s - The ServiceDetails that changed.
	 */
	public ServiceDetailsChangeEvent( Transport transport, SIChangeType type, ServiceDetails s)	{
		super(transport, type, s);
	}

	/**
	 * Reports the <code>ServiceDetails</code> that changed.  It will be
	 * identical to the object returned by the inherited
	 * <code>SIChangeEvent.getSIElement</code> method.
	 * 
	 * @return The ServiceDetails that changed.
	 */
	public ServiceDetails getServiceDetails()	{
		return (ServiceDetails) super.getSIElement();
	}

}
