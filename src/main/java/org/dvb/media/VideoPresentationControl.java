/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.media;

import javax.media.Control;

import org.havi.ui.HScreenRectangle;

public interface VideoPresentationControl extends Control {

    java.awt.Dimension getInputVideoSize();

    java.awt.Dimension getVideoSize();

    HScreenRectangle getActiveVideoArea();

    HScreenRectangle getActiveVideoAreaOnScreen();

    HScreenRectangle getTotalVideoArea();

    HScreenRectangle getTotalVideoAreaOnScreen();

    boolean supportsClipping();

    java.awt.Rectangle setClipRegion(java.awt.Rectangle clipRect);

    java.awt.Rectangle getClipRegion();

    float[] supportsArbitraryHorizontalScaling();

    float[] supportsArbitraryVerticalScaling();

    float[] getHorizontalScalingFactors();

    float[] getVerticalScalingFactors();

    byte POS_CAP_FULL = 0;

    byte POS_CAP_FULL_IF_ENTIRE_VIDEO_ON_SCREEN = 1;

    byte POS_CAP_FULL_EVEN_LINES = 3;

    byte POS_CAP_FULL_EVEN_LINES_IF_ENTIRE_VIDEO_ON_SCREEN = 4;

    byte POS_CAP_OTHER = -1;

    byte getPositioningCapability();
}
