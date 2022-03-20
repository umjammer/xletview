/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.util;

/**
 * A listener interested in timer specifications going off.
 *
 * A listener interested in timer specifications going off.
 * <HR>
 *
 *
 */
public interface TVTimerWentOffListener
{
    /**
     * Notifies the listener that a timer specification went off.
     *
     * @param e - The event specifying which timer and which timer specification went off.
     */
    public void timerWentOff( TVTimerWentOffEvent e);

}
