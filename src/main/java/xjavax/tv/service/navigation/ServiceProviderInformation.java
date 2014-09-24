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
 * This interface is used to report additional information concerning the
 * provider of a service. ServiceDetails objects may optionally implement
 * this interface on systems that provide information concerning the
 * service provider in their specific SI format. It can be mapped to the
 * DVB Service descriptor.
 * <a href="../../../../overview-summary.html#guidelines-opinterfaces">Optionally implemented interfaces</a></DL>
 * <HR>
 * 
 * 
 */
public interface ServiceProviderInformation
{
	/**
	 * Returns the name of the service provider. It can be retrieved from the
	 * DVB Service Descriptor or the Multilingual Service Name Descriptor.
	 * 
	 * @return A string representing the service provider's name. It returns an empty string if no provider information is available.
	 */
	public java.lang.String getProviderName();

}
