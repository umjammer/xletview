/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;


public interface HSwitchable extends HActionable{

    public boolean getSwitchableState();

    public void setSwitchableState(boolean state);

    public void setUnsetActionSound(HSound sound);

    public HSound getUnsetActionSound();
}
