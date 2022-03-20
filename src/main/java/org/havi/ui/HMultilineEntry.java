/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;


public class HMultilineEntry extends HSinglelineEntry{

    public HMultilineEntry(){
    }

    public HMultilineEntry(String text, int x, int y, int width, int height, int maxChars, java.awt.Font font, java.awt.Color color){
    }

    public HMultilineEntry(int x, int y, int width, int height, int maxChars){
    }

    public HMultilineEntry(String text, int maxChars, java.awt.Font font, java.awt.Color color){
    }

    public HMultilineEntry(int maxChars){
    }

    public static void setDefaultLook(HMultilineEntryLook look){
    }

    public static HSinglelineEntryLook getDefaultLook(){
        return (null);
    }

    public void setLook(HLook hlook) throws HInvalidLookException{
    }

    public void caretNextLine(){
    }

    public void caretPreviousLine(){
    }
}
