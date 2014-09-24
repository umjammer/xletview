/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.navigation;

import xjavax.tv.service.SIElement;
import xjavax.tv.service.Service;

/**
 * <code>SIElementFilter</code> represents a
 * <code>ServiceFilter</code> based on a particular
 * <code>SIElement</code> (such as a <code>TransportStream</code> or
 * <code>ProgramEvent</code>).  A <code>ServiceList</code> resulting
 * from this filter will include only <code>Service</code> objects
 * with one or more corresponding <code>ServiceDetails</code>,
 * <code>sd</code>, such that:
 * <ul>
 * <li> <code>sd</code> is contained by
 * the specified <code>SIElement</code>, or
 * <li><code>sd</code>
 * contains the specified <code>SIElement</code>
 * </ul>
 * -- according to the
 * type of <code>SIElement</code> provided.  Note that no guarantee
 * is made that every <code>SIElement</code> type is supported for
 * filtering.
 * <A HREF="../../../../javax/tv/service/navigation/ServiceList.html"><CODE>ServiceList</CODE></A></DL>
 * <HR>
 * 
 * 
 */
public final class SIElementFilter extends ServiceFilter
{
	//following variables are implicitely defined by getter- or setter-methods:
	private SIElement filterValue;

	/**
	 * Constructs the filter based on a particular <code>SIElement</code>.
	 * 
	 * @param element - An SIElement indicating the services to be included in a resulting service list.
	 * @throws FilterNotSupportedException - If element is not supported for filtering.
	 */
	public SIElementFilter( SIElement element) throws FilterNotSupportedException
	{
		//TODO implement SIElementFilter
	}

	/**
	 * Reports the <code>SIElement</code> used to create this filter.
	 * 
	 * @return The SIElement used to create this filter.
	 */
	public SIElement getFilterValue()
	{
		return this.filterValue;
	}

	/**
	 * Tests if the given service passes the filter.
	 * 
	 * @param service - An individual Service to be evaluated against the filtering algorithm.
	 * @return true if service has a corresponding ServiceDetails which contains or is contained by the SIElement indicated by the filter value; false otherwise.
	 * @see accept in class ServiceFilter
	 */
	public boolean accept( Service service)
	{
		return false;
		//TODO implement accept
	}

}
