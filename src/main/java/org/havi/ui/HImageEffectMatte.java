/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

import java.awt.Image;
import java.awt.Point;


public class HImageEffectMatte implements HMatte, HAnimateEffect{
    
    public HImageEffectMatte(){
    }

    public HImageEffectMatte(Image[] data){
    }

    public void setMatteData(Image[] data){
    }

    public Image[] getMatteData(){
        return (null);
    }

    public void setOffset(Point p, int index){
    }

    public Point getOffset(int index){
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
