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
 * This interface represents a collection of bouquets on a
 * <code>Transport</code>.  In DVB SI, this information is contained
 * in the BAT tables.  <code>BouquetCollection</code> may be
 * optionally implemented by <code>Transport</code> objects, depending
 * on the SI data carried on that transport.
 * <HR>
 *
 *
 */
public interface BouquetCollection extends Transport
{
    /**
     * Retrieves the specified <code>Bouquet</code> from the collection.<p>
     *
     * This method delivers its results asynchronously.
     *
     * @param locator - A Locator referencing the Bouquet of interest.
     * @param requestor - The SIRequestor to be notified when this retrieval operation completes.
     * @return An SIRequest object identifying this asynchronous retrieval request.
     * @throws InvalidLocatorException - If locator does not reference a valid bouquet.
     * @throws java.lang.SecurityException - If the caller does not have javax.tv.service.ReadPermission(locator).
     * @see Bouquet, ReadPermission
     */
    public SIRequest retrieveBouquet( Locator locator, SIRequestor requestor) throws InvalidLocatorException, java.lang.SecurityException;

    /**
     * Retrieves an array of all the <code>Bouquet</code> objects in
     * this <code>BouquetCollection</code>.  This array will only contain
     * <code>Bouquet</code> instances <code>b</code> for which the caller has
     * <code>javax.tv.service.ReadPermission(b.getLocator())</code>.  If
     * no <code>Bouquet</code> instances meet this criteria, this method
     * will result in an <code>SIRequestFailureType</code> of
     * <code>DATA_UNAVAILABLE</code>.<p>
     *
     * This method delivers its results asynchronously.
     *
     * @param requestor - The SIRequestor to be notified when this retrieval operation completes.
     * @return An SIRequest object identifying this asynchronous retrieval request.
     * @see Bouquet, ReadPermission
     */
    public SIRequest retrieveBouquets( SIRequestor requestor);

    /**
     * Registers a <code>BouquetChangeListener</code> to be notified of
     * changes to a <code>Bouquet</code> that is part of this
     * <code>BouquetCollection</code>. Subsequent notification is made
     * via <code>BouquetChangeEvent</code> with this
     * <code>BouquetCollection</code> as the event source and an
     * <code>SIChangeType</code> of <code>ADD</code>,
     * <code>REMOVE</code> or <code>MODIFY</code>.  Only changes to
     * <code>Bouquet</code> instances <code>b</code> for which the
     * caller has
     * <code>javax.tv.service.ReadPermission(b.getLocator())</code> will
     * be reported.<p>
     *
     * This method is only a request for notification.  No guarantee is
     * provided that the SI database will detect all, or even any, SI
     * changes or whether such changes will be detected in a timely
     * fashion.<p>
     *
     * If the specified <code>BouquetChangeListener</code> is
     * already registered, no action is performed.
     *
     * @param listener - A BouquetChangeListener to be notified about changes related to Bouquet carried on this Transport.
     * @see BouquetChangeEvent, ReadPermission
     */
    public void addBouquetChangeListener( BouquetChangeListener listener);

    /**
     * Called to unregister an
     * <code>BouquetChangeListener</code>.  If the specified
     * <code>BouquetChangeListener</code> is not registered, no
     * action is performed.
     *
     * @param listener - A previously registered listener.
     */
    public void removeBouquetChangeListener( BouquetChangeListener listener);

}
