/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.navigation;

import xjavax.tv.service.SIChangeType;

/**
 * A <code>ServiceComponentChangeEvent</code> notifies an
 * <code>ServiceComponentChangeListener</code> of changes to a
 * <code>ServiceComponent</code> detected in a
 * <code>ServiceDetails</code>.  Specifically, this event signals the
 * addition, removal, or modification of a
 * <code>ServiceComponent</code>.
 * <A HREF="../../../../javax/tv/service/navigation/ServiceComponent.html"><CODE>ServiceComponent</CODE></A>, <A HREF="../../../../serialized-form.html#javax.tv.service.navigation.ServiceComponentChangeEvent">Serialized Form</A></DL>
 * <HR>
 *
 *
 */
public class ServiceComponentChangeEvent extends ServiceDetailsSIChangeEvent
{
    //following variables are implicitely defined by getter- or setter-methods:
    private ServiceComponent serviceComponent;

    /**
     * Constructs a <code>ServiceComponentChangeEvent</code>.
     *
     * @param service - The ServiceDetails in which the change occurred.
     * @param type - The type of change that occurred.
     * @param c - The ServiceComponent that changed.
     */
    public ServiceComponentChangeEvent( ServiceDetails service, SIChangeType type, ServiceComponent c)
    {
        //TODO implement ServiceComponentChangeEvent
        super(null, null, null);

    }

    /**
     * Reports the <code>ServiceComponent</code> that changed.  It will be
     * identical to the object returned by the inherited
     * <code>SIChangeEvent.getSIElement</code> method.
     *
     * @return The ServiceComponent that changed.
     */
    public ServiceComponent getServiceComponent()
    {
        return this.serviceComponent;
    }

}
