/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.si;

public interface SIInformation{


	public static final short FROM_CACHE_ONLY = 0;
   
	public static final short FROM_CACHE_OR_STREAM = 1;

	public static final short FROM_STREAM_ONLY = 2;

	public SIRequest retrieveDescriptors(short retrieveMode, Object appData, SIRetrievalListener listener) throws SIIllegalArgumentException;

	public SIRequest retrieveDescriptors(short retrieveMode, Object appData, SIRetrievalListener listener, short[] someDescriptorTags) throws SIIllegalArgumentException;

	public short[] getDescriptorTags();

	public SIDatabase getSIDatabase();

	public java.util.Date getUpdateTime();
  
	public boolean fromActual();

	public org.davic.mpeg.TransportStream getDataSource();

}


