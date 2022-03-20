/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.util;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a timer specification.
 *
 * A class representing a timer specification. A timer specification declares
 * when a <code>TVTimerWentOffEvent</code> should be sent. These events are
 * sent to the listeners registered on the specification.
 * </p>
 *
 * <p>
 * A <code>TVTimerSpec</code> may be <b>absolute</b> or <b>delayed</b>.
 * Absolute specifications go off at the specified time. Delayed specifications
 * go off after waiting the specified amount of time.
 * </p>
 *
 * <p>
 * Delayed specifications may be repeating or non-repeating. Repeating
 * specifications automatically reschedule themselves after going off.
 * </p>
 *
 * <p>
 * Repeating specifications may be regular or non-regular. Regular
 * specifications attempt to go off at fixed intervals of time, irrespective of
 * system load or how long it takes to notify the listeners. Non-regular
 * specifications wait the specified amount of time after all listeners have
 * been called before going off again.
 * </p>
 *
 * <p>
 * For example, you could create a repeating specification that goes off every
 * 100 milliseconds. Furthermore, imagine that it takes 5 milliseconds to
 * notify the listeners every time it goes off. If the specification is
 * regular, the listeners will be notified after 100 milliseconds, 200
 * milliseconds, 300 milliseconds, and so on. If the specification is
 * non-regular, the listeners will be notified after 100 milliseconds, 205
 * milliseconds, 310 milliseconds, and so on.
 * </p>
 * <HR>
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class TVTimerSpec extends java.lang.Object {
    //following variables are implicitely defined by getter- or
    // setter-methods:
    private boolean absolute;
    private boolean repeat;
    private boolean regular;
    private long time;
    private List<TVTimerWentOffListener> listeners;


    /**
     * Creates a timer specification. It initially is absolute, non-repeating,
     * regular specification set to go off at time 0.
     */
    public TVTimerSpec() {
        absolute = true;
        repeat = false;
        regular = true;
        time = 0;

        listeners = new ArrayList<>();
    }

    /**
     * Sets this specification to be absolute or delayed.
     *
     * @param absolute -
     *            Flag to indicate that this specification is either absolute
     *            or delayed. If true, the specification is absolute;
     *            otherwise, it is delayed.
     */
    public void setAbsolute(boolean absolute) {
        this.absolute = absolute;
    }

    /**
     * Checks if this specification is absolute.
     *
     * @return true if this specification is absolute; false if it is delayed.
     */
    public boolean isAbsolute() {
        return absolute;
    }

    /**
     * Sets this specification to be repeating or non-repeating.
     *
     * @param repeat -
     *            Flag to indicate that this specification is either repeating
     *            or non-repeating. If true, the specification is repeating;
     *            otherwise, it is non-repeating.
     */
    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    /**
     * Checks if this specification is repeating.
     *
     * @return true if this specification is repeating; false if it is
     *         non-repeating.
     */
    public boolean isRepeat() {
        return repeat;
    }

    /**
     * Sets this specification to be regular or non-regular.
     *
     * @param regular -
     *            Flag to indicate that this specification is either regular or
     *            non-regular. If true, the specification is regular;
     *            otherwise, it is non-regular.
     */
    public void setRegular(boolean regular) {
        this.regular = regular;
    }

    /**
     * Checks if this specification is regular.
     *
     * @return true if this specification is regular; false if it is
     *         non-regular.
     */
    public boolean isRegular() {
        return regular;
    }

    /**
     * Sets when this specification should go off. For absolute specifications,
     * this is a time in milliseconds since midnight, January 1, 1970 UTC. For
     * delayed specifications, this is a delay time in milliseconds.
     *
     * @param time -
     *            The time when this specification should go off.
     */
    public void setTime(long time) {
        this.time = time;
    }

    /**
     * Returns the absolute or delay time when this specification will go off.
     *
     * @return The time when this specification will go off.
     */
    public long getTime() {
        return this.time;
    }

    /**
     * Registers a listener with this timer specification.
     *
     * @param l -
     *            The listener to add.
     */
    public void addTVTimerWentOffListener(TVTimerWentOffListener l) {
        listeners.add(l);
    }

    /**
     * Removes a listener to this timer specification. Silently does nothing if
     * the listener was not listening on this specification.
     *
     * @param l -
     *            The listener to remove.
     */
    public void removeTVTimerWentOffListener(TVTimerWentOffListener l) {
        listeners.remove(l);
    }

    /**
     * Sets this specification to go off at the given absolute time. This is a
     * convenience function equivalent to <code>setAbsolute(true)</code>,
     * <code>setTime(when)</code>,<code>setRepeat(false)</code>.
     *
     * @param when -
     *            The absolute time for the specification to go off.
     */
    public void setAbsoluteTime(long when) {
        setAbsolute(true);
        setRepeat(false);
        setTime(when);
    }

    /**
     * Sets this specification to go off after the given delay time. This is a
     * convenience function equivalent to <code>setAbsolute(false)</code>,
     * <code>setTime(delay)</code>,<code>setRepeat(false)</code>.
     *
     * @param delay -
     *            The relative time for the specification to go off.
     */
    public void setDelayTime(long delay) {
        setAbsolute(false);
        setRepeat(false);
        setTime(delay);
    }

    /**
     * Calls all listeners registered on this timer specification. This
     * function is primarily for the benefit of those writing implementations
     * of TVTimers.
     *
     * @param source -
     *            The TVTimer that decided that this specification should go
     *            off.
     */
    public void notifyListeners(TVTimer source) {
        TVTimerWentOffEvent event = new TVTimerWentOffEvent(source, this);
        for(int i = 0; i < listeners.size(); i++){
            ((TVTimerWentOffListener)listeners.get(i)).timerWentOff(event);
        }
    }

}
