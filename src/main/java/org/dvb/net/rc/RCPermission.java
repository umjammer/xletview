/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.net.rc;

/**
 * @author Martin Sveden
 * @statuscode 2
 */
public class RCPermission extends java.security.BasicPermission {

    public RCPermission(String name) {
        super(name);
    }

    public RCPermission(String name, String actions) {
        super(name, actions);
    }

    @Override
    public boolean implies(java.security.Permission p) {
        return false;
    }
}
