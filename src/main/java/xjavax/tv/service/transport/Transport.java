/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.transport;

import xjavax.tv.service.navigation.DeliverySystemType;

/**
 * This interface represents an individual content delivery mechanism.
 * 
 * This interface represents an individual content delivery mechanism.
 * A <code>Transport</code> serves as an access point for acquiring
 * information about services and their groupings.<p>
 * 
 * A <code>Transport</code> may expose various types of
 * entities (e.g. bouquets, networks and/or transport streams) by
 * optionally implementing additional interfaces
 * (i.e. <code>BouquetCollection</code>,
 * <code>NetworkCollection</code>, and/or
 * <code>TransportStreamCollection</code>), depending on the particular
 * SI format used and the presence of optional elements and tables in
 * the SI data being broadcast.<p>
 * <A HREF="../../../../javax/tv/service/transport/NetworkCollection.html"><CODE>NetworkCollection</CODE></A>,
 * <A HREF="../../../../javax/tv/service/transport/TransportStreamCollection.html"><CODE>TransportStreamCollection</CODE></A>,
 * <a href="../../../../overview-summary.html#guidelines-opinterfaces">Optionally implemented interfaces</a></DL>
 * <HR>
 * 
 * 
 */
public interface Transport
{
	/**
	 * Registers a <code>ServiceDetailsChangeListener</code> to be
	 * notified of changes to <code>ServiceDetails</code> that are
	 * carried on this <code>Transport</code>. Subsequent notification
	 * is made via <code>ServiceDetailsChangeEvent</code> with this
	 * <code>Transport</code> instance as the event source and an
	 * <code>SIChangeType</code> of <code>ADD</code>,
	 * <code>REMOVE</code> or <code>MODIFY</code>.  Only changes to
	 * <code>ServiceDetails</code> <code>sd</code> for which the caller
	 * has <code>javax.tv.service.ReadPermission(sd.getLocator())</code>
	 * will be reported.<p>
	 * 
	 * This method is only a request for notification.  No guarantee is
	 * provided that the SI database will detect all, or even any, SI
	 * changes or whether such changes will be detected in a timely
	 * fashion.  Applications may indicate <code>ServiceDetails</code>
	 * of particular interest via the method <A HREF="../../../../javax/tv/service/SIManager.html#registerInterest(javax.tv.locator.Locator, boolean)"><CODE>SIManager.registerInterest(javax.tv.locator.Locator, boolean)</CODE></A>. <p>
	 * 
	 * If the specified <code>ServiceDetailsChangeListener</code> is
	 * already registered, no action is performed.
	 * 
	 * @param listener - An ServiceDetailsChangeListener to be notified about changes related to ServiceDetails carried on this Transport.
	 * @see ServiceDetailsChangeEvent, SIManager.registerInterest(javax.tv.locator.Locator, boolean), ReadPermission
	 */
	public void addServiceDetailsChangeListener( ServiceDetailsChangeListener listener);

	/**
	 * Called to unregister an
	 * <code>ServiceDetailsChangeListener</code>.  If the specified
	 * <code>ServiceDetailsChangeListener</code> is not registered, no
	 * action is performed.
	 * 
	 * @param listener - A previously registered listener.
	 */
	public void removeServiceDetailsChangeListener( ServiceDetailsChangeListener listener);

	/**
	 * Reports the type of mechanism by which this
	 * <code>Transport</code> delivers content.
	 * 
	 * @return The delivery system type of this transport.
	 */
	public DeliverySystemType getDeliverySystemType();

}
