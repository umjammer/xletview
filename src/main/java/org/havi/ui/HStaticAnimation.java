/*
 *
 * This file is part of XleTView Copyright (C) 2003 Martin SvedÈn
 *
 * This is free software, and you are welcome to redistribute it under certain
 * conditions;
 *
 * See LICENSE document for details.
 *
 */

package org.havi.ui;

import java.awt.Image;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

import xjavax.tv.util.TVTimer;
import xjavax.tv.util.TVTimerScheduleFailedException;
import xjavax.tv.util.TVTimerSpec;
import xjavax.tv.util.TVTimerWentOffEvent;
import xjavax.tv.util.TVTimerWentOffListener;

import static java.lang.System.getLogger;


/**
 * @author Cristian Suazo
 * @author Martin Sveden
 * @statuscode 4
 */
public class HStaticAnimation extends HVisible implements HNoInputPreferred, HAnimateEffect {

    private static final Logger logger = getLogger(HStaticAnimation.class.getName());
    private static HAnimateLook defaultLook = new HAnimateLook();
    private int delay;
    private int position;
    private int playMode;
    private int repeatCount;
    private boolean isRunning;
    private HLook hlook;

    private final TVTimerSpec paintTask = new TVTimerSpec();
    private final AnimationTimerListner animationListner = new AnimationTimerListner();
    private int playDirection = 1; // if the animation is playing for forward or backward currently, 1 = forward, -1 backward
    private int currentRepeatCount = 0; // how many times the movie has been repeated

    public HStaticAnimation() {
        this(null, 1, HAnimateEffect.PLAY_REPEATING, HAnimateEffect.REPEAT_INFINITE);
    }

    public HStaticAnimation(Image[] imagesNormal, int delay, int playMode, int repeatCount, int x, int y, int width, int height) {
        super(HStaticAnimation.getDefaultLook(), x, y, width, height);
        super.setAnimateContent(imagesNormal, HState.NORMAL_STATE);

        logger.log(Level.DEBUG, "Constructor");
        setDelay(delay);
        setPlayMode(playMode);
        setRepeatCount(repeatCount);
        setBackgroundMode(HVisible.BACKGROUND_FILL);
        setHorizontalAlignment(HVisible.HALIGN_CENTER);
        setVerticalAlignment(HVisible.VALIGN_CENTER);
        setResizeMode(HVisible.RESIZE_NONE);
        setBordersEnabled(true);
        setPosition(0);

        // prepare animation objects
        paintTask.addTVTimerWentOffListener(animationListner);
    }

    public HStaticAnimation(Image[] imagesNormal, int delay, int playMode, int repeatCount) {
        this(imagesNormal, delay, playMode, repeatCount, 0, 0, 0, 0);
    }

    public static HAnimateLook getDefaultLook() {
        return HStaticAnimation.defaultLook;
    }

    public static void setDefaultLook(HAnimateLook hlook) {
        HStaticAnimation.defaultLook = hlook;
    }

    @Override
    public HLook getLook() {
        return hlook;
    }

    @Override
    public void setLook(HLook hlook) throws HInvalidLookException {
        if (!(hlook instanceof HAnimateLook)) {
            throw new HInvalidLookException("Invalid HLook datatype. Must be of type HAnimateLook.");
        }
        this.hlook = hlook;
    }

    @Override
    public void start() {
        isRunning = true;
        // indicate that animation is running
        currentRepeatCount = 0;

        paintTask.setDelayTime(delay);
        paintTask.setRepeat(true);

        // add a timer to trigger paint event
        try {
            TVTimer.getTimer().scheduleTimerSpec(paintTask);
            logger.log(Level.DEBUG, "Animation starting. delay = " + delay);
        } catch (TVTimerScheduleFailedException e) {
            logger.log(Level.ERROR, "Start animation failed. error: " + e.getMessage());
            isRunning = false;
        }
    }

    @Override
    public void stop() {
        if (isRunning) {
            logger.log(Level.DEBUG, "Animation stopped");
            isRunning = false;
            // deschedule animation event
            TVTimer.getTimer().deschedule(paintTask);
        }
    }

    @Override
    public boolean isAnimated() {
        return isRunning;
    }

    @Override
    public int getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(int position) {
        // make check so that position is not set outside the bounds of the image array
        if (getAnimateContent(getInteractionState()) != null && position > -1 && position < getAnimateContent(getInteractionState()).length) {
            this.position = position;
        } else {
            this.position = 0;
        }
    }

    @Override
    public int getRepeatCount() {
        return this.repeatCount;
    }

    @Override
    public void setRepeatCount(int count) {
        if (count > 0)
            this.repeatCount = 1;
        else
            this.repeatCount = count;
    }

    @Override
    public int getDelay() {
        // convert it to: 1 unit = 0.1, delay currently has milliseconds
        return this.delay / 100;
    }

    @Override
    public void setDelay(int count) {
        // 1 count unit = 0.1 sec
        // convert the count to milliseconds
        this.delay = count * 100;
    }

    @Override
    public int getPlayMode() {
        return this.playMode;
    }

    @Override
    public void setPlayMode(int mode) {
        playDirection = 1;
        this.playMode = mode;
    }

    /*
     *
     * @author Cristian Suazo
     *
     * inner class used for animation to handle event TVTimer handle. This
     * is a XleTView specific implementation. The TVTimer is used to create
     * the animation.
     */
    private class AnimationTimerListner implements TVTimerWentOffListener {

        @Override
        public void timerWentOff(TVTimerWentOffEvent e) {
            boolean hasNewRepeat = false; // used to indicate if the animation has reached the end/start of loop
//logger.log(Level.DEBUG, "animate event");
            Image[] images = getAnimateContent(getInteractionState());

            // check what next position is and if the loop is "repeated"
            if (position + playDirection >= images.length || position + playDirection < 0) {
                if (playMode == HAnimateEffect.PLAY_ALTERNATING) {
                    // change play direction
                    playDirection = -playDirection;
                    position += playDirection;
                    hasNewRepeat = true;
                } else if (playMode == HAnimateEffect.PLAY_REPEATING) {
                    hasNewRepeat = true;
                    position = 0;
                }
            } else position += playDirection;

            // check if the animation has a limited amount of repeats, if so stop it if
            // the repeat count has reached the end.
            if (hasNewRepeat && repeatCount != HAnimateEffect.REPEAT_INFINITE) {
                currentRepeatCount++;
                if (currentRepeatCount > repeatCount) {
                    stop();
                }
            }
            if (isRunning) {
//logger.log(Level.DEBUG,  "new position=" + position );
                repaint();
            }
        }
    }
}
