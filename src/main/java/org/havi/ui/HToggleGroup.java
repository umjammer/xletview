/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;


public class HToggleGroup{

    public HToggleGroup(){
    }

    public HToggleButton getCurrent(){
        return (null);
    }

    public void setCurrent(HToggleButton selection){
    }

    public void setForcedSelection(boolean forceSelection){
    }
    
    public boolean getForcedSelection(){
		return (false);
    }
            
    public void setEnabled(boolean enable){
    }
    
    public boolean isEnabled(){
		return (true);
    }

    protected void add(HToggleButton button){
    }

    protected void remove(HToggleButton button){
    }
    
}

