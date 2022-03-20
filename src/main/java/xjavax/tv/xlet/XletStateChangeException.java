/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.xlet;

/**
 * Signals that a requested Xlet state change failed.
 *
 * Signals that a requested Xlet state change failed. This exception is thrown
 * in response to state change calls in the <code>Xlet</code> interface.
 * <HR>
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class XletStateChangeException extends java.lang.Exception {
    /**
     * Constructs an exception with no specified detail message.
     * </DL>
     *
     */
    public XletStateChangeException() {
        super();
    }

    /**
     * Constructs an exception with the specified detail message.
     *
     * @param s -
     *            the detail message
     */
    public XletStateChangeException(java.lang.String s) {
        super(s);
    }

}
