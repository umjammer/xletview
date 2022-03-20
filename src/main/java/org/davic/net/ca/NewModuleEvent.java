/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.net.ca;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class NewModuleEvent extends CAEvent {

    private CAModule caModule;

    public NewModuleEvent(CAModule caModule, Object caModuleManager) {
        super(caModuleManager);
        this.caModule = caModule;
    }

    public CAModule getModule() {
        return caModule;
    }

    public Object getSource() {
        return super.getSource();
    }

}
