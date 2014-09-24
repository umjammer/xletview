/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service;

/**
 * This class represents service type values such as "digital television",
 * "digital radio", "NVOD reference service", "NVOD time-shifted service",
 * "analog television", "analog radio", "data broadcast" and "application".
 * These basic service types can be extended by subclassing.<p>
 * 
 * (These values are mappable to the ATSC service type in the VCT table and
 * the DVB service type in the Service Descriptor.)
 * <HR>
 * 
 * 
 */
public class ServiceType extends java.lang.Object
{
	/**
	 * Digital TV service type.</DL>
	 * 
	 */
	public static final ServiceType DIGITAL_TV = null;

	/**
	 * Digital radio service type.</DL>
	 * 
	 */
	public static final ServiceType DIGITAL_RADIO = null;

	/**
	 * NVOD reference service type.</DL>
	 * 
	 */
	public static final ServiceType NVOD_REFERENCE = null;

	/**
	 * NVOD time-shifted service type.</DL>
	 * 
	 */
	public static final ServiceType NVOD_TIME_SHIFTED = null;

	/**
	 * Analog TV service type.</DL>
	 * 
	 */
	public static final ServiceType ANALOG_TV = null;

	/**
	 * Analog radio service type.</DL>
	 * 
	 */
	public static final ServiceType ANALOG_RADIO = null;

	/**
	 * Data broadcast service type identifying a data service.</DL>
	 * 
	 */
	public static final ServiceType DATA_BROADCAST = null;

	/**
	 * Data application service type identifying an interactive application.</DL>
	 * 
	 */
	public static final ServiceType DATA_APPLICATION = null;

	/**
	 * Unknown service type.</DL>
	 * 
	 * 
	 */
	public static final ServiceType UNKNOWN = null;

	/**
	 * Creates a service type object.
	 * 
	 * @param name - The string name of this type (e.g., "DIGITAL_TV").
	 */
	protected ServiceType(java.lang.String name)
	{
		//TODO implement ServiceType
	}

	/**
	 * Provides the string name of the type.  For the type objects
	 * defined in this class, the string name will be identical to the
	 * class variable name.
	 * 
	 * @return The string name of the type.
	 * @see toString in class java.lang.Object
	 */
	public java.lang.String toString()
	{
		return null;
		//TODO implement toString
	}

}
