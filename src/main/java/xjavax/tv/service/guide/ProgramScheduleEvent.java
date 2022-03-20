/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.guide;

import xjavax.tv.service.SIChangeEvent;
import xjavax.tv.service.SIChangeType;

/**
 * A <code>ProgramScheduleEvent</code> notifies an
 * <code>ProgramScheduleListener</code> of changes to program events
 * detected in a <code>ProgramSchedule</code>.  Specifically, this
 * event signals the addition, removal, or modification of a
 * <code>ProgramEvent</code> in a <code>ProgramSchedule</code>, or a
 * change to the <code>ProgramEvent</code> that is current.<p>
 *
 * The class <code>ProgramScheduleChangeType</code> defines the kinds
 * of changes reported by <code>ProgramScheduleEvent</code>.  A
 * <code>ProgramScheduleChangeType</code> of
 * <code>CURRENT_PROGRAM_EVENT</code> indicates that the current
 * <code>ProgramEvent</code> of a <code>ProgramSchedule</code> has
 * changed in identity.
 * <A HREF="../../../../javax/tv/service/guide/ProgramScheduleChangeType.html"><CODE>ProgramScheduleChangeType</CODE></A>, <A HREF="../../../../serialized-form.html#javax.tv.service.guide.ProgramScheduleEvent">Serialized Form</A></DL>
 * <HR>
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class ProgramScheduleEvent extends SIChangeEvent{


    /**
     * Constructs a <code>ProgramScheduleEvent</code>.
     *
     * @param schedule - The schedule in which the change occurred.
     * @param type - The type of change that occurred.
     * @param e - The ProgramEvent that changed.
     */
    public ProgramScheduleEvent( ProgramSchedule schedule, SIChangeType type, ProgramEvent e){
        super(schedule, type, e);
    }

    /**
     * Reports the <code>ProgramSchedule</code> that generated the
     * event.  The object returned will be identical to the object
     * returned by the inherited <code>EventObject.getSource()</code>
     * method.
     *
     * @return The ProgramSchedule that generated the event.
     * @see EventObject.getSource()
     */
    public ProgramSchedule getProgramSchedule()    {
        return (ProgramSchedule) super.getSource();
    }

    /**
     * Reports the <code>ProgramEvent</code> that changed.  If the
     * <code>ProgramScheduleChangeType</code> is
     * <code>CURRENT_PROGRAM_EVENT</code>, the <code>ProgramEvent</code>
     * that became current will be returned.  The object returned will
     * be identical to the object returned by inherited
     * <code>SIChangeEvent.getSIElement</code> method.
     *
     * @return The ProgramEvent that changed.
     * @see SIChangeEvent.getSIElement()
     */
    public ProgramEvent getProgramEvent()    {
        return (ProgramEvent) super.getSIElement();
    }

}
