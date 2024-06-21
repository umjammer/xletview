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


public interface HItemValue extends HNavigable, HSelectionInputPreferred {

    void addItemListener(org.havi.ui.event.HItemListener l);

    void removeItemListener(org.havi.ui.event.HItemListener l);

    HSound getSelectionSound();

    void setSelectionSound(HSound sound);
}
