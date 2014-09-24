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
 * notification of changes to <code>ServiceDetails</code> data.
 * <HR>
 * 
 * 
 */
public interface ServiceDetailsChangeListener extends SIChangeListener
{
	/**
	 * Notifies the <code>ServiceDetailsChangeListener</code> of a
	 * change to a <code>ServiceDetails</code>.
	 * 
	 * @param event - A ServiceDetailsChangeEvent describing what changed and how.
	 */
	public void notifyChange( ServiceDetailsChangeEvent event);

}
