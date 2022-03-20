/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Sveden

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package net.beiker.xletview.util;

import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;


public class Util {

    /** Debugging facility. */
    private static final Logger logger = Logger.getLogger(Util.class.getName());

    public static String normalizePath(String path){
        String s;
        s = path.replace('\\', File.separatorChar);
        s = s.replace('/', File.separatorChar);
        return s;
    }



    public static Frame getParentFrame(Component component){
        Frame frame;
        Component parent = component.getParent();
        if(parent instanceof Frame == false){
            frame = getParentFrame(parent);
        }
        else{
            return (Frame)parent;
        }
        return frame;
    }

    /**
     * Provides a safe and fast way of Integer.parseInt(String s);
     * @param s
     * @return An int that is at lease 0;
     */
    public static int parseInt(String s){
        int i = 0;
        try{
            i = Integer.parseInt(s.trim());
        }
        catch(NumberFormatException e){
            logger.severe(e.toString());
        }
        return i;
    }


    /**
     * Centers the component
     * @param comp the Component to be centered
     */
    public static void center(Component comp){
        GraphicsConfiguration gc = comp.getGraphicsConfiguration();
        Rectangle bounds = gc.getBounds();
        int x = (int) (bounds.getWidth() - comp.getWidth()) / 2;
        int y = (int) (bounds.getHeight() - comp.getHeight()) / 2;
        comp.setLocation(x, y);
    }

    /**
     * Finds the absolute path to a file from the classpath
     * @param theClass The class object whose classloader is used to retrieve the resource
     * @param path The relative path of the file
     * @return A String with the absolute path.
     * @throws RuntimeException If the file is not in the classpath
     */
    public static URLConnection getURLConnection(Class<?> theClass, String path) throws NullPointerException{
        URLConnection result;
        try {
            result = getURL(theClass, path).openConnection();
            return result;
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not open URL connection of '"+getURL(theClass, path)+"'.");
        }

    }

    public static boolean isChildOf(Container possibleParent, Component comp){

        boolean result = false;
        if(possibleParent != null && comp != null){
            Component parent = comp.getParent();
            if(parent == possibleParent){
                result = true;
            }
            else if(parent != null){
                result = isChildOf(possibleParent, parent);
            }
        }
        return result;
    }

    /**
     * Adds a string to a String[]
     * @param strings the old String[]
     * @param string the String to add
     * @return the new String[]
     */
    public static String[] addToStringArr(String[] strings, String string) {
        String[] newArr = new String[strings.length + 1];
        System.arraycopy(strings, 0, newArr, 0, strings.length);
        newArr[newArr.length - 1] = string;
        return newArr;
    }

    public static Image loadImage(String name, Component component){
        Image image = null;


        URL url = null;
        try {
            url = new URL(name);
        } catch (MalformedURLException e1) {

            // it's not very interesting to print this exception

            //e1.printStackTrace();
            //System.err.println(name + " was not a java.net.URL");
        }

        MediaTracker mediatracker = new MediaTracker(component);
        Toolkit toolkit = Toolkit.getDefaultToolkit();


        //log.print(url.toString());
        if(url == null){
            image = toolkit.getImage(name);
            logger.fine("loading image by string - " + name);

                        java.io.File f = new java.io.File(name);
                        if(f.exists() == false){
                            logger.warning(name + " was not found + " + f.getAbsolutePath());
                        }
        }
        else{
            image = toolkit.getImage(url);
            logger.fine("loading image by URL - " + url);
        }



        mediatracker.addImage(image, 0);
        try{
            mediatracker.waitForID(0);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }


        return image;
    }



    /**
     * @param class1
     * @param property
     * @return
     */
    public static URL getURL(Class<?> theClass, String path) {
//        URLConnection result = null;

        URL url = theClass.getClassLoader().getResource(path);

        logger.fine(url != null? "URL found for '"+path+"': it's '"+url.toString()+"'." : "Could not find URL for '"+path+"'.");

        if(url == null){

            throw new RuntimeException("the file " + path + " does not exist in the classpath");
        }
        else{
            return url;
        }

    }

    /**
     *
     * @return
     */
    public static String getStackTrace(){
        Exception exc = new RuntimeException("Fake exception to extract a stack trace");
        return getStackTrace(exc);
    }

    /**
     *
     * @param t
     * @return
     */
    public static String getStackTrace(Throwable t){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        pw.flush();
        sw.flush();
        return sw.getBuffer().toString();
    }
}
