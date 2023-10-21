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

    void showLook(Graphics g, HVisible hvisible, int i);

    void widgetChanged(HVisible hvisible, HChangeData[] ahchangedata);

    Dimension getMinimumSize(HVisible hvisible);

    Dimension getPreferredSize(HVisible hvisible);

    Dimension getMaximumSize(HVisible hvisible);

    boolean isOpaque(HVisible hvisible);

    Insets getInsets(HVisible hvisible);
}
