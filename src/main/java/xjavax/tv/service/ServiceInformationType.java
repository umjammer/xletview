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
 * This class represents values of service information (SI) formats.
 *
 * This class represents values of service information (SI) formats.
 * <HR>
 *
 *
 */
public class ServiceInformationType extends java.lang.Object
{
    /**
     * ATSC PSIP format.</DL>
     *
     */
    public static final ServiceInformationType ATSC_PSIP = null;

    /**
     * DVB SI format.</DL>
     *
     */
    public static final ServiceInformationType DVB_SI = null;

    /**
     * SCTE SI format.</DL>
     *
     */
    public static final ServiceInformationType SCTE_SI = null;

    /**
     * Unknown format.</DL>
     *
     *
     */
    public static final ServiceInformationType UNKNOWN = null;

    /**
     * Creates a service information type object.
     *
     * @param name - The string name of this type (e.g., "ATSC_PSIP").
     */
    protected ServiceInformationType(java.lang.String name)
    {
        //TODO implement ServiceInformationType
    }

    /**
     * Provides the string name of the SI type.  For the type objects
     * defined in this class, the string name will be identical to the
     * class variable name.
     *
     * @return The string name of the SI type.
     * @see toString in class java.lang.Object
     */
    public java.lang.String toString()
    {
        return null;
        //TODO implement toString
    }

}
