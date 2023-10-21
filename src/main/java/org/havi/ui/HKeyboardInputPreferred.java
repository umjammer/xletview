/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

public interface HKeyboardInputPreferred{

    int INPUT_NUMERIC    = 1;
    int INPUT_ALPHA      = 2;
    int INPUT_ANY        = 4;
    int INPUT_CUSTOMIZED = 8;

    boolean getEditMode();

    void setEditMode(boolean edit);

    int getType();

    char[] getValidInput();

    void processHTextEvent(org.havi.ui.event.HTextEvent evt);

    void processHKeyEvent(org.havi.ui.event.HKeyEvent evt);



}









