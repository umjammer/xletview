/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Sveden

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package net.beiker.xletview.media;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.logging.Logger;

import org.dvb.ui.DVBGraphics;
import org.havi.ui.HScene;

import net.beiker.xletview.event.EventManager;
import net.beiker.xletview.ui.ProgressBar;
import net.beiker.xletview.ui.SafeArea;
import net.beiker.xletview.ui.XContainer;
import net.beiker.xletview.util.Settings;
import net.beiker.xletview.util.Util;


/**
 *  Has control over the background, video and graphics layer. There is also a
 *  fourth layer on top of the others for displaying additional stuff like safe
 *  area etc.
 *
 */
public class ScreenContainer extends Container {

    private static final Logger log = Logger.getLogger(ScreenContainer.class.getName());

    private static ScreenContainer THE_INSTANCE;


    // index 3 adds it last and therefore in the background
    public final static int BACKGROUND_LAYER = 3;

    public final static int VIDEO_LAYER = 2;

    // index 1 adds it first and therefore in the foreground
    public final static int GRAPHICS_LAYER = 1;

    // layer on top of everything that belongs to the emulator, for safe area marking etc.
    private final static int EMULATOR_LAYER = 0;

    private XContainer[] layers;

    private static int screenX = 0;
    private static int screenY = 0;

    public static int SCREEN_WIDTH = Util.parseInt(Settings.getProperty("tv.screenwidth"));
    public static int SCREEN_HEIGHT = Util.parseInt(Settings.getProperty("tv.screenheight"));

    private boolean eventEnabled;

    private static ProgressBar progressBar;


    /**
     *  Gets the instance attribute of the TV class
     *
     *@return    The instance value
     */
    public static ScreenContainer getInstance() {
        if (THE_INSTANCE == null) {
            THE_INSTANCE = new ScreenContainer();
        }
        return THE_INSTANCE;
    }

    public Dimension getPreferredSize() {
        return new Dimension(720, 576);
    }

    /**
     *  Constructor for the TV object
     */
    private ScreenContainer() {
        Toolkit.getDefaultToolkit().addAWTEventListener(EventManager.getInstance(), AWTEvent.KEY_EVENT_MASK);
        Toolkit.getDefaultToolkit().addAWTEventListener(EventManager.getInstance(), AWTEvent.FOCUS_EVENT_MASK);

        // catch all errors
        try {
            setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
            setLayout(null);
            // the layers on screen

            layers = new XContainer[4];

            layers[ScreenContainer.BACKGROUND_LAYER] = BackgroundLayer.getInstance();
            layers[ScreenContainer.VIDEO_LAYER] = VideoLayer.getInstance();
            layers[ScreenContainer.GRAPHICS_LAYER] = new XContainer();
            layers[ScreenContainer.EMULATOR_LAYER] = new XContainer();

            for (int i = 0; i < layers.length; i++) {
                layers[i].setBounds(screenX, screenY, SCREEN_WIDTH, SCREEN_HEIGHT);
                add(layers[i]);
            }

            // progress bar
            progressBar = new ProgressBar(SCREEN_WIDTH, 2, Color.GREEN, Color.BLACK);
            layers[ScreenContainer.EMULATOR_LAYER].add(progressBar);

            try {
                String strX = Settings.getProperty("safearea.x");
                int x = Integer.parseInt(strX);
                String strY = Settings.getProperty("safearea.y");
                int y = Integer.parseInt(strY);
                String strWidth = Settings.getProperty("safearea.width");
                int width = Integer.parseInt(strWidth);
                String strHeight = Settings.getProperty("safearea.height");
                int height = Integer.parseInt(strHeight);
                String hexColor = Settings.getProperty("safearea.color");
                if (Settings.getProperty("safearea.show").equals("true")) {
                    layers[ScreenContainer.EMULATOR_LAYER].add(new SafeArea(x, y, width, height, 3, Color.decode(hexColor)));
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }


        eventEnabled = true;
    }

    public void addToXletContainer(HScene scene) {

        // because there can only be one scene
        layers[ScreenContainer.GRAPHICS_LAYER].removeAll();

        // add the scene
        layers[ScreenContainer.GRAPHICS_LAYER].add(scene);

        // repaint it
        layers[ScreenContainer.GRAPHICS_LAYER].repaint();
        log.fine("layers[TV.GRAPHICS_LAYER].getComponentCount() = " + layers[ScreenContainer.GRAPHICS_LAYER].getComponentCount());
    }

    public Container getXletContainer() {
        return layers[ScreenContainer.GRAPHICS_LAYER];
    }

    public Container getBackgroundLayer() {
        return layers[ScreenContainer.BACKGROUND_LAYER];
    }

    public static void showProgressBar(){
        progressBar.setVisible(true);
    }

    public static void hideProgressBar(){
        progressBar.setVisible(false);
    }

    public static void updateProgressBar(int procent){
        progressBar.update(procent);
    }

    public void update(Graphics g){
        paint(g);
    }

    public void paint(Graphics g) {
//        for (int i = layers.length - 1; i > -1; i--) {
//            layers[i].paint(g);
//        }

        DVBGraphics dvbg = DVBGraphics.getDVBGraphics(g);

        layers[ScreenContainer.BACKGROUND_LAYER].paint(g);
        layers[ScreenContainer.VIDEO_LAYER].paint(g);
        layers[ScreenContainer.GRAPHICS_LAYER].paint(dvbg);
        layers[ScreenContainer.EMULATOR_LAYER].paint(g);

    }

}
