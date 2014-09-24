/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.user ;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class Facility {
	
	private String preference;
	private String[] values;
	
	public Facility (String preference, String value) {
		this.preference = preference;
		values = new String[1];
		values[0] = value;
	}
   
	public Facility (String preference, String values[]) {
		this.preference = preference;
		this.values = values;
	}
	
	protected String getPreference(){
		return preference;
	}
	
	protected String[] getValues(){
		return values;
	}
}
