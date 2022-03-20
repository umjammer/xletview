/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.net.tuning;

public class TunerPermission extends java.security.BasicPermission{

    public TunerPermission(String name)    {
        super(name);
    }

    public TunerPermission(String name, String actions){
        super(name,actions);
    }

    public boolean implies (java.security.Permission p) {
        return false;
    }

}
