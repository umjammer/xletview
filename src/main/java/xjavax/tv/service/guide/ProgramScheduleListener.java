/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.guide;

import xjavax.tv.service.SIChangeListener;

/**
 * This interface is implemented by applications wishing to receive
 * notification of changes to <code>ProgramSchedule</code> data.
 * <HR>
 * 
 * 
 */
public interface ProgramScheduleListener extends SIChangeListener
{
	/**
	 * Notifies the <code>ProgramScheduleListener</code> of a
	 * change to a <code>ProgramSchedule</code>.
	 * 
	 * @param event - A ProgramScheduleEvent describing what changed and how.
	 */
	public void notifyChange( ProgramScheduleEvent event);

}
