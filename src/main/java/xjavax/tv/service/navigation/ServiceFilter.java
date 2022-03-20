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
 * This class represents a set filtering criteria used to generate a
 * <code>ServiceList</code>.  <code>ServiceFilter</code> is extended
 * to create concrete filters based on various criteria.  Applications
 * may also extend this class to define custom filters, although
 * custom filters may not be supported on certain filtering
 * operations.
 * <HR>
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public abstract class ServiceFilter extends java.lang.Object{
    /**
     * Constructs the filter.</DL>
     *
     *
     */
    protected ServiceFilter(){
        //TODO implement ServiceFilter
    }

    /**
     * Tests if a particular service passes this filter.
     * Subtypes of <code>ServiceFilter</code> override this method to
     * provide the logic for a filtering operation on individual
     * <code>Service</code> objects.
     *
     * @param service - A Service to be evaluated against the filtering algorithm.
     * @return true if service satisfies the filtering algorithm; false otherwise.
     */
    public abstract boolean accept( Service service);

}
