/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

public interface HAdjustmentInputPreferred extends HOrientable{

    public boolean getAdjustMode();

    public void setAdjustMode(boolean adjust);

    public void processHAdjustmentEvent(org.havi.ui.event.HAdjustmentEvent evt);
}








