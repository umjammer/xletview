/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.transport;

import xjavax.tv.locator.InvalidLocatorException;
import xjavax.tv.locator.Locator;
import xjavax.tv.service.SIRequest;
import xjavax.tv.service.SIRequestor;

/**
 * This interface represents a collection of transport streams on a
 * <code>Transport</code>.  <code>TransportStreamCollection</code> may
 * be optionally implemented by <code>Transport</code> objects,
 * depending on the SI data carried on that transport.
 * <HR>
 *
 *
 */
public interface TransportStreamCollection extends Transport
{
    /**
     * Retrieves the specified <code>TransportStream</code> from the
     * collection.
     *
     * @param locator - Locator referencing the TransportStream of interest.
     * @param requestor - The SIRequestor to be notified when this retrieval operation completes.
     * @return An SIRequest object identifying this asynchronous retrieval request.
     * @throws InvalidLocatorException - If locator does not reference a valid transport stream.
     * @throws java.lang.SecurityException - If the caller does not have javax.tv.service.ReadPermission(locator).
     * @see TransportStream, ReadPermission
     */
    public SIRequest retrieveTransportStream( Locator locator, SIRequestor requestor) throws InvalidLocatorException, java.lang.SecurityException;

    /**
     * Retrieves an array of the <code>TransportStream</code> objects in
     * this <code>TransportStreamCollection</code>.  The array will only
     * contain <code>TransportStream</code> instances <code>ts</code>
     * for which the caller has
     * <code>javax.tv.service.ReadPermission(ts.getLocator())</code>. If
     * no <code>TransportStream</code> instances meet this criteria,
     * this method will result in an <code>SIRequestFailureType</code>
     * of <code>DATA_UNAVAILABLE</code>.<p>
     *
     * This method delivers its results asynchronously.
     *
     * @param requestor - The SIRequestor to be notified when this retrieval operation completes.
     * @return An SIRequest object identifying this asynchronous retrieval request.
     * @see TransportStream, ReadPermission
     */
    public SIRequest retrieveTransportStreams( SIRequestor requestor);

    /**
     * Registers a <code>TransportStreamChangeListener</code> to be
     * notified of changes to a <code>TransportStream</code> that is
     * part of this <code>TransportStreamCollection</code>. Subsequent
     * notification is made via <code>TransportStreamChangeEvent</code>
     * with this <code>TransportStreamCollection</code> as the event
     * source and an <code>SIChangeType</code> of <code>ADD</code>,
     * <code>REMOVE</code> or <code>MODIFY</code>.  Only changes to
     * <code>TransportStream</code> instances <code>ts</code> for which
     * the caller has
     * <code>javax.tv.service.ReadPermission(ts.getLocator())</code>
     * will be reported.<p>
     *
     * This method is only a request for notification.  No guarantee is
     * provided that the SI database will detect all, or even any, SI
     * changes or whether such changes will be detected in a timely
     * fashion.<p>
     *
     * If the specified <code>TransportStreamChangeListener</code> is
     * already registered, no action is performed.
     *
     * @param listener - A TransportStreamChangeListener to be notified about changes related to TransportStream carried on this Transport.
     * @see TransportStreamChangeEvent, ReadPermission
     */
    public void addTransportStreamChangeListener( TransportStreamChangeListener listener);

    /**
     * Called to unregister an
     * <code>TransportStreamChangeListener</code>.  If the specified
     * <code>TransportStreamChangeListener</code> is not registered, no
     * action is performed.
     *
     * @param listener - A previously registered listener.
     */
    public void removeTransportStreamChangeListener( TransportStreamChangeListener listener);

}
