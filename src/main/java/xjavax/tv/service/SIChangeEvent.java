/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service;

/**
 * <code>SIChangeEvent</code> objects are sent to
 * <code>SIChangeListener</code> instances to signal detected changes
 * in the SI database.<p>
 * 
 * Note that while the SI database may detect changes, notification of
 * which specific <code>SIElement</code> has changed is not guaranteed.
 * The entity reported by the method <code>getSIElement()</code> will
 * be either:
 * <ul>
 * <li>The specific SI element that changed, or<p>
 * <li>An SI element that contains, however indirectly, the specific SI
 * element that changed, or<p>
 * <li><code>null</code>, if the specific changed element is unknown.
 * </ul>
 * 
 * The level of specificity provided by the change mechanism is
 * entirely dependent on the capabilities and current resources of the
 * implementation.
 * 
 * <code>SIChangeEvent</code> instances also report the kind of change
 * that occurred to the SI element, via the method
 * <code>getChangeType()</code>:
 * <ul>
 * 
 * <li>An <code>SIChangeType</code> of <code>ADD</code> indicates that
 * the reported SI element is new in the database.<p>
 * 
 * <li>An <code>SIChangeType</code> of <code>REMOVE</code> indicates
 * that the reported SI element is defunct and no longer cached by the
 * database.  The results of subsequent method invocations on the
 * removed SIElement are undefined.<p>
 * 
 * <li>An <code>SIChangeType</code> of <code>MODIFY</code> indicates
 * that the data encapsulated by the reported SI element has changed.
 * 
 * </ul>
 * 
 * In the event that the SIElement reported by this event is not
 * the actual element that changed in the broadcast (i.e. it is
 * instead a containing element or <code>null</code>), the
 * <code>SIChangeType</code> will be <code>MODIFY</code>.
 * Individual SI element changes are reported only once, i.e.,
 * a change to an SI element is not also reported as a change
 * to any containing (or "parent") SI elements.
 * <A HREF="../../../javax/tv/service/SIChangeEvent.html#getChangeType()"><CODE>getChangeType()</CODE></A>, <A HREF="../../../serialized-form.html#javax.tv.service.SIChangeEvent">Serialized Form</A></DL>
 * <HR>
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public abstract class SIChangeEvent extends java.util.EventObject{

	private SIElement sIElement;
	private SIChangeType changeType;

	/**
	 * Constructs an <code>SIChangeEvent</code> object.
	 * 
	 * @param source - The entity in which the change occurred.
	 * @param type - The type of change that occurred.
	 * @param e - The SIElement that changed, or null if this is unknown.
	 */
	public SIChangeEvent(java.lang.Object source, SIChangeType type, SIElement e){
		super(source);
		changeType = type;
		sIElement = e;
		
	}

	/**
	 * Reports the <code>SIElement</code> that changed.<p>
	 * 
	 * This method may return <code>null</code>, since it is not
	 * guaranteed that the SI database can or will determine which
	 * element in a particular table changed.
	 * 
	 * @return The SIElement that changed, or null if this is unknown.
	 */
	public SIElement getSIElement()	{
		return sIElement;
	}

	/**
	 * Indicates the type of change that occurred.
	 * 
	 * @return The type of change that occurred.
	 */
	public SIChangeType getChangeType()	{
		return this.changeType;
	}

}
