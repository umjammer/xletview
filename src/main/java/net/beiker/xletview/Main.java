/*
 * This file is part of XleTView
 * Copyright (C) 2003 Martin SvedÈn
 *
 * This is free software, and you are
 * welcome to redistribute it under
 * certain conditions;
 *
 * See LICENSE document for details.
 */

package net.beiker.xletview;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.lang.reflect.Constructor;
import java.net.URLClassLoader;

import net.beiker.xletview.classloader.MainClassLoader;
import net.beiker.xletview.util.CommandLine;
import net.beiker.xletview.util.Constants;

import static java.lang.System.getLogger;


/**
 * Main
 *
 * @author Martin Sveden
 */
public class Main {

    private static final Logger logger = getLogger(Main.class.getName());

    public static void main(String[] args) {
        int command = CommandLine.check(args);
        if (command == CommandLine.EXIT) {
            System.exit(0);
        }

        System.out.println(Constants.DISCLAIMER_MESSAGE);

        URLClassLoader systemLoader = (URLClassLoader) Main.class.getClassLoader();

        MainClassLoader loader = new MainClassLoader(systemLoader.getURLs());

        try {
            Class<?> dynamicClass = Class.forName("net.beiker.xletview.Startup", false, loader);
            Constructor<?> classConstructor = dynamicClass.getConstructor(String[].class);
            Object[] constructorArgs = {args};
            classConstructor.newInstance(constructorArgs);
        } catch (Exception e) {
            logger.log(Level.ERROR, e.getMessage(), e);
        }
    }
}
