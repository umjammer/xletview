/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

public interface HAdjustmentValue extends HNavigable, HAdjustmentInputPreferred{
    
    public void setUnitIncrement(int increment);

    public int getUnitIncrement();
	
    public void setBlockIncrement(int increment);

    public int getBlockIncrement();

    public void addAdjustmentListener(org.havi.ui.event.HAdjustmentListener l);

    public void removeAdjustmentListener(org.havi.ui.event.HAdjustmentListener l);
    
    public void setAdjustmentSound(HSound sound);
        
    public HSound getAdjustmentSound();

}
