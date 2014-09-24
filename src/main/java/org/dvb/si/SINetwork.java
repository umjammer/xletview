/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.si;

public interface SINetwork extends SIInformation {

	public SIRequest retrieveDescriptors(short retrieveMode, Object appData, SIRetrievalListener listener) throws SIIllegalArgumentException;

	public SIRequest retrieveDescriptors(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags) throws SIIllegalArgumentException;
    
    public short[] getDescriptorTags();
    
    public int getNetworkID();
    
    public java.lang.String getName();
    
    public String getShortNetworkName();
    
    public SIRequest retrieveSITransportStreams(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags) throws SIIllegalArgumentException;

}









