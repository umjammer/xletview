/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.mpeg.sections;


/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class InvalidSourceException	extends SectionFilterException{
 
	public InvalidSourceException()	{
		super();
	}
 
	public InvalidSourceException(String detail){
		super(detail);
	}
}
