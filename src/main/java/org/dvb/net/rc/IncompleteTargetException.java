/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

 First Implemented version 0.1
 14.9.03 Bengt Skogvall
*/


package org.dvb.net.rc;

/**
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class IncompleteTargetException extends java.lang.Exception{

    public IncompleteTargetException(){
        super();
    }

    public IncompleteTargetException(String reason) {
        super(reason);
    }
}