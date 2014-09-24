/*
 * 
 * This file is part of XleTView Copyright (C) 2003 Martin Svedén
 * 
 * This is free software, and you are welcome to redistribute it under certain
 * conditions;
 * 
 * See LICENSE document for details.
 *  
 */

package org.havi.ui;

import java.awt.Image;

import xjavax.tv.util.TVTimer;
import xjavax.tv.util.TVTimerScheduleFailedException;
import xjavax.tv.util.TVTimerSpec;
import xjavax.tv.util.TVTimerWentOffEvent;
import xjavax.tv.util.TVTimerWentOffListener;

/**
 * @author Cristian Suazo
 * @author Martin Sveden
 * @statuscode 4
 * 
 */
public class HStaticAnimation
	extends HVisible
	implements HNoInputPreferred, HAnimateEffect {

	private static net.beiker.cake.Logger log = net.beiker.cake.Log.getLogger(HStaticAnimation.class);
	
	private int delay;
	private int position;
	private int playMode;
	private int repeatCount;
	private boolean isRunning;
	private static HAnimateLook defaultLook = new HAnimateLook();
	private HLook hlook;
	
	private TVTimerSpec paintTask = new TVTimerSpec();
	private AnimationTimerListner animationListner = new AnimationTimerListner();
	private int playDirection = 1; // if the animation is playing for forward or backward currently, 1 = forward, -1 backward 
	private int currentRepeatCount = 0; // how many times the movie has been repeated

	/*
	 * 
	 * @author Cristian Suazo
	 *
	 * inner class used for animation to handle event TVTimer handle. This
	 * is a XleTView specific implementation. The TVTimer is used to create
	 * the animation.
	 */
	private class AnimationTimerListner implements TVTimerWentOffListener{
		public void timerWentOff( TVTimerWentOffEvent e){
			boolean hasNewRepeat = false; // used to indicate if the animation has reached the end/start of loop
			//logger.debug("animate event");
			Image[] images = getAnimateContent(getInteractionState());
			
			// check what next position is and if the loop is "repeated"
			if (position + playDirection >= images.length || position + playDirection < 0) {
				if ( playMode == HAnimateEffect.PLAY_ALTERNATING ){
					// change play direction
					playDirection = -playDirection;
					position += playDirection;
					hasNewRepeat = true;
				}
				else if ( playMode == HAnimateEffect.PLAY_REPEATING ){
					hasNewRepeat = true;
					position = 0;
				}
			}
			else position += playDirection;
			
			// check if the animation has a limited amount of repeats, if so stop it if 
			// the repeat count has reached the end.
			if (hasNewRepeat == true && repeatCount != HAnimateEffect.REPEAT_INFINITE ){
				currentRepeatCount++;
				if (currentRepeatCount > repeatCount){
					stop();
				}
			}
			if (isRunning == true){
				//logger.debug( "new position=" + position );
				repaint();
			}
		}
	}

	public HStaticAnimation() {
		this(null,1,HAnimateEffect.PLAY_REPEATING,HAnimateEffect.REPEAT_INFINITE);
	}

	public HStaticAnimation(Image[] imagesNormal,int delay,int playMode,int repeatCount,int x,int y,int width,int height) {
		super(HStaticAnimation.getDefaultLook(), x, y, width, height);
		super.setAnimateContent(imagesNormal, HState.NORMAL_STATE);

		log.debug("Constructor");
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

	public HStaticAnimation(Image[] imagesNormal,int delay,int playMode,int repeatCount) {
		this(imagesNormal, delay, playMode, repeatCount, 0, 0, 0, 0);
	}

	public void setLook(HLook hlook) throws HInvalidLookException {
		if(hlook instanceof HAnimateLook == false){
			throw new HInvalidLookException("Invalid HLook datatype. Must be of type HAnimateLook.");
		}
		this.hlook = hlook;
	}

	public HLook getLook() {
		return hlook;
	}

	public static void setDefaultLook(HAnimateLook hlook) {
		HStaticAnimation.defaultLook = hlook;
	}

	public static HAnimateLook getDefaultLook() {
		return HStaticAnimation.defaultLook;
	}

	public void start() {
		isRunning = true;
		// indicate that animation is running
		currentRepeatCount = 0;

		paintTask.setDelayTime(delay);
		paintTask.setRepeat(true);
		
		// add a timer to trigger paint event
		try{
			TVTimer.getTimer().scheduleTimerSpec(paintTask);			
			log.debug("Animation starting. delay = " + delay);
		}
		catch(TVTimerScheduleFailedException e){
			log.error("Start animation failed. error: " + e.getMessage() );
			isRunning = false;
		}
	}

	public void stop() {
		if (isRunning == true){
			log.debug("Animation stopped");
			isRunning = false;
			// deschedule animation event
			TVTimer.getTimer().deschedule(paintTask);	
		}
	}

	public boolean isAnimated() {
		return isRunning;
	}

	public void setPosition(int position) {
		// make check so that position is not set outside the bounds of the image array
		if(getAnimateContent(getInteractionState()) != null && position > -1 && position < getAnimateContent(getInteractionState()).length ){
			this.position = position;
		}
		else{
			this.position = 0;
		}
	}

	public int getPosition() {
		return this.position;
	}

	public void setRepeatCount(int count) {
		if (count > 0)
			this.repeatCount = 1;
		else
			this.repeatCount = count;
	}

	public int getRepeatCount() {
		return this.repeatCount;
	}

	public void setDelay(int count) {
		// 1 count unit = 0.1 sec
		// convert the count to milliseconds
		this.delay = count * 100;
	}

	public int getDelay() {
		// convert it to: 1 unit = 0.1, delay currently has milliseconds 
		return this.delay / 100;
	}

	public void setPlayMode(int mode) {
		playDirection = 1;
		this.playMode = mode;
	}

	public int getPlayMode() {
		return this.playMode;
	}

}