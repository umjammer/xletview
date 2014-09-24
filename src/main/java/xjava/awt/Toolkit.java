/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Sveden
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjava.awt;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Image;
import java.awt.PrintJob;
import java.awt.datatransfer.Clipboard;
import java.awt.event.AWTEventListener;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Properties;

import xjava.io.FileSystem;



/**
 * Used to replace java.awt.Toolkit
 * 
 * @author Martin Sveden
 */
public class Toolkit {

	private static final net.beiker.cake.Logger log = net.beiker.cake.Log.getLogger(Toolkit.class);
	
    private static Toolkit thisToolkit;
    private static java.awt.Toolkit realToolkit;

    private Toolkit() {
    	realToolkit = java.awt.Toolkit.getDefaultToolkit();
    }

    /**
     * @see java.awt.Toolkit#getScreenSize()
     */
    public Dimension getScreenSize() {
        return realToolkit.getScreenSize();
    }

    /**
     * @see java.awt.Toolkit#getScreenResolution()
     */
    public int getScreenResolution() {
        return realToolkit.getScreenResolution();
    }

    /**
     * @see java.awt.Toolkit#getColorModel()
     */
    public ColorModel getColorModel() {
        return realToolkit.getColorModel();
    }

    /**
     * @see java.awt.Toolkit#getFontList()
     */
    public String[] getFontList() {
        return realToolkit.getFontList();
    }

    /**
     * @see java.awt.Toolkit#getFontMetrics(java.awt.Font font)
     */
    public FontMetrics getFontMetrics(java.awt.Font font) {
        return realToolkit.getFontMetrics(font);
    }

    /**
     * @see java.awt.Toolkit#sync()
     */
    public void sync() {
        realToolkit.sync();
    }

    /**
     * @see java.awt.Toolkit#getDefaultToolkit()
     */
    public static Toolkit getDefaultToolkit() {
        if (thisToolkit == null) {
            thisToolkit = new Toolkit();
        }
        return thisToolkit;
    }

    /**
     * 
     * @see java.awt.Toolkit#getImage(String filename)
     */
    public Image getImage(String filename) {
        log.debug("getImage(" + filename + ")");
        File f = null;
        try {
			f = FileSystem.getFile(filename);
		} catch (FileNotFoundException e) {
			// don't show stack trace
		}
        if(f != null){
        	filename = f.getPath();
        }
        
        return realToolkit.getImage(filename);
    }

    /**
     * @see java.awt.Toolkit#getImage(URL url)
     */
    public Image getImage(URL url) {
    	log.debug("getImage(" + url + ")");
    	// TODO fix
        return realToolkit.getImage(url);
    }

    /**
     * @see java.awt.Toolkit#prepareImage(Image image, int width, int height, ImageObserver observer)
     */
    public boolean prepareImage(Image image, int width, int height, ImageObserver observer) {
        return realToolkit.prepareImage(image, width, height, observer);
    }

    /**
     * @see java.awt.Toolkit#checkImage(Image image, int width, int height, ImageObserver observer) {
     */
    public int checkImage(Image image, int width, int height, ImageObserver observer) {
        return realToolkit.checkImage(image, width, height, observer);
    }
    
    /**
     * @see java.awt.Toolkit#gcreateImage(ImageProducer producer)
     */
    public Image createImage(ImageProducer producer) {
        return realToolkit.createImage(producer);
    }

    /**
     * @see java.awt.Toolkit#createImage(byte[] imagedata)
     */
    public Image createImage(byte[] imagedata) {
        return createImage(imagedata, 0, imagedata.length);
    }
    
    /**
     * @see java.awt.Toolkit#createImage(byte[] imagedata)
     */
    public Image createImage(String filename) {
        File f = null;
        try {
			f = FileSystem.getFile(filename);
		} catch (FileNotFoundException e) {		
			// don't show stack trace
		}
        if(f != null){
        	filename = f.getPath();
        }
    	return realToolkit.createImage(filename);
    }

    /**
     * @see java.awt.Toolkit#createImage(byte[] imagedata, int imageoffset, int imagelength)
     */
    public Image createImage(byte[] imagedata, int imageoffset, int imagelength) {
        return realToolkit.createImage(imagedata, imageoffset, imagelength);
    }
    
    /**
     * @see java.awt.Toolkit#getPrintJob(Frame frame, String jobtitle, Properties props)
     */
    public PrintJob getPrintJob(Frame frame, String jobtitle, Properties props) {
        return realToolkit.getPrintJob(frame, jobtitle, props);
    }
    
    /**
     * @see java.awt.Toolkit#beep()
     */
    public void beep() {
        realToolkit.beep();
    }
    
    /**
     * @see java.awt.Toolkit#getSystemClipboard()
     */
    public Clipboard getSystemClipboard() {
        return realToolkit.getSystemClipboard();
    }
    
    /**
     * @see java.awt.Toolkit#getMenuShortcutKeyMask()
     */
    public int getMenuShortcutKeyMask() {
        return realToolkit.getMenuShortcutKeyMask();
    }

    /*
     * The methods below exist since 1.2(not part of MHP) but are here
     * because they must be if the JVM is newer than 1.1.8 
     */

    public static String getProperty(String key, String defaultValue) {
        return java.awt.Toolkit.getProperty(key, defaultValue);
    }

    public final EventQueue getSystemEventQueue() {
        return realToolkit.getSystemEventQueue();
    }

    public void addAWTEventListener(AWTEventListener listener, long eventMask) {
        realToolkit.addAWTEventListener(listener, eventMask);
    }

    public void removeAWTEventListener(AWTEventListener listener) {
        realToolkit.removeAWTEventListener(listener);
    }

}
