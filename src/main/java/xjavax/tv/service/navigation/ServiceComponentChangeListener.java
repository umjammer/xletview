/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.navigation;

import xjavax.tv.service.SIChangeListener;

/**
 * This interface is implemented by applications wishing to receive
 * notification of changes to <code>ServiceComponent</code> data.
 * <HR>
 *
 *
 */
public interface ServiceComponentChangeListener extends SIChangeListener
{
    /**
     * Notifies the <code>ServiceComponentChangeListener</code> of a
     * change to a <code>ServiceComponent</code>.
     *
     * @param event - A ServiceComponentChangeEvent describing what changed and how.
     */
    public void notifyChange( ServiceComponentChangeEvent event);

}
