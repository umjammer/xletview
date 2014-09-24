/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Sved�n
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.dsmcc;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class NothingToAbortException extends DSMCCException {
   
	public NothingToAbortException(){
		super();
	}
   
	public NothingToAbortException(String s){
		super(s);
	}  
}



