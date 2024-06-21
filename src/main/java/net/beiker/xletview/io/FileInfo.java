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

package net.beiker.xletview.io;

import java.io.File;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

import static java.lang.System.getLogger;


public class FileInfo {

    /** Debugging facility */
    private final static Logger logger = getLogger(FileInfo.class.getName());

    private final File file;

    public FileInfo(File file) {
        this.file = file;
    }

    public String getPath() {
logger.log(Level.DEBUG, "-->" + this.file.getPath());
        return this.file.getPath();
    }

    public String toString() {
        String name = this.file.getName();
        if (name.isEmpty()) name = this.file.getPath();
        return name;
    }
}
