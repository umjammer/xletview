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

public class HRangeLook implements HAdjustableLook{

    public HRangeLook(){
    }

    public void showLook(java.awt.Graphics g, HVisible visible, int state){
        return;
    }

    public void widgetChanged (HVisible visible, HChangeData[] changes){
        return;
    }

    public Dimension getMinimumSize(HVisible hvisible){
        return(null);
    }

    public Dimension getPreferredSize(HVisible hvisible){
        return(null);
    }

    public Dimension getMaximumSize(HVisible hvisible){
        return(null);
    }

    public boolean isOpaque(HVisible visible){
        return(false);
    }

    public java.awt.Insets getInsets(HVisible visible){
        return(null);
    }

    public int hitTest(HOrientable component, java.awt.Point pt){
        return(0);
    }

    public java.lang.Integer getValue(HOrientable component, java.awt.Point pt){
        return(null);
    }
}








