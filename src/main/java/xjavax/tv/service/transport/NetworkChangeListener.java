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
 * notification of changes to <code>Network</code> data.
 * <HR>
 *
 *
 */
public interface NetworkChangeListener extends SIChangeListener
{
    /**
     * Notifies the <code>NetworkChangeListener</code> of a
     * change to a <code>Network</code>.
     *
     * @param event - A NetworkChangeEvent describing what changed and how.
     */
    public void notifyChange( NetworkChangeEvent event);

}
