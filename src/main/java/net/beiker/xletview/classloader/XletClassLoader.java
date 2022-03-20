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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javassist.CannotCompileException;
import javassist.ClassMap;
import javassist.ClassPool;
import javassist.CodeConverter;
import javassist.CtClass;
import javassist.NotFoundException;


/**
 * Loads the classes used in an Xlet. Each Xlet has their own instance of this
 * Classloader. This classloader also changes the bytecode of the Xlet classes
 * to get behaviours that better simulate the platform.
 *
 * @author Martin Sveden
 */
public final class XletClassLoader extends MainClassLoader {

    /** Debugging facility */
    private static final Logger logger = Logger.getLogger(XletClassLoader.class.getName());

    private Map<String, Class<?>> loadedClasses;
    private ClassPool pool;
    private ClassLoader parent;
    private ClassMap xletClassMap;


    public static void main(String[] args) {

        try {
            URL url = new URL(args[0]);

            logger.fine("url=" + url);
            logger.fine(url.getFile());
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
        //logger.fine("XletClassLoader's URL ("+(virtualRoot.length==1?"OK: it's exactly one URL":"WARNING: should only be one URL")+"):");
        for (int i=0; i<virtualRoot.length; i++){
            logger.fine(virtualRoot[i].getPath());
        }


        this.pool = new ClassPool();
        this.parent = getClass().getClassLoader();
        this.loadedClasses = new HashMap<>();
        this.xletClassMap = new XletClassMap();


        Arrays.stream(virtualRoot).map(URL::getPath).forEach(s -> {
            try {
                pool.insertClassPath(s);
            } catch (NotFoundException e) {
                throw new IllegalArgumentException("xlet option: " + s);
            }
        });

        try {
            loadClass("xjava.io.XFile");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.ClassLoader#loadClass(java.lang.String)
     */
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        name = name.replaceAll("/", ".");
logger.finer("try to load: " + name);
        Class<?> theClass = null;
        boolean newClass = false;

        // check if it's already loaded by this loader
        theClass = getLoadedClass(name);

        if (theClass == null) {
            try {

                 // try to load the class with the parent classloader
                if (this.parent != null) {
                    theClass = this.parent.loadClass(name);
                }

            } catch (ClassNotFoundException | java.lang.NoClassDefFoundError e) {
                // do nothing
                logger.finer(e.toString());
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
                logger.finer(e.toString());
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
            logger.fine("loaded class - " + name + ", " + this);
        }
        return theClass;

    }

    /**
     * Returns a class if previously loaded by this classloader.
     */
    private Class<?> getLoadedClass(String name) {
        return (Class<?>) this.loadedClasses.get(name);
    }

    /**
     * Finds the class and modifies the bytecode if necessary.
     */
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        try {

            logger.fine("Loading Xlet class '"+name+"'.");

            CtClass cc = this.pool.get(name);

            logger.fine("CHANGING BYTECODE IN " + name);
            cc.replaceClassName(this.xletClassMap);

            // convert code
            CodeConverter conv = new XletCodeConverter();
            cc.instrument(conv);



            // uncomment to see what the manipulation did
//            CtMethod[] methods = cc.getMethods();
//
//            logger.fine("methods in " + name + " ----------------------- ");
//            logger.fine("methods.length=" + methods.length);
//            for (int i = 0; i < methods.length; i++) {
//                String n = methods[i].getName();
//                String n2 = methods[i].getSignature();
//                logger.fine("name:" + n);
//                logger.fine("sign:" + n2);
//            }
//            logger.fine("end methods ----------------------- ");

            byte[] b = cc.toBytecode();

            Class<?> theClass = null;

            try {
                theClass = super.defineClass(name, b, 0, b.length);
            } catch (SecurityException e) {
                // do nothing
                logger.warning(e.toString());
            }

            return theClass;

        } catch (NotFoundException | IOException | CannotCompileException e) {
            throw (ClassNotFoundException) new ClassNotFoundException().initCause(e);
        }
    }

     /**
     *
     * @return
     */
    public URL getResource(String resource){
        URL ret = null;
        logger.fine("Locating RESOURCE '"+resource+"'.");
        for (URL url : getURLs()) {
            Path path = Paths.get(url.getPath(), resource);
logger.fine("path: " + path);
            if (Files.exists(path)) {
                try {
                    ret = path.toUri().toURL();
                } catch (MalformedURLException e) {
                    throw new IllegalArgumentException(path.toString());
                }
                break;
            }
        }
        logger.fine(ret == null ? "Resource was NOT FOUND." : "Resource was found.");
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
    public InputStream getResourceAsStream(String name) {
        InputStream ret = null;
        logger.fine("Locating RESOURCE '"+name+"'.");
        for (URL url : getURLs()) {
            Path path = Paths.get(url.getPath(), name);
logger.fine("path: " + path);
            if (Files.exists(path)) {
                try {
                    ret = Files.newInputStream(path);
                } catch (IOException e) {
                    throw new IllegalArgumentException(path.toString());
                }
                break;
            }
        }
        logger.fine(ret == null ? "Resource was NOT FOUND." : "Resource was found.");
        return ret;
    }
}
