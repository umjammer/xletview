/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Sveden

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package net.beiker.xletview.util;


import java.util.logging.Logger;

/**
 *
 * @author Martin Sveden
 */
public abstract class MemoryPrinter {

    /** Debugging facility. */
    private static final Logger logger = Logger.getLogger(MemoryPrinter.class.getName());

    /**
     *
     */
    public static void print() {
        long total = Runtime.getRuntime().totalMemory();
        long free = Runtime.getRuntime().freeMemory();
        logger.fine("free/used/total: " + format(free) + " / " + format(total - free) + " / " + format(total));
    }

    private static String format(long size) {
        String result = null;
        if (size < 1024) {
            result = "" + size;
        }
        else {
            result = (new Float(size / 1024).intValue()) + " K";
        }
        return result;
    }

}
