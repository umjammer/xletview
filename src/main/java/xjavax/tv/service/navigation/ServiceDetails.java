/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.navigation;

import xjavax.tv.service.SIElement;
import xjavax.tv.service.SIRequest;
import xjavax.tv.service.SIRequestor;
import xjavax.tv.service.Service;
import xjavax.tv.service.ServiceType;
import xjavax.tv.service.guide.ProgramSchedule;

/**
 * This interface provides access to service meta-data.
 *
 * This interface provides access to service meta-data. It provides more
 * information about a <code>Service</code> object and represents a
 * specific instance of a service bound to a transport stream. <p>
 *
 * A <code>ServiceDetails</code> object may optionally implement the
 * <code>ServiceNumber</code> interface to report service numbers as
 * assigned by the broadcaster of the service.<p>
 *
 * A <code>ServiceDetails</code> object may optionally implement the
 * <code>ServiceProviderInformation</code> interface to report information
 * concerning the service provider.
 * <A HREF="../../../../javax/tv/service/ServiceNumber.html"><CODE>ServiceNumber</CODE></A>,
 * <A HREF="../../../../javax/tv/service/navigation/ServiceProviderInformation.html"><CODE>ServiceProviderInformation</CODE></A>,
 * <a href="../../../../overview-summary.html#guidelines-opinterfaces">Optionally implemented interfaces</a></DL>
 * <HR>
 *
 *
 */
public interface ServiceDetails extends SIElement, CAIdentification
{
    /**
     * Retrieves a textual description of this service if available.
     * This method delivers its results asynchronously.
     *
     * @param requestor - The SIRequestor to be notified when this retrieval operation completes.
     * @return An SIRequest object identifying this asynchronous retrieval request.
     * @see ServiceDescription
     */
    public SIRequest retrieveServiceDescription( SIRequestor requestor);

    /**
     * Returns the type of this service, for example, "digital
     * television", "digital radio", "NVOD", etc. These values can be
     * mapped to the ATSC service type in the VCT table and the DVB
     * service type in the Service Descriptor.
     *
     * @return Service type of this service.
     */
    public ServiceType getServiceType();

    /**
     * Retrieves an array of elementary components which are part of
     * this service.  The array will only contain
     * <code>ServiceComponent</code> instances <code>c</code> for which
     * the caller has
     * <code>javax.tv.service.ReadPermission(c.getLocator())</code>.  If
     * no <code>ServiceComponent</code> instances meet this criteria,
     * this method will result in an <code>SIRequestFailureType</code> of
     * <code>DATA_UNAVAILABLE</code>.
     *
     * This method delivers its results asynchronously.
     *
     * @param requestor - The SIRequestor to be notified when this retrieval operation completes.
     * @return An SIRequest object identifying this asynchronous retrieval request.
     * @see ServiceComponent, ReadPermission
     */
    public SIRequest retrieveComponents( SIRequestor requestor);

    /**
     * Returns a schedule of program events associated with this service.
     *
     * @return The program schedule for this service, or null if no schedule is available.
     */
    public ProgramSchedule getProgramSchedule();

    /**
     * Called to obtain a full service name. For example, this
     * information may be delivered in the ATSC Extended Channel Name
     * Descriptor, the DVB Service Descriptor or the DVB Multilingual
     * Service Name Descriptor.
     *
     * @return A string representing the full service name, or an empty string if the name is not available.
     */
    public java.lang.String getLongName();

    /**
     * Returns the <code>Service</code> this <code>ServiceDetails</code>
     * object is associated with.
     *
     * @return The Service to which this ServiceDetails belongs.
     */
    public Service getService();

    /**
     * Registers a <code>ServiceComponentChangeListener</code> to be
     * notified of changes to a <code>ServiceComponent</code> that is
     * part of this <code>ServiceDetails</code>. Subsequent notification
     * is made via <code>ServiceComponentChangeEvent</code> with this
     * <code>ServiceDetails</code> instance as the event source and an
     * <code>SIChangeType</code> of <code>ADD</code>,
     * <code>REMOVE</code> or <code>MODIFY</code>. Only changes to
     * <code>ServiceComponent</code> instances <code>c</code> for which
     * the caller has
     * <code>javax.tv.service.ReadPermission(c.getLocator())</code> will
     * be reported.<p>
     *
     * This method is only a request for notification.  No guarantee is
     * provided that the SI database will detect all, or even any, SI
     * changes or whether such changes will be detected in a timely
     * fashion.<p>
     *
     * If the specified <code>ServiceComponentChangeListener</code> is
     * already registered, no action is performed.
     *
     * @param listener - A ServiceComponentChangeListener to be notified about changes related to a ServiceComponent in this ServiceDetails.
     * @see ServiceComponentChangeEvent, ReadPermission
     */
    public void addServiceComponentChangeListener( ServiceComponentChangeListener listener);

    /**
     * Called to unregister an
     * <code>ServiceComponentChangeListener</code>.  If the specified
     * <code>ServiceComponentChangeListener</code> is not registered, no
     * action is performed.
     *
     * @param listener - A previously registered listener.
     */
    public void removeServiceComponentChangeListener( ServiceComponentChangeListener listener);

    /**
     * Reports the type of mechanism by which this service was
     * delivered.
     *
     * @return The delivery system type of this service.
     */
    public DeliverySystemType getDeliverySystemType();

}
