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

package xjava.io;

import java.io.FileNotFoundException;

/**
 * @author Martin Sveden
 */
public class FileInputStream extends java.io.FileInputStream {

    public FileInputStream(String fileName) throws FileNotFoundException {
        super(FileSystem.getFile(fileName));
    }

    public FileInputStream(XFile file) throws FileNotFoundException {
        super(FileSystem.getFile(file));
    }


}
