/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
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
 * This interface represents a collection of networks on a
 * <code>Transport</code>.  This information is carried in the DVB SI
 * NIT or US Cable SI (A56) NIT tables.
 * <code>NetworkCollection</code> may be optionally implemented by
 * <code>Transport</code> objects, depending on the SI data carried on
 * that transport.
 * <HR>
 * 
 * 
 */
public interface NetworkCollection extends Transport
{
	/**
	 * Retrieves the specified <code>Network</code> from the collection.<p>
	 * 
	 * This method delivers its results asynchronously.
	 * 
	 * @param locator - Locator referencing the Network of interest.
	 * @param requestor - The SIRequestor to be notified when this retrieval operation completes.
	 * @return An SIRequest object identifying this asynchronous retrieval request.
	 * @throws InvalidLocatorException - If locator does not reference a valid network.
	 * @throws java.lang.SecurityException - If the caller does not have javax.tv.service.ReadPermission(locator).
	 * @see Network, ReadPermission
	 */
	public SIRequest retrieveNetwork( Locator locator, SIRequestor requestor) throws InvalidLocatorException, java.lang.SecurityException;

	/**
	 * Retrieves an array of all the <code>Network</code> objects in
	 * this <code>NetworkCollection</code>.  The array will only contain
	 * <code>Network</code> instances <code>n</code> for which the
	 * caller has
	 * <code>javax.tv.service.ReadPermission(n.getLocator())</code>. If
	 * no <code>Network</code> instances meet this criteria, this method
	 * will result in an <code>SIRequestFailureType</code> of
	 * <code>DATA_UNAVAILABLE</code>.<p>
	 * 
	 * This method delivers its results asynchronously.
	 * 
	 * @param requestor - The SIRequestor to be notified when this retrieval operation completes.
	 * @return An SIRequest object identifying this asynchronous retrieval request.
	 * @see Network, ReadPermission
	 */
	public SIRequest retrieveNetworks( SIRequestor requestor);

	/**
	 * Registers a <code>NetworkChangeListener</code> to be notified of
	 * changes to a <code>Network</code> that is part of this
	 * <code>NetworkCollection</code>. Subsequent notification is made
	 * via <code>NetworkChangeEvent</code> with this
	 * <code>NetworkCollection</code> as the event source and an
	 * <code>SIChangeType</code> of <code>ADD</code>,
	 * <code>REMOVE</code> or <code>MODIFY</code>.  Only changes to
	 * <code>Network</code> instances <code>n</code> for which the
	 * caller has
	 * <code>javax.tv.service.ReadPermission(n.getLocator())</code> will
	 * be reported.<p>
	 * 
	 * This method is only a request for notification.  No guarantee is
	 * provided that the SI database will detect all, or even any, SI
	 * changes or whether such changes will be detected in a timely
	 * fashion.<p>
	 * 
	 * If the specified <code>NetworkChangeListener</code> is
	 * already registered, no action is performed.
	 * 
	 * @param listener - A NetworkChangeListener to be notified about changes related to Network carried on this Transport.
	 * @see NetworkChangeEvent, ReadPermission
	 */
	public void addNetworkChangeListener( NetworkChangeListener listener);

	/**
	 * Called to unregister an
	 * <code>NetworkChangeListener</code>.  If the specified
	 * <code>NetworkChangeListener</code> is not registered, no
	 * action is performed.
	 * 
	 * @param listener - A previously registered listener.
	 */
	public void removeNetworkChangeListener( NetworkChangeListener listener);

}
