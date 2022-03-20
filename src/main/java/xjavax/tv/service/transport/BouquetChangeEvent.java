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
 * A <code>BouquetChangeEvent</code> notifies an
 * <code>BouquetChangeListener</code> of changes detected in a
 * <code>BouquetCollection</code>.  Specifically, this event
 * signals the addition, removal, or modification of a
 * <code>Bouquet</code>.
 * <A HREF="../../../../javax/tv/service/transport/Bouquet.html"><CODE>Bouquet</CODE></A>, <A HREF="../../../../serialized-form.html#javax.tv.service.transport.BouquetChangeEvent">Serialized Form</A></DL>
 * <HR>
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class BouquetChangeEvent extends TransportSIChangeEvent{

//    private BouquetCollection bouquetCollection;
//    private Bouquet bouquet;

    /**
     * Constructs a <code>BouquetChangeEvent</code>.
     *
     * @param collection - The BouquetCollection in which the change occurred.
     * @param type - The type of change that occurred.
     * @param b - The Bouquet that changed.
     */
    public BouquetChangeEvent( BouquetCollection collection, SIChangeType type, Bouquet b)    {
        super(collection, type, b);

    }

    /**
     * Reports the <code>BouquetCollection</code> that generated the
     * event.  It will be identical to the object returned by the
     * <code>getTransport()</code> method.
     *
     * @return The BouquetCollection that generated the event.
     */
    public BouquetCollection getBouquetCollection()    {
        return (BouquetCollection) super.getSource();
    }

    /**
     * Reports the <code>Bouquet</code> that changed.  It will be
     * identical to the object returned by the inherited
     * <code>SIChangeEvent.getSIElement</code> method.
     *
     * @return The Bouquet that changed.
     */
    public Bouquet getBouquet()    {
        return (Bouquet) super.getSIElement();
    }

}
