/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.net.tuning;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class NetworkInterfaceTuningOverEvent extends NetworkInterfaceEvent {

	public final static int SUCCEEDED = 0;
	public final static int FAILED = 1;
	
	private int status;
  
	public NetworkInterfaceTuningOverEvent(Object networkInterface, int status){
		super(networkInterface);
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

}



