/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service;

/**
 * The base class for exceptions related to service information.
 * 
 * The base class for exceptions related to service information.
 * <HR>
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class SIException extends java.lang.Exception{
	/**
	 * Constructs an <code>SIException</code> with no detail message.</DL>
	 * 
	 */
	public SIException(){
		super();
	}

	/**
	 * Constructs an <code>SIException</code> with a detail message.
	 * 
	 * @param reason - The reason why this exception was thrown.
	 */
	public SIException(String reason)	{
		super(reason);
	}

}
