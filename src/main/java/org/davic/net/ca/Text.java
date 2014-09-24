/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.net.ca;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class Text extends MMIObject {

	private String text;
	
	Text() {
		super();
	}
	
	Text(String text){
		this();
		this.text = text;
	}
  
	public String getText() {
		return text;
	}
}
