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

import java.awt.Component;
import java.awt.Graphics;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.media.ClockStoppedException;
import javax.media.Control;
import javax.media.Controller;
import javax.media.ControllerListener;
import javax.media.GainControl;
import javax.media.IncompatibleSourceException;
import javax.media.IncompatibleTimeBaseException;
import javax.media.Player;
import javax.media.Time;
import javax.media.TimeBase;
import javax.media.protocol.DataSource;

import net.beiker.xletview.ui.XContainer;
import net.beiker.xletview.util.Util;
import xjavax.tv.locator.Locator;
import xjavax.tv.media.AWTVideoSizeControlImpl;
import xjavax.tv.service.selection.ServiceContentHandler;

import static java.lang.System.getLogger;


/**
 * Displays the video, or an image symbolizing video
 */
public class VideoLayer extends XContainer implements ServiceContentHandler, Player {

    /** Debugging facility */
    private final static Logger logger = getLogger(VideoLayer.class.getName());

    private static VideoLayer THE_INSTANCE;
    private AWTVideoSizeControlImpl awtVideoSizeControl;

    private VideoLayer() {
    }

    public static VideoLayer getInstance() {
        if (THE_INSTANCE == null) {
            THE_INSTANCE = new VideoLayer();
            //THE_INSTANCE.setLayout(null);
            THE_INSTANCE.setLayout(null);
        }
        return THE_INSTANCE;
    }

    /**
     * Overrides the super implementation so
     * it's only possible to add one Component
     */
    @Override
    public Component add(Component comp) {
        Component added = null;
        if (getComponentCount() < 1) {
            added = super.add(comp);
        } else {
            try {
                throw new Exception("Component already added, can only contain one component");
            } catch (Exception e) {
                logger.log(Level.WARNING, Util.getStackTrace(e));
            }
        }
        return added;
    }

    @Override
    public Component add(Component comp, int index) {
        return add(comp);
    }

    @Override
    public Component add(String name, Component comp) {
        return add(comp);
    }

//    public void setSize(AWTVideoSize size){
//        int videoX          = size.getDestination().x;
//        int videoY          = size.getDestination().y;
//        int videoWidth      = size.getDestination().width;
//        int videoHeight     = size.getDestination().height;
//        setBounds(videoX, videoY, videoWidth, videoHeight);
//        validate();
//    }

//    public void paint(Graphics g){
//        logger.log(Level.DEBUG, this, "paint");
//        logger.log(Level.DEBUG, this, "this = " + this);
//        super.paint(g);
//    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < getComponentCount(); i++) {
            getComponent(i).paint(g);
        }
    }

    @Override
    public Locator[] getServiceContentLocators() {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "getServiceContentLocators");
        return null;
    }

    @Override
    public Component getVisualComponent() {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "getVisualComponent");
        return null;
    }

    @Override
    public GainControl getGainControl() {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "getGainControl");
        return null;
    }

    @Override
    public Component getControlPanelComponent() {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "getControlPanelComponent");
        return null;
    }

    @Override
    public void start() {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "start");
    }

    @Override
    public void addController(Controller arg0) throws IncompatibleTimeBaseException {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "addController");
    }

    @Override
    public void removeController(Controller arg0) {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "removeController");
    }

    @Override
    public void setSource(DataSource arg0) throws IOException, IncompatibleSourceException {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "setSource");
    }

    @Override
    public int getState() {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "getState");
        return 0;
    }

    @Override
    public int getTargetState() {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "getTargetState");
        return 0;
    }

    @Override
    public void realize() {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "realize");

    }

    @Override
    public void prefetch() {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "prefetch");
    }

    @Override
    public void deallocate() {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "deallocate");

    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "close");
    }

    @Override
    public Time getStartLatency() {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "getStartLatency");
        return null;
    }

    @Override
    public Control[] getControls() {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "getControls");
        return null;
    }

    @Override
    public Control getControl(String s) {
        Control result = null;

        if (s.equals("javax.tv.media.AWTVideoSizeControl")) {
            result = AWTVideoSizeControlImpl.getInstance();
        }

        return result;
    }

    @Override
    public void addControllerListener(ControllerListener arg0) {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "addControllerListener");
    }

    @Override
    public void removeControllerListener(ControllerListener arg0) {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "removeControllerListener");
    }

    @Override
    public void setTimeBase(TimeBase arg0) throws IncompatibleTimeBaseException {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "setTimeBase");
    }

    @Override
    public void syncStart(Time arg0) {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "syncStart");
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "stop");
    }

    @Override
    public void setStopTime(Time arg0) {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "setStopTime");
    }

    @Override
    public Time getStopTime() {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "getStopTime");
        return null;
    }

    @Override
    public void setMediaTime(Time arg0) {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "setMediaTime");
    }

    @Override
    public Time getMediaTime() {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "getMediaTime");
        return null;
    }

    @Override
    public long getMediaNanoseconds() {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "getMediaNanoseconds");
        return 0;
    }

    @Override
    public Time getSyncTime() {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "getSyncTime");
        return null;
    }

    @Override
    public TimeBase getTimeBase() {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "getTimeBase");
        return null;
    }

    @Override
    public Time mapToTimeBase(Time arg0) throws ClockStoppedException {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "mapToTimeBase");
        return null;
    }

    @Override
    public float getRate() {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "getRate");
        return 0;
    }

    @Override
    public float setRate(float arg0) {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "setRate");
        return 0;
    }

    @Override
    public Time getDuration() {
        // TODO Auto-generated method stub
        logger.log(Level.TRACE, "getDuration");
        return null;
    }
}
