/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

public interface HOrientable{

    public static final int ORIENT_LEFT_TO_RIGHT = 0;

    public static final int ORIENT_RIGHT_TO_LEFT = 1;

    public static final int ORIENT_TOP_TO_BOTTOM = 2;

    public static final int ORIENT_BOTTOM_TO_TOP = 3;

    public int getOrientation();

    public void setOrientation(int orient);
}
