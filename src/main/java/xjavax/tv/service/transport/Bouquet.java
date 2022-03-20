/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.transport;

import xjavax.tv.service.SIElement;

/**
 * This interface represents information about a bouquet.
 *
 * This interface represents information about a bouquet.<p>
 *
 * A <code>Bouquet</code> object may optionally implement the
 * <code>CAIdentification</code> interface. Note that bouquets are not
 * supported in ATSC.
 * <a href="../../../../overview-summary.html#guidelines-opinterfaces">Optionally implemented interfaces</a></DL>
 * <HR>
 *
 *
 */
public interface Bouquet extends SIElement
{
    /**
     * Reports the ID of this bouquet definition.
     *
     * @return A number identifying this bouquet
     */
    public int getBouquetID();

    /**
     * Reports the name of this bouquet.
     *
     * @return A string representing the name of this bouquet, or an empty string if the name is not available.
     */
    public java.lang.String getName();

}
