/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.media;

import xjavax.tv.locator.Locator;

/**
 * A <code>MediaSelectSucceededEvent</code> notifies a
 * <code>MediaSelectListener</code> that a selection operation
 * succeeded.
 * <HR>
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class MediaSelectSucceededEvent extends MediaSelectEvent{
    /**
     * Creates a new <code>MediaSelectSucceededEvent</code>.
     *
     * @param source - The Controller that generated this event.
     * @param selection - The Locator instances on which selection occurred.
     */
    public MediaSelectSucceededEvent(javax.media.Controller source, Locator[] selection){
        super(source, selection);
    }

}
