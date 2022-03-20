/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.resources;

public interface ResourceClient{

    public abstract boolean requestRelease(ResourceProxy proxy, Object requestData);

    public abstract void release(ResourceProxy proxy);

    public abstract void notifyRelease(ResourceProxy proxy);

}

