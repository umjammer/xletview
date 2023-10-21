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
import java.io.FilenameFilter;
import javax.swing.filechooser.FileFilter;


/**
 * @author Martin Sveden
 */
public class FileFilterImpl extends FileFilter implements FilenameFilter {

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

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        String s = file.getName();
        for (String string : filters) {
            if (s.indexOf(string) == s.length() - string.length()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        StringBuilder s = new StringBuilder("filters: ");
        for (String string : filters) {
            s.append(string).append(" ");
        }
        return s.toString();
    }

    /**
     * FilenameFilter implementation
     */
    @Override
    public boolean accept(File dir, String name) {
        for (String s : filters) {
            if (name.toLowerCase().endsWith(s)) {
                return true;
            }
        }
        return new File(dir, name).isDirectory();
    }

}
