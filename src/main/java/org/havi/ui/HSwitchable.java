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


public interface HSwitchable extends HActionable {

    boolean getSwitchableState();

    void setSwitchableState(boolean state);

    HSound getUnsetActionSound();

    void setUnsetActionSound(HSound sound);
}
