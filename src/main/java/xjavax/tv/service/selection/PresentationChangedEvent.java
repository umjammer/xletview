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
 * <code>PresentationChangedEvent</code> indicates that the content
 * being presented in the <code>ServiceContext</code> has changed.
 * <code>PresentationChangedEvent</code> is the parent class of events
 * indicating dynamic changes to the presentation of a service due to
 * interaction with the CA system.  It is generated when neither
 * <code>AlternativeContentEvent</code> nor
 * <code>NormalContentEvent</code> are applicable.<p>
 * 
 * Applications may determine the nature of the new content by
 * querying the current <code>ServiceContentHandler</code> instances
 * of the <code>ServiceContext</code>.
 * <A HREF="../../../../javax/tv/service/selection/NormalContentEvent.html"><CODE>NormalContentEvent</CODE></A>,
 * <A HREF="../../../../javax/tv/service/selection/ServiceContentHandler.html#getServiceContentLocators()"><CODE>ServiceContentHandler.getServiceContentLocators()</CODE></A>, <A HREF="../../../../serialized-form.html#javax.tv.service.selection.PresentationChangedEvent">Serialized Form</A></DL>
 * <HR>
 * 
 * @author Martin Sveden
 * @statuscode 4 
 */
public class PresentationChangedEvent extends ServiceContextEvent{
	/**
	 * Constructs the event.
	 * 
	 * @param source - The ServiceContext that generated the event.
	 */
	public PresentationChangedEvent( ServiceContext source)	{
		super(source);
	}

}
