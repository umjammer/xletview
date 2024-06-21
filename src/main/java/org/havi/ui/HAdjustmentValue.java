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

public interface HAdjustmentValue extends HNavigable, HAdjustmentInputPreferred {

    int getUnitIncrement();

    void setUnitIncrement(int increment);

    int getBlockIncrement();

    void setBlockIncrement(int increment);

    void addAdjustmentListener(org.havi.ui.event.HAdjustmentListener l);

    void removeAdjustmentListener(org.havi.ui.event.HAdjustmentListener l);

    HSound getAdjustmentSound();

    void setAdjustmentSound(HSound sound);
}
