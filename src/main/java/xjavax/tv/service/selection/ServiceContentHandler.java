/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.selection;

import xjavax.tv.locator.Locator;

/**
 * A <code>ServiceContentHandler</code> represents a mechanism for
 * presenting, processing or playing portions of a service.  A single
 * <code>ServiceContentHandler</code> may handle one or more
 * constituent parts of a service, as represented by one or more
 * locators to those parts.  Each locator reported by a
 * <code>ServiceContentHandler</code> refers either to an individual
 * service component or to content within a service component (such as
 * an Xlet).
 * <HR>
 *
 *
 */
public interface ServiceContentHandler
{
    /**
     * Reports the portions of the service on which this handler operates.
     *
     * @return An array of locators representing the portions of the service on which this handler operates.
     * @see ServiceContext.select(Locator[] components)
     */
    public Locator[] getServiceContentLocators();

}
