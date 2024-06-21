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

package net.beiker.xletview.app;

import java.io.File;

import net.beiker.xletview.ui.tree.UserObject;


public class App implements UserObject {

    private static String defaultBackgroundPath;
    private static int count;
    private String name;
    private String path;
    private String xletName;
    private String backgroundPath;

    public App(String projectName, String path, String xletName) {
        this.name = (projectName != null) ? projectName : "new app " + (count++);
        this.xletName = (xletName != null) ? xletName : "undefined";
        this.backgroundPath = (defaultBackgroundPath != null) ? defaultBackgroundPath : "undefined";
        this.path = (path != null) ? path : "";
        if (this.path.lastIndexOf(File.separator) > -1 && this.path.lastIndexOf(File.separator) == this.path.length() - 1) {
            this.path = this.path.substring(0, this.path.length() - 1);
        }
    }

    public static String getDefaultBackgroundPath() {
        return defaultBackgroundPath;
    }

    public static void setDefaultBackgroundPath(String path) {
        defaultBackgroundPath = path;
    }

    public String getBackgroundPath() {
        return backgroundPath;
    }

    public void setBackgroundPath(String path) {
        backgroundPath = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getXletName() {
        return xletName;
    }

    public void setXletName(String xletName) {
        this.xletName = xletName;
    }

    public String toString() {
        return name;
    }

    @Override
    public Object getObject() {
        return this;
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public Object[] getChildren() {
        return null;
    }

    @Override
    public boolean isBranch() {
        return false;
    }
}
