/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.media;

public interface SubtitlingLanguageControl extends LanguageControl {

    public boolean isSubtitlingOn();

    public boolean setSubtitling(boolean new_value);
}

