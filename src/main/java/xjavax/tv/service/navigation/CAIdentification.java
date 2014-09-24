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
 * This interface associates information related to
 * the conditional access (CA) subsystem with certain SI objects.
 * <A HREF="../../../../javax/tv/service/guide/ProgramEvent.html"><CODE>ProgramEvent</CODE></A>,
 * <A HREF="../../../../javax/tv/service/transport/Bouquet.html"><CODE>Bouquet</CODE></A></DL>
 * <HR>
 * 
 * 
 */
public interface CAIdentification
{
	/**
	 * Returns an array of CA System IDs associated with this object. This
	 * information may be obtained from the CAT MPEG message or a system
	 * specific conditional access descriptor (such as defined by Simulcrypt
	 * or ATSC).
	 * 
	 * @return An array of CA System IDs. An empty array is returned when no CA System IDs are available.
	 */
	public int[] getCASystemIDs();

	/**
	 * Provides information concerning conditional access of this object.
	 * 
	 * @return true if this Service is not protected by a conditional access; false if one or more components is protected by conditional access.
	 */
	public boolean isFree();

}
