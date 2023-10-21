/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

import java.awt.Image;


public class HToggleButton extends HGraphicButton implements HSwitchable {

    public HToggleButton() {
    }

    public HToggleButton(Image image, int x, int y, int width, int height) {
    }

    public HToggleButton(Image image) {
    }

    public HToggleButton(Image image, int x, int y, int width, int height, boolean state) {
    }

    public HToggleButton(Image imageNormal, Image imageFocused, Image imageActioned, Image imageNormalActioned, int x, int y, int width, int height, boolean state) {
    }

    public HToggleButton(Image imageNormal, Image imageFocused, Image imageActioned, Image imageNormalActioned, boolean state) {
    }

    public HToggleButton(Image image, int x, int y, int width, int height, boolean state, HToggleGroup group) {
    }

    public HToggleButton(Image image, boolean state, HToggleGroup group) {
    }

    public HToggleButton(Image imageNormal, Image imageFocused, Image imageActioned, Image imageNormalActioned, int x, int y, int width, int height, boolean state, HToggleGroup group) {
    }

    public HToggleButton(Image imageNormal, Image imageFocused, Image imageActioned, Image imageNormalActioned, boolean state, HToggleGroup group) {
    }

    public void setToggleGroup(HToggleGroup group) {
    }

    public HToggleGroup getToggleGroup() {
        return (null);
    }

    public void removeToggleGroup() {
    }

    public static void setDefaultLook(HGraphicLook hlook) {
    }

    public static HGraphicLook getDefaultLook() {
        return (null);
    }

    @Override
    public boolean getSwitchableState() {
        return (false);
    }

    @Override
    public void setSwitchableState(boolean state) {
    }

    @Override
    public void setUnsetActionSound(HSound sound) {
    }

    @Override
    public HSound getUnsetActionSound() {
        return (null);
    }
}
