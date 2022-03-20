/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.transport;

import xjavax.tv.service.SIElement;

/**
 * This interface provides information about a transport stream.
 *
 * This interface provides information about a transport stream.
 * <HR>
 *
 *
 */
public interface TransportStream extends SIElement
{
    /**
     * Reports the ID of this transport stream.
     *
     * @return A number identifying this transport stream.
     */
    public int getTransportStreamID();

    /**
     * Reports the textual name or description of this transport stream.
     *
     * @return A string representing the name of this transport stream, or an empty string if no information is available.
     */
    public java.lang.String getDescription();

}
