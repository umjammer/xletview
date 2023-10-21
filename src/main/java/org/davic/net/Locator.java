/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.net;


/**
 *
 *
 * @author Martin Sveden
 * @statuscode 2
 * @comment check hasMultipleTransformations()
 */
public abstract class Locator implements xjavax.tv.locator.Locator {

    private String url;

    protected Locator() {
    }

    public Locator(String url) {
        this.url = url;
    }

    public String toString() {
        return "org.davic.net.Locator, url=" + url;
    }

    @Override
    public boolean hasMultipleTransformations() {
        return false;
    }

    @Override
    public String toExternalForm() {
        return url;
    }
}

