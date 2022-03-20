/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;


public interface HLook    extends Cloneable{

    public abstract void showLook(Graphics g, HVisible hvisible, int i);

    public abstract void widgetChanged(HVisible hvisible, HChangeData ahchangedata[]);

    public abstract Dimension getMinimumSize(HVisible hvisible);

    public abstract Dimension getPreferredSize(HVisible hvisible);

    public abstract Dimension getMaximumSize(HVisible hvisible);

    public abstract boolean isOpaque(HVisible hvisible);

    public abstract Insets getInsets(HVisible hvisible);
}
