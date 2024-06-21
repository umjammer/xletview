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

package xjavax.tv.service.selection;

import net.beiker.xletview.media.VideoLayer;
import xjavax.tv.locator.Locator;
import xjavax.tv.service.SIRequest;
import xjavax.tv.service.SIRequestor;
import xjavax.tv.service.Service;
import xjavax.tv.service.ServiceType;


/**
 * @author Martin Sveden
 * @statuscode 2
 */
public class ServiceContextImpl implements ServiceContext, Service, Locator, SIRequest {

    private final static ServiceContextImpl THEINSTANCE = new ServiceContextImpl();

    private ServiceContextImpl() {
    }

    @Override
    public ServiceContentHandler[] getServiceContentHandlers() throws SecurityException {
        ServiceContentHandler[] aservicecontenthandler = new ServiceContentHandler[1];
        aservicecontenthandler[0] = VideoLayer.getInstance();
        return aservicecontenthandler;
    }

    public boolean isDestroyed() {
        return false;
    }

    // implementing ServiceContext
    @Override
    public void addListener(xjavax.tv.service.selection.ServiceContextListener scl) {
    }

    @Override
    public void removeListener(xjavax.tv.service.selection.ServiceContextListener scl) {
    }

    @Override
    public void select(xjavax.tv.service.Service s) {
    }

    @Override
    public void select(xjavax.tv.locator.Locator[] l) {
    }

    @Override
    public void stop() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public Service getService() {
        return THEINSTANCE;
    }
    // implementing ServiceContext ends

    // implementing Service
    public boolean equals(java.lang.Object obj) {
        return false;
    }

    @Override
    public Locator getLocator() {
        return THEINSTANCE;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public ServiceType getServiceType() {
        return null;//new ServiceType("DIGITAL_TV");
    }

    public int hashCode() {
        return 0;
    }

    @Override
    public boolean hasMultipleInstances() {
        return false;
    }

    @Override
    public SIRequest retrieveDetails(SIRequestor requestor) {
        return THEINSTANCE;
    }
    // implementing Service ends

    // implementing Locator
    /* already exist
    public boolean equals(java.lang.Object o){
        return false;
    }*/
    /* already exist
    public int hashCode(){
        return 0;
    }
    */
    @Override
    public boolean hasMultipleTransformations() {
        return false;
    }

    @Override
    public java.lang.String toExternalForm() {
        return "";
    }

    public java.lang.String toString() {
        return "ServiceContextImpl";
    }
    // implementing Locator end

    // implementing SIRequestor
    @Override
    public boolean cancel() {
        return false;
    }


    public static ServiceContext getInstance() {
        return THEINSTANCE;
    }


}
