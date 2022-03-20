/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.media;

import org.davic.media.SubtitlingLanguageControl;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class SubtitleSelectedEvent extends java.util.EventObject {

    public SubtitleSelectedEvent(SubtitlingLanguageControl source){
        super(source);
    }

    public java.lang.Object getSource()    {
        return super.getSource();
    }
}


