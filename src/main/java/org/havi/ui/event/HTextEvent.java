/*
 * 
 * This file is part of XleTView Copyright (C) 2003 Martin Svedén
 * 
 * This is free software, and you are welcome to redistribute it under certain
 * conditions;
 * 
 * See LICENSE document for details.
 *  
 */

package org.havi.ui.event;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class HTextEvent extends java.awt.AWTEvent {

	public static final int TEXT_FIRST = HItemEvent.ITEM_LAST + 1;
	
	public static final int TEXT_START_CHANGE = TEXT_FIRST;
	public static final int TEXT_CHANGE       = TEXT_FIRST + 1;
	public static final int TEXT_CARET_CHANGE = TEXT_FIRST + 2;
	public static final int TEXT_END_CHANGE   = TEXT_FIRST + 3;
	public static final int CARET_NEXT_CHAR   = TEXT_FIRST + 4;
	public static final int CARET_NEXT_LINE   = TEXT_FIRST + 5;
	public static final int CARET_PREV_CHAR   = TEXT_FIRST + 6;
	public static final int CARET_PREV_LINE   = TEXT_FIRST + 7;
	public static final int CARET_NEXT_PAGE   = TEXT_FIRST + 8;
	public static final int CARET_PREV_PAGE   = TEXT_FIRST + 9;

	public static final int TEXT_LAST = CARET_PREV_PAGE;
	
	public HTextEvent(org.havi.ui.HKeyboardInputPreferred source, int id) {
		super(source, id);
	}

}
