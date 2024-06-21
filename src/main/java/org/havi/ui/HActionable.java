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


public interface HActionable extends HNavigable, HActionInputPreferred {

    void addHActionListener(org.havi.ui.event.HActionListener l);

    void removeHActionListener(org.havi.ui.event.HActionListener l);

    void setActionCommand(String command);

    void setActionSound(HSound sound);

    HSound getActionSound();

}
