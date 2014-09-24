/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.net;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class InvalidLocatorException extends Exception {

	public InvalidLocatorException() {
		super();
	}

	public InvalidLocatorException(String reason) {
		super(reason);
	}

}
