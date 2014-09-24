/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.navigation;

/**
 * This class represents values of <code>ServiceComponent</code>
 * stream types (e.g., "video", "audio", "subtitles", "data",
 * "sections", etc.).
 * <HR>
 * 
 * 
 */
public class StreamType extends java.lang.Object
{
	/**
	 * Video component.</DL>
	 * 
	 */
	public static final StreamType VIDEO = null;

	/**
	 * Audio component.</DL>
	 * 
	 */
	public static final StreamType AUDIO = null;

	/**
	 * Subtitles component.</DL>
	 * 
	 */
	public static final StreamType SUBTITLES = null;

	/**
	 * Data component.</DL>
	 * 
	 */
	public static final StreamType DATA = null;

	/**
	 * MPEG sections component.</DL>
	 * 
	 */
	public static final StreamType SECTIONS = null;

	/**
	 * Unknown component.</DL>
	 * 
	 * 
	 */
	public static final StreamType UNKNOWN = null;

	/**
	 * Creates a stream type object.
	 * 
	 * @param name - The string name of this type (e.g., "VIDEO").
	 */
	protected StreamType(java.lang.String name)
	{
		//TODO implement StreamType
	}

	/**
	 * Provides the string name of the type.  For the type objects
	 * defined in this class, the string name will be identical to the
	 * class variable name.
	 * 
	 * @return The string name of the type.
	 * @see toString in class java.lang.Object
	 */
	public java.lang.String toString()
	{
		return null;
		//TODO implement toString
	}

}
