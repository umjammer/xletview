/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.media;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class MediaFreezeException extends javax.media.MediaException {

    public MediaFreezeException () {
        super();
    }

    public MediaFreezeException (String reason)    {
        super(reason);
    }
}

