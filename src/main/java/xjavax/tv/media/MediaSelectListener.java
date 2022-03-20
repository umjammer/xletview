/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.media;

/**
 * The <code>MediaSelectListener</code> interface is implemented by
 * applications in order to receive notification of selection
 * operations on a <code>MediaSelectControl</code>.
 * <HR>
 *
 *
 */
public interface MediaSelectListener extends java.util.EventListener{
    /**
     * Notifies the <code>MediaSelectListener</code> that a selection
     * has completed.
     *
     * @param event - MediaSelectEvent describing the completion of a selection operation.
     */
    public void selectionComplete( MediaSelectEvent event);

}
