/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.locator;

/**
 * The <code>Locator</code> interface provides an opaque reference to
 * the location information of objects which are addressable within the
 * Java TV API. A given locator may represent a transport independent
 * object and have multiple mappings to transport dependent locators.
 * Methods are provided for discovery of such circumstances and for
 * transformation to transport dependent locators.
 * <A HREF="../../../javax/tv/locator/LocatorFactory.html#transformLocator(javax.tv.locator.Locator)"><CODE>LocatorFactory.transformLocator(javax.tv.locator.Locator)</CODE></A></DL>
 * <HR>
 *
 *
 */
public interface Locator
{
    /**
     * Generates a canonical, string-based representation of this
     * <code>Locator</code>. The string returned may be entirely
     * platform-dependent.  If two locators have identical external
     * forms, they refer to the same resource.  However, two locators
     * that refer to the same resource may have different external
     * forms.<p>
     *
     * This method returns the canonical
     * form of the string that was used to create the Locator (via
     * <code>LocatorFactory.createLocator()</code>).  In generating
     * canonical external forms, the implementation will make its best
     * effort at resolving locators to one-to-one relationships
     * with the resources that they reference.<p>
     *
     * The result of this method can be used to create new
     * <code>Locator</code> instances as well as other types of
     * locators, such as JMF <code>MediaLocator</code>s and
     * <code>URL</code>s.
     *
     * @return A string-based representation of this Locator.
     * @see LocatorFactory.createLocator(java.lang.String),  javax.media.MediaLocator, URL
     */
    public java.lang.String toExternalForm();

    /**
     * Indicates whether this <code>Locator</code> has a mapping to
     * multiple transports.
     *
     * @return true if multiple transformations exist for this Locator, false otherwise.
     */
    public boolean hasMultipleTransformations();

    /**
     * Compares this <code>Locator</code> with the specified object for
     * equality.  The result is <code>true</code> if and only if the
     * specified object is also a <code>Locator</code> and has an
     * external form identical to the external form of this
     * <code>Locator</code>.
     *
     * @param o - The object against which to compare this Locator.
     * @return true if the specified object is equal to this Locator.
     * @see equals in class java.lang.Object
     * @see String.equals(Object)
     */
    public boolean equals(java.lang.Object o);

    /**
     * Generates a hash code value for this <code>Locator</code>.
     * Two <code>Locator</code> instances for which <code>Locator.equals()</code>
     * is <code>true</code> will have identical hash code values.
     *
     * @return The hash code value for this Locator.
     * @see hashCode in class java.lang.Object
     * @see equals(Object)
     */
    public int hashCode();

    /**
     * Returns the string used to create this locator.
     *
     * @return The string used to create this locator.
     * @see toString in class java.lang.Object
     * @see LocatorFactory.createLocator(java.lang.String)
     */
    public java.lang.String toString();

}
