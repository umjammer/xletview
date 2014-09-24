/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.si;

public interface SIRetrievalListener extends java.util.EventListener {

	public void postRetrievalEvent(SIRetrievalEvent event);

}
