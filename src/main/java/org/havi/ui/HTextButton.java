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

import net.beiker.xletview.helper.HActionableHelper;


/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class HTextButton extends HText implements HActionable{
	
	private HActionableHelper helper;
	
    private static HTextLook defaultHLook = new HTextLook();

    public HTextButton(){
        super();
        init();
    }

    public HTextButton(String textNormal, int x, int y, int width, int height){
        super(textNormal, x, y, width, height);
        init();
    }

    public HTextButton(String textNormal, int x, int y, int width, int height, Font font, Color foreground, Color background, HTextLayoutManager tlm){
        super(textNormal, x, y, width, height, font, foreground, background, tlm);
        init();
    }

    public HTextButton(String textNormal){
        super(textNormal);
        init();
    }

    public HTextButton(String textNormal, Font font, Color foreground, Color background, HTextLayoutManager tlm){
        super(textNormal, font, foreground, background, tlm);
        init();
    }
    // constructors end //
    
    private void init(){
    	helper = new HActionableHelper(this);
    }
    

    public static void setDefaultLook(HTextLook hLook){
        HTextButton.defaultHLook = hLook;
    }

    public static HTextLook getDefaultLook(){
        return HTextButton.defaultHLook;
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
