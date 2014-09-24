/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.locator;

/**
 * This class defines a factory for the creation of
 * <code>Locator</code> objects.
 * <HR>
 * 
 * 
 */
public abstract class LocatorFactory extends java.lang.Object
{
	//following variables are implicitely defined by getter- or setter-methods:
	private static LocatorFactory instance;

	/**
	 * Creates the <code>LocatorFactory</code> instance.</DL>
	 * 
	 * 
	 */
	protected LocatorFactory()
	{
		//TODO implement LocatorFactory
	}

	/**
	 * Provides an instance of <code>LocatorFactory</code>.
	 * 
	 * @return A LocatorFactory instance.
	 */
	public static LocatorFactory getInstance()
	{	
		return instance;
	}

	/**
	 * Creates a <code>Locator</code> object from the specified locator
	 * string.  The format of the locator string may be entirely
	 * implementation-specific.
	 * 
	 * @param locatorString - The string form of the Locator to be created.
	 * @return A Locator object representing the resource referenced by the given locator string.
	 * @throws MalformedLocatorException - If an incorrectly formatted locator string is detected.
	 * @see Locator.toExternalForm()
	 */
	public abstract Locator createLocator(java.lang.String locatorString) throws MalformedLocatorException;

	/**
	 * Transforms a <code>Locator</code> into its respective collection
	 * of transport dependent <code>Locator</code> objects. A
	 * transformation on a transport dependent <code>Locator</code>
	 * results in an identity transformation, i.e. the same locator is
	 * returned in a single-element array.
	 * 
	 * @param source - The Locator to transform.
	 * @return An array of transport dependent Locator objects for the given Locator.
	 * @throws InvalidLocatorException - If source is not a valid Locator.
	 */
	public abstract Locator[] transformLocator( Locator source) throws InvalidLocatorException;

}
