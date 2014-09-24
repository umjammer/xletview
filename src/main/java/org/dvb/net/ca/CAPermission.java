/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.net.ca;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 2
 */
public class CAPermission extends java.security.BasicPermission{
	
	public CAPermission(String name){
		super(name);
	}

	public CAPermission(String name, String actions){
		super(name,actions);
	}
	
	public boolean implies (java.security.Permission p) {
		return false;
	}

}
