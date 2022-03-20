/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.si;

public class SIRequest {

    protected SIRequest() {
    }

    public boolean isAvailableInCache() {
        return true;
    }

    public boolean cancelRequest() {
        return true;
    }

}

