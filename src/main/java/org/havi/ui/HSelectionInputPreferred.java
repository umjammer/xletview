/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;


public interface HSelectionInputPreferred extends HOrientable{
    public boolean getSelectionMode();

    public void setSelectionMode(boolean edit);

    public void processHItemEvent(org.havi.ui.event.HItemEvent evt);
}








