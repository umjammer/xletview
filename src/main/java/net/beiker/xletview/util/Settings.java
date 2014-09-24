/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Sveden
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package net.beiker.xletview.util;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

import net.beiker.xletview.Startup;
import net.beiker.xletview.window.ConsoleWindow;

/**
 * Parses a settings file and holds the values.
 */
public class Settings {

	private static final net.beiker.cake.Logger log = net.beiker.cake.Log.getLogger(Settings.class);
	
    private static Properties properties;
    private static File file;
    private static String instruction = "" + 
    "#Mind that paths can not contain backslash" + System.getProperty("line.separator") +  
    "#Make sure there are no spaces after the values" +  System.getProperty("line.separator");
    
    private static String[] exclude = {"path.home"};
    private Settings() {
    }

    public static void load(InputStream is) {
        //Settings.file = file;
        Properties p = new Properties();
        properties = p;
        try {
        	//InputStream fis = Settings.class.getClassLoader().getResourceAsStream(Constants.PATH_SETTINGS);
            //FileInputStream fis = new FileInputStream(file);
            p.load(is);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void beforeSave() {
        Properties p = Settings.getProperties();
        Point point = ConsoleWindow.getInstance().getLocation();
        p.setProperty("console.x", "" + point.x);
        p.setProperty("console.y", "" + point.y);
    }

    public static void save() {
        beforeSave();
        //try {
            URLConnection settingsPath = Util.getURLConnection(Startup.class, Constants.PATH_SETTINGS);
            //String settingsPath = Settings.getProperty("path.home") + Constants.PATH_SETTINGS;            
            //File file2 = new File(settingsPath);
            //System.out.println(file.getAbsolutePath());
            //FileOutputStream os = new FileOutputStream(settingsPath);
            OutputStream os = null;
			try {
				os = settingsPath.getOutputStream();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			OutputStreamWriter osw = new OutputStreamWriter(os);
            
            
            // Sort 
            Vector v = new Vector(properties.keySet());
            Collections.sort(v);

            try {
                osw.write(instruction + System.getProperty("line.separator"));
                Enumeration enum_ = v.elements();
                while (enum_.hasMoreElements()) {
                    String name = (String) enum_.nextElement();
                    boolean include = true;
                    for(int i = 0; i < exclude.length; i++){
                        if(name.indexOf(exclude[i]) != -1){
                            include = false;
                            break;
                        }
                    }
                    if(include){
                        String value = properties.getProperty(name);
                        log.debug(name + "=" + value);

                        osw.write(name + "=" + fixPath(value) + System.getProperty("line.separator"));
                    }
                }
            }
            catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                osw.close();
            }
            catch (IOException e1) {
                e1.printStackTrace();
            }

        //}
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * Used because it doesn't work to have backslash in the properties file 
     */
    public static String fixPath(String path) {
        String s;
        s = path.replace(File.separatorChar, '/');
        return s;
    }

    public static void setProperties(Properties p) {
        properties = p;
    }

    public static Properties getProperties() {
        return properties;
    }

    public static String getProperty(String key) {
        //Debug.write(Settings.class, key);
        return properties.getProperty(key);
    }

    public static void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }
}
