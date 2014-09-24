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
public class DSMCCException  extends java.io.IOException {

	public DSMCCException(){
		super();
    }
   
	public DSMCCException(String s){
        super(s);
    }
}
