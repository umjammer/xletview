/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
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
public class ObjectChangeEvent extends java.util.EventObject {

	private int versionNumber;

	public ObjectChangeEvent(DSMCCObject source, int versionNumber){
		super(source);
		this.versionNumber = versionNumber;
	}
  
	public int getNewVersionNumber(){
		return versionNumber;
	}

	public Object getSource() {
		return super.getSource();
	}  
 }
