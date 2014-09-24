/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.navigation;

import xjavax.tv.service.SIElement;
import xjavax.tv.service.Service;

/**
 * This interface represents an abstraction of an elementary
 * stream. It provides information about individual components of a
 * service.  Generally speaking, a service component carries content
 * such as media (e.g. as audio or video) or data.  Content within a
 * <code>ServiceComponent</code> may include <code>Xlet</code>s.
 * <A HREF="../../../../javax/tv/service/guide/ProgramEvent.html#retrieveComponents(javax.tv.service.SIRequestor)"><CODE>ProgramEvent.retrieveComponents(javax.tv.service.SIRequestor)</CODE></A></DL>
 * <HR>
 * 
 * 
 */
public interface ServiceComponent extends SIElement
{
	/**
	 * Returns a name associated with this component. The Component Descriptor
	 * (DVB) or Component Name Descriptor (ATSC) may be used if present. A
	 * generic name (e.g., "video", "first audio", etc.) may be used otherwise.
	 * 
	 * @return A string representing the component name or an empty string if no name can be associated with this component.
	 */
	public java.lang.String getName();

	/**
	 * Identifies the language used for the elementary stream. The
	 * associated language is indicated using a language code.  This is
	 * typically a three-character language code as specified by ISO
	 * 639.2/B, but the code may be system-dependent.
	 * 
	 * @return A string representing a language code defining the language associated with this component.  An empty string is returned when there is no language associated with this component.
	 */
	public java.lang.String getAssociatedLanguage();

	/**
	 * Provides the stream type of this component. (For example, "video",
	 * "audio", etc.)
	 * 
	 * @return Stream type of this component.
	 */
	public StreamType getStreamType();

	/**
	 * Provides the <code>Service</code> object to which this
	 * <code>ServiceComponent</code> belongs. The result may be
	 * <code>null</code> if the Service cannot be determined.
	 * 
	 * @return The Service to which this ServiceComponent belongs.
	 */
	public Service getService();

}
