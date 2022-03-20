/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.transport;

import xjavax.tv.service.SIElement;
import xjavax.tv.service.SIRequest;
import xjavax.tv.service.SIRequestor;

/**
 * This interface provides descriptive information concerning a network.
 *
 * This interface provides descriptive information concerning a network.
 * <HR>
 *
 *
 */
public interface Network extends SIElement
{
    /**
     * Reports the ID of this network.
     *
     * @return A number identifying this network.
     */
    public int getNetworkID();

    /**
     * Reports the name of this network.
     *
     * @return A string representing the name of this network, or an empty string if the name is unavailable.
     */
    public java.lang.String getName();

    /**
     * Retrieves an array of <code>TransportStream</code> objects
     * representing the transport streams carried in this
     * <code>Network</code>. Only <code>TransportStream</code> instances
     * <code>ts</code> for which the caller has
     * <code>javax.tv.service.ReadPermission(ts.getLocator())</code>
     * will be present in the array. If no <code>TransportStream</code>
     * instances meet this criteria or if this <code>Network</code> does
     * not aggregate transport streams, the result is an
     * <code>SIRequestFailureType</code> of
     * <code>DATA_UNAVAILABLE</code>.<p>
     *
     * This method delivers its results asynchronously.
     *
     * @param requestor - The SIRequestor to be notified when this retrieval operation completes.
     * @return An SIRequest object identifying this asynchronous retrieval request.
     * @see TransportStream, ReadPermission
     */
    public SIRequest retrieveTransportStreams( SIRequestor requestor);

}
