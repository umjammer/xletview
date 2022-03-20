/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Sveden

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package net.beiker.xletview.media;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import net.beiker.xletview.ui.XContainer;



public class BackgroundLayer extends XContainer {

//    private static final Logger log = Logger.getLogger(BackgroundLayer.class.getName());

    private static BackgroundLayer THE_INSTANCE;
    private Image bgImage;


    private BackgroundLayer() {
        setBounds(0, 0, ScreenContainer.SCREEN_WIDTH, ScreenContainer.SCREEN_HEIGHT);
        setBackground(Color.BLACK);
        // works in linux
        //Img img = new Img(0, 0, TvMain.home + "/config/defaultbg.jpg");
        //add(img);
    }

    public static BackgroundLayer getInstance() {
        if (THE_INSTANCE == null) {
            THE_INSTANCE = new BackgroundLayer();

        }
        return THE_INSTANCE;
    }

    public void setBgImage(Image image){
        bgImage = image;
    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        if(bgImage != null){
            g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

}
