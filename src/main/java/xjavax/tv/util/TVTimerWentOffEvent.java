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
 * An event indicating that a timer specification has gone off.
 *
 * An event indicating that a timer specification has gone off.
 * <HR>
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class TVTimerWentOffEvent extends java.util.EventObject {
    //following variables are implicitely defined by getter- or
    // setter-methods:
    private TVTimerSpec timerSpec;

    /**
     * Creates a new TVTimerWentOffEvent with the specified timer and timer
     * specification.
     *
     * @param source -
     *            the timer that sent this event
     * @param spec -
     *            the timer specification that went off
     */
    public TVTimerWentOffEvent(TVTimer source, TVTimerSpec spec) {
        super(source);
        timerSpec = spec;
    }

    /**
     * Returns the timer specification for this event.
     *
     * @return The TVTimerSpec for this event.
     */
    public TVTimerSpec getTimerSpec() {
        return this.timerSpec;
    }

}
