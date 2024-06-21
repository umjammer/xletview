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


public interface HNavigable extends HNavigationInputPreferred {

    void setMove(int keyCode, HNavigable target);

    HNavigable getMove(int keyCode);

    void setFocusTraversal(HNavigable up, HNavigable down, HNavigable left, HNavigable right);

    boolean isSelected();

    void setGainFocusSound(HSound sound);

    void setLoseFocusSound(HSound sound);

    HSound getGainFocusSound();

    HSound getLoseFocusSound();

    void addHFocusListener(org.havi.ui.event.HFocusListener l);

    void removeHFocusListener(org.havi.ui.event.HFocusListener l);

}
