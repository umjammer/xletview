/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
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
 * 
 * 
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

    public void setMatte(HMatte hmatte) throws HMatteException {
        hMatte = hmatte;
    }

    public HMatte getMatte() {
        return hMatte;
    }

    /*
        "true if all the drawing done during the update and paint methods for this
        specific HComponent object is automatically double buffered, or false if
        drawing is not double buffered. The default value for the double buffering
        setting is platform-specific"
    */
    public boolean isDoubleBuffered() {
        return false;
    }

    public boolean isOpaque() {
        /*
            " By default, the return value is false. The return value should be overridden by
            subclasses that can guarantee full opacity. The consequences of an invalid
            overridden value are implementation specific. "
        */
        return false;
    }

    public void setEnabled(boolean b) {
        enabled = b;
    }

    public boolean isEnabled() {
        return enabled;
    }

    protected void processEvent(AWTEvent awtevent) {
        super.processEvent(awtevent);
    }
    
	/**
	 * @see java.awt.Component#getGraphics()
	 */
	public Graphics getGraphics()
	{
		return DVBGraphics.getDVBGraphics(super.getGraphics());
	}

}
