/*
 *
 * This file is part of XleTView Copyright (C) 2003 Martin SvedÈn
 *
 * This is free software, and you are welcome to redistribute it under certain
 * conditions;
 *
 * See LICENSE document for details.
 *
 */

package org.dvb.lang;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javassist.CannotCompileException;
import javassist.ClassMap;
import javassist.ClassPool;
import javassist.CodeConverter;
import javassist.CtClass;
import javassist.LoaderClassPath;
import javassist.NotFoundException;
import net.beiker.xletview.classloader.XletCodeConverter;

/**
 * @author Martin Sveden
 * @statuscode 3
 * @comment Have to fix the loading of DVBGraphics stuff, a bit buggy now.
 */
public abstract class DVBClassLoader extends java.security.SecureClassLoader {

    java.util.logging.Logger log = java.util.logging.Logger.getLogger(DVBClassLoader.class.getName());

    private URL[] urls;
    private ClassLoader parent;
    private Map<String, Class<?>> loaded;
    private ClassPool pool;
    private ClassMap xletClassMap;


    public DVBClassLoader(URL[] urls) {
        this.urls = urls;
        this.parent = getClass().getClassLoader();
        loaded = new HashMap<>();
        pool = new ClassPool(null);
        xletClassMap = new net.beiker.xletview.classloader.XletClassMap();
        addUrls(urls);

        pool.insertClassPath(new LoaderClassPath(parent));
    }

    public DVBClassLoader(URL[] urls, ClassLoader parent) {
        this(urls);
        this.parent = parent;
    }

    private void addUrls(URL[] urls){
        for (int i = 0; i < urls.length; i++) {
            try {
                String path = urls[i].getPath();
                path = path.substring(1);
                pool.appendClassPath(path);
                log.fine("DVBClassLoader, added " + path + " to the pool");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static DVBClassLoader newInstance(URL[] urls) {
        return new DVBClassLoaderImpl(urls);
    }

    public static DVBClassLoader newInstance(URL[] urls, ClassLoader parent) {
        return new DVBClassLoaderImpl(urls, parent);
    }

    public Class<?> loadClass(String name) throws ClassNotFoundException {
        name = name.replaceAll("/", ".");

//        logger.fine("loading - " + name);
        Class<?> theClass = null;
        boolean newClass = false;

        // check if it's already loaded by this loader
        theClass = getLoadedClass(name);


        if (theClass == null) {
            try {
                /*
                 * try to load the class with the parent classloader
                 */
                if (parent != null) {
                    theClass = parent.loadClass(name);
                }

            } catch (ClassNotFoundException e) {
                // do nothing
            }
        }

        if (theClass == null) {
             try{
                theClass = findClass(name);
                newClass = true;
            }
            catch(ClassNotFoundException e){
                // do nothing
            }
        }


        if(theClass == null){
            /*
             * The class is still not found.
             * Throw an Exception
             */
            throw new ClassNotFoundException("not found -> " + name);
        }
        else if(newClass){
            // it wasn't previously loaded
            loaded.put(name, theClass);
            //Debug.write(this, "name=" + name);
        }
        return theClass;

    }

    private Class<?> getLoadedClass(String name) {
        return (Class<?>) loaded.get(name);
    }


    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            CtClass cc = pool.get(name);

            cc.replaceClassName(xletClassMap);
            CodeConverter conv = new XletCodeConverter();
            cc.instrument(conv);


            byte[] b = cc.toBytecode();

            return super.defineClass(name, b, 0, b.length);
        }
        catch (NotFoundException e) {
            throw new ClassNotFoundException();
        }
        catch (IOException e) {
            throw new ClassNotFoundException();
        }
        catch (CannotCompileException e) {
            throw new ClassNotFoundException();
        }
    }




}
