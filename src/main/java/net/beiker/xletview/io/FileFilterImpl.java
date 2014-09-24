/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/
package net.beiker.xletview.io;

import java.io.File;
import java.io.FilenameFilter;

import javax.swing.filechooser.FileFilter;

/**
 * @author Martin Sveden
 */
public class FileFilterImpl extends FileFilter implements FilenameFilter{

    String filter;
    String[] filters;

    public FileFilterImpl(String filter) {
        this.filter = filter;
        filters = new String[1];
        filters[0] = filter;
    }


    public FileFilterImpl(String[] filters) {
        this.filters = filters;
    }

    public boolean accept(File file) {
        if(file.isDirectory()){
            return true;
        }
        String s = file.getName();
        for (int i = 0; i < filters.length; i++) {
            if (s.indexOf(filters[i]) == s.length() - filters[i].length()) {
                return true;
            }
        }
        return false;
    }

    public String getDescription() {
        String s = "filters: ";
        for(int i = 0; i < filters.length; i++){
            s += filters[i] + " ";
        }
        return s;
    }

    /**
     * FilenameFilter implementation
     */ 
    public boolean accept(File dir, String name) {        
        for (int i = 0; i < filters.length; i++) {
            if (name.toLowerCase().endsWith(filters[i])) {
                return true;
            }
        }
        return new File(dir, name).isDirectory();
    }

}
