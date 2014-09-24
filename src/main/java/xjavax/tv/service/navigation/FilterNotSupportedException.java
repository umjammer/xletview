/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/
package xjavax.tv.service.navigation;

import xjavax.tv.service.SIException;

/**
 * This exception indicates that the specified <code>ServiceFilter</code> is
 * not supported.
 * <HR>
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class FilterNotSupportedException extends SIException{
	/**
	 * Constructs a <code>FilterNotSupportedException</code> with no
	 * detail message.</DL>
	 * 
	 */
	public FilterNotSupportedException(){
		super();
	}

	/**
	 * Constructs a <code>FilterNotSupportedException</code> with a
	 * detail message.
	 * 
	 * @param reason - The reason why this exception was thrown.
	 */
	public FilterNotSupportedException(String reason)	{
		super(reason);
	}

}
