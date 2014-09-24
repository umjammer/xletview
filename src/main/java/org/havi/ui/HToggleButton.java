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


public class HToggleButton extends HGraphicButton implements HSwitchable{
    
	public HToggleButton(){
    }

    public HToggleButton(Image image, int x, int y, int width, int height){
    }

    public HToggleButton(Image image){
    }

    public HToggleButton(Image image, int x, int y, int width, int height, boolean state){
    }

    public HToggleButton(Image imageNormal, Image imageFocused, Image imageActioned, Image imageNormalActioned, int x, int y, int width, int height, boolean state){
    }

    public HToggleButton(Image imageNormal, Image imageFocused, Image imageActioned, Image imageNormalActioned, boolean state){
    }

    public HToggleButton(Image image, int x, int y, int width, int height, boolean state, HToggleGroup group){
    }

    public HToggleButton(Image image, boolean state, HToggleGroup group){
    }

    public HToggleButton(Image imageNormal, Image imageFocused, Image imageActioned, Image imageNormalActioned, int x, int y, int width, int height, boolean state, HToggleGroup group){
    }

    public HToggleButton(Image imageNormal, Image imageFocused, Image imageActioned, Image imageNormalActioned, boolean state, HToggleGroup group){
    }

    public void setToggleGroup(HToggleGroup group){
    }

    public HToggleGroup getToggleGroup(){
        return (null);
    }

    public void removeToggleGroup(){
    }

    public static void setDefaultLook(HGraphicLook hlook){
    }

    public static HGraphicLook getDefaultLook(){
        return (null);
    }

    public boolean getSwitchableState(){
        return(false);
    }
    
    public void setSwitchableState(boolean state){
        return;
    }
    
    public void setUnsetActionSound(HSound sound){
        return;
    }
    
    public HSound getUnsetActionSound(){
        return(null);
    }

}
