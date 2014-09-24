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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 * @comment The preferences are hardcoded - fix, write not implemented
 */
public class UserPreferenceManager {

	private static final Hashtable prefs;
	
	private static UserPreferenceManager THE_INSTANCE;
	
	private static final String USER_LANGUAGE = "User Language";
	private static final String PARENTAL_RATING = "Parental Rating";
	private static final String USERNAME = "User Name";
	private static final String ADDRESS = "User Address";
	private static final String EMAIL = "User @";
	private static final String COUNTRYCODE = "Country Code";
	private static final String FONTSIZE = "Default Font Size";
	
	private static final String settingsPath = "config/user.preference";
	
	private Vector listeners;
	
	static{
		prefs = new Hashtable();
		prefs.put(USER_LANGUAGE, "");
		prefs.put(PARENTAL_RATING, "");
		prefs.put(USERNAME, "");
		prefs.put(ADDRESS, "");
		prefs.put(EMAIL, "");
		prefs.put(COUNTRYCODE, "");
		prefs.put(FONTSIZE, "");	
	}
	
	static boolean isValidPrefName(String name){
		return prefs.containsKey(name);
	}
	
	private UserPreferenceManager() {
		listeners = new Vector();
		
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(settingsPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String string;
		
		string = props.getProperty("user.language");		
		prefs.put(USER_LANGUAGE, getPrefArr(string));
		
		string = props.getProperty("parental.rating");		
		prefs.put(PARENTAL_RATING, getPrefArr(string));
		
		string = props.getProperty("user.name");		
		prefs.put(USERNAME, getPrefArr(string));
		
		string = props.getProperty("user.address");		
		prefs.put(ADDRESS, getPrefArr(string));
		
		string = props.getProperty("user.email");		
		prefs.put(EMAIL, getPrefArr(string));
		
		string = props.getProperty("country.code");		
		prefs.put(COUNTRYCODE, getPrefArr(string));
		
		string = props.getProperty("font.size");		
		prefs.put(FONTSIZE, getPrefArr(string));
	}

	private static String[] getPrefArr(String s){
		String[] arr = s.split(",");
		String[] result = new String[arr.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = arr[i].trim();
		}
		return result;
	}
	
	public static UserPreferenceManager getInstance() {
		if(THE_INSTANCE == null){
			THE_INSTANCE = new UserPreferenceManager();
		}
		return THE_INSTANCE;
	}

	public void read(Preference p) {
		String name = p.getName();
		String[] s = (String[]) prefs.get(name);
		p.add(s);
		
		UserPreferenceChangeEvent event = new UserPreferenceChangeEvent(name);
		notifyListeners(event);
	}

	public void read(Preference p, Facility facility) {
		
		String name = p.getName();
		String fName = facility.getPreference();
		
		
		if(name != null && name.equals(fName)) {
			String[] s = (String[]) prefs.get(name);
			String[] wanted = facility.getValues();
			
			for (int i = 0; i < wanted.length; i++) {
				for (int j = 0; j < s.length; j++) {
					if(s[j].equals(wanted[i])){
						p.add(s[j]);
						UserPreferenceChangeEvent event = new UserPreferenceChangeEvent(name);
						notifyListeners(event);
					}
				}
			}
		}
		
	}

	public void write(Preference p)
		throws UnsupportedPreferenceException, IOException {
	}

	public void addUserPreferenceChangeListener(UserPreferenceChangeListener listener) {
		if(listener != null){
			listeners.add(listener);
		}
	}

	public void removeUserPreferenceChangeListener(UserPreferenceChangeListener listener) {
		if(listener != null){
			listeners.remove(listener);
		}
	}
	
	private void notifyListeners(UserPreferenceChangeEvent event){
		for(int i = 0; i < listeners.size(); i++){
			((UserPreferenceChangeListener) listeners.get(i)).receiveUserPreferenceChangeEvent(event);
		}
	}

}
