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
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javassist.CannotCompileException;
import javassist.ClassMap;
import javassist.ClassPool;
import javassist.CodeConverter;
import javassist.CtClass;
import javassist.NotFoundException;

import static java.lang.System.getLogger;


/**
 * Loads the classes used in a Xlet. Each Xlet has their own instance of this
 * Classloader. This classloader also changes the bytecode of the Xlet classes
 * to get behaviours that better simulate the platform.
 *
 * @author Martin Sveden
 */
public final class XletClassLoader extends MainClassLoader {

    /** Debugging facility */
    private static final Logger logger = getLogger(XletClassLoader.class.getName());

    private Map<String, Class<?>> loadedClasses;
    private ClassPool pool;
    private ClassLoader parent;
    private ClassMap xletClassMap;


    public static void main(String[] args) {
        try {
            URL url = new URL(args[0]);

            logger.log(Level.DEBUG, "url=" + url);
            logger.log(Level.DEBUG, url.getFile());
        } catch (MalformedURLException e) {
            logger.log(Level.ERROR, e.getMessage(), e);
        }
    }

    /**
     * Creates a classloader for an Xlet
     *
     * @param virtualRoot A URL[] containing one URL with the location of the Xlet
     *                    at position 0, and possibly other URLs to retrieve class
     *                    files or resources from (extra class path).
     */
    public XletClassLoader(URL[] virtualRoot) {

        super(virtualRoot);

        // deprecated warning: we should consider extra class paths
//logger.log(Level.DEBUG, "XletClassLoader's URL ("+(virtualRoot.length==1?"OK: it's exactly one URL":"WARNING: should only be one URL")+"):");
        for (URL url : virtualRoot) {
            logger.log(Level.DEBUG, url.getPath());
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

//        try {
//            loadClass("xjava.io.XFile");
//        } catch (ClassNotFoundException e) {
//            logger.log(Level.ERROR, e.getMessage(), e);
//        }
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        name = name.replaceAll("/", ".");
        logger.log(Level.TRACE, "try to load: " + name);
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
                logger.log(Level.TRACE, e.toString());
            }
        }

        if (theClass == null) {
            // It's one of the Xlet's classes
            try {
                theClass = findClass(name);
                newClass = true;
            } catch (ClassNotFoundException e) {
                // do nothing
                logger.log(Level.TRACE, e.toString());
            }
        }


        if (theClass == null) {
            // The class is still not found. Throw an Exception
            throw new ClassNotFoundException(name);
        } else if (newClass) {
            // it wasn't previously loaded
            this.loadedClasses.put(name, theClass);
            logger.log(Level.DEBUG, "loaded class - " + name + ", " + this);
        }
        return theClass;

    }

    /**
     * Returns a class if previously loaded by this classloader.
     */
    private Class<?> getLoadedClass(String name) {
        return this.loadedClasses.get(name);
    }

    /**
     * Finds the class and modifies the bytecode if necessary.
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        try {

            logger.log(Level.DEBUG, "Loading Xlet class '" + name + "'.");

            CtClass cc = this.pool.get(name);

            logger.log(Level.DEBUG, "CHANGING BYTECODE IN " + name);
            if (!this.xletClassMap.containsKey(name)) {
                cc.replaceClassName(this.xletClassMap);
            }
            // convert code
            CodeConverter conv = new XletCodeConverter();
            cc.instrument(conv);


            // uncomment to see what the manipulation did
//            CtMethod[] methods = cc.getMethods();
//
//            logger.log(Level.DEBUG, "methods in " + name + " ----------------------- ");
//            logger.log(Level.DEBUG, "methods.length=" + methods.length);
//            for (int i = 0; i < methods.length; i++) {
//                String n = methods[i].getName();
//                String n2 = methods[i].getSignature();
//                logger.log(Level.DEBUG, "name:" + n);
//                logger.log(Level.DEBUG, "sign:" + n2);
//            }
//            logger.log(Level.DEBUG, "end methods ----------------------- ");

            byte[] b = cc.toBytecode();

            Class<?> theClass = null;

            try {
                theClass = super.defineClass(name, b, 0, b.length);
            } catch (SecurityException e) {
                // do nothing
                logger.log(Level.WARNING, e.toString());
            }

            return theClass;

        } catch (NotFoundException | IOException | CannotCompileException e) {
            throw (ClassNotFoundException) new ClassNotFoundException().initCause(e);
        }
    }

    @Override
    public URL getResource(String resource) {
        URL ret = null;
        logger.log(Level.DEBUG, "Locating RESOURCE '" + resource + "'.");
        for (URL url : getURLs()) {
            Path path = Paths.get(url.getPath(), resource);
            logger.log(Level.DEBUG, "path: " + path);
            if (Files.exists(path)) {
                try {
                    ret = path.toUri().toURL();
                } catch (MalformedURLException e) {
                    throw new IllegalArgumentException(path.toString());
                }
                break;
            }
        }
        logger.log(Level.DEBUG, ret == null ? "Resource was NOT FOUND." : "Resource was found.");
        return ret;
    }

    /**
     * This method is called by "jassist"'s LoaderClassPath; i.e. jassist as
     * we use it calls this method.
     * <p>
     * To change the template for this generated type comment go to
     * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
     *
     * @author intuidev
     */
    @Override
    public InputStream getResourceAsStream(String name) {
        InputStream ret = null;
        logger.log(Level.DEBUG, "Locating RESOURCE '" + name + "'.");
        for (URL url : getURLs()) {
            Path path = Paths.get(url.getPath(), name);
            logger.log(Level.DEBUG, "path: " + path);
            if (Files.exists(path)) {
                try {
                    ret = Files.newInputStream(path);
                } catch (IOException e) {
                    throw new IllegalArgumentException(path.toString());
                }
                break;
            }
        }
        logger.log(Level.DEBUG, ret == null ? "Resource was NOT FOUND." : "Resource was found.");
        return ret;
    }
}
