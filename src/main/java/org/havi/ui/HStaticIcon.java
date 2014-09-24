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


/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class HStaticIcon extends HVisible implements HNoInputPreferred{

    private static HGraphicLook defaultHLook = new HGraphicLook();

    public HStaticIcon(){
    	this(null, 0, 0, 0, 0);
    }

    public HStaticIcon(Image imageNormal, int x, int y, int width, int height){
        super(defaultHLook, x, y, width, height);        
    	this.setGraphicContent(imageNormal, HVisible.NORMAL_STATE);
    }

    public HStaticIcon(Image imageNormal){
    	this(null, 0, 0, 0, 0);
        this.setGraphicContent(imageNormal, HVisible.NORMAL_STATE);
    }

    public void setLook(HLook hLook) throws HInvalidLookException{
    	if(hLook instanceof HGraphicLook || hLook == null ){
    		super.setLook(hLook);
    	}
    	else{
    		throw new HInvalidLookException("HLook was not a org.havi.ui.HGraphicLook");
    	}    	
    }

    public static void setDefaultLook(HGraphicLook hGraphicLook){
    	HStaticIcon.defaultHLook = hGraphicLook;
    }

    public static HGraphicLook getDefaultLook(){
        return HStaticIcon.defaultHLook;
    }
    
    public String toString(){
    	return super.toString() + " img:" + getGraphicContent(getInteractionState());
    }
}
