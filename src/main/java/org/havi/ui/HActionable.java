/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;


public interface HActionable extends HNavigable, HActionInputPreferred{
    
    public void addHActionListener(org.havi.ui.event.HActionListener l);

    public void removeHActionListener(org.havi.ui.event.HActionListener l);

    public void setActionCommand(String command);

    public void setActionSound(HSound sound);

    public HSound getActionSound();

}
