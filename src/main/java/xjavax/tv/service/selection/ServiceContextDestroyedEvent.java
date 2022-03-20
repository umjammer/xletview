/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.selection;

/**
 * <code>ServiceContextDestroyedEvent</code> is generated when a
 * <code>ServiceContext</code> is destroyed via its
 * <code>destroy()</code> method.
 * <HR>
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class ServiceContextDestroyedEvent extends ServiceContextEvent{
    /**
     * Constructs the event.
     *
     * @param source - The ServiceContext that was destroyed.
     */
    public ServiceContextDestroyedEvent( ServiceContext source)    {
        super(source);
    }

}
