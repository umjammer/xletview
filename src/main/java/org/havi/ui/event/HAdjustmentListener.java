/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Sved�n
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui.event;


public interface HAdjustmentListener extends java.util.EventListener{
    
    public abstract void valueChanged(org.havi.ui.event.HAdjustmentEvent e);

}