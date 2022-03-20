/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Sveden

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package net.beiker.xletview.ui;

import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.KeyStroke;

public class RemoteButton extends JButton {

    public RemoteButton(String text) {
        super(text);
        int enterCode = KeyEvent.VK_ENTER;
        getInputMap().put(KeyStroke.getKeyStroke(enterCode, 0, false), "pressed");
        getInputMap().put(KeyStroke.getKeyStroke(enterCode, 0, true), "released");
    }
    public boolean isDefaultCapable() {
        return false;
    }
}