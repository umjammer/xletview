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
public class HAdjustmentEvent extends java.awt.AWTEvent{

    public static final int ADJUST_FIRST = RESERVED_ID_MAX + 1;
    public static final int ADJUST_LAST = ADJUST_FIRST + 5;
    public static final int ADJUST_START_CHANGE = ADJUST_FIRST;
    public static final int ADJUST_LESS = ADJUST_FIRST + 1;
    public static final int ADJUST_MORE = ADJUST_FIRST + 2;
    public static final int ADJUST_PAGE_LESS = ADJUST_FIRST + 3;
    public static final int ADJUST_PAGE_MORE = ADJUST_FIRST + 4;
    public static final int ADJUST_END_CHANGE = ADJUST_FIRST + 5;
    
    public HAdjustmentEvent(org.havi.ui.HAdjustmentInputPreferred source, int id){
	    super(source, id);
    }
}
