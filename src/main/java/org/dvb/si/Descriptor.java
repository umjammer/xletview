/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.si;

public class Descriptor{

  	Descriptor() {}

	public short getTag() {  
		return ((short) 0);
	}

	public short getContentLength() {    
		return ((short) 0);
	}

	public byte getByteAt(int index) throws java.lang.IndexOutOfBoundsException {
		return ((byte) 0);
	}

	public byte[] getContent() {    
		return (null);
	}

}
