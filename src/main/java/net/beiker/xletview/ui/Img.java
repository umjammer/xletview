/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package net.beiker.xletview.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;

import net.beiker.cake.Log;
import net.beiker.cake.Logger;

public class Img extends Component{

	private static final Logger log = Log.getLogger(Img.class);

    private Image image;
    private String imageUrl;

    private int width;
    private int height;

    /**
     * Creates an image at x=0, y=0
     */
    public Img(String path){
        this(0, 0, path);
    }

    /**
     * Creates an image at the given coordinates
     * @param x the x coordinate
     * @param y the y coordinate
     * @param path the path to the image
     */
    public Img(int x, int y, String path){
        this.image = loadImage(path, null, this);
        this.width     = this.image.getWidth(this);
        this.height = this.image.getHeight(this);
        setBounds(x, y, this.width, this.height);
    }

    public Img(Image image){
        this.image = loadImage(image, this);
        this.width = image.getWidth(this);
        this.height = image.getHeight(this);
        setBounds(0, 0, this.width, this.height);
    }

    public Img(URL url, int width, int height){
        this(0, 0, width, height, url);
    }

    /**
     * Creates an image at x=0, y=0
     */
    public Img(URL url){
        this(0, 0, url);
    }

    /**
     * Creates an image at the given coordinates
     * @param x the x coordinate
     * @param y the y coordinate
     * @param url the url to the image
     */
    public Img(int x, int y, URL url){
        this.image = loadImage(null, url, this);
        this.width     = this.image.getWidth(this);
        this.height = this.image.getHeight(this);
        setBounds(x, y, this.width, this.height);
    }

    public Img(int x, int y, int width, int height, URL url){
        this.image = loadImage(null, url, this);
        this.width     = width;
        this.height = height;
        setBounds(x, y, this.width, this.height);
    }

    public Dimension getPreferredSize(){
        return new Dimension(this.width, this.height);
    }

    /**
     * Loads and Image and returns it when it's completely loaded
     * @param image
     * @param component
     * @return
     */
    private Image loadImage(Image image, Component component){
        MediaTracker mediatracker = new MediaTracker(component);
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
    * Loads images by name.
    * @param     name images'name
    * @return    java.awt.Image
    * @see   java.awt.MediaTracker
    * @see   java.awt.Toolkit
    */
    private Image loadImage(String name, URL url, Component component){
        MediaTracker mediatracker = new MediaTracker(component);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = null;
        if(name != null){
            image = toolkit.getImage(name);
            // just to see if the path is correct
            try{
                java.io.File f = new java.io.File(name);
                java.io.FileReader fr = new java.io.FileReader(f);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(url != null){
            image = toolkit.getImage(url);
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

    public void paint(Graphics g){
        if(this.image != null){
            //g.drawImage(image, 0, 0,this);
            g.drawImage(this.image, 0, 0, this.width, this.height, this);
        }
    }
}
