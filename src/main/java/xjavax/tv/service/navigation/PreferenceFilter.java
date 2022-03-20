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

/**
 * <code>PreferenceFilter</code> represents a
 * <code>ServiceFilter</code> based on a user preference for favorite
 * services. A <code>ServiceList</code> resulting from this filter
 * will include only user favorite services contained in the specified
 * preference.
 * <A HREF="../../../../javax/tv/service/navigation/ServiceList.html"><CODE>ServiceList</CODE></A></DL>
 * <HR>
 *
 *
 */
public final class PreferenceFilter extends ServiceFilter
{
    //following variables are implicitely defined by getter- or setter-methods:
    private FavoriteServicesName filterValue;

    /**
     * Constructs the filter based on a particular user preference
     * for favorite services.
     *
     * @param preference - A named user preference, obtained from the listPreferences() method, representing favorite Services to be included in a resulting service list.
     * @throws java.lang.IllegalArgumentException - If the specified preference is not obtainable from the listPreferences() method.
     * @see listPreferences()
     */
    public PreferenceFilter( FavoriteServicesName preference)
    {
        //TODO implement PreferenceFilter
    }

    /**
     * Reports the available favorite service preferences that
     * can be used to create this filter.
     *
     * @return An array of preferences for favorite services.  If none exist or are supported, an empty array is returned.
     */
    public static FavoriteServicesName[] listPreferences()
    {
        return null;
        //TODO implement listPreferences
    }

    /**
     * Reports the user preference used to create this filter.
     *
     * @return The user preference representing the favorite services by which the filter was constructed.
     */
    public FavoriteServicesName getFilterValue()
    {
        return this.filterValue;
    }

    /**
     * Tests if the given service passes the filter.
     *
     * @param service - An individual Service to be evaluated against the filtering algorithm.
     * @return true if service is part of the favorite services indicated by the filter value; false otherwise.
     * @see accept in class ServiceFilter
     */
    public boolean accept( Service service)
    {
        return false;
        //TODO implement accept
    }

}
