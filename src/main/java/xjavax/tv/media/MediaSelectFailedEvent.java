/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.media;

import xjavax.tv.locator.Locator;

/**
 * <code>MediaSelectFailedEvent</code> notifies a
 * <code>MediaSelectListener</code> that a selection operation failed.
 * <HR>
 * 
 * @author Martin Sveden
 * @statuscode 4 
 */
public class MediaSelectFailedEvent extends MediaSelectEvent
{
	/**
	 * Creates a new <code>MediaSelectFailedEvent</code>.
	 * 
	 * @param source - The Controller that generated this event.
	 * @param selection - The Locator instances on which selection was attempted.
	 */
	public MediaSelectFailedEvent(javax.media.Controller source, Locator[] selection){
		super(source, selection);
	}

}
