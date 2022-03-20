/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;



public class HStaticRange extends HVisible implements HNoInputPreferred, HOrientable{

    public final static int SLIDER_BEHAVIOR = 0;

    public final static int SCROLLBAR_BEHAVIOR = 1;

    public HStaticRange(){
    }

    public HStaticRange(int orientation, int minimum, int maximum, int value, int x, int y, int width, int height){
    }

    public HStaticRange(int orientation, int minimum, int maximum, int value){
    }

    public void setLook(HLook hlook) throws HInvalidLookException{
    }

    public static void setDefaultLook(HRangeLook look){
    }

    public static HRangeLook getDefaultLook(){
        return (null);
    }

    public int getOrientation(){
        return(0);
    }

    public void setOrientation(int orient){
        return;
    }

    public boolean setRange(int minimum, int maximum){
        return (true);
    }

    public int getMinValue(){
        return (0);
    }

    public int getMaxValue(){
        return (0);
    }

    public void setValue(int value){
    }

    public int getValue(){
        return (0);
    }

    public void setThumbOffsets(int minOffset, int maxOffset){
    }

    public int getThumbMinOffset(){
        return(0);
    }

    public int getThumbMaxOffset(){
        return(0);
    }

    public void setBehavior(int behavior){
    }

    public int getBehavior(){
        return(0);
    }

}






