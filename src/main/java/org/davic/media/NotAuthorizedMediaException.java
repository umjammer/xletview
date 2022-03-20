/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.media;

import org.davic.mpeg.ElementaryStream;
import org.davic.mpeg.NotAuthorizedInterface;
import org.davic.mpeg.Service;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 * @comment not tested
 */
public class NotAuthorizedMediaException extends NotAuthorizedException    implements org.davic.mpeg.NotAuthorizedInterface{

    private Service service;
    private int[] reasons;
    private ElementaryStream[] streams;
    private int type;

    public NotAuthorizedMediaException(Service service, int reason){
        super();
        this.service = service;

        reasons = new int[2];
        reasons[0] = reason;
        reasons[1] = reason;

        this.type = NotAuthorizedInterface.SERVICE;
    }

    public NotAuthorizedMediaException(ElementaryStream[] eStreams, int reasons[]){
        this.streams = eStreams;
        this.reasons = reasons;
        type = NotAuthorizedInterface.ELEMENTARY_STREAM;
    }

    public NotAuthorizedMediaException(Service s, int major_reason,int minor_reason) {
        type = NotAuthorizedInterface.SERVICE;
        reasons = new int[2];
        reasons[0] = major_reason;
        reasons[1] = minor_reason;
    }

    public int getType(){
        return type;
    }

    public Service getService(){
        return service;
    }

    public ElementaryStream[] getElementaryStreams()    {
        return streams;
    }

    public int[] getReason(int index) throws java.lang.IndexOutOfBoundsException{
        return reasons;
    }
}

