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
 * This interface extends the basic <code>ServiceNumber</code> interface to
 * provide the minor number of two-part service numbers described in
 * <em>major.minor</em> format. <p>
 * 
 * Service and ServiceDetails objects may optionally implement this
 * interface. <p>
 * 
 * The major number of a service is obtained from the
 * <code>ServiceNumber.getServiceNumber</code> method.
 * <A HREF="../../../javax/tv/service/navigation/ServiceDetails.html"><CODE>ServiceDetails</CODE></A>,
 * <A HREF="../../../javax/tv/service/ServiceNumber.html#getServiceNumber()"><CODE>ServiceNumber.getServiceNumber()</CODE></A>,
 * <a href="../../../overview-summary.html#guidelines-opinterfaces">Optionally implemented interfaces</a></DL>
 * <HR>
 * 
 * 
 */
public interface ServiceMinorNumber extends ServiceNumber
{
	/**
	 * Reports the minor number of the service.
	 * 
	 * @return The minor number of this service.
	 */
	public int getMinorNumber();

}
