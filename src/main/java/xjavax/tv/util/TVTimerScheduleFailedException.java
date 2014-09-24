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
 * An exception thrown by the TVTimer.
 * 
 * An exception thrown by the <code>TVTimer.schedule()</code> method when a
 * timer specification cannot be met.
 * <HR>
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class TVTimerScheduleFailedException extends java.lang.Exception {
	/**
	 * Constructs a TVTimerScheduleFailedException with null as its error
	 * detail message.
	 * </DL>
	 *  
	 */
	public TVTimerScheduleFailedException() {
		super();
	}

	/**
	 * Constructs a TVTimerScheduleFailedException with the specified detail
	 * message. The error message string <code>s</code> can later be
	 * retrieved by <code>java.lang.Throwable.getMessage()</code> method.
	 * 
	 * @param s -
	 *            The detail message.
	 */
	public TVTimerScheduleFailedException(java.lang.String s) {
		super(s);
	}

}
