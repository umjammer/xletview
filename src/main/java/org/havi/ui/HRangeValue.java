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


public class HRangeValue extends HRange implements HAdjustmentValue {

    public HRangeValue() {
    }

    public HRangeValue(int orientation, int minimum, int maximum, int value, int x, int y, int width, int height) {
    }

    public HRangeValue(int orientation, int minimum, int maximum, int value) {
    }

    public static void setDefaultLook(HRangeLook look) {
    }

    public static HRangeLook getDefaultLook() {
        return (null);
    }

    @Override
    public void setMove(int keyCode, HNavigable target) {
    }

    @Override
    public HNavigable getMove(int keyCode) {
        return (null);
    }

    @Override
    public void setFocusTraversal(HNavigable up, HNavigable down, HNavigable left, HNavigable right) {
    }

    @Override
    public boolean isSelected() {
        return (false);
    }

    @Override
    public void setGainFocusSound(HSound sound) {
    }

    @Override
    public void setLoseFocusSound(HSound sound) {
    }

    @Override
    public HSound getGainFocusSound() {
        return (null);
    }

    @Override
    public HSound getLoseFocusSound() {
        return (null);
    }

    @Override
    public void addHFocusListener(org.havi.ui.event.HFocusListener l) {
    }


    @Override
    public void removeHFocusListener(org.havi.ui.event.HFocusListener l) {
    }

    @Override
    public int[] getNavigationKeys() {
        return (null);
    }

    @Override
    public void processHFocusEvent(org.havi.ui.event.HFocusEvent evt) {
    }

    @Override
    public void setUnitIncrement(int increment) {
    }

    @Override
    public int getUnitIncrement() {
        return (1);
    }

    @Override
    public void setBlockIncrement(int increment) {
    }

    @Override
    public int getBlockIncrement() {
        return (1);
    }

    @Override
    public void addAdjustmentListener(org.havi.ui.event.HAdjustmentListener l) {
    }

    @Override
    public void removeAdjustmentListener(org.havi.ui.event.HAdjustmentListener l) {
    }

    @Override
    public void setAdjustmentSound(HSound sound) {
    }

    @Override
    public HSound getAdjustmentSound() {
        return (null);
    }

    @Override
    public boolean getAdjustMode() {
        return (true);
    }

    @Override
    public void setAdjustMode(boolean adjust) {
    }

    @Override
    public void processHAdjustmentEvent(org.havi.ui.event.HAdjustmentEvent evt) {
    }
}
