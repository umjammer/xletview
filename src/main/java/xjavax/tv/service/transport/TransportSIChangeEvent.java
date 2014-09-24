/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.transport;

import xjavax.tv.service.SIChangeEvent;
import xjavax.tv.service.SIChangeType;
import xjavax.tv.service.SIElement;

/**
 * An <code>TransportSIChangeEvent</code> notifies an
 * <code>SIChangeListener</code> of changes detected to the SI on a
 * <code>Transport</code>.<p>
 * 
 * Subtypes <code>ServiceDetailsChangeEvent</code>,
 * <code>TransportStreamChangeEvent</code>,
 * <code>NetworkChangeEvent</code> and <code>BouquetChangeEvent</code>
 * are used to signal changes to service details, transport streams,
 * networks and bouquets, respectively.  Changes to program events are
 * signaled through <code>ProgramScheduleChangeEvent</code>.
 * <HR>
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public abstract class TransportSIChangeEvent extends SIChangeEvent{

	/**
	 * Constructs an <code>TransportSIChangeEvent</code>.
	 * 
	 * @param transport - The Transport on which the change occurred.
	 * @param type - The type of change that occurred.
	 * @param e - The SIElement that changed.
	 */
	public TransportSIChangeEvent( Transport transport, SIChangeType type, SIElement e)	{
		super(transport, type, e);
	}

	/**
	 * Reports the <code>Transport</code> that generated the event.  It
	 * will be identical to the object returned by the
	 * <code>getSource()</code> method.
	 * 
	 * @return The Transport that generated the event.
	 */
	public Transport getTransport()	{
		return (Transport) super.getSource();
	}

}
