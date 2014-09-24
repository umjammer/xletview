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
 * @statuscode 2
 * @comment check hasMultipleTransformations()
 */
public abstract class Locator implements xjavax.tv.locator.Locator {

	private String url;
	
	private Locator() {
	}

	public Locator(String url) {
		this.url = url;
	}

	public String toString() {
	    return "org.davic.net.Locator, url=" + url;
	}

	public boolean hasMultipleTransformations() {
		return false;
	}

	public String toExternalForm() {
		return url;
	}

}

