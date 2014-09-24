/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.selection;

/**
 * The base class for exceptions related to service contexts.
 * 
 * The base class for exceptions related to service contexts.
 * <HR>
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class ServiceContextException extends java.lang.Exception{
	/**
	 * Constructs a <code>ServiceContextException</code> with no detail message.</DL>
	 * 
	 */
	public ServiceContextException(){
		super();
	}

	/**
	 * Constructs a <code>ServiceContextException</code> with a detail message.
	 * 
	 * @param reason - The reason this exception was thrown.
	 */
	public ServiceContextException(String reason)	{
		super(reason);
	}

}
