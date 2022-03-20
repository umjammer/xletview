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
 * This class represents permission to read the data referenced by a given
 * <code>Locator</code>.
 * <HR>
 *
 *
 */
public final class ReadPermission extends java.security.Permission implements java.io.Serializable
{
    //following variables are implicitely defined by getter- or setter-methods:
    private java.lang.String actions;

    /**
     * Creates a new ReadPermission object for the specified locator.
     *
     * @param locator - The locator.  Null indicates permission for all locators.
     */
    public ReadPermission( Locator locator)
    {
        //TODO implement ReadPermission
        super(null);
    }

    /**
     * Creates a new <code>ReadPermission</code> object for a locator
     * with the given external form.  The <code>actions</code> string
     * is currently unused and should be <code>null</code>.  This
     * constructor exists for use by the <code>Policy</code> object to
     * instantiate new <code>Permission</code> objects.
     *
     * @param locator - The external form of the locator.  The string "*" indicates all locators.
     * @param actions - Should be null.
     */
    public ReadPermission(java.lang.String locator, java.lang.String actions)
    {
        //TODO implement ReadPermission
        super(null);
    }

    /**
     * Checks if this ReadPermission object "implies" the specified
     * permission. <p>
     *
     * More specifically, this method returns true if: <p>
     * <ul>
     * <li><i>p</i> is an instance of ReadPermission, and
     * <li><i>p</i>'s locator's external form matches this object's locator
     * string, or this object's locator string is "*".
     * </ul>
     *
     * @param p - The permission to check against.
     * @return true if the specified permission is implied by this object, false if not.
     * @see implies in class java.security.Permission
     */
    public boolean implies(java.security.Permission p)
    {
        return false;
        //TODO implement implies
    }

    /**
     * Checks two ReadPermission objects for equality.  Checks that
     * <i>other</i> is a ReadPermission, and has the same locator
     * as this object.
     *
     * @param other - the object we are testing for equality with this object.
     * @return true if other is of type ReadPermission and has the same locator as this ReadPermission object.
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
     * Returns the canonical string representation of the actions,
     * which currently is the empty string "", since there are no actions for
     * a ReadPermission.
     *
     * @return the empty string "".
     * @see getActions in class java.security.Permission
     */
    public java.lang.String getActions()
    {
        return this.actions;
    }

}
