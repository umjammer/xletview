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
 * <code>SelectPermission</code> represents permission to perform a
 * <code>select()</code> operation on a <code>ServiceContext</code>.
 * A caller might have permission to select some content but not
 * others.
 *
 * <p>
 * <a name="actions"></a>
 * The <code>actions</code> string is either "own" or "*".  The
 * string "own" means the permission applies to your own service
 * context, acquired via
 * <code>ServiceContextFactory.createServiceContext()</code> or
 * <code>ServiceContextFactory.getServiceContext(javax.tv.xlet.XletContext)</code>.
 * The string "*" implies permission to these, plus permission for service
 * contexts obtained from all other sources.<p>
 *
 * Note that undefined actions strings may be provided to the
 * constructors of this class, but subsequent calls to
 * <code>SecurityManager.checkPermission()</code> with the resulting
 * <code>SelectPermission</code> object will fail.
 * <HR>
 *
 *
 */
public final class SelectPermission extends java.security.Permission implements java.io.Serializable
{
    //following variables are implicitely defined by getter- or setter-methods:
    private java.lang.String actions;

    /**
     * Creates a new SelectPermission object for the specified locator.
     *
     * @param locator - The locator.  A value of null indicates permission for all locators.
     * @param actions - The actions string, as detailed in the class description.
     */
    public SelectPermission( Locator locator, java.lang.String actions)
    {
        //TODO implement SelectPermission
        super(null);
    }

    /**
     * Creates a new SelectPermission object for a locator with the
     * given external form.  This constructor exists for use by the
     * <code>Policy</code> object to instantiate new Permission objects.
     *
     * @param locator - The external form of the locator.  The string "*" indicates all locators.
     * @param actions - The actions string, as detailed in the class description.
     */
    public SelectPermission(java.lang.String locator, java.lang.String actions)
    {
        //TODO implement SelectPermission
        super(null);
    }

    /**
     * Checks if this SelectPermission object "implies" the specified
     * permission.  More specifically, this method returns true if:
     * <ul>
     * <li><i>p</i> is an instance of SelectPermission, and
     * <li><i>p</i>'s action string matches this object's, or this object has
     * "*" as an action string, and
     * <li><i>p</i>'s locator's external form matches this object's locator
     * string, or this object's locator string is "*".
     * </ul>
     *
     * @param p - The permission against which to check.
     * @return true if the specified permission is implied by this object, false if not.
     * @see implies in class java.security.Permission
     */
    public boolean implies(java.security.Permission p)
    {
        return false;
        //TODO implement implies
    }

    /**
     * Checks two SelectPermission objects for equality.  Tests that
     * the given object is a <code>SelectPermission</code> and has the
     * same <code>Locator</code> and actions string as this
     * object.
     *
     * @param other - The object to test for equality.
     * @return true if other is a SelectPermission and has the same locator and actions string as this SelectPermission object; false otherwise.
     * @see equals in class java.security.Permission
     */
    public boolean equals(java.lang.Object other)
    {
        return false;
        //TODO implement equals
    }

    /**
     * Returns the hash code value for this object.
     *
     * @return A hash code value for this object.
     * @see hashCode in class java.security.Permission
     */
    public int hashCode()
    {
        return 0;
        //TODO implement hashCode
    }

    /**
     * Returns the canonical string representation of the actions.
     *
     * @return The canonical string representation of the actions.
     * @see getActions in class java.security.Permission
     */
    public java.lang.String getActions()
    {
        return this.actions;
    }

}
