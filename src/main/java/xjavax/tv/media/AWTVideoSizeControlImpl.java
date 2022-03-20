/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package xjavax.tv.media;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;

import net.beiker.xletview.media.MediaPlayer;
import net.beiker.xletview.media.ScreenContainer;


/**
 *
 *
 * @author Martin Sveden
 * @statuscode 2
 */
public class AWTVideoSizeControlImpl implements AWTVideoSizeControl{

    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(AWTVideoSizeControlImpl.class.getName());

    private static AWTVideoSizeControlImpl THE_INSTANCE;

    private AWTVideoSize defaultSize;
    private AWTVideoSize currentSize;
    private ScreenContainer tv;

    public static AWTVideoSizeControlImpl getInstance(){
        if(THE_INSTANCE == null){
               THE_INSTANCE = new AWTVideoSizeControlImpl();
        }
        return THE_INSTANCE;
    }

    private AWTVideoSizeControlImpl(){
        log.fine("---> " + ScreenContainer.SCREEN_WIDTH + ", " + ScreenContainer.SCREEN_HEIGHT);
        defaultSize = new AWTVideoSize(new Rectangle(0, 0 , ScreenContainer.SCREEN_WIDTH, ScreenContainer.SCREEN_HEIGHT), new Rectangle(0, 0 , ScreenContainer.SCREEN_WIDTH, ScreenContainer.SCREEN_HEIGHT));
        currentSize = defaultSize;
    }


    public AWTVideoSize checkSize(AWTVideoSize awtvideosize){
        return currentSize;
    }

    public AWTVideoSize getDefaultSize(){
        return defaultSize;
    }

    public AWTVideoSize getSize(){
        return currentSize;
    }

    public Dimension getSourceVideoSize(){
        Rectangle rect = currentSize.getSource();
        Dimension dim = new Dimension(rect.width, rect.height);
        return dim;
    }

    public boolean setSize(AWTVideoSize awtvideosize){
        currentSize = awtvideosize;

        log.fine("setSize");
        MediaPlayer.getInstance().setSize(awtvideosize);
        return true;
    }

    public Component getControlComponent(){
        return null;
    }

}
