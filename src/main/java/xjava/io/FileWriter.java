/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Sveden

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjava.io;

import java.io.FileDescriptor;
import java.io.IOException;

/**
 *
 * @author Martin Sveden
 */
public class FileWriter extends java.io.FileWriter{


    public FileWriter(String fileName) throws IOException {
        super(FileSystem.getFile(fileName));
    }

    public FileWriter(String fileName, boolean append) throws IOException {
        super(FileSystem.getFile(fileName), append);
    }

    public FileWriter(XFile file) throws IOException {
        super(FileSystem.getFile(file));
    }

    public FileWriter(FileDescriptor fd) throws IOException {
        super(FileSystem.getFile(fd));
    }

}
