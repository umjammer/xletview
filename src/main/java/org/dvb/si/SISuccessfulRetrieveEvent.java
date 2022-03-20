/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.si;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class SISuccessfulRetrieveEvent extends SIRetrievalEvent {

    private SIIterator iterator;

    public SISuccessfulRetrieveEvent(Object appData, SIRequest request, SIIterator result) {
        super(appData, request);
        this.iterator = result;
    }

    public SIIterator getResult() {
        return iterator;
    }


}
