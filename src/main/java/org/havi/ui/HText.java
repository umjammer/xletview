/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import net.beiker.xletview.helper.HNavigableHelper;

import org.havi.ui.event.HFocusEvent;
import org.havi.ui.event.HFocusListener;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class HText extends HStaticText implements HNavigable{
    
	private HNavigableHelper helper;
	
    private static HTextLook defaultHLook = new HTextLook();


    public HText(){
        super();
        init();
    }

    public HText(String textNormal){
        super(textNormal);
        init();
    }

    public HText(String textNormal, String textFocus){
        this(textNormal);
        this.setTextContent(textFocus, HVisible.FOCUSED_STATE);
        init();
    }

    public HText(String textNormal, int x, int y, int width, int height){
        super(textNormal, x, y, width, height);
        init();
    }

    public HText(String textNormal, String textFocus, int x, int y, int width, int height){
        super(textNormal, x, y, width, height);
        this.setTextContent(textFocus, HVisible.FOCUSED_STATE);
        init();
    }

    public HText(String textNormal, Font font, Color foreground, Color background, HTextLayoutManager tlm){
        super(textNormal, font, foreground, background, tlm);
        init();
    }

    public HText(String textNormal, String textFocus, Font font, Color foreground, Color background, HTextLayoutManager tlm){
        super(textNormal, font, foreground, background, tlm);
        this.setTextContent(textFocus, HVisible.FOCUSED_STATE);
        init();
    }

    public HText(String textNormal, int x, int y, int width, int height, Font font, Color foreground, Color background, HTextLayoutManager tlm){
        super(textNormal, x, y, width, height, font, foreground, background, tlm);
        init();
    }

    public HText(String textNormal, String textFocus, int x, int y, int width, int height, Font font, Color foreground, Color background, HTextLayoutManager tlm){
        super(textNormal, x, y, width, height, font, foreground, background, tlm);
        this.setTextContent(textFocus, HVisible.FOCUSED_STATE);
        init();
    }
    // constructors end //
    
    private void init(){
    	helper = new HNavigableHelper(this);
    }
    
    public static void setDefaultLook(HTextLook defaultHLook){
        HText.defaultHLook = defaultHLook;
    }

    public static HTextLook getDefaultLook(){        
        return HText.defaultHLook;
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

    public synchronized void addHFocusListener(HFocusListener listener){
    	helper.addHFocusListener(listener);
    }

    public synchronized void removeHFocusListener(HFocusListener listener) {
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
        super.processFocusEvent(e);
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
