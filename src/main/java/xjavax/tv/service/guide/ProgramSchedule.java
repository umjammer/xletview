/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.guide;

import xjavax.tv.locator.InvalidLocatorException;
import xjavax.tv.locator.Locator;
import xjavax.tv.service.SIException;
import xjavax.tv.service.SIRequest;
import xjavax.tv.service.SIRequestor;

/**
 * This interface represents a collection of program events for a given
 * service ordered by time. It provides the current, next and future
 * program events.<p>
 * 
 * Note that all time values are in UTC time.
 * <A HREF="../../../../javax/tv/service/guide/ProgramEvent.html"><CODE>ProgramEvent</CODE></A>,
 * <A HREF="../../../../javax/tv/service/ReadPermission.html"><CODE>ReadPermission</CODE></A></DL>
 * <HR>
 * 
 * 
 */
public interface ProgramSchedule
{
	/**
	 * Retrieves the current <code>ProgramEvent</code>.  The resulting
	 * <code>ProgramEvent</code> is available for immediate viewing.<p>
	 * 
	 * This method delivers its results asynchronously.  If the caller
	 * does not have
	 * <code>javax.tv.service.ReadPermission(pe.getLocator())</code>
	 * (where <code>pe</code> is the current program event), this
	 * method will result in an <code>SIRequestFailureType</code> of
	 * <code>DATA_UNAVAILABLE</code>.
	 * 
	 * @param requestor - The SIRequestor to be notified when this retrieval operation completes.
	 * @return An SIRequest object identifying this asynchronous retrieval request.
	 * @see ProgramEvent, ReadPermission
	 */
	public SIRequest retrieveCurrentProgramEvent( SIRequestor requestor);

	/**
	 * Retrieves the program event for the specified time.  The
	 * specified time will fall between the resulting program event's
	 * start time (inclusive) and end time (exclusive).<p>
	 * 
	 * This method delivers its results asynchronously.  If the caller
	 * does not have
	 * <code>javax.tv.service.ReadPermission(pe.getLocator())</code>
	 * (where <code>pe</code> is the program event at the specified
	 * time), this method will result in an
	 * <code>SIRequestFailureType</code> of
	 * <code>DATA_UNAVAILABLE</code>.
	 * 
	 * @param time - The time of the program event to be retrieved.
	 * @param requestor - The SIRequestor to be notified when this retrieval operation completes.
	 * @return An SIRequest object identifying this asynchronous retrieval request.
	 * @throws SIException - If time does not represent a future time value.
	 * @see ProgramEvent, ReadPermission
	 */
	public SIRequest retrieveFutureProgramEvent(java.util.Date time, SIRequestor requestor) throws SIException;

	/**
	 * Retrieves all known program events on this service for the
	 * specified time interval.  A program event <code>pe</code> is
	 * retrieved by this method if the time interval from
	 * <code>pe.getStartTime()</code> (inclusive) to
	 * <code>pe.getEndTime()</code> (exclusive) intersects the time
	 * interval from <code>begin</code> (inclusive) to <code>end</code>
	 * (exclusive) specified by the input parameters.<p>
	 * 
	 * This method returns data asynchronously.  Only program events
	 * <code>pe</code> for which the caller has
	 * <code>javax.tv.service.ReadPermission(pe.getLocator())</code>
	 * will be retrieved.  If no program events meet this criteria,
	 * this method will result in an <code>SIRequestFailureType</code> of
	 * <code>DATA_UNAVAILABLE</code>.
	 * 
	 * @param begin - Time identifying the beginning of the interval.
	 * @param end - Time identifying the end of the interval.
	 * @param requestor - The SIRequestor to be notified when this retrieval operation completes.
	 * @return An SIRequest object identifying this asynchronous retrieval request.
	 * @throws SIException - If end represents a time value before begin, or if end does not represent a future time value.
	 * @see ProgramEvent, ReadPermission
	 */
	public SIRequest retrieveFutureProgramEvents(java.util.Date begin, java.util.Date end, SIRequestor requestor) throws SIException;

	/**
	 * Retrieves a event which follows the specified event.<p>
	 * 
	 * This method delivers its results asynchronously.  If the caller
	 * does not have
	 * <code>javax.tv.service.ReadPermission(pe.getLocator())</code>
	 * (where <code>pe</code> is the next program event), this
	 * method will result in an <code>SIRequestFailureType</code> of
	 * <code>DATA_UNAVAILABLE</code>.
	 * 
	 * @param event - A reference event.
	 * @param requestor - The SIRequestor to be notified when this retrieval operation completes.
	 * @return An SIRequest object identifying this asynchronous retrieval request.
	 * @throws SIException - If event does not belong to this ProgramSchedule.
	 * @see ProgramEvent, ReadPermission
	 */
	public SIRequest retrieveNextProgramEvent( ProgramEvent event, SIRequestor requestor) throws SIException;

	/**
	 * Retrieves a program event matching the locator. Note that
	 * the event must be part of this schedule.<p>
	 * 
	 * This method returns data asynchronously.
	 * 
	 * @param locator - Locator referencing the ProgramEvent of interest.
	 * @param requestor - The SIRequestor to be notified when this retrieval operation completes.
	 * @return An SIRequest object identifying this asynchronous retrieval request.
	 * @throws InvalidLocatorException - If locator does not reference a valid ProgramEvent in this ProgramSchedule.
	 * @throws java.lang.SecurityException - If the caller does not have javax.tv.service.ReadPermission(locator).
	 * @see ProgramEvent, ReadPermission
	 */
	public SIRequest retrieveProgramEvent( Locator locator, SIRequestor requestor) throws InvalidLocatorException, java.lang.SecurityException;

	/**
	 * Registers a <code>ProgramScheduleListener</code> to be notified of
	 * changes to program events on this <code>ProgramSchedule</code>.
	 * Subsequent changes will be indicated through instances of
	 * <code>ProgramScheduleEvent</code>, with this
	 * <code>ProgramSchedule</code> as the event source and an
	 * <code>SIChangeType</code> of <code>ADD</code>,
	 * <code>REMOVE</code>, <code>MODIFY</code>, or
	 * <code>CURRENT_PROGRAM_EVENT</code>.  Only changes to
	 * <code>ProgramEvent</code> instances <code>p</code> for which the
	 * caller has
	 * <code>javax.tv.service.ReadPermission(p.getLocator())</code> will
	 * be reported.<p>
	 * 
	 * This method is only a request for notification.  No guarantee is
	 * provided that the SI database will detect all, or even any,
	 * changes to the <code>ProgramSchedule</code>, or whether such changes
	 * will be detected in a timely fashion.<p>
	 * 
	 * If the specified <code>ProgramScheduleListener</code> is already
	 * registered, no action is performed.
	 * 
	 * @param listener - A ProgramScheduleListener to be notified of changes to program events on this ProgramSchedule.
	 * @see ProgramEvent, ProgramScheduleEvent, ProgramScheduleChangeType, ReadPermission
	 */
	public void addListener( ProgramScheduleListener listener);

	/**
	 * Unregisters a <code>ProgramScheduleListener</code>.  If the
	 * specified <code>ProgramScheduleListener</code> is not registered, no
	 * action is performed.
	 * 
	 * @param listener - A previously registered listener.
	 */
	public void removeListener( ProgramScheduleListener listener);

	/**
	 * Reports the transport-dependent locator referencing the service to
	 * which this <code>ProgramSchedule</code> belongs.  Note that
	 * applications may use this method to establish the identity of
	 * a <code>ProgramSchedule</code> after it has changed.
	 * 
	 * @return The transport-dependent locator referencing the service to which this ProgramSchedule belongs.
	 * @see ProgramScheduleEvent.getProgramSchedule()
	 */
	public Locator getServiceLocator();

}
