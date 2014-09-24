/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.mpeg;

public abstract class ElementaryStream{
	
	protected ElementaryStream()	{
	}

	public Service getService()	{
		return null;
	}
	
	public int getPID()	{
		return 0;
	}

	public Integer getAssociationTag(){
		return null;
	}

}
