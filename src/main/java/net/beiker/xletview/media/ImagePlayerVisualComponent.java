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

package net.beiker.xletview.media;

import java.awt.Graphics;
import java.awt.Image;
import java.lang.System.Logger.Level;
import java.net.URL;
import java.lang.System.Logger;
import javax.swing.ImageIcon;

import net.beiker.xletview.ui.XContainer;

import static java.lang.System.getLogger;


public class ImagePlayerVisualComponent extends XContainer {

    private static final Logger logger = getLogger(ImagePlayerVisualComponent.class.getName());

    private ImageIcon icon;
    private Image image;
    private String imageUrl;

    public ImagePlayerVisualComponent(String imageUrl) {
        icon = new ImageIcon(imageUrl);
        logger.log(Level.DEBUG, imageUrl + " - " + icon);
        repaint();
    }

    public ImagePlayerVisualComponent(URL imageUrl) {
        icon = new ImageIcon(imageUrl);
        logger.log(Level.DEBUG, imageUrl + " - " + icon);
        repaint();
    }

    /**
     * Flushes the image data
     */
    public void destroy() {
        icon.getImage().flush();
        icon = null;
        logger.log(Level.DEBUG, "destroy");
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
//        logger.log(Level.DEBUG, this, "paint, width height = " + getWidth() + "," + getHeight());
//        logger.log(Level.DEBUG, this, "paint, icon = " + icon);
//        logger.log(Level.DEBUG, this, "paint, this = " + this);
        if (icon != null) {
            int x = getX();
            int y = getY();
//            logger.log(Level.DEBUG, this, "x=" + x + ", y=" + y);
            g.drawImage(icon.getImage(), x, y, getWidth(), getHeight(), this);

        }
//        logger.log(Level.DEBUG, this, "paint");
//        if (icon != null) {
//
//            AWTVideoSizeControlImpl awtVideoSizeControl = AWTVideoSizeControlImpl.getInstance();
//            AWTVideoSize size                = awtVideoSizeControl.getSize();
//            int videoX          = size.getDestination().x;
//            int videoY          = size.getDestination().y;
//            int videoWidth      = size.getDestination().width;
//            int videoHeight     = size.getDestination().height;
//
//            g.drawImage(icon.getImage(), videoX, videoY, videoWidth, videoHeight, this);
//
//        }
    }
}
