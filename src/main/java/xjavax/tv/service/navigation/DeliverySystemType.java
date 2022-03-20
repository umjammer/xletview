/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/
package xjavax.tv.service.navigation;

/**
 * This class represents values of various types of delivery systems,
 * for example, satellite, cable, etc.
 * <HR>
 *
 *
 */
public class DeliverySystemType extends java.lang.Object
{
    /**
     * Satellite delivery system type.</DL>
     *
     */
    public static final DeliverySystemType SATELLITE = null;

    /**
     * Cable delivery system type.</DL>
     *
     */
    public static final DeliverySystemType CABLE = null;

    /**
     * Terrestrial delivery system type.</DL>
     *
     */
    public static final DeliverySystemType TERRESTRIAL = null;

    /**
     * Unknown delivery system type.</DL>
     *
     *
     */
    public static final DeliverySystemType UNKNOWN = null;

    /**
     * Creates a delivery system type object.
     *
     * @param name - The string name of this type (e.g., "SATELLITE").
     */
    protected DeliverySystemType(java.lang.String name)
    {
        //TODO implement DeliverySystemType
    }

    /**
     * Provides the string name of delivery system type.  For the type
     * objects defined in this class, the string name will be identical
     * to the class variable name.
     *
     * @return The string name of the delivery system type.
     * @see toString in class java.lang.Object
     */
    public java.lang.String toString()
    {
        return null;
        //TODO implement toString
    }

}
