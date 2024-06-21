/*
 * This file is part of XleTView
 * Copyright (C) 2003 Martin SvedÈn
 *
 * This is free software, and you are
 * welcome to redistribute it under
 * certain conditions;
 *
 * See LICENSE document for details.
 */

package net.beiker.xletview.ui;

import java.awt.AWTEventMulticaster;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;


/**
 * A Button that fires key events.
 */
public class KeyButton extends Container implements MouseListener {

    private final Img image;
    private KeyListener keyListener;
    private Component listenerComponent;

    private final int keyCode;
    private final char theChar;

    public KeyButton(URL imgUrl, int width, int height, int keyCode, char ch) {
        image = new Img(imgUrl, width, height);
//        setSize(getPreferredSize());
        setSize(image.getSize());
        add(image);

        this.keyCode = keyCode;
        this.theChar = ch;

        addMouseListener(this);
    }

    public void setNormal() {
        image.setLocation(0, 0);
    }

    public void setOn() {
        image.setLocation(1, 1);
    }

    @Override
    public Dimension getPreferredSize() {
//        return new Dimension(image.getWidth(), image.getHeight());
        return new Dimension(getWidth(), getHeight());
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }

    @Override
    public void addKeyListener(KeyListener keyListener) {
        this.keyListener = AWTEventMulticaster.add(this.keyListener, keyListener);
    }

    public void setListenerComponent(Component c) {
        listenerComponent = c;
    }

    private void fireKeyEvent(int eventType) {
        if (keyListener != null) {

//            KeyEvent keyEvent = new KeyEvent(this, keyCode, 0L, 0, keyCode);
            KeyEvent keyEvent = null;
            switch (eventType) {
                case KeyEvent.KEY_PRESSED:
                    keyEvent = new KeyEvent(this, eventType, 0L, 0, keyCode, (char) keyCode);
                    keyListener.keyPressed(keyEvent);
                    break;
                case KeyEvent.KEY_RELEASED:
                    keyEvent = new KeyEvent(this, eventType, 0L, 0, keyCode, (char) keyCode);
                    keyListener.keyReleased(keyEvent);
                    break;
//                case KeyEvent.KEY_TYPED:
//                    keyEvent = new KeyEvent(this, eventType, 0L, 0, KeyEvent.VK_UNDEFINED);
//                    keyListener.keyTyped(keyEvent);
//                break;
            }
        }
    }

//#region implementing MouseListener

    @Override
    public void mouseClicked(MouseEvent e) {
        fireKeyEvent(KeyEvent.KEY_TYPED);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        setOn();
        fireKeyEvent(KeyEvent.KEY_PRESSED);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        setNormal();
        fireKeyEvent(KeyEvent.KEY_RELEASED);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

//#endregion
}
