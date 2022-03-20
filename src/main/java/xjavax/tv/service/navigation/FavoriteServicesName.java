/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/
package xjavax.tv.service.navigation;

/**
 * This interface represents the name of a preference for a set of
 * favorite services. It can be used to create a collection of
 * <code>Service</code> objects based on a user preference for
 * favorite services.
 * <HR>
 *
 *
 */
public interface FavoriteServicesName
{
    /**
     * Provides a human-readable name for this favorite services preference.
     *
     * @return The name of the favorite services preference.
     */
    public java.lang.String getName();

}
