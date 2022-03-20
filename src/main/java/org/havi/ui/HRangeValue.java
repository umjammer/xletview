/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;


public class HRangeValue extends HRange implements HAdjustmentValue{

    public HRangeValue(){
    }

    public HRangeValue(int orientation, int minimum, int maximum, int value,int x, int y, int width, int height){
    }

    public HRangeValue(int orientation, int minimum, int maximum, int value){
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

    public void setUnitIncrement(int increment){
        return;
    }

    public int getUnitIncrement(){
        return(1);
    }

    public void setBlockIncrement(int increment){
        return;
    }

    public int getBlockIncrement(){
        return(1);
    }

    public void addAdjustmentListener(org.havi.ui.event.HAdjustmentListener l){
        return;
    }

    public void removeAdjustmentListener(org.havi.ui.event.HAdjustmentListener l){
        return;
    }

    public void setAdjustmentSound(HSound sound){
        return;
    }

    public HSound getAdjustmentSound(){
        return(null);
    }

    public boolean getAdjustMode(){
        return(true);
    }

    public void setAdjustMode(boolean adjust){
        return;
    }

    public void processHAdjustmentEvent(org.havi.ui.event.HAdjustmentEvent evt){
        return;
    }
}
