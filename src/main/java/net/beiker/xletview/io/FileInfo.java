/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package net.beiker.xletview.io;


import java.io.File;
import java.util.logging.Logger;

public class FileInfo{

    /** Debugging facility */
    private final static Logger logger = Logger.getLogger(FileInfo.class.getName());

    private File file;

    public FileInfo(File file){
        this.file = file;
    }

    public String getPath(){
        logger.fine("-->" + this.file.getPath());
        return this.file.getPath();
    }

    public String toString(){
        String name = this.file.getName();
        if(name.length() < 1) name = this.file.getPath();
        return name;
    }

}
