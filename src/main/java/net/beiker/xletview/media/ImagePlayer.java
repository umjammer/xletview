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
import java.net.URL;
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

public class ImagePlayer implements Player{

    private static final Logger log = Logger.getLogger(ImagePlayer.class.getName());

    private ImagePlayerVisualComponent visualComponent;
    private ControllerListener controllerListener;

    public ImagePlayer(URL imageURL){
        visualComponent = new ImagePlayerVisualComponent(imageURL);
        visualComponent.setVisible(false);
        log.fine("constructor");
    }

    public void addController(Controller newController){}

    public Component getControlPanelComponent(){ return null;}
    public GainControl getGainControl(){return null;}

    public Component getVisualComponent(){
        return visualComponent;
    }

    public void removeController(Controller oldController){}

    public void start(){
        //imagePlayerThread = new Thread(this, "imagePlayerThread");
        visualComponent.setVisible(true);
        //imagePlayerThread.start();
    }

    public void stop(){
        visualComponent.setVisible(false);
    }


    // Methods inherited from interface javax.media.MediaHandler -->
    public void setSource(DataSource source) throws java.io.IOException, IncompatibleSourceException{
    }
    // Methods inherited from interface javax.media.MediaHandler //

    // Methods inherited from interface javax.media.Duration -->
    public Time getDuration(){return null;}
    // Methods inherited from interface javax.media.Duration //

    // Methods inherited from interface javax.media.Clock -->
    public void setTimeBase(TimeBase master) throws IncompatibleTimeBaseException{}
    public void syncStart(Time at){}
    public void setStopTime(Time stopTime){}
    public Time getStopTime(){return null;}
    public void setMediaTime(Time now){}
    public Time getMediaTime(){return null;}
    public long getMediaNanoseconds(){return -1l;}
    public Time getSyncTime(){return null;}
    public TimeBase getTimeBase(){return null;}
    public Time mapToTimeBase(Time t) throws ClockStoppedException{return null;}
    public float getRate(){return -1f;}
    public float setRate(float factor){return -1f;}
    // Methods inherited from interface javax.media.Clock //

    // Methods inherited from interface javax.media.Controller -->
    public int getState(){return -1;}
    public int getTargetState(){return -1;}
    public void realize(){}
    public void prefetch(){}
    public void deallocate(){}
    public void close(){}
    public Time getStartLatency(){return null;}
    public Control[] getControls(){return null;}
    public Control getControl(java.lang.String forName){return null;}

    public void addControllerListener(ControllerListener listener){
        this.controllerListener = listener;
    }
    public void removeControllerListener(ControllerListener listener){
        this.controllerListener = null;
    }



}
