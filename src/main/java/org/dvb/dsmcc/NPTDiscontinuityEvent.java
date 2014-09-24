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
public class NPTDiscontinuityEvent extends NPTStatusEvent {

	private long before;
	private long after;
	
	public NPTDiscontinuityEvent( DSMCCStream source, long before, long after )	{
		super(source);
		this.before = before;
		this.after = after;
	}

	public long getLastNPT(){ 
		return after;
	}

	public long getFirstNPT() { 
		return before;
	}

}
