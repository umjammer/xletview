/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.mpeg;

public class Service{
	
	protected Service()	{
	}

	public TransportStream getTransportStream()	{
		return null;
	}

	public int getServiceId(){
		return 0;
	}

	public ElementaryStream retrieveElementaryStream(int pid){
		return null;
	}

	public ElementaryStream[] retrieveElementaryStreams(){
		return null;
	}

}

