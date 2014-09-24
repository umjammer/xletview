/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.mpeg.dvb;

public class DvbTransportStream extends org.davic.mpeg.TransportStream {

	protected DvbTransportStream(){
	}

	public int getOriginalNetworkId(){
		return 0;
	}

	public int getNetworkId(){
		return 0;
	}
}

