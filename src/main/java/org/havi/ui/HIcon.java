/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Sved�n
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import net.beiker.xletview.helper.HNavigableHelper;

import org.havi.ui.event.HFocusEvent;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class HIcon extends HStaticIcon implements HNavigable{

	private static final net.beiker.cake.Logger log = net.beiker.cake.Log.getLogger(HIcon.class);
	
	
	private HNavigableHelper helper;
	
	
    private static HGraphicLook defaultHLook    = new HGraphicLook();


    public HIcon(){
    	super();
    	init();
    }

    public HIcon(Image image){
        super(image);
        init();
    }

    public HIcon(Image image, int x, int y, int width, int height){
        super(image, x, y, width, height);
        init();
    }

    public HIcon(Image imageNormal, Image imageFocus, int x, int y, int width, int height){
        super(imageNormal, x, y, width, height);
        setGraphicContent(imageFocus, HVisible.FOCUSED_STATE);
        init();

    }
    // constructors end //
    
    private void init(){
    	helper = new HNavigableHelper(this);
    	log.debug("HIcon - init");
    }

    public static void setDefaultLook(HGraphicLook hGraphicLook){
        HIcon.defaultHLook = hGraphicLook;
    }

    public static HGraphicLook getDefaultLook(){
        return HIcon.defaultHLook;
    }

    public void setMove(int keyCode, HNavigable target){
    	helper.setMove(keyCode, target);
    }

    public HNavigable getMove(int keyCode){
    	return helper.getMove(keyCode);
    }

    public void setFocusTraversal(HNavigable up, HNavigable down, HNavigable left, HNavigable right){
    	helper.setFocusTraversal(up, down, left, right);
    }

    public boolean isSelected(){
    	return helper.isSelected();
    }

    public void setGainFocusSound(HSound sound){
    	helper.setGainFocusSound(sound);
    }

    public void setLoseFocusSound(HSound sound){
    	helper.setLoseFocusSound(sound);
    }

    public HSound getGainFocusSound(){
    	return helper.getGainFocusSound();
    }

    public HSound getLoseFocusSound(){
    	return helper.getLoseFocusSound();
    }

    public synchronized void addHFocusListener(org.havi.ui.event.HFocusListener listener){
    	helper.addHFocusListener(listener);
    }

    public synchronized void removeHFocusListener(org.havi.ui.event.HFocusListener listener){
    	helper.removeHFocusListener(listener);
    }

    public int[] getNavigationKeys(){
    	return helper.getNavigationKeys();
    }
    
    /*
     Overloaded from HVisible, is true for HNavigable
     */
    public boolean isFocusTraversable() {
    	return true;
    }
    
    /**
     * Since the Component will not get focus unless there is
     * a FocusListener registered we "secretly" add one in the
     * helper.
     * We don't want this secret one to be returned when someone
     * asks for the FocusListener objects.
     * This mehod overrides Component.getFocusListeners()
     * and takes care of that.
     */
    public synchronized FocusListener[] getFocusListeners(){
    	return helper.getFocusListeners();
    }
    

    public void processFocusEvent(FocusEvent e){
    	//super.processFocusEvent(e);
    	HFocusEvent event = new HFocusEvent(this, e.getID());
    	processHFocusEvent(event);
    	
    }

    
    public void processHFocusEvent(HFocusEvent evt) {
    	int state = getInteractionState();
    	int newState = helper.getHFocusEventResult(evt);
    	
    	if(state != newState){
    		setInteractionState(newState);
    	}
    }
}
