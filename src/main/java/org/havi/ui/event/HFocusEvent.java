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
public class HFocusEvent extends java.awt.event.FocusEvent{

    public static final int HFOCUS_FIRST   = HTextEvent.TEXT_LAST + 1;
    public static final int FOCUS_TRANSFER = HFOCUS_FIRST;
    public static final int HFOCUS_LAST    = FOCUS_TRANSFER;
    public static final int NO_TRANSFER_ID = -1;

    private int transferId = NO_TRANSFER_ID;

    public HFocusEvent(java.awt.Component source, int id){
        super(source, id, false);
    }

    public HFocusEvent(java.awt.Component source, int id, int transferId){
        super(source, id, false);
        this.transferId = transferId;
    }

    public boolean isTemporary(){
        return false;
    }

    public int getTransferId(){
        return transferId;
    }
    
    /**
     * Returns a parameter string identifying this event.
     * This method is useful for event-logging and for debugging.
     *
     * @return a string identifying the event and its attributes
     */
    public String paramString() {
    	String result = null;
    	if(id == FOCUS_TRANSFER) {
			result = "FOCUS_TRANSFER";
			switch (transferId) {
				case NO_TRANSFER_ID :
					result += ",NO_TRANSFER_ID";
					break;

				default :
					result += ", transferId=" + transferId;
					break;
			}
    	}
    	if(result == null){
    		return super.paramString();
    	}
    	else{
    		return result;
    	}
    	
    }

}
