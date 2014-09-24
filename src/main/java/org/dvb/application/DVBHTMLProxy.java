/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.application ;

public interface DVBHTMLProxy extends AppProxy {
	
	public static final int LOADING = 6;
	public static final int KILLED = 7;
    
	public void prefetch () ;
    
	public void startTrigger (java.util.Date starttime) ;
    
	public void trigger (java.util.Date time, Object triggerPayload) ;
}

