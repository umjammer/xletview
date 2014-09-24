/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.selection;

/**
 * <code>ServiceContextPermission</code> represents permission to
 * control a <code>ServiceContext</code>.  A
 * <code>ServiceContextPermission</code> contains a name (also
 * referred to as a "target name") and an actions string.
 * 
 * <p> The target name is the name of the service context permission
 * (see the table below).  Each permission identifies a method.  A
 * wildcard match is signified by an asterisk, i.e., "*".
 * 
 * <p><a name="actions"></a> The actions string is either "own" or
 * "*".  From a security standpoint, a caller is said to "own" a
 * <code>ServiceContext</code> instance if it was acquired through
 * <A HREF="../../../../javax/tv/service/selection/ServiceContextFactory.html#createServiceContext()"><CODE>ServiceContextFactory.createServiceContext()</CODE></A> or <A HREF="../../../../javax/tv/service/selection/ServiceContextFactory.html#getServiceContext(javax.tv.xlet.XletContext)"><CODE>ServiceContextFactory.getServiceContext(javax.tv.xlet.XletContext)</CODE></A>.  The string "own" means
 * the permission applies to your own service contexts; the string "*"
 * implies permission to these, plus permission for service contexts
 * obtained from all other sources.
 * 
 * <p> The following table lists all the possible
 * <code>ServiceContextPermission</code> target names, and describes
 * what the permission allows for each.  <p>
 * 
 * <table border=1 cellpadding=5>
 * <tr>
 * <th>Permission Target Name</th>
 * <th>What the Permission Allows</th>
 * </tr>
 * 
 * <tr>
 * <td>access</td>
 * <td>Access to a <code>ServiceContext</code>, via <code>ServiceContextFactory.getServiceContexts()</code></td>
 * </tr>
 * 
 * <tr>
 * <td>create</td>
 * <td>Creation of a <code>ServiceContext</code>.</td>
 * </tr>
 * 
 * <tr>
 * <td>destroy</td>
 * <td>Destruction of a <code>ServiceContext</code>.</td>
 * </tr>
 * 
 * <tr>
 * <td>getServiceContentHandlers</td>
 * <td>Obtaining the service content handlers from a <code>ServiceContext</code>.</td>
 * </tr>
 * 
 * <tr>
 * <td>stop</td>
 * <td>Stopping a <code>ServiceContext</code>.</td>
 * </tr>
 * 
 * </table>
 * 
 * <p>
 * The permission ServiceContextPermission("access", "*") is intended
 * to be granted only to special monitoring applications and not to
 * general broadcast applications.<p>
 * 
 * Note that undefined target and actions strings may be provided to
 * the constructors of this class, but subsequent calls to
 * <code>SecurityManager.checkPermission()</code> with the resulting
 * <code>SelectPermission</code> object will fail.
 * <CODE>Permission</CODE>,
 * <A HREF="../../../../javax/tv/service/selection/ServiceContext.html"><CODE>ServiceContext</CODE></A>,
 * <A HREF="../../../../javax/tv/service/selection/ServiceContextFactory.html"><CODE>ServiceContextFactory</CODE></A>, <A HREF="../../../../serialized-form.html#javax.tv.service.selection.ServiceContextPermission">Serialized Form</A></DL>
 * <HR>
 * 
 * 
 */
public final class ServiceContextPermission extends java.security.BasicPermission
{
	//following variables are implicitely defined by getter- or setter-methods:
	private java.lang.String actions;

	/**
	 * Creates a new ServiceContextPermission object with the specified
	 * name.  The name is the symbolic name of the permission, such as
	 * "create".  An asterisk may be used to signify a wildcard match.
	 * 
	 * @param name - The name of the ServiceContextPermission
	 * @param actions - The actions string, as detailed in the class description.
	 */
	public ServiceContextPermission(java.lang.String name, java.lang.String actions)
	{
		//TODO implement ServiceContextPermission
		super(name, actions);
	}

	/**
	 * Checks if the specified permission is "implied" by this object. <p>
	 * 
	 * More specifically, this method returns true if: <p>
	 * <ul>
	 * <li><i>p</i> is an instance of ServiceContextPermission, and
	 * <li><i>p</i>'s action string matches this object's, or this object has
	 * "*" as an action string, and
	 * <li><i>p</i>'s locator's external form matches this object's locator
	 * string, or this object's locator string is "*".
	 * </ul>
	 * 
	 * @param p - The permission against which to test.
	 * @return true if the specified permission is equal to or implied by this permission; false otherwise.
	 * @see implies in class java.security.BasicPermission
	 */
	public boolean implies(java.security.Permission p)
	{
		return false;
		//TODO implement implies
	}

	/**
	 * Tests two <code>ServiceContextPermission</code> objects for
	 * equality. Returns <code>true</code> if and only if
	 * <code>obj</code>'s class is the same as the class of this
	 * object, and <code>obj</code> has the same name and actions
	 * string as this object.
	 * 
	 * @param obj - The object to test for equality.
	 * @return true if the two permissions are equal; false otherwise.
	 * @see equals in class java.security.BasicPermission
	 */
	public boolean equals(java.lang.Object obj)
	{
		return false;
		//TODO implement equals
	}

	/**
	 * Provides the hash code value of this object.  Two
	 * <code>ServiceContextPermission</code> objects that are equal will
	 * return the same hash code.
	 * 
	 * @return The hash code value of this object.
	 * @see hashCode in class java.security.BasicPermission
	 */
	public int hashCode()
	{
		return 0;
		//TODO implement hashCode
	}

	/**
	 * Returns the canonical representation of the actions string.
	 * 
	 * @return The actions string of this permission.
	 * @see getActions in class java.security.BasicPermission
	 */
	public java.lang.String getActions()
	{
		return this.actions;
	}

}
