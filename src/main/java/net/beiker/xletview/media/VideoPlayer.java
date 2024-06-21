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

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.RealizeCompleteEvent;
import javax.media.Time;
import javax.swing.JFrame;

import net.beiker.xletview.ui.XContainer;

import static java.lang.System.getLogger;


public class VideoPlayer extends JFrame implements ControllerListener {

    /** Debugging facility. */
    private static final Logger logger = getLogger(VideoPlayer.class.getName());

    private static int count;
    public static final int WIDTH = 720;
    public static final int HEIGHT = 576;
    public static final char FS = File.separatorChar;

    private Player player;
    private Container cont;
    private XContainer cont2;
    private XContainer xcont;

    public VideoPlayer() {
        this.setTitle("VideoPlayer");
        this.cont = getContentPane();
        logger.log(Level.DEBUG, this + this.cont.getClass().getName());
        this.xcont = new XContainer();
        this.cont2 = new XContainer();
        this.cont2.setLayout(new BorderLayout());
        this.cont2.setBounds(0, 0, 400, 400);
        this.setContentPane(this.cont2);

        createPlayer();
        if (this.player != null) {
            this.player.realize();
            this.player.start();
        } else {
            logger.log(Level.WARNING, this + toString() + "player is null");
        }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        setSize(400, 400);
        setVisible(true);
    }

    public void createPlayer() {
        String fileName = "file:///C:/myDocs/dev/java/myriam.avi";
        MediaLocator mediaLocator = null;

        try {
            mediaLocator = new MediaLocator(fileName);
            Manager.setHint(Manager.LIGHTWEIGHT_RENDERER, Boolean.TRUE);
            this.player = Manager.createPlayer(mediaLocator);
            this.player.addControllerListener(this);
        } catch (Exception e) {
            logger.log(Level.ERROR, e.getMessage(), e);
        }
    }

    @Override
    public synchronized void controllerUpdate(ControllerEvent event) {
        logger.log(Level.DEBUG, this + toString() + "event = " + event);
        if (event instanceof RealizeCompleteEvent) {
            Component comp;
            if ((comp = this.player.getVisualComponent()) != null) {

//             JPanel jp = new JPanel();
//             jp.setBounds(20, 40, 10, 10);
//             jp.setBackground(Color.cyan);
//             this.add(jp);
//             this.repaint();

//                logger.log(Level.DEBUG, this, "**** " + comp.getClass().getName());
                comp.setBounds(0, 0, this.getSize().width, this.getSize().height);
                this.cont2.add(comp);
                logger.log(Level.DEBUG, this + "RealizeCompleteEvent");

            }
            validate();
        } else if (event instanceof EndOfMediaEvent) {
            // We've reached the end of the media; rewind and start over
            this.player.setMediaTime(new Time(0));
            this.player.start();
            logger.log(Level.DEBUG, this + "count = " + (count++));
        }
    }

    public static void main(String[] args) {
        new VideoPlayer();
    }
}
