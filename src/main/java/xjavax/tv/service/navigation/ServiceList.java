/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.navigation;

import xjavax.tv.locator.InvalidLocatorException;
import xjavax.tv.locator.Locator;
import xjavax.tv.service.Service;

/**
 * <code>ServiceList</code> represents an ordered list of
 * <code>Service</code> objects based on a specific grouping rule
 * defined by a <code>ServiceFilter</code>.  The objects in a
 * <code>ServiceList</code> are numbered from 0 to <code>size()
 * -1</code>.
 * 
 * A <code>ServiceList</code> is <i>immutable</i>.  In other words,
 * once a <code>ServiceList</code> instance is created, the elements
 * in the list and their order will never change.  All classes that
 * implement the <code>ServiceList</code> interface are required to
 * maintain this property.
 * <A HREF="../../../../javax/tv/service/navigation/ServiceFilter.html"><CODE>ServiceFilter</CODE></A>,
 * <A HREF="../../../../javax/tv/service/navigation/ServiceList.html#size()"><CODE>size()</CODE></A></DL>
 * <HR>
 * 
 * 
 */
public interface ServiceList
{
	/**
	 * Generates a new <code>ServiceList</code> containing the
	 * same elements as the current list, sorted in ascending
	 * order by service name.
	 * 
	 * @return A ServiceList sorted by service name.
	 * @see Service.getName()
	 */
	public ServiceList sortByName();

	/**
	 * Generates a new <code>ServiceList</code> containing the
	 * same elements as the current list, sorted in ascending
	 * order by service number.
	 * 
	 * @return A ServiceList sorted by service number.
	 * @throws SortNotAvailableException - If any of the Service objects in this ServiceList do not implement the ServiceNumber interface.
	 * @see ServiceNumber
	 */
	public ServiceList sortByNumber() throws SortNotAvailableException;

	/**
	 * Reports the <code>Service</code> corresponding to the specified
	 * locator if it is a member of this list.
	 * 
	 * @param locator - Specifies the Service to be searched for.
	 * @return The Service corresponding to locator, or null if the Service is not a member of this list.
	 * @throws InvalidLocatorException - If locator does not reference a valid Service.
	 */
	public Service findService( Locator locator) throws InvalidLocatorException;

	/**
	 * Creates a new <code>ServiceList</code> object that is a subset of
	 * this list, based on the conditions specified by a
	 * <code>ServiceFilter</code> object. This method may be used to
	 * generate increasingly specialized lists of <code>Service</code>
	 * objects based on multiple filtering criteria.  If the filter is
	 * <code>null</code>, the resulting <code>ServiceList</code> will be
	 * a duplicate of this list.  <p>
	 * 
	 * Note that the <code>accept</code> method of the given
	 * <code>ServiceFilter</code> will be invoked for each
	 * <code>Service</code> to be filtered using the same application
	 * thread that invokes this method.
	 * 
	 * @param filter - A filter constraining the requested service list, or null.
	 * @return A ServiceList object created based on the specified filtering rules.
	 * @see ServiceFilter.accept(javax.tv.service.Service)
	 */
	public ServiceList filterServices( ServiceFilter filter);

	/**
	 * Generates an iterator on the <code>Service</code> elements
	 * in this list.
	 * 
	 * @return A ServiceIterator on the Service s in this list.
	 */
	public ServiceIterator createServiceIterator();

	/**
	 * Tests if the indicated <code>Service</code> object is contained
	 * in the list.
	 * 
	 * @param service - The Service object for which to search.
	 * @return true if the specified Service is member of the list; false otherwise.
	 */
	public boolean contains( Service service);

	/**
	 * Reports the position of the first occurrence of the
	 * indicated <code>Service</code> object in the list.
	 * 
	 * @param service - The Service object for which to search.
	 * @return The index of the first occurrence of the service, or -1 if service is not contained in the list.
	 */
	public int indexOf( Service service);

	/**
	 * Reports the number of <code>Service</code> objects in the list.
	 * 
	 * @return The number of Service objects in the list.
	 */
	public int size();

	/**
	 * Reports the <code>Service</code> at the specified index position.
	 * 
	 * @param index - A position in the ServiceList.
	 * @return The Service at the specified index.
	 * @throws java.lang.IndexOutOfBoundsException - If index index > size()-1.
	 */
	public Service getService(int index);

	/**
	 * Compares the specified object with this <code>ServiceList</code>
	 * for equality. Returns <code>true</code> if and only if the
	 * specified object is also a <code>ServiceList</code>, both lists
	 * have the same size, and all corresponding pairs of elements in
	 * the two lists are equal.  (Two elements e1 and e2 are equal if
	 * (e1==null ? e2==null : e1.equals(e2)).) In other words, two lists
	 * are defined to be equal if they contain the same elements in the
	 * same order.
	 * 
	 * @param o - The object to be compared for equality with this list.
	 * @return true if the specified object is equal to this list; false otherwise.
	 * @see equals in class java.lang.Object
	 */
	public boolean equals(java.lang.Object o);

	/**
	 * Provides the hash code value for this <code>ServiceList</code>.
	 * Two <code>ServiceList</code> objects that are equal will have
	 * the same hash code.
	 * 
	 * @return The hash code value of this ServiceList.
	 * @see hashCode in class java.lang.Object
	 */
	public int hashCode();

}
