/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.net.ca;

import org.davic.mpeg.ElementaryStream;
import org.davic.mpeg.Service;
import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;

public class DescramblerProxy implements ResourceProxy {

  public DescramblerProxy(ResourceClient c){
  }


    public void startDescramblingDialog(Service s) throws CAException,  org.davic.mpeg.NotAuthorizedException {
    }

    public void startDescramblingDialog(ElementaryStream[] streams) throws CAException, org.davic.mpeg.NotAuthorizedException  {
    }


    public synchronized CAModule startDescrambling(Service s, Object requestData) throws CAException, org.davic.mpeg.NotAuthorizedException {
        return null;
    }

    public synchronized CAModule startDescrambling(ElementaryStream[] streams, Object requestData) throws CAException, org.davic.mpeg.NotAuthorizedException {
        return null;
    }

    public synchronized void startDescrambling(Service s, CAModule module, Object requestData) throws CAException, org.davic.mpeg.NotAuthorizedException {
    }

    public synchronized void startDescrambling(ElementaryStream[] streams, CAModule module, Object requestData) throws CAException, org.davic.mpeg.NotAuthorizedException {
    }

    public void stopDescrambling() throws CAException {}

    public void stopDescrambling(ElementaryStream[] streams) throws CAException {}

    public void addDescramblerListener(DescramblerListener l) {
    }

    public void removeDescramblerListener(DescramblerListener l) {
    }

    public CAModule getCAModule() {
        return null;
    }

    public ResourceClient getClient() {
        return null;
    }

    public ElementaryStream[] getElementaryStreams() {
        return null;
    }

}

