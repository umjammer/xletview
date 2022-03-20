/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.locator;

/**
 * This exception is thrown to indicate that a malformed locator
 * string has been used.  Either no legal mapping could be determined
 * for the specified string, or the string could not be parsed.
 * <HR>
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class MalformedLocatorException extends java.lang.Exception
{
    /**
     * Constructs a <code>MalformedLocatorException</code> with no
     * detail message.</DL>
     *
     */
    public MalformedLocatorException(){
        super();
    }

    /**
     * Constructs a <code>MalformedLocatorException</code> with the
     * specified detail message.
     *
     * @param reason - The reason the exception was raised.
     */
    public MalformedLocatorException(String reason){
        super(reason);
    }

}
