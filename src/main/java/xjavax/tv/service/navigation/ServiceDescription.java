/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.navigation;

import xjavax.tv.service.SIRetrievable;

/**
 * This interface provides a textual description of a
 * <code>Service</code>.
 * (In ATSC PSIP, this information is obtained from the ETT
 * associated with this service.)
 * <HR>
 * 
 * 
 */
public interface ServiceDescription extends SIRetrievable
{
	/**
	 * Provides a textual description of the <code>Service</code>.
	 * 
	 * @return A textual description of the Service, or an empty string if no description is available.
	 */
	public java.lang.String getServiceDescription();

}
