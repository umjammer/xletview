/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.mpeg;

public abstract class TransportStream {

    protected TransportStream(){
    }

    public int getTransportStreamId(){
        return 0;
    }

    public Service retrieveService(int serviceId){
        return null;
    }

    public Service[] retrieveServices()    {
        return new Service[1];
    }
}









