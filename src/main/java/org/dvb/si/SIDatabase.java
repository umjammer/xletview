/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.si;

public class SIDatabase{

	protected SIDatabase() {
	}
  
	public static SIDatabase[] getSIDatabase() {    
		return (null);
	}

	public SIRequest retrieveSIBouquets(short retrieveMode, Object appData, SIRetrievalListener listener, int bouquetId, short[] someDescriptorTags) throws SIIllegalArgumentException {
		return (null);
	}

	public SIRequest retrieveActualSINetwork(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags) throws SIIllegalArgumentException {
		return (null);
	}

	public SIRequest retrieveSINetworks(short retrieveMode, Object appData, SIRetrievalListener listener, int networkId, short[] someDescriptorTags) throws SIIllegalArgumentException {
		return (null);
	}
  
	public SIRequest retrieveActualSITransportStream(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags) throws SIIllegalArgumentException {
		return (null);
	}
  
	public SIRequest retrieveActualSIServices(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags) throws SIIllegalArgumentException {
		return (null);
	}

	public SIRequest retrieveSIServices(short retrieveMode, Object appData, SIRetrievalListener listener, int originalNetworkId, int transportStreamId, int serviceId, short[] someDescriptorTags) throws SIIllegalArgumentException {
		return (null);
	}

	public SIRequest retrieveSIService(short retrieveMode, Object appData, SIRetrievalListener listener, org.davic.net.dvb.DvbLocator dvbLocator, short[] someDescriptorTags) throws SIIllegalArgumentException {
		return (null);
	}

	public SIRequest retrievePMTServices(short retrieveMode, Object appData, SIRetrievalListener listener, int serviceId, short[] someDescriptorTags) throws SIIllegalArgumentException {
		return (null);
	}

	public SIRequest retrievePMTService(short retrieveMode, Object appData, SIRetrievalListener listener, org.davic.net.dvb.DvbLocator dvbLocator, short[] someDescriptorTags) throws SIIllegalArgumentException {
		return (null);
	}

	public SIRequest retrievePMTElementaryStreams(short retrieveMode, Object appData, SIRetrievalListener listener, int serviceId, int componentTag, short[] someDescriptorTags) throws SIIllegalArgumentException {
		return (null);
	}

	public SIRequest retrievePMTElementaryStreams(short retrieveMode, Object appData, SIRetrievalListener listener, org.davic.net.dvb.DvbLocator dvbLocator, short[] someDescriptorTags) throws SIIllegalArgumentException {
		return (null);
	}

	public SIRequest retrieveSITimeFromTDT(short retrieveMode, Object appData, SIRetrievalListener listener) throws SIIllegalArgumentException {
		return (null);
	}
  
	public SIRequest retrieveSITimeFromTOT(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags) throws SIIllegalArgumentException {
		return (null);
	}
  
	public SIRequest retrieveSITransportStreamDescription(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags) throws SIIllegalArgumentException {
		return (null);
	}

	public void addNetworkMonitoringListener(SIMonitoringListener listener, int networkId) throws SIIllegalArgumentException {
	}
  
	public void removeNetworkMonitoringListener(SIMonitoringListener listener, int networkId) throws SIIllegalArgumentException {
	}
  
	public void addBouquetMonitoringListener(SIMonitoringListener listener, int bouquetId) throws SIIllegalArgumentException {
	}
  
	public void removeBouquetMonitoringListener(SIMonitoringListener listener, int bouquetId) throws SIIllegalArgumentException {
	}
  
	public void addServiceMonitoringListener(SIMonitoringListener listener, int originalNetworkId, int transportStreamId) throws SIIllegalArgumentException {
	}
  
	public void removeServiceMonitoringListener(SIMonitoringListener listener, int originalNetworkId, int transportStreamId) throws SIIllegalArgumentException {
	}
  
	public void addPMTServiceMonitoringListener(SIMonitoringListener listener, int originalNetworkId, int transportStreamId, int serviceId)  throws SIIllegalArgumentException {
	}
  
	public void removePMTServiceMonitoringListener(SIMonitoringListener listener, int originalNetworkId, int transportStreamId, int serviceId) throws SIIllegalArgumentException {
	}

	public void addEventPresentFollowingMonitoringListener(SIMonitoringListener listener, int originalNetworkId, int transportStreamId, int serviceId) throws SIIllegalArgumentException {
	}
  
	public void removeEventPresentFollowingMonitoringListener(SIMonitoringListener listener, int originalNetworkId, int transportStreamId, int serviceId) throws SIIllegalArgumentException {
	}
  
	public void addEventScheduleMonitoringListener(SIMonitoringListener listener, int originalNetworkId, int transportStreamId, int serviceId, java.util.Date startTime, java.util.Date endTime) throws SIIllegalArgumentException, SIInvalidPeriodException {
	}
  
	public void removeEventScheduleMonitoringListener(SIMonitoringListener listener, int originalNetworkId, int transportStreamId, int serviceId) throws SIIllegalArgumentException {
	}
  
}
