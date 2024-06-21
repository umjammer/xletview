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

package org.havi.ui;

public interface HOrientable {

    int ORIENT_LEFT_TO_RIGHT = 0;

    int ORIENT_RIGHT_TO_LEFT = 1;

    int ORIENT_TOP_TO_BOTTOM = 2;

    int ORIENT_BOTTOM_TO_TOP = 3;

    int getOrientation();

    void setOrientation(int orient);
}
