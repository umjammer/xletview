/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.ui;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

/**
 * Implementation of the <code>DVBBufferedImage</code> using delegates to
 * <code>java.awt.image.BufferedImage</code>
 * @see java.awt.image.BufferedImage
 *
 * @author Christian K&ouml;berl
 * @version $Revision: 1.6 $
 * @statuscode 4
 */
public class DVBBufferedImage extends java.awt.Image {

    public static final int TYPE_ADVANCED = 20;

    public static final int TYPE_BASE = 21;

    private BufferedImage bimg;

    public DVBBufferedImage(int width, int height) {
        bimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    public DVBBufferedImage(int width, int height, int type)
    {
        bimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    private DVBBufferedImage(BufferedImage bimg)
    {
        this.bimg = bimg;
    }

    public DVBGraphics createGraphics() {
        return bimg == null ? null : new DVBGraphicsImpl(bimg.createGraphics());
    }

    public java.awt.Graphics getGraphics() {
        return createGraphics();
    }

    public void flush() {
        if(bimg != null)
            bimg.flush();
    }

    public int getHeight() {
        return bimg == null ? -1 : bimg.getHeight();
    }

    public int getHeight(ImageObserver observer) {
        return bimg == null ? -1 : bimg.getHeight(observer);
    }

    public Image getImage()    {
        return bimg;
    }

    public void dispose() {
        bimg = null;
    }

    public Object getProperty(String name, ImageObserver observer) {
        return bimg == null ? null : bimg.getProperty(name, observer);
    }

    public int getRGB(int x, int y) {
        return bimg == null ? -1 : bimg.getRGB(x, y);
    }

    public int[] getRGB(int startX, int startY, int w, int h, int[] rgbArray, int offset, int scansize) {
        return bimg == null ? null : bimg.getRGB(startX, startY, w, h, rgbArray, offset, scansize);
    }

    public ImageProducer getSource() {
        return bimg == null ? null : bimg.getSource();
    }

    public DVBBufferedImage getSubimage (int x, int y, int w, int h) throws DVBRasterFormatException {
        return bimg == null ? null : new DVBBufferedImage(bimg.getSubimage(x, y, w, h));
    }

    public int getWidth() {
        return bimg == null ? -1 : bimg.getWidth();
    }

    public int getWidth(ImageObserver observer) {
        return bimg == null ? -1 : bimg.getWidth(observer);
    }

    public synchronized void setRGB(int x, int y, int rgb) {
        if(bimg != null)
            bimg.setRGB(x, y, rgb);
    }

    public void setRGB(int startX, int startY, int w, int h, int[] rgbArray, int offset, int scansize) {
        if(bimg != null)
            bimg.setRGB(startX, startY, w, h, rgbArray, offset, scansize);
    }

    public String toString() {
        StringBuffer buf = new StringBuffer("DVBBufferedImage@");
        buf.append(Integer.toHexString(hashCode()));
        if(bimg != null)
        {
            buf.append(": type = ").append(bimg.getType()).append(" ");
            buf.append(bimg.getColorModel()).append(" ").append(bimg.getRaster());
        }
        return buf.toString();
    }

    public java.awt.Image getScaledInstance(int width, int height, int hints) {
        return bimg == null ? null : bimg.getScaledInstance(width, height, hints);
    }

}
