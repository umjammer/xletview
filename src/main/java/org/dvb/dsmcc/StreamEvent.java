/*
 * This file is part of XleTView
 * Copyright (C) 2003 Martin SvedÈn
 *
 * This is free software, and you are
 * welcome to redistribute it under
 * certain conditions;
 *
 * See LICENSE document for details.
 */

package org.dvb.dsmcc;

/**
 * @author Martin Sveden
 * @statuscode 4
 */
public class StreamEvent extends java.util.EventObject {

    private final long normalPlayTime;
    private final String eventName;
    private final int eventId;
    private final byte[] eventData;

    public StreamEvent(DSMCCStreamEvent source, long npt, String name, int eventId, byte[] eventData) {
        super(source);
        this.normalPlayTime = npt;
        this.eventName = name;
        this.eventId = eventId;
        this.eventData = eventData;
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }

    public String getEventName() {
        return eventName;
    }

    public int getEventId() {
        return eventId;
    }

    public long getEventNPT() {
        return normalPlayTime;
    }

    public byte[] getEventData() {
        return eventData;
    }
}
