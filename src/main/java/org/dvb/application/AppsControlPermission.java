/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.application;

/**
 * AppsControlPermission, can be used as the base class for permissions that
 * want to follow the same naming convention as BasicPermission. 
 * @author Martin Sveden
 * @statuscode 4
 * @comment Even though it doesn't look fully implemented, there shouldn't be anything more to it than this, check the API.
 */
public final class AppsControlPermission extends java.security.BasicPermission {

    private static final int hash = new String("AppsControlPermission").hashCode();
    
	public AppsControlPermission() {
		super("");
	}
	
	public AppsControlPermission(String name, String actions){
		super(name);
	}

	public String getActions() { 
	    return null;
	}

	public boolean implies(java.security.Permission permission) {
	   return permission instanceof AppsControlPermission;
	}

	public boolean equals(Object obj) { 
	   return obj instanceof AppsControlPermission;
	}

	public int hashCode() { 
	    return hash;
	}


}
