/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.selection;

/**
 * The parent class for service context events.
 * 
 * The parent class for service context events.
 * <HR>
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class ServiceContextEvent extends java.util.EventObject{


	/**
	 * Constructs the event.
	 * 
	 * @param source - The ServiceContext that generated the event.
	 */
	public ServiceContextEvent( ServiceContext source)	{
		super(source);
	}

	/**
	 * Reports the <code>ServiceContext</code> that generated the event.
	 * 
	 * @return The ServiceContext that generated the event.
	 */
	public ServiceContext getServiceContext()	{
		return (ServiceContext) super.getSource();
	}

}
