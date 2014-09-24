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
import java.io.FileFilter;

/**
 *@author Martin Sveden
 */
public class DirFilter implements FileFilter{
    String filter;
    String[] filters;

    public DirFilter(String filter) {
        this.filter = filter;
        filters = new String[1];
        filters[0] = filter;
    }


    public DirFilter(String[] filters) {
        this.filters = filters;
    }

    public boolean accept(File file) {
        if(file.isDirectory()){
            return true;
        }
        String s = file.getName();
        //Debug.write(this, s);
        for (int i = 0; i < filters.length; i++) {
            if (s.indexOf(filters[i]) == s.length() - filters[i].length()) {
                return true;
            }
        }
        return false;
    }

}
