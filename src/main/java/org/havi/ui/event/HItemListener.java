/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui.event;


public interface HItemListener extends java.util.EventListener{

    public abstract void selectionChanged(org.havi.ui.event.HItemEvent e);

    public abstract void currentItemChanged(org.havi.ui.event.HItemEvent e);

}

