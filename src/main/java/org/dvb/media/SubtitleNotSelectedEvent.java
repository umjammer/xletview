/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package org.dvb.media;

import java.util.EventObject;

import org.davic.media.SubtitlingLanguageControl;


/**
 * SubtitleNotSelectedEvent
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class SubtitleNotSelectedEvent extends EventObject {

    public SubtitleNotSelectedEvent(SubtitlingLanguageControl source) {
        super(source);
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }
}


