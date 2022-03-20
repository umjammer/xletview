/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Sveden

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package net.beiker.xletview.media;

/**
 * Represents a channel
 * @author Martin Sveden
 */
public class Channel {

    private String name;
    private Media media;

    public Channel(String name, Media media){
        this.name = name;
        this.media = media;
    }

    public String getName(){
        return name;
    }

    public Media getMedia(){
        return media;
    }

}
