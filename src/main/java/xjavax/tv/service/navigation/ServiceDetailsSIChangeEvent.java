/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.navigation;

import xjavax.tv.service.SIChangeEvent;
import xjavax.tv.service.SIChangeType;
import xjavax.tv.service.SIElement;

/**
 * A <code>ServiceDetailsSIChangeEvent</code> notifies an
 * <code>SIChangeListener</code> of changes to a
 * <code>ServiceDetails</code>.
 * <A HREF="../../../../javax/tv/service/navigation/ServiceDetails.html"><CODE>ServiceDetails</CODE></A>, <A HREF="../../../../serialized-form.html#javax.tv.service.navigation.ServiceDetailsSIChangeEvent">Serialized Form</A></DL>
 * <HR>
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public abstract class ServiceDetailsSIChangeEvent extends SIChangeEvent{

	/**
	 * Constructs a <code>ServiceDetailsSIChangeEvent</code>.
	 * 
	 * @param service - The ServiceDetails in which the change occurred.
	 * @param type - The type of change that occurred.
	 * @param e - The SIElement that changed.
	 */
	public ServiceDetailsSIChangeEvent( ServiceDetails service, SIChangeType type, SIElement e)	{
		super(service, type, e);
	}

	/**
	 * Reports the <code>ServiceDetails</code> that generated the
	 * event.  It will be identical to the object returned by the
	 * <code>getSource()</code> method.
	 * 
	 * @return The ServiceDetails that generated the event.
	 */
	public ServiceDetails getServiceDetails(){
		return (ServiceDetails) super.getSource();
	}

}
