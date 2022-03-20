/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;


public interface HAdjustableLook extends HLook{

    public static final int ADJUST_NONE = -1;

    public static final int ADJUST_BUTTON_LESS = -2;

    public static final int ADJUST_BUTTON_MORE = -3;

    public static final int ADJUST_PAGE_LESS = -4;

    public static final int ADJUST_PAGE_MORE = -5;

    public static final int ADJUST_THUMB = -6;

    public int hitTest(HOrientable component, java.awt.Point pt);

    public java.lang.Integer getValue(HOrientable component, java.awt.Point pt);
}
