/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.application;


public class AppID {

	public int getOID(){return 1;}
    
    public int getAID(){return 1;}
    
    public AppID(int oid, int aid){}

    public String toString(){return null;}

	public boolean equals( Object obj ) {
		return false;
	}

	public int hashCode() {
		return 0;
	}

}
