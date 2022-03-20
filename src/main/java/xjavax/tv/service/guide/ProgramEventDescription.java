/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.guide;

import xjavax.tv.service.SIRetrievable;

/**
 * This <code>SIElement</code> provides a textual description of a
 * <code>ProgramEvent</code>.  In ATSC PSIP, this information is
 * obtained from the Extended Text Table; in DVB SI, from the Short
 * Event Descriptor.)
 * <HR>
 *
 *
 */
public interface ProgramEventDescription extends SIRetrievable
{
    /**
     * Provides a textual description of the <code>ProgramEvent</code>.
     *
     * @return A textual description of the ProgramEvent, or an empty string if no description is available.
     */
    public java.lang.String getProgramEventDescription();

}
