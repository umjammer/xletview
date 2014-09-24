/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui.event;


public interface HTextListener extends java.util.EventListener{
    
    public abstract void textChanged(org.havi.ui.event.HTextEvent e);

    public abstract void caretMoved(org.havi.ui.event.HTextEvent e);

}
