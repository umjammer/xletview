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

/**
 * A <code>TransportStreamChangeEvent</code> notifies an
 * <code>TransportStreamChangeListener</code> of changes detected in a
 * <code>TransportStreamCollection</code>.  Specifically, this event
 * signals the addition, removal, or modification of a
 * <code>TransportStream</code>.
 * <A HREF="../../../../javax/tv/service/transport/TransportStream.html"><CODE>TransportStream</CODE></A>, <A HREF="../../../../serialized-form.html#javax.tv.service.transport.TransportStreamChangeEvent">Serialized Form</A></DL>
 * <HR>
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class TransportStreamChangeEvent extends TransportSIChangeEvent{

	/**
	 * Constructs a <code>TransportStreamChangeEvent</code>.
	 * 
	 * @param collection - The transport stream collection in which the change occurred.
	 * @param type - The type of change that occurred.
	 * @param ts - The TransportStream that changed.
	 */
	public TransportStreamChangeEvent( TransportStreamCollection collection, SIChangeType type, TransportStream ts)	{
		super(collection, type, ts);
	}

	/**
	 * Reports the <code>TransportStreamCollection</code> that generated
	 * the event.  It will be identical to the object returned by the
	 * <code>getTransport()</code> method.
	 * 
	 * @return The TransportStreamCollection that generated the event.
	 */
	public TransportStreamCollection getTransportStreamCollection()	{
		return (TransportStreamCollection) super.getTransport();
	}

	/**
	 * Reports the <code>TransportStream</code> that changed.  It will be
	 * identical to the object returned by the inherited
	 * <code>SIChangeEvent.getSIElement</code> method.
	 * 
	 * @return The TransportStream that changed.
	 */
	public TransportStream getTransportStream()	{
		return (TransportStream) super.getSIElement();
	}

}
