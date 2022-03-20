/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;


public class HFlatEffectMatte implements HMatte, HAnimateEffect{

    public HFlatEffectMatte(){
    }

    public HFlatEffectMatte(float[] data){
    }

    public void setMatteData(float[] data){
    }

    public float[] getMatteData(){
        return (null);
    }

    public void start(){
        return;
    }

    public void stop(){
        return;
    }

    public boolean isAnimated(){
        return(false);
    }

    public void setPosition(int position){
        return;
    }

    public int getPosition(){
        return(0);
    }

    public void setRepeatCount(int count){
        return;
    }

    public int getRepeatCount(){
        return(0);
    }

    public void setDelay(int count){
        return;
    }

    public int getDelay(){
        return(0);
    }

    public void setPlayMode(int mode){
        return;
    }

    public int getPlayMode(){
        return(0);
    }
}
