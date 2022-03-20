/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.selection;

import xjavax.tv.xlet.XletContext;


/**
 * This class serves as a factory for the creation of <code>ServiceContext</code>
 * objects.
 * <HR>
 *
 *
 */
public abstract class ServiceContextFactory {
    //following variables are implicitely defined by getter- or
    // setter-methods:
    private static ServiceContextFactory instance;

    /**
     * Creates a <code>ServiceContextFactory</code>.
     * </DL>
     *
     *
     */
    protected ServiceContextFactory() {
    }

    /**
     * Provides an instance of <code>ServiceContextFactory</code>.
     *
     * @return An instance of ServiceContextFactory.
     */
    public static ServiceContextFactory getInstance() {
        if(instance == null){
            instance = new ServiceContextFactoryImpl();
        }
        return instance;
    }

    /**
     * Creates a <code>ServiceContext</code> object. The new <code>ServiceContext</code>
     * is created in the <em>not
     * presenting</em> state.
     *
     * <p>
     * Due to resource restrictions, implementations may limit the total number
     * of simultaneous <code>ServiceContext</code> objects. In such a case,
     * <code>InsufficientResourcesException</code> is thrown.
     *
     * @return A new ServiceContext object.
     * @throws InsufficientResourcesException -
     *             If the receiver lacks the resources to create this
     *             ServiceContext.
     * @throws java.lang.SecurityException -
     *             if the caller doesn't have
     *             ServiceContextPermission("create", "own").
     */
    public abstract ServiceContext createServiceContext() throws InsufficientResourcesException, java.lang.SecurityException;

    /**
     * Provides the <code>ServiceContext</code> instances to which the caller
     * of the method is permitted access. If the caller has <code>ServiceContextPermission("access","*")</code>,
     * then all current (i.e., undestroyed) <code>ServiceContext</code>
     * instances are returned. If the application making this call is running
     * in a <code>ServiceContext</code> and has <code>ServiceContextPermission("access","own")</code>,
     * its own <code>ServiceContext</code> will be included in the returned
     * array. If no <code>ServiceContext</code> instances are accessible to
     * the caller, a zero-length array is returned. No <code>ServiceContext</code>
     * instances in the <em>destroyed</em> state are returned by this method.
     *
     * @return An array of accessible ServiceContext objects.
     * @see ServiceContextPermission
     */
    public abstract ServiceContext[] getServiceContexts();

    /**
     * Reports the <code>ServiceContext</code> in which the <code>Xlet</code>
     * corresponding to the specified <code>XletContext</code> is running.
     * The returned <code>ServiceContext</code> is the one from which the
     * <code>Service</code> carrying the <code>Xlet</code> was selected.
     *
     * @param ctx -
     *            The XletContext of the Xlet of interest.
     * @return The ServiceContext in which the Xlet corresponding to ctx is
     *         running.
     * @throws java.lang.SecurityException -
     *             If the Xlet corresponding to ctx does not have
     *             ServiceContextPermission("access", "own").
     * @throws ServiceContextException -
     *             If the Xlet corresponding to ctx is not running within a
     *             ServiceContext.
     */
    public abstract ServiceContext getServiceContext(XletContext ctx) throws java.lang.SecurityException, ServiceContextException;

}
