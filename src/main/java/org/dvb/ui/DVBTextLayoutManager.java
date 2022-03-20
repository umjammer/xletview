/*
 *
 * This file is part of XleTView Copyright (C) 2003 Martin SvedÈn
 *
 * This is free software, and you are welcome to redistribute it under certain
 * conditions;
 *
 * See LICENSE document for details.
 *
 */

package org.dvb.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.Vector;

import org.dvb.user.GeneralPreference;
import org.dvb.user.Preference;
import org.dvb.user.UserPreferenceManager;
import org.havi.ui.HVisible;

/**
 * @author Martin Sveden
 * @statuscode 2
 * @comment fix:
 * align justify,
 * letter spacing,
 * tab spacing,
 * line orientation
 */
public class DVBTextLayoutManager implements org.havi.ui.HTextLayoutManager {

    public static final int HORIZONTAL_START_ALIGN = 1;
    public static final int HORIZONTAL_END_ALIGN = 2;
    public static final int HORIZONTAL_CENTER = 3;
    public static final int VERTICAL_START_ALIGN = 4;
    public static final int VERTICAL_END_ALIGN = 5;
    public static final int VERTICAL_CENTER = 6;
    public static final int LINE_ORIENTATION_HORIZONTAL = 10;
    public static final int LINE_ORIENTATION_VERTICAL = 11;
    public static final int START_CORNER_UPPER_LEFT = 20;
    public static final int START_CORNER_UPPER_RIGHT = 21;
    public static final int START_CORNER_LOWER_LEFT = 22;
    public static final int START_CORNER_LOWER_RIGHT = 23;

    private int horizontalAlign;
    private int verticalAlign;
    private int lineOrientation;
    private int startCorner;
    private boolean textWrap;
    private int lineSpace;
    private int letterSpace;
    private int horizontalTabSpace;
    private Insets insets;

    private String[] rows;
    private int[] rowWidths;
    private int ascent;
    private int rowHeight;
    private int textHeight;
    private int textWidth;

	private Vector listeners;

    public DVBTextLayoutManager() {
        this(HORIZONTAL_START_ALIGN, VERTICAL_START_ALIGN, LINE_ORIENTATION_HORIZONTAL, START_CORNER_UPPER_LEFT, true, -1234, 0, 56);
    }

    public DVBTextLayoutManager(int horizontalAlign, int verticalAlign, int lineOrientation, int startCorner, boolean wrap, int linespace, int letterspace, int horizontalTabSpace) {

        this.horizontalAlign = horizontalAlign;
        this.verticalAlign = verticalAlign;
        this.lineOrientation = lineOrientation;
        this.startCorner = startCorner;
        this.textWrap = wrap;

        if (linespace != -1234) {
            this.lineSpace = linespace;
        } else {

            /*
             * point size of the default font for HVisible + 7
             */

            UserPreferenceManager man = UserPreferenceManager.getInstance();
            Preference p;

            p = new GeneralPreference("Default Font Size");
            try {
                this.lineSpace = Integer.parseInt(p.getMostFavourite() + 7);
            } catch (NumberFormatException e) {
                this.lineSpace = -1;
            }
            man.read(p);
        }

        this.letterSpace = letterspace;
        this.horizontalTabSpace = horizontalTabSpace;

		this.listeners = new Vector();

    }

    public void setHorizontalAlign(int horizontalAlign) {
        this.horizontalAlign = horizontalAlign;
    }

    public void setVerticalAlign(int verticalAlign) {
        this.verticalAlign = verticalAlign;
    }

    public void setLineOrientation(int lineOrientation) {
        this.lineOrientation = lineOrientation;
    }

    public void setStartCorner(int startCorner) {
        this.startCorner = startCorner;
    }

    public void setTextWrapping(boolean wrap) {
        this.textWrap = wrap;
    }

    public void setLineSpace(int lineSpace) {
        this.lineSpace = lineSpace;
    }

    public void setLetterSpace(int letterSpace) {
        this.letterSpace = letterSpace;
    }

    public void setHorizontalTabSpacing(int horizontalTabSpace) {
        this.horizontalTabSpace = horizontalTabSpace;
    }

    public int getHorizontalAlign() {
        return horizontalAlign;
    }

    public int getVerticalAlign() {
        return verticalAlign;
    }

    public int getLineOrientation() {
        return lineOrientation;
    }

    public int getStartCorner() {
        return startCorner;
    }

    public boolean getTextWrapping() {
        return textWrap;
    }

    public int getLineSpace() {
        return lineSpace;
    }

    public int getLetterSpace() {
        return letterSpace;
    }

    public int getHorizontalTabSpacing() {
        return horizontalTabSpace;
    }

    public void setInsets(Insets insets) {
        this.insets = insets;
    }

    public Insets getInsets() {
        return insets;
    }

    public void addTextOverflowListener(TextOverflowListener listener) {
        if (listener != null) {
            listeners.add(listener);
        }
    }

    public void removeTextOverflowListener(TextOverflowListener listener) {
        if (listener != null) {
            listeners.remove(listener);
        }
    }

    private void notifyListeners(String markedUpString, HVisible hVisible, boolean overflowedHorizontally, boolean overflowedVertically) {
        for (int i = 0; i < listeners.size(); i++) {
            ((TextOverflowListener) listeners.get(i)).notifyTextOverflow(markedUpString, hVisible, overflowedHorizontally, overflowedVertically);
        }
    }

    public void render(String markedUpString, java.awt.Graphics g, HVisible hVisible, java.awt.Insets insets) {

        String lb = System.getProperty("line.separator");
        String string = markedUpString;

        //        String[] strings = string.split("\n");


        int x = 0;
        int y = 0;

        // get/set the font
        Font font = hVisible.getFont();
        g.setFont(font);

        // get/set color
        Color foreground = hVisible.getForeground();
        g.setColor(foreground);

        // get area to paint within
        int width = hVisible.getWidth() - insets.left - insets.right;
        int height = hVisible.getHeight() - insets.top - insets.bottom;

        // make rows
        createRows(string, font, width);

        boolean overflowH = false;
        boolean overflowV = false;

        for (int i = 0; i < rows.length; i++) {

            // get the x coordinate depending on horizontal alignment
            if (horizontalAlign == HORIZONTAL_CENTER) {
                x = (hVisible.getWidth() / 2) - (rowWidths[i] / 2);
            } else if (horizontalAlign == HORIZONTAL_START_ALIGN) {
                x = insets.left;
            } else if (horizontalAlign == HORIZONTAL_END_ALIGN) {
                x = hVisible.getWidth() - rowWidths[i] - insets.right;
            }

            // get the x coordinate depending on horizontal alignment
            if (verticalAlign == VERTICAL_CENTER) {
                y = (hVisible.getHeight() / 2) - (textHeight / 2) + ascent + (i * rowHeight);
            } else if (verticalAlign == VERTICAL_START_ALIGN) {
                y = insets.top + ascent + (i * rowHeight);
            } else if (verticalAlign == VERTICAL_END_ALIGN) {
                y = hVisible.getHeight() - insets.bottom - textHeight + ascent + (i * rowHeight);
            }

            // draw the String
            g.drawString(rows[i], x, y);



            if (textWidth > width) {
                overflowH = true;
            }
            if (textHeight > height) {
                overflowV = true;
            }
        }
        if (overflowH || overflowV) {
            notifyListeners(string, hVisible, overflowH, overflowV);
        }
    }

    /**
     * @param font
     * @param width
     *            width after the insets have been subtracted
     * @param height
     *            height after the insets have been subtracted
     */
    private void createRows(String string, Font font, int width) {
        rows = new String[0];
        rowWidths = new int[0];

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        FontMetrics fm = toolkit.getFontMetrics(font);

        String[] words;
        if(textWrap){
            words = string.split(" ");
        }
        else{
            words = new String[1];
            words[0] = string;
        }

        String tmp = "";

        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                // create the first row
                rows = addToStringArr(rows, words[i]);
            } else {
                if (fm.stringWidth(rows[rows.length - 1] + ' ' + words[i]) <= width) {
                    rows[rows.length - 1] += ' ' + words[i];
                } else {
                    rows = addToStringArr(rows, words[i]);
                }
            }
        }

        ascent = fm.getAscent();

        if(lineSpace == -1){
            rowHeight = fm.getHeight();
        }
        else{
            rowHeight = lineSpace;
        }

        textHeight = rows.length * rowHeight;
        textWidth = 0;

        for (int i = 0; i < rows.length; i++) {
            int rowWidth = fm.stringWidth(rows[i]);
            if (textWidth < rowWidth) {
                textWidth = rowWidth;
            }
            rowWidths = addToIntArr(rowWidths, rowWidth);
        }

    }

    private static String[] addToStringArr(String[] strings, String string) {
        String[] newArr = new String[strings.length + 1];
        System.arraycopy(strings, 0, newArr, 0, strings.length);
        newArr[newArr.length - 1] = string;
        return newArr;
    }

    private static int[] addToIntArr(int[] ints, int theInt) {
        int[] newArr = new int[ints.length + 1];
        System.arraycopy(ints, 0, newArr, 0, ints.length);
        newArr[newArr.length - 1] = theInt;
        return newArr;
    }

}
