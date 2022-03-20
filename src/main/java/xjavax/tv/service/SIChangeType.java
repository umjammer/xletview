/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service;

/**
 * This class represents types of changes to SI elements.
 *
 * This class represents types of changes to SI elements.
 * <A HREF="../../../javax/tv/service/SIElement.html"><CODE>SIElement</CODE></A></DL>
 * <HR>
 *
 *
 */
public class SIChangeType extends java.lang.Object
{
    /**
     * <code>SIChangeType</code> indicating that an <code>SIElement</code>
     * has been added.</DL>
     *
     */
    public static final SIChangeType ADD = null;

    /**
     * <code>SIChangeType</code> indicating that an <code>SIElement</code>
     * has been removed.</DL>
     *
     */
    public static final SIChangeType REMOVE = null;

    /**
     * <code>SIChangeType</code> indicating that an <code>SIElement</code>
     * has been modified.</DL>
     *
     *
     */
    public static final SIChangeType MODIFY = null;

    /**
     * Creates an <code>SIChangeType</code> object.
     *
     * @param name - The string name of this type (e.g. "ADD").
     */
    protected SIChangeType(java.lang.String name)
    {
        //TODO implement SIChangeType
    }

    /**
     * Provides the string name of the type.  For the type objects
     * defined in this class, the string name will be identical to the
     * class variable name.
     *
     * @return The string name of the type.
     * @see toString in class java.lang.Object
     */
    public java.lang.String toString()
    {
        return null;
        //TODO implement toString
    }

}
