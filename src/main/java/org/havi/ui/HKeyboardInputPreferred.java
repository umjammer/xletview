/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

public interface HKeyboardInputPreferred{
    
    public static final int INPUT_NUMERIC    = 1;
    public static final int INPUT_ALPHA      = 2;
    public static final int INPUT_ANY        = 4;
    public static final int INPUT_CUSTOMIZED = 8;

    public boolean getEditMode();

    public void setEditMode(boolean edit);

    public int getType();

    public char[] getValidInput();

    public void processHTextEvent(org.havi.ui.event.HTextEvent evt);

    public void processHKeyEvent(org.havi.ui.event.HKeyEvent evt);



}









