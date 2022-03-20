/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.transport;

import xjavax.tv.service.SIChangeListener;

/**
 * This interface is implemented by applications wishing to receive
 * notification of changes to <code>Bouquet</code> data.
 * <HR>
 *
 *
 */
public interface BouquetChangeListener extends SIChangeListener
{
    /**
     * Notifies the <code>BouquetChangeListener</code> of a
     * change to a <code>Bouquet</code>.
     *
     * @param event - A BouquetChangeEvent describing what changed and how.
     */
    public void notifyChange( BouquetChangeEvent event);

}
