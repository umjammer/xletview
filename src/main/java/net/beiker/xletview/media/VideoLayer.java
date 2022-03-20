/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Sveden

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package net.beiker.xletview.media;

import java.awt.Component;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Logger;

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


/**
 * Displays the video, or an image symbolizing video
 */
public class VideoLayer extends XContainer implements ServiceContentHandler, Player {
    /** Debugging facility */
    private final static Logger logger = Logger.getLogger(VideoLayer.class.getName());

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
     *
     */
    public Component add(Component comp){
        Component added = null;
        if(getComponentCount() < 1){
            added = super.add(comp);
        }
        else{
            try {
                throw new Exception("Component already added, can only contain one component");
            }
            catch (Exception e) {
                logger.warning(Util.getStackTrace(e));
            }
        }
        return added;
    }

    public Component add(Component comp, int index){
        return add(comp);
    }

    public Component add(String name, Component comp){
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
    //        Debug.write(this, "paint");
    //        Debug.write(this, "this = " + this);
    //        super.paint(g);
    //    }

    public void paint(Graphics g) {
        for (int i = 0; i < getComponentCount(); i++) {
            getComponent(i).paint(g);
        }
    }

    /* (non-Javadoc)
     * @see xjavax.tv.service.selection.ServiceContentHandler#getServiceContentLocators()
     */
    public Locator[] getServiceContentLocators() {
        // TODO Auto-generated method stub
        logger.fine("getServiceContentLocators");
        return null;
    }

    /* (non-Javadoc)
     * @see javax.media.Player#getVisualComponent()
     */
    public Component getVisualComponent() {
        // TODO Auto-generated method stub
        logger.fine("getVisualComponent");
        return null;
    }

    /* (non-Javadoc)
     * @see javax.media.Player#getGainControl()
     */
    public GainControl getGainControl() {
        // TODO Auto-generated method stub
        logger.fine("getGainControl");
        return null;
    }

    /* (non-Javadoc)
     * @see javax.media.Player#getControlPanelComponent()
     */
    public Component getControlPanelComponent() {
        // TODO Auto-generated method stub
        logger.fine("getControlPanelComponent");
        return null;
    }

    /* (non-Javadoc)
     * @see javax.media.Player#start()
     */
    public void start() {
        // TODO Auto-generated method stub
        logger.fine("start");

    }

    /* (non-Javadoc)
     * @see javax.media.Player#addController(javax.media.Controller)
     */
    public void addController(Controller arg0) throws IncompatibleTimeBaseException {
        // TODO Auto-generated method stub
        logger.fine("addController");

    }

    /* (non-Javadoc)
     * @see javax.media.Player#removeController(javax.media.Controller)
     */
    public void removeController(Controller arg0) {
        // TODO Auto-generated method stub
        logger.fine("removeController");

    }

    /* (non-Javadoc)
     * @see javax.media.MediaHandler#setSource(javax.media.protocol.DataSource)
     */
    public void setSource(DataSource arg0) throws IOException, IncompatibleSourceException {
        // TODO Auto-generated method stub
        logger.fine("setSource");

    }

    /* (non-Javadoc)
     * @see javax.media.Controller#getState()
     */
    public int getState() {
        // TODO Auto-generated method stub
        logger.fine("getState");
        return 0;
    }

    /* (non-Javadoc)
     * @see javax.media.Controller#getTargetState()
     */
    public int getTargetState() {
        // TODO Auto-generated method stub
        logger.fine("getTargetState");
        return 0;
    }

    /* (non-Javadoc)
     * @see javax.media.Controller#realize()
     */
    public void realize() {
        // TODO Auto-generated method stub
        logger.fine("realize");

    }

    /* (non-Javadoc)
     * @see javax.media.Controller#prefetch()
     */
    public void prefetch() {
        // TODO Auto-generated method stub
        logger.fine("prefetch");

    }

    /* (non-Javadoc)
     * @see javax.media.Controller#deallocate()
     */
    public void deallocate() {
        // TODO Auto-generated method stub
        logger.fine("deallocate");

    }

    /* (non-Javadoc)
     * @see javax.media.Controller#close()
     */
    public void close() {
        // TODO Auto-generated method stub
        logger.fine("close");

    }

    /* (non-Javadoc)
     * @see javax.media.Controller#getStartLatency()
     */
    public Time getStartLatency() {
        // TODO Auto-generated method stub
        logger.fine("getStartLatency");
        return null;
    }

    /* (non-Javadoc)
     * @see javax.media.Controller#getControls()
     */
    public Control[] getControls() {
        // TODO Auto-generated method stub
        logger.fine("getControls");
        return null;
    }

    /* (non-Javadoc)
     * @see javax.media.Controller#getControl(java.lang.String)
     */
    public Control getControl(String s) {
        Control result = null;

            if(s.equals("javax.tv.media.AWTVideoSizeControl")){
                result = AWTVideoSizeControlImpl.getInstance();
            }

        return result;
    }

    /* (non-Javadoc)
     * @see javax.media.Controller#addControllerListener(javax.media.ControllerListener)
     */
    public void addControllerListener(ControllerListener arg0) {
        // TODO Auto-generated method stub
        logger.fine("addControllerListener");

    }

    /* (non-Javadoc)
     * @see javax.media.Controller#removeControllerListener(javax.media.ControllerListener)
     */
    public void removeControllerListener(ControllerListener arg0) {
        // TODO Auto-generated method stub
        logger.fine("removeControllerListener");

    }

    /* (non-Javadoc)
     * @see javax.media.Clock#setTimeBase(javax.media.TimeBase)
     */
    public void setTimeBase(TimeBase arg0) throws IncompatibleTimeBaseException {
        // TODO Auto-generated method stub
        logger.fine("setTimeBase");

    }

    /* (non-Javadoc)
     * @see javax.media.Clock#syncStart(javax.media.Time)
     */
    public void syncStart(Time arg0) {
        // TODO Auto-generated method stub
        logger.fine("syncStart");

    }

    /* (non-Javadoc)
     * @see javax.media.Clock#stop()
     */
    public void stop() {
        // TODO Auto-generated method stub
        logger.fine("stop");

    }

    /* (non-Javadoc)
     * @see javax.media.Clock#setStopTime(javax.media.Time)
     */
    public void setStopTime(Time arg0) {
        // TODO Auto-generated method stub
        logger.fine("setStopTime");

    }

    /* (non-Javadoc)
     * @see javax.media.Clock#getStopTime()
     */
    public Time getStopTime() {
        // TODO Auto-generated method stub
        logger.fine("getStopTime");
        return null;
    }

    /* (non-Javadoc)
     * @see javax.media.Clock#setMediaTime(javax.media.Time)
     */
    public void setMediaTime(Time arg0) {
        // TODO Auto-generated method stub
        logger.fine("setMediaTime");

    }

    /* (non-Javadoc)
     * @see javax.media.Clock#getMediaTime()
     */
    public Time getMediaTime() {
        // TODO Auto-generated method stub
        logger.fine("getMediaTime");
        return null;
    }

    /* (non-Javadoc)
     * @see javax.media.Clock#getMediaNanoseconds()
     */
    public long getMediaNanoseconds() {
        // TODO Auto-generated method stub
        logger.fine("getMediaNanoseconds");
        return 0;
    }

    /* (non-Javadoc)
     * @see javax.media.Clock#getSyncTime()
     */
    public Time getSyncTime() {
        // TODO Auto-generated method stub
        logger.fine("getSyncTime");
        return null;
    }

    /* (non-Javadoc)
     * @see javax.media.Clock#getTimeBase()
     */
    public TimeBase getTimeBase() {
        // TODO Auto-generated method stub
        logger.fine("getTimeBase");
        return null;
    }

    /* (non-Javadoc)
     * @see javax.media.Clock#mapToTimeBase(javax.media.Time)
     */
    public Time mapToTimeBase(Time arg0) throws ClockStoppedException {
        // TODO Auto-generated method stub
        logger.fine("mapToTimeBase");
        return null;
    }

    /* (non-Javadoc)
     * @see javax.media.Clock#getRate()
     */
    public float getRate() {
        // TODO Auto-generated method stub
        logger.fine("getRate");
        return 0;
    }

    /* (non-Javadoc)
     * @see javax.media.Clock#setRate(float)
     */
    public float setRate(float arg0) {
        // TODO Auto-generated method stub
        logger.fine("setRate");
        return 0;
    }

    /* (non-Javadoc)
     * @see javax.media.Duration#getDuration()
     */
    public Time getDuration() {
        // TODO Auto-generated method stub
        logger.fine("getDuration");
        return null;
    }
}
