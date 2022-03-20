/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.dsmcc;

import org.davic.net.Locator;


/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class ServiceXFRReference  {

    private byte[] nsapAddress;
    private String pathName;
    private Locator locator;
    private int carouselId;


    public ServiceXFRReference(Locator serviceLocator, int carouselId, String pathName) {
        this.locator = serviceLocator;
        this.carouselId = carouselId;
        this.pathName = pathName;
    }

    public ServiceXFRReference(byte[] nsapAddress, String pathName){
        this.nsapAddress = nsapAddress;
        this.pathName = pathName;
    }

    public Locator getLocator(){
        return locator;
    }

    public int getCarouselId(){
        return carouselId;
    }

    public String getPathName(){
        return pathName;
    }

    public byte[] getNSAPAddress(){
        return nsapAddress;
    }

}
