/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.transport;

import xjavax.tv.service.SIChangeType;

/**
 * A <code>NetworkChangeEvent</code> notifies an
 * <code>NetworkChangeListener</code> of changes detected in a
 * <code>NetworkCollection</code>.  Specifically, this event
 * signals the addition, removal, or modification of a
 * <code>Network</code>.
 * <A HREF="../../../../javax/tv/service/transport/Network.html"><CODE>Network</CODE></A>, <A HREF="../../../../serialized-form.html#javax.tv.service.transport.NetworkChangeEvent">Serialized Form</A></DL>
 * <HR>
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class NetworkChangeEvent extends TransportSIChangeEvent{


    /**
     * Constructs a <code>NetworkChangeEvent</code>.
     *
     * @param collection - The network collection in which the change occurred.
     * @param type - The type of change that occurred.
     * @param n - The Network that changed.
     */
    public NetworkChangeEvent( NetworkCollection collection, SIChangeType type, Network n)    {
        super(collection, type, n);
    }

    /**
     * Reports the <code>NetworkCollection</code> that generated the
     * event.  It will be identical to the object returned by the
     * <code>getTransport()</code> method.
     *
     * @return The NetworkCollection that generated the event.
     */
    public NetworkCollection getNetworkCollection()    {
        return (NetworkCollection) super.getSource();
    }

    /**
     * Reports the <code>Network</code> that changed.  It will be
     * identical to the object returned by the inherited
     * <code>SIChangeEvent.getSIElement</code> method.
     *
     * @return The Network that changed.
     */
    public Network getNetwork()    {
        return (Network) super.getSIElement();
    }

}
