/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Sveden

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package net.beiker.xletview.classloader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Hashtable;
import java.util.Vector;

import net.beiker.cake.Log;
import net.beiker.cake.Logger;

/**
 * This ClassLoader loads the emulator classes. This means that it's also the
 * parent classloader of all Xlets.
 *
 * @author Martin Sveden
 */
public class MainClassLoader extends URLClassLoader {
	
	/** Debugging facility. */
	private static final Logger logger = Log.getLogger(MainClassLoader.class);
	
    private Hashtable loadedClasses;

    public MainClassLoader(URL[] urls) {
    	super(urls);
    	addUrls();

        this.loadedClasses = new Hashtable();
    }


    public void addClassPath(String classpath){
    	String[] s = classpath.split(File.pathSeparator);
    	
    	for (int i = 0; i < s.length; i++) {    		
    		try {
    		    URL url = new File(s[i]).toURL();
    			super.addURL(url);
    			logger.debug("added " + url);
    		} catch (MalformedURLException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    private URL[] addUrls() {

    	Vector paths = new Vector();

    	// TODO: Throw that out, it belongs in a
    	//       META-INF/MANIFEST.MF file
    	paths.add("xletview.jar");
    	paths.add("JMF2.1.1/lib/jmf.jar");
    	paths.add("jars/nanoxml-2.2.3.jar");
    	paths.add("jars/metouia.jar");
    	paths.add("jars/javassist.jar");
    	paths.add("jars/log4j-1.2.8.jar");

    	URL[] urls = new URL[paths.size()];

    	for (int i = 0; i < paths.size(); i++) {
    		String s = (String) paths.get(i);
    		File f = new File(s);
    		try {
    			urls[i] = f.toURL();
    			super.addURL(urls[i]);
    		} catch (MalformedURLException e) {
    			e.printStackTrace();
    		}
    	}
    	return urls;
    }

    /*
     *  (non-Javadoc)
     * @see java.lang.ClassLoader#loadClass(java.lang.String)
     */
    public Class loadClass(String name) throws ClassNotFoundException {
    	
    	name = name.replaceAll("/", ".");

        Class theClass = null;

        boolean newClass = false;
        theClass = getLoadedClass(name);
        
        //don't let an instance of this classloader load the class of itself
        if(theClass == null && !name.equals(getClass().getName())){
            newClass = true;
            theClass = findClass(name);            
        }
        
        if(theClass == null){        	
            theClass = this.findSystemClass(name);            
        }


        if(theClass == null){
            throw new ClassNotFoundException();
        }
        
        if(newClass && theClass != null){
            this.loadedClasses.put(name, theClass);
        }
        return theClass;

    }

    /**
     * Returns a class if previously loaded by
     * this classloader.
     */
    private Class getLoadedClass(String name){
        return (Class)this.loadedClasses.get(name);
    }

    /*
     * overridden to take care of the exception 
     */
    protected Class findClass(String name) throws ClassNotFoundException {
        Class theClass = null;
        try {
            theClass = super.findClass(name);
        }
        catch (ClassNotFoundException e) {
        }
        return theClass;
    }

}
