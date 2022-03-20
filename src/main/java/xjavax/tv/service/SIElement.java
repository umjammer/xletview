/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service;

import xjavax.tv.locator.Locator;

/**
 * The base interface of elements provided by the SI database.
 *
 * The base interface of elements provided by the SI database.
 * <code>SIElement</code> objects represent immutable <em>copies</em>
 * of the service information data contained in the SI database.  If
 * the information represented by an <code>SIElement</code> <em>E</em>
 * changes in the database, <em>E</em> will not be changed.  The value
 * of the <code>SIElement</code>'s locator (obtained by the
 * <code>getLocator()</code> method) will remain unchanged in this
 * case; the locator may be used to retrieve a copy of the SI element
 * with the new data.  Two <code>SIElement</code> objects retrieved
 * from the SI database using the same input <code>Locator</code> at
 * different times will report <code>Locator</code> objects that are
 * equal according to <code>Locator.equal()</code>.  However, the
 * <code>SIElement</code> objects themselves will not be
 * <code>equal()</code> if the corresponding data changed in the SI
 * database between the times of their respective retrievals.
 * <A HREF="../../../javax/tv/service/SIManager.html#retrieveSIElement(javax.tv.locator.Locator, javax.tv.service.SIRequestor)"><CODE>SIManager.retrieveSIElement(javax.tv.locator.Locator, javax.tv.service.SIRequestor)</CODE></A></DL>
 * <HR>
 *
 *
 */
public interface SIElement extends SIRetrievable
{
    /**
     * Reports the <code>Locator</code> of this <code>SIElement</code>.
     *
     * @return Locator The locator referencing this SIElement
     */
    public Locator getLocator();

    /**
     * Tests two <code>SIElement</code> objects for equality.  Returns
     * <code>true</code> if and only if:
     * <ul>
     * <li><code>obj</code>'s class is the
     * same as the class of this <code>SIElement</code>, and<p>
     * <li><code>obj</code>'s <code>Locator</code> is equal to
     * the <code>Locator</code> of this object (as reported by
     * <code>SIElement.getLocator()</code>, and<p>
     * <li><code>obj</code> and this object encapsulate identical data.
     * </ul>
     *
     * @param obj - The object against which to test for equality.
     * @return true if the two SIElement objects are equal; false otherwise.
     * @see equals in class java.lang.Object
     */
    public boolean equals(java.lang.Object obj);

    /**
     * Reports the hash code value of this <code>SIElement</code>.  Two
     * <code>SIElement</code> objects that are equal will have identical
     * hash codes.
     *
     * @return The hash code value of this SIElement.
     * @see hashCode in class java.lang.Object
     */
    public int hashCode();

    /**
     * Reports the SI format in which this <code>SIElement</code> was
     * delivered.
     *
     * @return The SI format in which this SI element was delivered.
     */
    public ServiceInformationType getServiceInformationType();

}
