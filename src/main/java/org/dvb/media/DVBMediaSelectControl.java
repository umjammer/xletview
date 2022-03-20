/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.media;

import xjavax.tv.locator.InvalidLocatorException;
import xjavax.tv.locator.Locator;
import xjavax.tv.service.selection.InsufficientResourcesException;
import xjavax.tv.service.selection.InvalidServiceComponentException;

public interface DVBMediaSelectControl extends xjavax.tv.media.MediaSelectControl{

        public void selectServiceMediaComponents(Locator l) throws
                        InvalidLocatorException,InvalidServiceComponentException,
                        InsufficientResourcesException;

}

