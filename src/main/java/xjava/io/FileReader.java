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

package xjava.io;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.lang.System.Logger;

import static java.lang.System.getLogger;


/**
 * @author Martin Sveden
 */
public class FileReader extends java.io.FileReader {

    /** Debugging facility */
    private static final Logger logger = getLogger(FileReader.class.getName());

//    public static java.io.FileReader create(java.io.File f) throws FileNotFoundException{
//        return new java.io.FileReader(File.getVirtualRoot() + f.getPath());
//    }
//
//    public static java.io.FileReader create(String fileName) throws FileNotFoundException{
//        return new java.io.FileReader(File.getVirtualRoot() + fileName);
//    }

    public FileReader(XFile f) throws FileNotFoundException {
        super(FileSystem.getFile(f));
    }

    public FileReader(String fileName) throws FileNotFoundException {
        super(FileSystem.getFile(fileName));
    }

    public FileReader(FileDescriptor fd) {
        super(fd);
    }

    public static java.io.FileReader create(xjava.io.XFile f) throws FileNotFoundException {
//        return new java.io.FileInputStream(f);
        return FileReader.create(f.getPath());
    }

    public static java.io.FileReader create(String fileName) throws FileNotFoundException {
        java.io.FileReader result = null;

//        xjava.io.File file = new xjava.io.File(fileName);

        java.io.File file = FileSystem.getFile(fileName);

        result = new java.io.FileReader(file);

//        try {
//            fis = new java.io.FileInputStream(File.getVirtualRoot() + fileName);
//        } catch (FileNotFoundException e) {
//            String s = e.getMessage();
//logger.log(Level.WARNING, s);
//        }

        return result;
    }
}
