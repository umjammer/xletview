/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

public interface HAdjustmentValue extends HNavigable, HAdjustmentInputPreferred {

    void setUnitIncrement(int increment);

    int getUnitIncrement();

    void setBlockIncrement(int increment);

    int getBlockIncrement();

    void addAdjustmentListener(org.havi.ui.event.HAdjustmentListener l);

    void removeAdjustmentListener(org.havi.ui.event.HAdjustmentListener l);

    void setAdjustmentSound(HSound sound);

    HSound getAdjustmentSound();

}
