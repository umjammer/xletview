/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.selection;

import xjavax.tv.locator.Locator;

/**
 * This exception is thrown when one or more service components are
 * not valid for usage in a particular context.  If multiple service
 * components are simultaneously invalid, this exception reports
 * one of them.
 * <HR>
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class InvalidServiceComponentException extends ServiceContextException{

	private Locator invalidServiceComponent;

	/**
	 * Constructs an <code>InvalidServiceComponentException</code>
	 * with no detail message.
	 * 
	 * @param component - A locator indicating the offending service component.
	 */
	public InvalidServiceComponentException( Locator component)	{
		invalidServiceComponent = component;
	}

	/**
	 * Constructs an <code>InvalidServiceComponentException</code> with
	 * the specified detail message.
	 * 
	 * @param component - A locator indicating the offending service component.
	 * @param reason - The reason why this component is invalid.
	 */
	public InvalidServiceComponentException( Locator component, String reason){
		super(reason);
		invalidServiceComponent = component;
	}

	/**
	 * Reports the offending service components.
	 * 
	 * @return A locator indicating the service component that caused the exception.
	 */
	public Locator getInvalidServiceComponent()	{
		return invalidServiceComponent;
	}

}
