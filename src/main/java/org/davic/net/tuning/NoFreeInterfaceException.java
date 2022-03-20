/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.net.tuning;

public class NoFreeInterfaceException extends NetworkInterfaceException {

    public NoFreeInterfaceException() {
        super();
    }

    public NoFreeInterfaceException(String reason) {
        super(reason);
    }

}

