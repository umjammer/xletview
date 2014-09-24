/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/
package xjavax.tv.service;

import xjavax.tv.locator.InvalidLocatorException;
import xjavax.tv.locator.Locator;
import xjavax.tv.service.navigation.ServiceFilter;
import xjavax.tv.service.navigation.ServiceList;
import xjavax.tv.service.transport.Transport;

/**
 * An <code>SIManager</code> represents a managing entity which has
 * knowledge of all the broadcast resources available to a receiver.  An
 * <code>SIManager</code> can be used to retrieve any
 * <code>SIElement</code> or create a collection of
 * <code>Service</code> objects according to filtering rules. <p>
 * 
 * An <code>SIManager</code> may also be used to set parameters such
 * as the preferred language for multilingual text information.
 * Normally an application will create a single instance of
 * <code>SIManager</code> and use that instance to access all SI
 * information.  If an application creates more than one instance of
 * <code>SIManager</code> it may experience degraded caching
 * performance, particularly if the <code>SIManager</code> instances
 * use different preferred languages.
 * <A HREF="../../../javax/tv/service/SIElement.html"><CODE>SIElement</CODE></A></DL>
 * <HR>
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public abstract class SIManager {
	/**
	 * Constructs an <code>SIManager</code> object.</DL>
	 * 
	 * 
	 */
	protected SIManager()
	{
		//TODO implement SIManager
	}

	/**
	 * Creates a new instance of <code>SIManager</code>.
	 * 
	 * @return A new instance of SIManager.
	 */
	public static SIManager createInstance()
	{
		return null;
		//TODO implement createInstance
	}

	/**
	 * Overrides the system-level preferred language for objects
	 * obtained through this <code>SIManager</code>.  The specified
	 * language will be used by the textual information obtained from
	 * the <code>SIElement</code> objects obtained through this
	 * <code>SIManager</code>, if such information is available in the
	 * specified language. If the specified language is not available
	 * the system-level preferred language is used. If the system-level
	 * preferred language is not available either, the first available
	 * language will be used.<p>
	 * 
	 * The preferred language is indicated using a language code.
	 * This is typically a three-character language code as specified by
	 * ISO 639.2/B, but the code may be system-dependent.
	 * 
	 * @param language - A string representing the desired language code. If the input parameter is null, any language preference previously set using this method is canceled.
	 */
	public abstract void setPreferredLanguage(java.lang.String language);

	/**
	 * Reports the preferred language for this <code>SIManager</code>.
	 * The resulting string is a language code indicating
	 * the language desired when retrieving multilingual text.  This
	 * is typically a three-character code as specified by ISO 639.2/B.
	 * 
	 * @return A string representing a language code defining the language used to retrieve multilingual strings.  If no language preference is in effect, null is returned.
	 */
	public abstract java.lang.String getPreferredLanguage();

	/**
	 * Provides a hint to the SI database that the application desires
	 * SI information as complete as possible about the specified
	 * <code>SIElement</code>. As a result, the SI database might tune
	 * to the transport stream delivering the desired information and
	 * begin caching it, depending on resource availability.
	 * 
	 * <p> For example, if the given <code>Locator</code> references a
	 * bouquet, the database might begin caching
	 * <code>ServiceDetails</code> data for services that are part of
	 * the bouquet. If the given <code>Locator</code>
	 * references a service, the database might start caching
	 * <code>ProgramEvent</code> data for the service.
	 * 
	 * <p> Note that this method returns immediately and that there is
	 * no indication of the completion of any resulting SI database
	 * operations.  Since it is only a hint for cache optimization, no
	 * specific behavior for this method is guaranteed.
	 * 
	 * @param locator - A locator referencing the SIElement for which complete information is desired.
	 * @param active - A flag indicating whether this interest is active or not. A value of true means that the application is interested in the SIElement; false means that the application wants to cancel a previously shown interest for the SIElement.
	 * @throws InvalidLocatorException - If locator does not reference a valid SIElement.
	 * @throws java.lang.SecurityException - If the caller does not have javax.tv.service.ReadPermission(locator).
	 * @see ReadPermission
	 */
	public abstract void registerInterest( Locator locator, boolean active) throws InvalidLocatorException, java.lang.SecurityException;

	/**
	 * Provides the names of available rating dimensions in the local
	 * rating region.  A zero-length array is returned if no rating
	 * dimensions are available.
	 * 
	 * @return An array of strings representing the names of available rating dimensions in this rating region.
	 * @see RatingDimension
	 */
	public abstract java.lang.String[] getSupportedDimensions();

	/**
	 * Reports the <code>RatingDimension</code> corresponding to the
	 * specified string name.
	 * 
	 * @param name - The name of the requested rating dimension.
	 * @return The requested RatingDimension.
	 * @throws SIException - If name is not a supported rating dimension, as returned by getSupportedDimensions().
	 * @see getSupportedDimensions()
	 */
	public abstract RatingDimension getRatingDimension(java.lang.String name) throws SIException;

	/**
	 * Reports the various content delivery mechanisms currently
	 * available on this platform.  The implementation must be capable
	 * of supporting at least one <code>Transport</code> instance.
	 * 
	 * @return An array of Transport objects representing the content delivery mechanisms currently available on this platform.
	 */
	public abstract Transport[] getTransports();

	/**
	 * Retrieves the <code>SIElement</code> corresponding to the
	 * specified <code>Locator</code>. If the locator identifies more
	 * than one <code>SIElement</code>, all matching
	 * <code>SIElements</code> are retrieved. <p>
	 * 
	 * For example, multiple <code>SIElement</code> objects are
	 * retrieved when the locator represents identical content delivered
	 * over different media (terrestrial, satellite, cable, etc.) or a
	 * specific program event made available at different times,
	 * possibly on different services. <p>
	 * 
	 * This call retrieves various types of <code>SIElement</code>
	 * instances according to the locator specified.  For example, if
	 * the locator is a transport-dependent locator to a service (and
	 * therefore to a <code>ServiceDetails</code> -- see <A HREF="../../../javax/tv/service/Service.html#getLocator()"><CODE>Service.getLocator()</CODE></A> for more information), a
	 * <code>ServiceDetails</code> object is retrieved; if the locator
	 * represents a program event, a <code>ProgramEvent</code> object is
	 * retrieved; if the locator represents a service component, a
	 * <code>ServiceComponent</code> is retrieved.<p>
	 * 
	 * <p>This method delivers its results asynchronously.
	 * 
	 * @param locator - A locator referencing one or more SIElements.
	 * @param requestor - The SIRequestor to be notified when this retrieval operation completes.
	 * @return An SIRequest object identifying this asynchronous retrieval request.
	 * @throws InvalidLocatorException - If locator does not reference a valid SIElement.
	 * @throws java.lang.SecurityException - if the caller does not have javax.tv.service.ReadPermission(locator).
	 * @see SIElement
	 */
	public abstract SIRequest retrieveSIElement( Locator locator, SIRequestor requestor) throws InvalidLocatorException, java.lang.SecurityException;

	/**
	 * Provides the <code>Service</code> referred to by a given
	 * <code>Locator</code>.  An implementation must be capable of
	 * supporting at least one <code>Service</code> instance.<p>
	 * 
	 * @param locator - A locator specifying a service.
	 * @return The Service object corresponding to the specified locator.
	 * @throws InvalidLocatorException - If locator does not reference a valid Service.
	 * @throws java.lang.SecurityException - If the caller does not have javax.tv.service.ReadPermission(locator).
	 * @see ReadPermission
	 */
	public abstract Service getService( Locator locator) throws InvalidLocatorException, java.lang.SecurityException;

	/**
	 * Retrieves the <code>ServiceDetails</code> object corresponding to
	 * the given <code>Locator</code>.
	 * 
	 * <p>Note that the locator may point to an SI element lower in the
	 * hierarchy than a service (such as a program event). In such a
	 * case, the <code>ServiceDetails</code> for the service that the
	 * program event is part of will be returned. <p>
	 * 
	 * If a transport-independent locator is provided, one or more
	 * <code>ServiceDetails</code> objects may be returned.  However, it
	 * is permissible in this case for this method to always retrieve
	 * a single <code>ServiceDetails</code> object, as determined
	 * by the implementation, user preferences, or availability.  To
	 * obtain all of the corresponding <code>ServiceDetails</code>
	 * objects, the application may transform the transport-independent
	 * locator into multiple transport-dependent locators and retrieve
	 * a <code>ServiceDetails</code> object for each.<p>
	 * 
	 * This method delivers its results asynchronously.
	 * 
	 * @param locator - A locator referencing a Service
	 * @param requestor - The SIRequestor to be notified when this retrieval operation completes.
	 * @return An SIRequest object identifying this asynchronous retrieval request.
	 * @throws InvalidLocatorException - If locator does not reference a valid Service.
	 * @throws java.lang.SecurityException - If the caller does not have javax.tv.service.ReadPermission(locator).
	 * @see Locator, ServiceDetails, ReadPermission
	 */
	public abstract SIRequest retrieveServiceDetails( Locator locator, SIRequestor requestor) throws InvalidLocatorException, java.lang.SecurityException;

	/**
	 * Retrieves the <code>ProgramEvent</code> corresponding to the
	 * given <code>Locator</code>.  If a transport-independent locator
	 * is provided (e.g., one referencing the same movie shown at
	 * different times and/or on different services), this method may
	 * retrieve multiple <code>ProgramEvent</code> objects.<p>
	 * 
	 * This method delivers its results asynchronously.
	 * 
	 * @param locator - A locator referencing a ProgramEvent
	 * @param requestor - The SIRequestor to be notified when this retrieval operation completes.
	 * @return An SIRequest object identifying this asynchronous retrieval request.
	 * @throws InvalidLocatorException - If locator does not reference a valid ProgramEvent.
	 * @throws java.lang.SecurityException - If the caller does not have javax.tv.service.ReadPermission(locator).
	 * @see ProgramEvent, ReadPermission
	 */
	public abstract SIRequest retrieveProgramEvent( Locator locator, SIRequestor requestor) throws InvalidLocatorException, java.lang.SecurityException;

	/**
	 * Filters the available services using the
	 * <code>ServiceFilter</code> provided to generate a
	 * <code>ServiceList</code> containing the matching services.  If
	 * the filter parameter is <code>null</code>, a list of all known
	 * services is generated.  Only <code>Service</code> instances for
	 * which the caller has <code>javax.tv.service.ReadPermission</code>
	 * on the underlying locator will be present in the returned
	 * list.<p>
	 * 
	 * Note that for each <code>Service</code> to be filtered, the
	 * <code>accept()</code> method of the given
	 * <code>ServiceFilter</code> will be invoked with the same
	 * application thread that invokes this method.
	 * 
	 * @param filter - A ServiceFilter by which to generate the requested service list, or null.
	 * @return A ServiceList generated according to the specified filtering rules.
	 * @see ServiceFilter.accept(javax.tv.service.Service)
	 */
	public abstract ServiceList filterServices( ServiceFilter filter);

}
