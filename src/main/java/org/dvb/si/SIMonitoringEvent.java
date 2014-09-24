/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.si;

import java.util.Date;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class SIMonitoringEvent extends java.util.EventObject {

	private SIDatabase source;
	private byte objectType;
	private int networkId;
	private int bouquetId;
	private int originalNetworkId;
	private int transportStreamId;
	private int serviceId;
	private Date startTime;
	private Date endTime;
	
	
	public SIMonitoringEvent(SIDatabase source, byte objectType, int networkId, int bouquetId, int originalNetworkId, int transportStreamId, int serviceId, java.util.Date startTime, java.util.Date endTime) {
		super(source);
		this.objectType = objectType;
		this.networkId = networkId;
		this.bouquetId = bouquetId;
		this.originalNetworkId = originalNetworkId;
		this.transportStreamId = transportStreamId;
		this.serviceId = serviceId;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Object getSource() {
		return super.getSource();
	}

	public byte getSIInformationType() {
		return objectType;
	}

	public int getNetworkID() {
		return networkId;
	}

	public int getBouquetID() {
		return bouquetId;
	}

	public int getOriginalNetworkID() {
		return originalNetworkId;
	}

	public int getTransportStreamID() {
	    return transportStreamId;
	}

	public int getServiceID() {
	    return serviceId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
	    return endTime;
	}
}


