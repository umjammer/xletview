/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.mpeg;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 2
 */
public class TuningException extends org.davic.mpeg.ResourceException{

    public TuningException() {
        super();
    }

    public TuningException(String s){
        super(s);
    }

    public TransportStream getTransportStream(){
        return null;
    }
}













