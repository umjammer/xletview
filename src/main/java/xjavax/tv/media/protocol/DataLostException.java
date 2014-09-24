/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/
package xjavax.tv.media.protocol;

/**
 * Signals that streaming data has been lost.
 * 
 * Signals that streaming data has been lost.
 * <HR>
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class DataLostException extends java.io.IOException{
	/**
	 * Constructs the exception with no detail message.</DL>
	 * 
	 */
	public DataLostException(){
		super();
	}

	/**
	 * Constructs the exception with the given detail message.
	 * 
	 * @param reason - The reason for the exception.
	 */
	public DataLostException(String reason){
		super(reason);
	}

}
