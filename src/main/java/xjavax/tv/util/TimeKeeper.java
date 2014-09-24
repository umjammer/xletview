/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.util;



/**
 * 
 * @author Martin Sveden
 */
class TimeKeeper {

	private TVTimerSpec spec;
	
	/**
	 * Used by TVTimerImpl, is set to
	 * when it should go off
	 */
	private long timerTime = -1;
	
	private boolean scheduled;
	
	TimeKeeper(TVTimerSpec spec){	
		this.spec = spec;
		if(!spec.isAbsolute()){
			timerTime = spec.getTime() + System.currentTimeMillis();
		}
		else{
			timerTime = spec.getTime();
		}
		scheduled = true;
	}
	
	TVTimerSpec getSpec(){
		return spec;
	}
	
	/**
	 * Convenience method used by the TVTimerImpl
	 * @return The time in ms when it should go off.
	 */
	long getTimerTime(){		
		return timerTime;		
	}
	
	void reschedule(){
		timerTime = spec.getTime() + System.currentTimeMillis();
		scheduled = true;
	}
	
	void setScheduled(boolean b){
		scheduled = b;
	}
	
	boolean isScheduled(){
		return scheduled;
	}
	
	
}
