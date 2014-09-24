/*
 * 
 * This file is part of XleTView Copyright (C) 2003 Martin Svedén
 * 
 * This is free software, and you are welcome to redistribute it under certain
 * conditions;
 * 
 * See LICENSE document for details.
 *  
 */

package org.dvb.user;

import java.util.Hashtable;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public final class GeneralPreference extends Preference {

	private Hashtable prefs;

	public GeneralPreference(String name) throws IllegalArgumentException {
		super(name, "");
		if (!UserPreferenceManager.isValidPrefName(name)) {
			throw new IllegalArgumentException(
				name + " the preference's name is not supported");
		}
		
	}
	
	/*
	public static void main(String[] args) {
		
		UserPreferenceManager man = UserPreferenceManager.getInstance();
		Preference p;
		
		p = new GeneralPreference("User Language");
		man.read(p);
		System.out.println(p.toString());
		
		p = new GeneralPreference("Parental Rating");
		man.read(p);
		System.out.println(p.toString());
		
		p = new GeneralPreference("User Name");
		man.read(p);
		System.out.println(p.toString());
		
		p = new GeneralPreference("User Address");
		man.read(p);
		System.out.println(p.toString());
		
		p = new GeneralPreference("User @");
		man.read(p);
		System.out.println(p.toString());
		
		p = new GeneralPreference("Country Code");
		man.read(p);
		System.out.println(p.toString());
		
		p = new GeneralPreference("Default Font Size");
		man.read(p);
		System.out.println(p.toString());
		
	}
	*/
}
