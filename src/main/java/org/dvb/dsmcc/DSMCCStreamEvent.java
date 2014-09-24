/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.dsmcc;

import java.io.IOException;

public class DSMCCStreamEvent extends DSMCCStream {

	public DSMCCStreamEvent(DSMCCObject aDSMCCObject) throws NotLoadedException, IllegalObjectTypeException	{ 
		super (aDSMCCObject);
	}

	public DSMCCStreamEvent(String path) throws IOException, IllegalObjectTypeException	{
		super(path);
	}
	
	public DSMCCStreamEvent(String path, String name) throws IOException, IllegalObjectTypeException {super(path, name);
	}  
  
	public synchronized int subscribe(String eventName, StreamEventListener l) throws UnknownEventException, InsufficientResourcesException	{
		return 0;
	}
  
	public synchronized void unsubscribe(int eventId, StreamEventListener l) throws UnknownEventException{
	}
  
	public synchronized void unsubscribe(String eventName, StreamEventListener l) throws UnknownEventException{
	}
  
  
	public String [] getEventList()	{ 
		return null;
	}

}

