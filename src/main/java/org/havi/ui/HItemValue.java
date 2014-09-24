/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;


public interface HItemValue extends HNavigable,  HSelectionInputPreferred{
    
    public void addItemListener(org.havi.ui.event.HItemListener l);

    public void removeItemListener(org.havi.ui.event.HItemListener l);
    
    public void setSelectionSound(HSound sound);
        
    public HSound getSelectionSound();
 
}
