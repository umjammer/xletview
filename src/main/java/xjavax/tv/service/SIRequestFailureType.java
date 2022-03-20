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
 * This class represents reason codes for failure of asynchronous SI
 * retrieval requests.  It is subclassed to provide the individual
 * reason codes.
 * <A HREF="../../../javax/tv/service/SIRequest.html"><CODE>SIRequest</CODE></A></DL>
 * <HR>
 *
 *
 */
public class SIRequestFailureType extends java.lang.Object
{
    /**
     * The reason generated when the <code>SIRequest</code> is canceled.
     * <DT><B>See Also: </B>
     *
     */
    public static final SIRequestFailureType CANCELED = null;

    /**
     * The reason generated when the resources required to fulfill an
     * asynchronous SI retrieval (such as a tuner, section filter, etc.)
     * are unavailable. The application may attempt to release some
     * resources and attempt the request again.</DL>
     *
     */
    public static final SIRequestFailureType INSUFFICIENT_RESOURCES = null;

    /**
     * The reason generated when the system cannot find the
     * requested data. This occurs when the
     * requested data is not present in the transport stream, when the
     * data is present on some transport/network but the SI database
     * does not know about it, or when the type of requested data is
     * not supported by the broadcast environment.</DL>
     *
     */
    public static final SIRequestFailureType DATA_UNAVAILABLE = null;

    /**
     * The reason for the failure is unknown.</DL>
     *
     *
     */
    public static final SIRequestFailureType UNKNOWN = null;

    /**
     * Creates an <code>SIRequestFailureType</code> object.
     *
     * @param name - The string name of this type (e.g., "CANCELED").
     */
    protected SIRequestFailureType(java.lang.String name)
    {
        //TODO implement SIRequestFailureType
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
