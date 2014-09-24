/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Sveden
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjava.awt;


/**
 * This class is used when the Xlet creates a new
 * instance of java.awt.Font
 * It makes it possible to adjust the over all
 * font size so it looks more like on television.
 * @author Martin Sveden
 */
public class Font{
	
    private static int offset = 0;

    /**
     * When a class in the Xlet do a new java.awt.Font(String name, int type, int size)
     * this method is used to return a java.awt.Font object but adjust
     * the size before it return it.
     * @param name Font name
     * @param type Font type
     * @param size Font size - might be adjusted in this method
     * @return
     */
    public static java.awt.Font create(String name, int type, int size){
        int resolution = Toolkit.getDefaultToolkit().getScreenResolution();        
                
        //int newSize = (int)Math.round(size * resolution / 72.0);
        int newSize = size;
        newSize = newSize + offset;
		
		return new java.awt.Font(name, type, newSize);
    }
    
    public static void setOffset(int fontSizeOffset){
        offset = fontSizeOffset;
    }
}
