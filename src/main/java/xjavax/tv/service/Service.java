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
import xjavax.tv.service.navigation.ServiceDetails;

/**
 * The <code>Service</code> interface represents an abstract view on
 * what is generally referred to as a television "service" or
 * "channel". It may represent an MPEG-2 program, DVB service, an ATSC
 * virtual channel, SCTE virtual channel, etc. It represents the basic
 * information associated with a service, such as its name or number,
 * which is guaranteed to be available on the receiver. <P>
 *
 * Internal to the receiver, each service is uniquely identified by
 * information that may include system type, network ID, transport stream
 * ID, service number, service number, or other information. This
 * identification is encapsulated by the Locator object. <P>
 *
 * Note that a <code>Service</code> object may represent multiple
 * instances of the same content delivered over different media
 * (e.g., the same service may be delivered over a terrestrial and
 * cable network). A <code>ServiceDetails</code> object represents a
 * specific instance of such content which is bound to a specific
 * delivery mechanism. <P>
 *
 * The information available through this object, i.e., the service name,
 * service number, etc., represents information that is stored in
 * the receiver and is not necessarily the same as what is broadcast in any
 * broadcast service information protocol. For example, a receiver
 * implementation may let the end user edit this information according to
 * the user's preferences. <P>
 *
 * A <code>Service</code> object may optionally implement an interface
 * that supports service numbers.  Each <code>Service</code> object
 * must provide either a service name (via the <code>getName</code> method)
 * or a service number (via the <code>ServiceNumber</code> interface).
 * <A HREF="../../../javax/tv/service/ServiceNumber.html"><CODE>ServiceNumber</CODE></A>,
 * <A HREF="../../../javax/tv/service/navigation/ServiceDetails.html"><CODE>ServiceDetails</CODE></A>,
 * <a href="../../../overview-summary.html#guidelines-opinterfaces">Optionally implemented interfaces</a></DL>
 * <HR>
 *
 *
 */
public interface Service
{
    /**
     * This method retrieves additional information about the
     * <code>Service</code>. This information is retrieved from the
     * broadcast service information. <P>
     *
     * Note that if the content represented by this <code>Service</code>
     * is delivered on multiple transport-dependent streams there may be
     * multiple <code>ServiceDetails</code> for it. This method
     * retrieves one of them based on availability or user
     * preferences. If access to all possible
     * <code>ServiceDetails</code> is required, the service
     * <code>Locator</code> can be transformed to transport-dependent
     * <code>Locator</code> instances and <code>ServiceDetails</code>
     * can be retrieved for each. <P>
     *
     * This method returns data asynchronously.
     *
     * @param requestor - The SIRequestor to be notified when this retrieval operation completes.
     * @return An SIRequest object identifying this asynchronous retrieval request.
     * @see Locator, ServiceDetails
     */
    public SIRequest retrieveDetails( SIRequestor requestor);

    /**
     * Returns a short service name or acronym.  For example, in ATSC
     * systems the service name is provided by the the PSIP VCT; in DVB
     * systems, this information is provided by the DVB Service
     * Descriptor or the Multilingual Service Name Descriptor.  The
     * service name may also be user-defined.
     *
     * @return A string representing this service's short name.  If the short name is unavailable, the string representation of the service number is returned.
     */
    public java.lang.String getName();

    /**
     * This method indicates whether the service represented by this
     * <code>Service</code> object is available on multiple
     * transports, (e.g., the same content delivered over terrestrial and
     * cable network).
     *
     * @return true if multiple transports carry the same content identified by this Service object; false if there is only one instance of this service.
     */
    public boolean hasMultipleInstances();

    /**
     * Returns the type of this service, (for example, "digital
     * television", "digital radio", "NVOD", etc.) These values can be
     * mapped to the ATSC service type in the VCT table and the DVB
     * service type in the service descriptor.
     *
     * @return Service type of this Service.
     */
    public ServiceType getServiceType();

    /**
     * Reports the <code>Locator</code> of this <code>Service</code>.
     * Note that if the resulting locator is transport-dependent, it
     * will also correspond to a <code>ServiceDetails</code> object.
     *
     * @return A locator referencing this Service.
     * @see ServiceDetails
     */
    public Locator getLocator();

    /**
     * Tests two <code>Service</code> objects for equality.  Returns
     * <code>true</code> if and only if:
     * <ul>
     * <li><code>obj</code>'s class is the
     * same as the class of this <code>Service</code>, and<p>
     * <li><code>obj</code>'s <code>Locator</code> is equal to
     * the <code>Locator</code> of this <code>Service</code>
     * (as reported by
     * <code>Service.getLocator()</code>, and<p>
     * <li><code>obj</code> and this object encapsulate identical data.
     * </ul>
     *
     * @param obj - The object against which to test for equality.
     * @return true if the two Service objects are equal; false otherwise.
     * @see equals in class java.lang.Object
     */
    public boolean equals(java.lang.Object obj);

    /**
     * Reports the hash code value of this <code>Service</code>.  Two
     * <code>Service</code> objects that are equal will have identical
     * hash codes.
     *
     * @return The hash code value of this Service.
     * @see hashCode in class java.lang.Object
     */
    public int hashCode();

}
