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

    @Override
    public void start(){
    }

    @Override
    public void stop(){
    }

    @Override
    public boolean isAnimated(){
        return(false);
    }

    @Override
    public void setPosition(int position){
    }

    @Override
    public int getPosition(){
        return(0);
    }

    @Override
    public void setRepeatCount(int count){
    }

    @Override
    public int getRepeatCount(){
        return(0);
    }

    @Override
    public void setDelay(int count){
    }

    @Override
    public int getDelay(){
        return(0);
    }

    @Override
    public void setPlayMode(int mode){
    }

    @Override
    public int getPlayMode(){
        return(0);
    }
}
