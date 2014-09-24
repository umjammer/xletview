/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;


	public interface HNavigable extends HNavigationInputPreferred{
    
	public void setMove(int keyCode, HNavigable target);

    public HNavigable getMove(int keyCode);

    public void setFocusTraversal(HNavigable up, HNavigable down, HNavigable left, HNavigable right);

    public boolean isSelected();

    public void setGainFocusSound(HSound sound);

    public void setLoseFocusSound(HSound sound);

    public HSound getGainFocusSound();

    public HSound getLoseFocusSound();

	public void addHFocusListener(org.havi.ui.event.HFocusListener l);

	public void removeHFocusListener(org.havi.ui.event.HFocusListener l);

}
