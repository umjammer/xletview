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
 * <code>ServiceIterator</code> permits iteration over an ordered
 * list of <code>Service</code> objects.  Applications may use the
 * <code>ServiceIterator</code> interface to browse a
 * <code>ServiceList</code> forward or backward.<p>
 *
 * Upon initial usage, <code>hasPrevious()</code> will return
 * <code>false</code> and <code>nextService()</code> will return the
 * first <code>Service</code> in the list, if present.
 * <HR>
 *
 *
 */
public interface ServiceIterator
{
    /**
     * Resets the iterator to the beginning of the list, such that
     * <code>hasPrevious()</code> returns <code>false</code> and
     * <code>nextService()</code> returns the first <code>Service</code>
     * in the list (if the list is not empty).</DL>
     *
     */
    public void toBeginning();

    /**
     * Sets the iterator to the end of the list, such that
     * <code>hasNext()</code> returns <code>false</code> and
     * <code>previousService()</code> returns the last <code>Service</code>
     * in the list (if the list is not empty).</DL>
     *
     */
    public void toEnd();

    /**
     * Reports the next <code>Service</code> object in the list.  This
     * method may be called repeatedly to iterate through the list.
     *
     * @return The Service object at the next position in the list.
     * @throws java.util.NoSuchElementException - If the iteration has no next Service.
     */
    public Service nextService();

    /**
     * Reports the previous <code>Service</code> object in the list.
     * This method may be called repeatedly to iterate through the list
     * in reverse order.
     *
     * @return The Service object at the previous position in the list.
     * @throws java.util.NoSuchElementException - If the iteration has no previous Service.
     */
    public Service previousService();

    /**
     * Tests if there is a <code>Service</code> in the next position in
     * the list.
     *
     * @return true if there is a Service in the next position in the list; false otherwise.
     */
    public boolean hasNext();

    /**
     * Tests if there is a <code>Service</code> in the previous
     * position in the list.
     *
     * @return true if there is a Service in the previous position in the list; false otherwise.
     */
    public boolean hasPrevious();

}
