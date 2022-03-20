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
 * This exception is thrown when a <code>Locator</code> is not valid
 * in a particular context.  A <code>Locator</code> can be invalid or
 * several reasons, including:
 *
 * <ul>
 *
 * <li> The <code>Locator</code> refers to a resource that is not
 * valid at the time of usage.
 *
 * <li> The <code>Locator</code> refers to a type of resource that is
 * not appropriate for usage as a particular method parameter.
 *
 * <li> The <code>Locator</code> refers to a type of
 * resource whose usage is not supported on this system.
 *
 * </ul>
 * <HR>
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class InvalidLocatorException extends java.lang.Exception
{

    private Locator invalidLocator;

    /**
     * Constructs an <code>InvalidLocatorException</code> with no
     * detail message.
     *
     * @param locator - The offending Locator.
     */
    public InvalidLocatorException( Locator locator){
        super();
        invalidLocator = locator;
    }

    /**
     * Constructs an <code>InvalidLocatorException</code> with the
     * specified detail message.
     *
     * @param locator - The offending Locator.
     * @param reason - The reason this Locator is invalid.
     */
    public InvalidLocatorException( Locator locator, java.lang.String reason){
        super(reason);
        invalidLocator = locator;
    }

    /**
     * Returns the offending <code>Locator</code> instance.
     *
     * @return The locator that caused the exception.
     */
    public Locator getInvalidLocator(){
        return invalidLocator;
    }

}
