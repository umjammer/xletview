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
 * <code>SelectionFailedEvent</code> is generated when a service
 * selection operation fails.  <code>SelectionFailedEvent</code> is
 * not generated when a service selection fails with an exception. <p>
 * 
 * Presentation failures enforced via a conditional access system may
 * be reported by this event (with the reason code CA_REFUSAL) or by
 * <code>AlternativeContentEvent.</code> Which of these is used
 * depends on the precise nature of the conditional access
 * system. Applications must allow for both modes of failure.
 * <HR>
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class SelectionFailedEvent extends ServiceContextEvent{
	/**
	 * Reason code : Selection has been interrupted by another selection
	 * request.</DL>
	 * 
	 */
	public static final int INTERRUPTED = 1;

	/**
	 * Reason code : Selection failed due to the CA system refusing to
	 * permit it.</DL>
	 * 
	 */
	public static final int CA_REFUSAL = 2;

	/**
	 * Reason code : Selection failed because the requested content
	 * could not be found in the network.</DL>
	 * 
	 */
	public static final int CONTENT_NOT_FOUND = 3;

	/**
	 * Reason code : Selection failed due to absence of a
	 * <code>ServiceContentHandler</code> required to present the requested
	 * service.
	 * <DT><B>See Also: </B>
	 * 
	 */
	public static final int MISSING_HANDLER = 4;

	/**
	 * Reason code : Selection failed due to problems with tuning.</DL>
	 * 
	 */
	public static final int TUNING_FAILURE = 5;

	/**
	 * Reason code : Selection failed due to a lack of resources required to
	 * present this service.</DL>
	 * 
	 * 
	 */
	public static final int INSUFFICIENT_RESOURCES = 6;

	private int reason;

	/**
	 * Constructs the event with a reason code.
	 * 
	 * @param source - The ServiceContext that generated the event.
	 * @param reason - The reason why the selection failed.
	 */
	public SelectionFailedEvent( ServiceContext source, int reason)	{
		super(source);
		this.reason = reason;
	}

	/**
	 * Reports the reason why the selection failed.
	 * 
	 * @return The reason why the selection failed.
	 */
	public int getReason(){
		return reason;
	}

}
