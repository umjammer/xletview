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

    boolean getAdjustMode();

    void setAdjustMode(boolean adjust);

    void processHAdjustmentEvent(org.havi.ui.event.HAdjustmentEvent evt);
}








