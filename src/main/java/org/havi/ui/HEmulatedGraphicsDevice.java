/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;


public abstract class HEmulatedGraphicsDevice extends HGraphicsDevice{

    protected HEmulatedGraphicsDevice(){
    }

    public boolean setGraphicsConfiguration(HEmulatedGraphicsConfiguration hegc) throws SecurityException, org.havi.ui.HPermissionDeniedException, org.havi.ui.HConfigurationException{
        return (false);
    }
}
