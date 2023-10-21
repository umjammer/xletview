/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;


public interface HAdjustableLook extends HLook {

    int ADJUST_NONE = -1;

    int ADJUST_BUTTON_LESS = -2;

    int ADJUST_BUTTON_MORE = -3;

    int ADJUST_PAGE_LESS = -4;

    int ADJUST_PAGE_MORE = -5;

    int ADJUST_THUMB = -6;

    int hitTest(HOrientable component, java.awt.Point pt);

    java.lang.Integer getValue(HOrientable component, java.awt.Point pt);
}
