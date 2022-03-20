/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package org.havi.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.MenuContainer;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;

import org.havi.ui.event.HEventGroup;

import net.beiker.xletview.event.EventManager;
import net.beiker.xletview.util.Util;
import net.beiker.xletview.xlet.XletManager;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 2
 * @comment not complete
 */
public class HScene extends Container implements HComponentOrdering, ImageObserver, MenuContainer, Serializable {

	private static final net.beiker.cake.Logger log = net.beiker.cake.Log.getLogger(HScene.class);

    public static final int IMAGE_NONE = 0;
    public static final int IMAGE_STRETCH = 1;
    public static final int IMAGE_CENTER = 2;
    public static final int IMAGE_TILE = 3;
    public static final int NO_BACKGROUND_FILL = 0;
    public static final int BACKGROUND_FILL = 1;

    private int backgroundMode;
    private int renderMode;
    private boolean shortCutsEnabled;
    private Image bgImage;
    private HEventGroup eventGroup;
    private WindowListener windowListener;

    private Component focusedComponent;

    protected HScene() {

        setLayout(null);

        /* The default value of isVisible() should be false
         */
        setVisible(false);
        this.requestFocus();

        this.backgroundMode = NO_BACKGROUND_FILL;
        this.renderMode = IMAGE_NONE;
        this.shortCutsEnabled = true;

        XletManager.getInstance().addScene(this);
    }

    private int getComponentIndex(Component component) {
        Component components[] = getComponents();
        for (int i = 0; i < components.length; i++) {
            if (components[i] == component) {
                return i;
            }
        }
        return -1;
    }

    public Component add(Component comp) {
        return super.add(comp);
    }

    /**
     * Brings the component to the front.
     */
    public boolean popToFront(Component component) {
        int i = getComponentIndex(component);
        if (i != -1) {
            remove(i);
            add(component, 0);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Puts move just in front of behind
     */
    public boolean popInFrontOf(Component move, Component behind) {
        if (move == behind) {
            return true;
        }
        else if (getComponentIndex(move) == -1 || getComponentIndex(behind) == -1) {
            return false;
        }
        else {
            add(move, getComponentIndex(behind));
            return true;
        }
    }

    /**
     * Brings the component one step more to the front.
     * It changes order with the component before.
     */
    public boolean pop(Component component) {
        int i = getComponentIndex(component);
        if (i != -1 && --i != -1) {
            remove(i + 1);
            add(component, i);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Pushes the component one step back.
     */
    public boolean push(Component component) {
        int i = getComponentIndex(component);
        if (i != -1 && ++i < getComponentCount()) {
            remove(i - 1);
            add(component, i);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Pushes the component to the back.
     */
    public boolean pushToBack(Component component) {
        int i = getComponentIndex(component);
        if (i != -1) {
            remove(i);
            add(component);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Adds component just before front.
     */
    public Component addBefore(Component component, Component behind) {
        if (component == behind) {
            return component;
        }
        else if (getComponentIndex(behind) == -1) {
            return null;
        }
        else {
            return add(component, getComponentIndex(behind));

        }
    }

    /**
     * Adds component just behind front.
     */
    public Component addAfter(Component component, Component front) {
        if (component == front) {
            return component;
        }
        else if (getComponentIndex(component) != -1) {
            // it was already added
            popInFrontOf(front, component);
            return component;
        }
        else if (getComponentIndex(component) == -1) {
            add(component);
            popInFrontOf(front, component);
            return component;
        }
        else {
            return null;
        }

    }

    /**
     * Puts move just behind front.
     */
    public boolean pushBehind(Component move, Component front) {
        return popInFrontOf(front, move);
    }

    public void setVisible(boolean visible) {
        super.setVisible(visible);
    }

    public boolean isVisible() {
        return super.isVisible();
    }


    public void paint(java.awt.Graphics g) {
        super.paint(g);

        /*
         * 1. If the current background mode is BACKGROUND_FILL, the entire HScene is
         * first filled using the current background color
         */
        if(this.backgroundMode == BACKGROUND_FILL){
             g.setColor(this.getBackground());
             g.fillRect(0,0, this.getWidth(), this.getHeight());
        }

        /*
         * 2. If a background image has been set using the setBackgroundImage method, and
         * the current image rendering mode as set using setRenderMode is not IMAGE_NONE,
         * the specified image is painted. Scaling and tiling are performed according to
         * the render mode set.
         *
         * AT THE MOMENT WE DON'T SUPPORT ANY OTHER BACKGROUND MODE THAT IMAGE_NONE
         */


        /*
         * 3. Finally any children of the HScene are rendered in z-order.
         */

    }

    public void setBackgroundMode(int i) {
        this.backgroundMode = i;
    }

    public int getBackgroundMode() {
        return this.backgroundMode;
    }

    public void setBackgroundImage(Image image) {
        this.bgImage = image;
    }

    public java.awt.Image getBackgroundImage() {
        return this.bgImage;
    }

    public boolean setRenderMode(int mode) {

        /*
         * Note that the minimum requirement is to support only the IMAGE_NONE mode
         */

        if (mode == IMAGE_NONE) {
            this.renderMode = mode;
            return true;
        }
        else {
            return false;
        }
    }

    public int getRenderMode() {
        return this.renderMode;
    }

    public boolean isDoubleBuffered() {
        return false;
    }

    public boolean isOpaque() {
        return false;
    }

    public void addWindowListener(WindowListener wl) {
        this.windowListener = HEventMulticaster.add(this.windowListener, wl);
    }

    public void removeWindowListener(WindowListener wl) {
        this.windowListener = HEventMulticaster.remove(this.windowListener, wl);
    }

    protected void processWindowEvent(WindowEvent we) {
        int id = we.getID();
        switch(id) {
          case WindowEvent.WINDOW_ACTIVATED:
            this.windowListener.windowActivated(we);
            log.debug("processWindowEvent, activated");
          break;
          case WindowEvent.WINDOW_DEACTIVATED:
            this.windowListener.windowDeactivated(we);
            log.debug("processWindowEvent, deactivated");
          break;
        }
    }

//    protected void processFocusEvent(FocusEvent event){
//        Debug.write(this, "focus event");
//        super.processFocusEvent(event);
//
//    }

    public Component getFocusOwner() {
        Component c = EventManager.getInstance().getFocusOwner();
        boolean b = Util.isChildOf(this, c);
        if(b || c == this){
            return c;
        }
        else{
            return null;
        }
    }

    /**
     * @deprecated
     */
    public void show() {
        super.show();
    }

    public void dispose() {
        HSceneFactory.getInstance().dispose(this);
    }

    public boolean addShortcut(int keyCode, HActionable comp) {
        return (false);
    }

    public void removeShortcut(int keyCode) {
    }

    public HActionable getShortcutComponent(int keyCode) {
        return (null);
    }

    public void enableShortcuts(boolean enable) {
        this.shortCutsEnabled = enable;
    }

    public boolean isEnableShortcuts() {
        return this.shortCutsEnabled;
    }

    public int getShortcutKeycode(HActionable comp) {
        return 0;
    }

    public int[] getAllShortcutKeycodes() {
        return null;
    }

    public HScreenRectangle getPixelCoordinatesHScreenRectangle(Rectangle r) {
        HScreenRectangle hr = new HScreenRectangle(r.x, r.y, r.width, r.height);
        return hr;
    }

    public HSceneTemplate getSceneTemplate() {
        HSceneTemplate st = new HSceneTemplate();
        st.setPreference(HSceneTemplate.GRAPHICS_CONFIGURATION, new HGraphicsConfiguration(), HSceneTemplate.UNNECESSARY);
        return st;
    }

    public void setActive(boolean focus) {
    }

    public void setKeyEvents(HEventGroup keyCodes) {
        this.eventGroup = keyCodes;
    }

    public HEventGroup getKeyEvents() {
        return this.eventGroup;
    }

}
