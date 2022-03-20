/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class HDefaultTextLayoutManager implements HTextLayoutManager{

    private int caretPosition;
    private boolean showCaret;

    public HDefaultTextLayoutManager(){
    }

    public Dimension getMinimumSize(HVisible hVisible){
        return hVisible.getMinimumSize();
    }

    public Dimension getMaximumSize(HVisible hVisible){
        return hVisible.getMaximumSize();
    }

    public Dimension getPreferredSize(HVisible hVisible){
        return hVisible.getPreferredSize();
    }

    /*
        " The string passed to the render method may be multi-line, where each line
        is separated by a "\n" (0x0A). If the string does not fit in the space
        available, the string shall be truncated and an ellipsis ("...") appended to
        indicate the truncation "
    */
    public void render(String string, Graphics g, HVisible hVisible, Insets insets){
        String lb = System.getProperty("line.separator");

        /*
            " The text should be laid out in the layout area, which is defined by
            the bounds of the specified HVisible, after subtracting the insets.
            If the insets are null the full bounding rectangle is used as the
            area to render text into.
        */
        int insetLeft      = 0;
        int insetRight     = 0;
        int insetTop       = 0;
        int insetBottom    = 0;
        if(insets != null){
            insetLeft      = insets.left;
            insetRight     = insets.right;
            insetTop       = insets.top;
            insetBottom    = insets.bottom;
        }

        String [] strings = string.split("\n");

        FontMetrics fontMetrics     = g.getFontMetrics();
        int x                       = 0;
        int y                       = 0;
        int ascentCompensation      = 3; // because the ascent is higher than it should be on normal letters
        int ascent                  = fontMetrics.getAscent() - ascentCompensation;
        int descent                 = fontMetrics.getDescent();
        int leading                 = fontMetrics.getLeading();
        int stringWidth             = fontMetrics.stringWidth(string);
        int stringHeight            = (ascent + descent + leading);
        int textHeight              = strings.length * (ascent + descent + leading);
        Font font                   = hVisible.getFont();

        g.setFont(font);

        Color foreground = hVisible.getForeground();
        g.setColor(foreground);

        for(int i = 0; i < strings.length; i++){
            stringWidth             = fontMetrics.stringWidth(strings[i]);

            // get the x coordinate depending on horizontal alignment

            int hAlign = hVisible.getHorizontalAlignment();

            if(hAlign == HVisible.HALIGN_CENTER || hAlign == HVisible.HALIGN_JUSTIFY){
                x = ( hVisible.getWidth()/2 ) - ( stringWidth/2);
            }
            else if(hAlign == HVisible.HALIGN_LEFT){
                x = insetLeft;
            }
            else if(hAlign == HVisible.HALIGN_RIGHT){
                x = hVisible.getWidth() - stringWidth - insetRight;
            }

            // get the x coordinate depending on horizontal alignment

            int vAlign = hVisible.getVerticalAlignment();

            if(vAlign == HVisible.VALIGN_CENTER || vAlign == HVisible.VALIGN_JUSTIFY){
                y = ( hVisible.getHeight()/2 ) - ( textHeight/2 ) + ascent + (i*stringHeight);
            }
            else if(vAlign == HVisible.VALIGN_TOP){
                y = insetTop + ascent + (i*stringHeight);
            }
            else if(vAlign == HVisible.VALIGN_BOTTOM){
                y = hVisible.getHeight() - insetBottom - textHeight + ascent + (i*stringHeight);
            }

            // draw the String
            g.drawString(strings[i], x, y );

            /*//////////////////////////////////////
             *
             * added stuff for HSinglelineInput
             *
             *//////////////////////////////////////

            //showCaret = true;
            //caretPosition = 3;
            if(showCaret){
                if(caretPosition > -1 && caretPosition < strings[i].length() + 1){

                    char[] chars = strings[i].toCharArray();

                    int caretX = x + fontMetrics.stringWidth(new String(chars, 0, caretPosition));
                    int caretY = y + 4;
                    int caretWidth = 0;
                    if(caretPosition < chars.length){
                        caretWidth = fontMetrics.stringWidth(chars[caretPosition] + "");
                    }
                    else{
                        caretWidth = fontMetrics.stringWidth("m");
                    }
                    int caretHeight = 2;
                    g.fillRect(caretX, caretY, caretWidth, caretHeight);
                }

                // always reset showCaret
                showCaret = false;
            }
        }
    }

    /*
     * Added stuff for HSinglelineInput
     */

    void setCaretVisible(boolean b){
        showCaret = b;
    }

    void setCaretPosition(int i){
        caretPosition = i;
    }


}
