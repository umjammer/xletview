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
 * This interface is implemented by objects that are retrieved from SI
 * data in the broadcast.
 * <HR>
 *
 *
 */
public interface SIRetrievable
{
    /**
     * Returns the time when this object was last updated from data in
     * the broadcast.
     *
     * @return The date of the last update in UTC format, or null if unknown.
     */
    public java.util.Date getUpdateTime();

}
