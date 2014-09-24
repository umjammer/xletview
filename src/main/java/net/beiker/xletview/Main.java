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

package net.beiker.xletview;

import java.lang.reflect.Constructor;
import java.net.URLClassLoader;

//import net.beiker.xletview.classloader.MainClassLoader;
import net.beiker.xletview.classloader.MainClassLoader;
import net.beiker.xletview.util.CommandLine;
import net.beiker.xletview.util.Constants;
//import net.sourceforge.mlf.metouia.MetouiaLookAndFeel;

/**
 * 
 * 
 * @author Martin Sveden
 */
public class Main {

	public static void main(String[] args) {
		int command = CommandLine.check(args);
		if(command == CommandLine.EXIT){
			System.exit(0);
		}
		
		System.out.println(Constants.DISCLAIMER_MESSAGE);
				
		URLClassLoader systemLoader = (URLClassLoader)Main.class.getClassLoader();
		
		MainClassLoader loader = new MainClassLoader(systemLoader.getURLs());
		
		try {	
			Class dynamicClass = Class.forName("net.beiker.xletview.Startup", false, loader);
			Class[] constructorArgumentTypes = { String[].class };
			Constructor classConstructor = dynamicClass.getConstructor(constructorArgumentTypes);
			Object[] constructorArgs = { args };
			classConstructor.newInstance(constructorArgs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
