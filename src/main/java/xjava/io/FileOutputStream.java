/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Sveden

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjava.io;

import java.io.FileNotFoundException;

/**
 *
 * @author Martin Sveden
 */
public class FileOutputStream extends java.io.FileOutputStream{

    public FileOutputStream(String fileName) throws FileNotFoundException {
        super(FileSystem.getFile(fileName));
    }

    public FileOutputStream(java.io.File file) throws FileNotFoundException {
        super(FileSystem.getFile(file));
    }




}
