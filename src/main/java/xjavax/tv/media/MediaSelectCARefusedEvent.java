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
 * <code>MediaSelectCARefusedEvent</code> is generated when a
 * media select operation fails due to lack of CA authorization.
 * <HR>
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class MediaSelectCARefusedEvent extends MediaSelectFailedEvent
{
	/**
	 * Constructs the <code>MediaSelectCARefusedEvent</code>.
	 * 
	 * @param source - The Controller that generated this event.
	 * @param selection - The Locator instances on which selection failed.
	 */
	public MediaSelectCARefusedEvent(javax.media.Controller source, Locator[] selection){
		super(source, selection);		
	}

}
