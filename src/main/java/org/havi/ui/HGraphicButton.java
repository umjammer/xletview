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

import net.beiker.xletview.helper.HActionableHelper;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class HGraphicButton extends HIcon implements HActionable{    

	private static final net.beiker.cake.Logger log = net.beiker.cake.Log.getLogger(HGraphicButton.class);
	
	private HActionableHelper helper;
	
	private static HGraphicLook defaultHLook    = new HGraphicLook();
	
    public HGraphicButton(){
    	super();
    	init();    	
    }

    public HGraphicButton(Image image){
    	super(image);
    	init();
    }
    
    public HGraphicButton(Image image, int x, int y, int width, int height){
    	super(image, x, y, width, height);
    	init();
    }

    public HGraphicButton(Image imageNormal, Image imageFocused, Image imageActioned, int x, int y, int width, int height){
    	super(imageNormal, x, y, width, height);
    	setGraphicContent(imageFocused, HVisible.FOCUSED_STATE);
    	setGraphicContent(imageActioned, HVisible.ACTIONED_STATE);
    	init();
    }

    public HGraphicButton(Image imageNormal, Image imageFocused,Image imageActioned){
    	this(imageNormal, imageFocused, imageActioned, 0, 0, 0, 0);
    }
    // constructors end //
    
    private void init(){
    	helper = new HActionableHelper(this);
    	log.debug("HGraphicButton - init");
    }

    public static void setDefaultLook(HGraphicLook hlook){
    	HGraphicButton.defaultHLook = hlook;
    }

    public static HGraphicLook getDefaultLook(){
        return HGraphicButton.defaultHLook;
    }

    public void addHActionListener(org.havi.ui.event.HActionListener listener){
        helper.addHActionListener(listener);
    }

    public void removeHActionListener(org.havi.ui.event.HActionListener listener){
        helper.removeHActionListener(listener);
    }

    public void setActionCommand(String command){
        helper.setActionCommand(command);
    }

    public void setActionSound(HSound sound){
    	helper.setActionSound(sound);
    }

    public HSound getActionSound(){
        return helper.getActionSound();
    }

    public void processHActionEvent(org.havi.ui.event.HActionEvent evt){
    	//Debug.write(this, "processHActionEvent");
    	int state = getInteractionState();
    	int newState = helper.getHActionEventResult(evt);
    	
    	if(state != newState){
    		setInteractionState(newState);
    	}
    }

    public java.lang.String getActionCommand(){
        return helper.getActionCommand();
    }
}
