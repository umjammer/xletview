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
 * <code>MediaSelectEvent</code> is the base class of events sent to
 * <code>MediaSelectListener</code> instances.
 * <HR>
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public abstract class MediaSelectEvent extends java.util.EventObject{
	private javax.media.Controller controller;
	private Locator[] selection;

	/**
	 * Creates a new <code>MediaSelectEvent</code>.
	 * 
	 * @param controller - The Controller that generated this event.
	 * @param selection - The Locator instances on which selection was attempted.
	 */
	public MediaSelectEvent(javax.media.Controller controller, Locator[] selection)	{
		super(controller);
	}

	/**
	 * Reports the Controller that generated this event.
	 * 
	 * @return The Controller that generated this event.
	 */
	public javax.media.Controller getController(){
		return this.controller;
	}

	/**
	 * Reports the selection that caused this event.
	 * 
	 * @return The selection that caused this event.
	 */
	public Locator[] getSelection()	{
		return this.selection;
	}

}
