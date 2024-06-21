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

package org.havi.ui;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.URL;
import javax.media.Controller;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.StartEvent;
import javax.media.Time;

import static java.lang.System.getLogger;


/**
 * @author Cristian Suazo
 * @statuscode 4
 * @comment bugfixed
 */
public class HSound {

    private static final Logger logger = getLogger(HSound.class.getName());
    private boolean isLooping;
    private Player player;
    private final MediaControllerListner playerListner;

    public HSound() {
logger.log(Level.DEBUG, "Constructor");
        isLooping = false; // used for when the method loop() is called.

        // create listener for the player
        playerListner = new MediaControllerListner();
    }

    public void load(String location) throws java.io.IOException, java.lang.SecurityException {
        load(new URL(location));
    }

    // SecurityException has not been implemented.
    public void load(java.net.URL contents) throws java.io.IOException, java.lang.SecurityException {
        dispose();
        // create the new player
        try {
            player = Manager.createPlayer(contents);
        } catch (NoPlayerException e) {
            logger.log(Level.DEBUG, e.getMessage());
            logger.log(Level.ERROR, e.getMessage(), e);
        }
        player.addControllerListener(playerListner);
    }

    public void set(byte[] data) {
        logger.log(Level.INFO, "Has no implementation, so calling this will not do anything.");
    }

    public void play() {
        this.isLooping = false;
        if (player != null) {
            player.start();
        }
    }

    public void stop() {
        if (player != null) {
            player.stop();
            player.deallocate();
        }
    }

    public void loop() {
        this.isLooping = true;
        if (player != null) {
            player.start();
        }
    }

    public void dispose() {
logger.log(Level.DEBUG, "dispose");
        if (player != null) {
            player.removeControllerListener(playerListner);
            player.stop();
            player.close();
            player.deallocate();
        }
    }

    // Handles events that are created by the mediaplayer
    private class MediaControllerListner implements ControllerListener {

        @Override
        public void controllerUpdate(ControllerEvent event) {
logger.log(Level.DEBUG, event.toString());
            if (event instanceof EndOfMediaEvent) {
                // check if the sound clip should be looped
                if (isLooping) {
                    player.setMediaTime(new Time(0));
                    player.start();
                } else {
                    stop();
                }
            } else if (event instanceof StartEvent) {
                if (player.getState() == Controller.Started) {
                    player.setMediaTime(new Time(0));
                }
            }
        }
    }
}
