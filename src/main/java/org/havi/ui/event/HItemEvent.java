/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui.event;


/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class HItemEvent extends java.awt.AWTEvent{
    
    public static final int ITEM_FIRST              = HAdjustmentEvent.ADJUST_LAST + 1;
    public static final int ITEM_START_CHANGE       = ITEM_FIRST;
    public static final int ITEM_TOGGLE_SELECTED    = ITEM_FIRST + 1;
    public static final int ITEM_SELECTED           = ITEM_FIRST + 2;
    public static final int ITEM_CLEARED            = ITEM_FIRST + 3;
    public static final int ITEM_SELECTION_CLEARED  = ITEM_FIRST + 4;
    public static final int ITEM_SET_CURRENT        = ITEM_FIRST + 5;
    public static final int ITEM_SET_PREVIOUS       = ITEM_FIRST + 6;  
    public static final int ITEM_SET_NEXT           = ITEM_FIRST + 7;
    public static final int SCROLL_MORE             = ITEM_FIRST + 8;
    public static final int SCROLL_LESS             = ITEM_FIRST + 9;
    public static final int SCROLL_PAGE_MORE        = ITEM_FIRST + 10;
    public static final int SCROLL_PAGE_LESS        = ITEM_FIRST + 11;
    public static final int ITEM_END_CHANGE         = ITEM_FIRST + 12;
    public static final int ITEM_LAST               = ITEM_FIRST + 12;

    private Object item;
    
    public HItemEvent(org.havi.ui.HSelectionInputPreferred source, int id, Object item){
	    super(source, id);
	    this.item = item;
    }

    public Object getItem(){
	    return item;
    }

}


