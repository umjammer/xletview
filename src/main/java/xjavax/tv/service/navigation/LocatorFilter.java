/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.navigation;

import xjavax.tv.locator.InvalidLocatorException;
import xjavax.tv.locator.Locator;
import xjavax.tv.service.Service;

/**
 * <code>LocatorFilter</code> represents a <code>ServiceFilter</code>
 * based on a set of locators.  A <code>ServiceList</code> resulting
 * from this filter will include only services matching the specified
 * locators.
 * <A HREF="../../../../javax/tv/service/navigation/ServiceList.html"><CODE>ServiceList</CODE></A></DL>
 * <HR>
 *
 *
 */
public final class LocatorFilter extends ServiceFilter
{
    //following variables are implicitely defined by getter- or setter-methods:
    private Locator[] filterValue;

    /**
     * Constructs the filter based on a set of locators.
     *
     * @param locators - An array of locators representing services to be included in a resulting ServiceList.
     * @throws InvalidLocatorException - If one of the given locators does not reference a valid Service.
     */
    public LocatorFilter( Locator[] locators) throws InvalidLocatorException
    {
        //TODO implement LocatorFilter
    }

    /**
     * Reports the locators used to create this filter.
     *
     * @return The array of locators used to create this filter.
     */
    public Locator[] getFilterValue()
    {
        return this.filterValue;
    }

    /**
     * Tests if the given service passes the filter.
     *
     * @param service - An individual Service to be evaluated against the filtering algorithm.
     * @return true if service belongs to the set of locators indicated by the filter value; false otherwise.
     * @see accept in class ServiceFilter
     */
    public boolean accept( Service service)
    {
        return false;
        //TODO implement accept
    }

}
