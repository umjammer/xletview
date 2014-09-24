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
 * <code>InsufficientResourcesException</code> is generated when
 * sufficient resources for an operation are not available.
 * <HR>
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class InsufficientResourcesException extends ServiceContextException{
	/**
	 * Constructs an <code>InsufficientResourcesException</code> with no
	 * detail message.</DL>
	 * 
	 */
	public InsufficientResourcesException()	{
		super();
	}

	/**
	 * Constructs an <code>InsufficientResourcesException</code> with a
	 * detail message.
	 * 
	 * @param s - The detail message.
	 */
	public InsufficientResourcesException(String s){
		super(s);
	}

}
