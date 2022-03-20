/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.navigation;

import xjavax.tv.service.Service;
import xjavax.tv.service.ServiceType;

/**
 * <code>ServiceTypeFilter</code> represents a
 * <code>ServiceFilter</code> based on a particular
 * <code>ServiceType</code>.  A <code>ServiceList</code> resulting
 * from this filter will include only <code>Service</code> objects of
 * the specified service type.
 * <A HREF="../../../../javax/tv/service/navigation/ServiceList.html"><CODE>ServiceList</CODE></A></DL>
 * <HR>
 *
 *
 */
public final class ServiceTypeFilter extends ServiceFilter
{
    //following variables are implicitely defined by getter- or setter-methods:
    private ServiceType filterValue;

    /**
     * Constructs the filter based on a particular <code>ServiceType</code>.
     *
     * @param type - A ServiceType object indicating the type of services to be included in a resulting service list.
     */
    public ServiceTypeFilter( ServiceType type)
    {
        //TODO implement ServiceTypeFilter
    }

    /**
     * Reports the <code>ServiceType</code> used to create this filter.
     *
     * @return The ServiceType used to create this filter.
     */
    public ServiceType getFilterValue()
    {
        return this.filterValue;
    }

    /**
     * Tests if the given service passes the filter.
     *
     * @param service - An individual Service to be evaluated against the filtering algorithm.
     * @return true if service is of the type indicated by the filter value; false otherwise.
     * @see accept in class ServiceFilter
     */
    public boolean accept( Service service)
    {
        return false;
        //TODO implement accept
    }

}
