/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.guide;

import xjavax.tv.service.SIChangeType;

/**
 * This class represents types of changes to program schedules.
 * 
 * This class represents types of changes to program schedules.
 * <A HREF="../../../../javax/tv/service/guide/ProgramSchedule.html"><CODE>ProgramSchedule</CODE></A></DL>
 * <HR>
 * 
 * 
 */
public class ProgramScheduleChangeType extends SIChangeType
{
	/**
	 * <code>ProgramScheduleChangeType</code> indicating that the
	 * current program event has changed.</DL>
	 * 
	 * 
	 */
	public static final ProgramScheduleChangeType CURRENT_PROGRAM_EVENT = null;

	/**
	 * Creates an <code>ProgramScheduleChangeType</code> object.
	 * 
	 * @param name - The string name of this type (e.g. "CURRENT_PROGRAM_EVENT").
	 */
	protected ProgramScheduleChangeType(java.lang.String name)
	{
		//TODO implement ProgramScheduleChangeType
		super(name);
	}

	/**
	 * Provides the string name of the type.  For the type objects
	 * defined in this class, the string name will be identical to the
	 * class variable name.
	 * 
	 * @return The string name of the type.
	 * @see toString in class SIChangeType
	 */
	public java.lang.String toString()
	{
		return null;
		//TODO implement toString
	}

}
