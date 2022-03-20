/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.net.ca;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class UnknownSessionException extends CAException {

    public UnknownSessionException() {
        super();
    }

    public UnknownSessionException(String reason) {
        super(reason);
    }

}
