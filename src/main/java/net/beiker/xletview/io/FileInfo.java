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

import net.beiker.cake.Log;
import net.beiker.cake.Logger;

public class FileInfo{

    /** Debugging facility */
	private final static Logger logger = Log.getLogger(FileInfo.class);

    private File file;

    public FileInfo(File file){
        this.file = file;
    }

    public String getPath(){
        logger.debug("-->" + this.file.getPath());
        return this.file.getPath();
    }

    public String toString(){
        String name = this.file.getName();
        if(name.length() < 1) name = this.file.getPath();
        return name;
    }

}
