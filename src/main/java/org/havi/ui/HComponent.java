/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package org.havi.ui;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Graphics;

import org.dvb.ui.DVBGraphics;
import org.dvb.ui.TestOpacity;


/**
 * @author Martin Sveden
 * @statuscode 4
 */
public abstract class HComponent extends Component implements HMatteLayer, TestOpacity {

    private HMatte hMatte;
    private boolean enabled;

    public HComponent() {
        // " HComponent are enabled initially by default. "
        enabled = true;
    }

    public HComponent(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
    }

    @Override
    public HMatte getMatte() {
        return hMatte;
    }

    @Override
    public void setMatte(HMatte hmatte) throws HMatteException {
        hMatte = hmatte;
    }

    /**
     * "true if all the drawing done during the update and paint methods for this
     * specific HComponent object is automatically double buffered, or false if
     * drawing is not double buffered. The default value for the double buffering
     * setting is platform-specific"
     */
    @Override
    public boolean isDoubleBuffered() {
        return false;
    }

    @Override
    public boolean isOpaque() {
        // " By default, the return value is false. The return value should be overridden by
        //  subclasses that can guarantee full opacity. The consequences of an invalid
        //  overridden value are implementation specific. "
        return false;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean b) {
        enabled = b;
    }

    @Override
    protected void processEvent(AWTEvent awtevent) {
        super.processEvent(awtevent);
    }

    /**
     * @see java.awt.Component#getGraphics()
     */
    @Override
    public Graphics getGraphics() {
        return DVBGraphics.getDVBGraphics(super.getGraphics());
    }
}
