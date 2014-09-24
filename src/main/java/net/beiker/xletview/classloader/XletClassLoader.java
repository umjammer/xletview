/*
 * 
 * This file is part of XleTView Copyright (C) 2003 Martin Sveden
 * 
 * This is free software, and you are welcome to redistribute it under certain
 * conditions;
 * 
 * See LICENSE document for details.
 *  
 */

package net.beiker.xletview.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;

import javassist.CannotCompileException;
import javassist.ClassMap;
import javassist.ClassPath;
import javassist.ClassPool;
import javassist.CodeConverter;
import javassist.CtClass;
import javassist.LoaderClassPath;
import javassist.NotFoundException;
import net.beiker.cake.Log;
import net.beiker.cake.Logger;


/**
 * Loads the classes used in an Xlet. Each Xlet has their own instance of this
 * Classloader. This classloader also changes the bytecode of the Xlet classes
 * to get behaviours that better simulate the platform.
 * 
 * @author Martin Sveden
 */
public final class XletClassLoader extends MainClassLoader {

	/** Debugging facility */
	private static final Logger logger = Log.getLogger(XletClassLoader.class);
	
	private Hashtable loadedClasses;
	private ClassPool pool;
	private ClassLoader parent;
	private ClassMap xletClassMap;


	public static void main(String[] args) {
		
		try {
			URL url = new URL("file:H:\\kamel");
			
			logger.debug("url=" + url);
			logger.debug(url.getFile());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates a classloader for an Xlet
	 * @param virtualRoot A URL[] containing one URL with the location of the Xlet
	 *                    at position 0, and possibly other URLs to retrieve class
	 *                    files or resources from (extra class path).
	 */
	public XletClassLoader(URL[] virtualRoot) {
		
		super(virtualRoot);
		
		// deprecated warning: we should consider extra class paths
		//logger.debug("XletClassLoader's URL ("+(virtualRoot.length==1?"OK: it's exactly one URL":"WARNING: should only be one URL")+"):");
		for (int i=0; i<virtualRoot.length; i++){
			logger.debug(virtualRoot[i]);
		}
		
		
		this.pool = new ClassPool();
		this.parent = getClass().getClassLoader();
		this.loadedClasses = new Hashtable();
		this.xletClassMap = new XletClassMap();

		
		ClassPath cp = new LoaderClassPath(this);
		this.pool.insertClassPath(cp);						
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.ClassLoader#loadClass(java.lang.String)
	 */
	public Class loadClass(String name) throws ClassNotFoundException {

		name = name.replaceAll("/", ".");
		
		Class theClass = null;
		boolean newClass = false;

		// check if it's already loaded by this loader
		theClass = getLoadedClass(name);

		if (theClass == null) {
			try {
				
				 // try to load the class with the parent classloader				 
				if (this.parent != null) {
					theClass = this.parent.loadClass(name);
				}

			} catch (ClassNotFoundException e) {
				// do nothing
			}
		}

		if (theClass == null) {
			/*
			 * It's one of the Xlet's classes
			 */
			try {
				theClass = findClass(name);
				newClass = true;
			} catch (ClassNotFoundException e) {
				// do nothing
			}
		}
		

		if (theClass == null) {
			/*
			 * The class is still not found. Throw an Exception
			 */
			throw new ClassNotFoundException(name);
		} else if (newClass) {
			// it wasn't previously loaded
			this.loadedClasses.put(name, theClass);
			logger.debug("loaded class - " + name + ", " + this);
		}
		return theClass;

	}

	/**
	 * Returns a class if previously loaded by this classloader.
	 */
	private Class getLoadedClass(String name) {
		return (Class) this.loadedClasses.get(name);
	}

	/**
	 * Finds the class and modifies the bytecode if necessary.
	 */
	protected Class findClass(String name) throws ClassNotFoundException {
		try {
			
			logger.debug("Loading Xlet class '"+name+"'.");
			
			CtClass cc = this.pool.get(name);

			logger.debug("CHANGING BYTECODE IN " + name);
			cc.replaceClassName(this.xletClassMap);

			// convert code
			CodeConverter conv = new XletCodeConverter();
			cc.instrument(conv);

			

			/*// uncomment to see what the manipulation did 
			CtMethod[] methods = cc.getMethods();
		
			log.debug("methods in " + name + " ----------------------- ");
			log.debug("methods.length=" + methods.length);
			for (int i = 0; i < methods.length; i++) {
				String n = methods[i].getName();
				String n2 = methods[i].getSignature();
				log.debug("name:" + n);
				log.debug("sign:" + n2);
			}
			log.debug("end methods ----------------------- ");
			*/
			
			byte[] b = cc.toBytecode();	
			
			Class theClass = null;
			
			try {
				theClass = super.defineClass(name, b, 0, b.length);
			} catch (SecurityException e) {
				// do nothing
			}
			
			return theClass;
			
		} catch (NotFoundException e) {
			throw new ClassNotFoundException();
		} catch (IOException e) {
			throw new ClassNotFoundException();
		} catch (CannotCompileException e) {
			throw new ClassNotFoundException();
		}
	}

	 /**
     * 
     * @return
     */
    public URL getResource(String resource){
    	logger.debug("Locating RESOURCE '"+resource+"'.");
		URL ret = super.getResource(resource);
		logger.debug(ret == null ? "Resource was NOT FOUND." : "Resource was found.");
		return ret;
    }
    
    /**
     * 
     * @author intuidev
     *
     * To change the template for this generated type comment go to
     * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
     */
    
	/* This method is called by "jassist"'s LoaderClassPath; i.e. jassist as
	 * we use it calls this method.
	 */
	public InputStream getResourceAsStream(String arg0) {
		logger.debug("Locating RESOURCE '"+arg0+"'.");
		InputStream ret = super.getResourceAsStream(arg0);
		logger.debug(ret == null ? "Resource was NOT FOUND." : "Resource was found.");
		return ret;
	}
}
