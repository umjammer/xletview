/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package net.beiker.xletview.app;

import java.io.File;

import net.beiker.xletview.ui.tree.UserObject;

public class App implements UserObject{

    private String name;
    private String path;
    private String xletName;
    private static String defaultBackgroundPath;
    private String backgroundPath;
    private static int count;

    public App(String projectName, String path, String xletName){
        this.name = (projectName != null)? projectName: "new app " + (count++);        
        this.xletName = (xletName != null)? xletName: "undefined";
        this.backgroundPath = (defaultBackgroundPath != null)? defaultBackgroundPath: "undefined";        
        this.path = (path != null)? path: "";
        if(this.path.lastIndexOf(File.separator) > -1 && this.path.lastIndexOf(File.separator) == this.path.length()-1){
            this.path = this.path.substring(0, this.path.length()-1);            
        }    
    }

    public void setBackgroundPath(String path){
        backgroundPath = path;
    }

    public static void setDefaultBackgroundPath(String path){
        defaultBackgroundPath = path;
    }

    public String getBackgroundPath(){
        return backgroundPath;
    }

    public static String getDefaultBackgroundPath(){
        return defaultBackgroundPath;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPath(String path){
        this.path = path;
    }

    public String getPath(){
        return path;
    }

    public void setXletName(String xletName){
        this.xletName = xletName;
    }

    public String getXletName(){
        return xletName;
    }
    
    public String toString(){
        return name;
    }

    /* (non-Javadoc)
     * @see net.beiker.xletview.ui.tree.UserObject#getObject()
     */
    public Object getObject() {        
        return this;
    }

    /* (non-Javadoc)
     * @see net.beiker.xletview.ui.tree.UserObject#hasChildren()
     */
    public boolean hasChildren() {
        return false;
    }

    /* (non-Javadoc)
     * @see net.beiker.xletview.ui.tree.UserObject#getChildren()
     */
    public Object[] getChildren() {
        return null;
    }

    /* (non-Javadoc)
     * @see net.beiker.xletview.ui.tree.UserObject#isLeaf()
     */
    public boolean isBranch() {
        return false;
    }
}
