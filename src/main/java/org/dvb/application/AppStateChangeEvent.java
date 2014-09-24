/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.application;

import java.util.EventObject;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class AppStateChangeEvent  extends EventObject {
    
	private AppID appId;
	private int fromState;
	private int toState;
	private boolean hasFailed; 
	
    public AppStateChangeEvent(AppID appId, int fromState, int toState, Object source, boolean hasFailed) {
		super(source) ;
		this.appId = appId;
		this.fromState = fromState;
		this.toState = toState;
		this.hasFailed = hasFailed;
    }

    public AppID getAppID () {
		return appId;
    }
    
    public int getFromState () {
		return fromState;
    }

    public int getToState () {
		return toState;
    }

    public boolean hasFailed () {
		return hasFailed;
    }
}
