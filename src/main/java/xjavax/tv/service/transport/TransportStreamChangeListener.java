/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.transport;

import xjavax.tv.service.SIChangeListener;

/**
 * This interface is implemented by applications wishing to receive
 * notification of changes to <code>TransportStream</code> data.
 * <HR>
 * 
 * 
 */
public interface TransportStreamChangeListener extends SIChangeListener
{
	/**
	 * Notifies the <code>TransportStreamChangeListener</code> of a
	 * change to a <code>TransportStream</code>.
	 * 
	 * @param event - A TransportStreamChangeEvent describing what changed and how.
	 */
	public void notifyChange( TransportStreamChangeEvent event);

}
