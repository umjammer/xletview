/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.guide;

import xjavax.tv.service.SIElement;
import xjavax.tv.service.SIRequest;
import xjavax.tv.service.SIRequestor;
import xjavax.tv.service.Service;

/**
 * <code>ProgramEvent</code> represents collection of elementary
 * streams with a common time base, an associated start time, and an
 * associated end time. An event is equivalent to the common industry
 * usage of "TV program." <p>
 * 
 * 
 * The Event Information Table (EIT) contains information (titles, start
 * times, etc.) for events on defined services. An event is, in most cases,
 * a typical TV program, however its definition may be extended to include
 * particular data broadcasting sessions and other information segments.<p>
 * 
 * A <code>ProgramEvent</code> object may optionally implement the
 * <code>CAIdentification</code> interface. Note that all time values
 * are in UTC time. <P>
 * <A HREF="../../../../javax/tv/service/navigation/CAIdentification.html"><CODE>CAIdentification</CODE></A>,
 * <a href="../../../../overview-summary.html#guidelines-opinterfaces">Optionally implemented interfaces</a></DL>
 * <HR>
 * 
 * 
 */
public interface ProgramEvent extends SIElement
{
	/**
	 * Returns the start time of this program event. The start time is in UTC
	 * time.
	 * 
	 * @return This program's start time (UTC).
	 */
	public java.util.Date getStartTime();

	/**
	 * Returns the end time of this program event. The end time is in UTC time.
	 * 
	 * @return This program's end time (UTC).
	 */
	public java.util.Date getEndTime();

	/**
	 * Returns the duration of this program event in seconds.
	 * 
	 * @return This program's duration in seconds.
	 */
	public long getDuration();

	/**
	 * Returns the program event title. This information may be obtained in
	 * the ATSC EIT table or the DVB Short Event Descriptor.
	 * 
	 * @return A string representing this program's title, or an empty string if the title is unavailable.
	 */
	public java.lang.String getName();

	/**
	 * Retrieves a textual description of the event. This method
	 * delivers its results asynchronously.
	 * 
	 * @param requestor - The SIRequestor to be notified when this retrieval operation completes.
	 * @return An SIRequest object identifying this asynchronous retrieval request.
	 * @see ProgramEventDescription
	 */
	public SIRequest retrieveDescription( SIRequestor requestor);

	/**
	 * Reports content advisory information associated with this program for
	 * the local rating region.
	 * 
	 * @return A ContentRatingAdvisory object describing the rating of this ProgramEvent or null if no rating information is available.
	 */
	public ContentRatingAdvisory getRating();

	/**
	 * Reports the <code>Service</code> this program event is associated with.
	 * 
	 * @return The Service this program event is delivered on.
	 */
	public Service getService();

	/**
	 * Retrieves an array of service components which are part of this
	 * <code>ProgramEvent</code>.  Service component information may not
	 * always be available. If the <code>ProgramEvent</code> is current,
	 * this method will provide only service components associated with
	 * the <code>Service</code> to which the <code>ProgramEvent</code>
	 * belongs.  If the <code>ProgramEvent</code> is not current, no
	 * guarantee is provided that all or even any of its service
	 * components will be available.<p>
	 * 
	 * This method delivers its results asynchronously.  The retrieved
	 * array will only contain <code>ServiceComponent</code> instances
	 * <code>c</code> for which the caller has
	 * <code>javax.tv.service.ReadPermission(c.getLocator())</code>.  If
	 * no <code>ServiceComponent</code> instances meet this criteria,
	 * this method will result in an <code>SIRequestFailureType</code> of
	 * <code>DATA_UNAVAILABLE</code>.
	 * 
	 * @param requestor - The SIRequestor to be notified when this retrieval operation completes.
	 * @return An SIRequest object identifying this asynchronous retrieval request.
	 * @see ServiceComponent, ReadPermission
	 */
	public SIRequest retrieveComponents( SIRequestor requestor);

}
