/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Sveden

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package net.beiker.xletview.remotecontrol;

import java.net.URL;

import net.beiker.xletview.ui.KeyButton;

/**
 *
 * @author Martin Sveden
 */
public class RemoteButton extends KeyButton {

    public RemoteButton(URL imgUrl, int x, int y, int width, int height, int keyCode, char ch){
        super(imgUrl, width, height, keyCode, ch);
        this.setLocation(x, y);
    }



}
