/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.media;

import xjavax.tv.locator.Locator;

/**
 * This class represents permission to select, via a
 * <code>MediaSelectControl</code>, the content that a JMF Player
 * presents.  A caller might have permission to select content
 * referenced by some locators, but not others.
 * <HR>
 * 
 * 
 */
public final class MediaSelectPermission extends java.security.Permission implements java.io.Serializable
{
	//following variables are implicitely defined by getter- or setter-methods:
	private java.lang.String actions;

	/**
	 * Creates a new <code>MediaSelectPermission</code> object for the
	 * specified <code>Locator</code>.
	 * 
	 * @param locator - The locator for which to create the permission. A value of null indicates permission for all locators.
	 */
	public MediaSelectPermission( Locator locator)
	{
		//TODO implement MediaSelectPermission
		super(null);
	}

	/**
	 * Creates a new <code>MediaSelectPermission</code> object for a
	 * <code>Locator</code> with the given external form.  The actions
	 * string is currently unused and should be <code>null</code>.
	 * This constructor is used by the <code>Policy</code> class to
	 * instantiate new <code>Permission</code> objects.
	 * 
	 * @param locator - The external form of the locator.  The string "*" indicates all locators.
	 * @param actions - Should be null.
	 */
	public MediaSelectPermission(java.lang.String locator, java.lang.String actions)
	{
		//TODO implement MediaSelectPermission
		super(null);
	}

	/**
	 * Checks if this <code>MediaSelectPermission</code> "implies" the
	 * specified <code>Permission</code>. <p>
	 * 
	 * More specifically, this method returns true if: <p>
	 * <ul>
	 * <li><i>p</i> is an instance of MediaSelectPermission, and
	 * <li><i>p</i>'s locator's external form matches this object's locator
	 * string, or this object's locator string is "*".
	 * </ul>
	 * 
	 * @param p - The Permission to check against.
	 * @return true if the specified Permission is implied by this object; false otherwise.
	 * @see implies in class java.security.Permission
	 */
	public boolean implies(java.security.Permission p)
	{
		return false;
		//TODO implement implies
	}

	/**
	 * Tests two MediaSelectPermission objects for equality.  This
	 * method tests that <code>other</code> is of type
	 * <code>MediaSelectPermission</code>, and has the same
	 * <code>Locator</code> as this object.
	 * 
	 * @param other - The object to test for equality.
	 * @return true if other is a MediaSelectPermission, and has the same Locator as this MediaSelectPermission.
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
	 * @return The hash code value for this object.
	 * @see hashCode in class java.security.Permission
	 */
	public int hashCode()
	{
		return 0;
		//TODO implement hashCode
	}

	/**
	 * Reports the canonical string representation of the actions.
	 * This is currently the empty string "", since there are no
	 * actions for a <code>MediaSelectPermission</code>.
	 * 
	 * @return The empty string "".
	 * @see getActions in class java.security.Permission
	 */
	public java.lang.String getActions()
	{
		return this.actions;
	}

}
