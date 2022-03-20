/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service;

/**
 * This interface is used to identify services by service (or channel)
 * numbers. The service number may represent a receiver-specific service
 * designation or a broadcaster-specific service designation delivered as a
 * private descriptor. <p>
 *
 * Service and ServiceDetails objects may optionally implement this
 * interface. <code>ServiceNumber</code> is extended by
 * <code>ServiceMinorNumber</code> to report two-part ATSC channel numbers.
 * <A HREF="../../../javax/tv/service/navigation/ServiceDetails.html"><CODE>ServiceDetails</CODE></A>,
 * <A HREF="../../../javax/tv/service/ServiceMinorNumber.html"><CODE>ServiceMinorNumber</CODE></A>,
 * <a href="../../../overview-summary.html#guidelines-opinterfaces">Optionally implemented interfaces</a></DL>
 * <HR>
 *
 *
 */
public interface ServiceNumber
{
    /**
     * Reports the service number of a service.
     *
     * @return The number of the service.
     */
    public int getServiceNumber();

}
