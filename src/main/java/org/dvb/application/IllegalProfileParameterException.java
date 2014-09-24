/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.application ;

/**
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class IllegalProfileParameterException extends Exception {
	
	public IllegalProfileParameterException(){
	    super();
	}

	public IllegalProfileParameterException(String s){
	    super(s);
	}
}
