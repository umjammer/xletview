/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;


public class HRange extends HStaticRange implements HNavigable{

    public HRange(){
    }

    public HRange(int orientation, int minimum, int maximum, int value, int x, int y, int width, int height){
    }

    public HRange(int orientation, int minimum, int maximum, int value){
    }

    public static void setDefaultLook(HRangeLook look){
    }

    public static HRangeLook getDefaultLook(){
        return (null);
    }

    public void setMove(int keyCode, HNavigable target){
        return;
    }

    public HNavigable getMove(int keyCode){
        return(null);
    }

    public void setFocusTraversal(HNavigable up, HNavigable down, HNavigable left, HNavigable right){
        return;
    }

    public boolean isSelected(){
        return(false);
    }

    public void setGainFocusSound(HSound sound){
        return;
    }

    public void setLoseFocusSound(HSound sound){
        return;
    }

    public HSound getGainFocusSound(){
        return(null);
    }

    public HSound getLoseFocusSound(){
        return(null);
    }

    public void addHFocusListener(org.havi.ui.event.HFocusListener l){
        return;
    }


    public void removeHFocusListener(org.havi.ui.event.HFocusListener l){
        return;
    }

    public int[] getNavigationKeys(){
        return(null);
    }

    public void processHFocusEvent(org.havi.ui.event.HFocusEvent evt){
        return;
    }
}
