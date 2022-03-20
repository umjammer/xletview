/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.dsmcc;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class IllegalObjectTypeException extends DSMCCException {

    public IllegalObjectTypeException () {
        super();
    }

    public IllegalObjectTypeException (String s) {
        super(s);
    }

}
