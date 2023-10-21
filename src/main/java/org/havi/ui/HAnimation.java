/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import net.beiker.xletview.helper.HNavigableHelper;
import org.havi.ui.event.HFocusEvent;


/**
 * @author Martin Sveden
 * @statuscode 4
 */
public class HAnimation extends HStaticAnimation implements HNavigable {

    private HNavigableHelper helper;

    private static HAnimateLook defaultHLook = new HAnimateLook();

    public HAnimation() {
        super();
        init();
    }

    public HAnimation(Image[] images, int delay, int playMode, int repeatCount) {
        super(images, delay, playMode, repeatCount);
        init();
    }

    public HAnimation(Image[] images, int delay, int playMode, int repeatCount, int x, int y, int width, int height) {
        super(images, delay, playMode, repeatCount, x, y, width, height);
        init();
    }

    public HAnimation(Image[] imagesNormal, Image[] imagesFocused, int delay, int playMode, int repeatCount, int x, int y, int width, int height) {
        super(imagesNormal, delay, playMode, repeatCount, x, y, width, height);
        this.setAnimateContent(imagesFocused, HVisible.FOCUSED_STATE);
        init();
    }

    public HAnimation(Image[] imagesNormal, Image[] imagesFocused, int delay, int playMode, int repeatCount) {
        super(imagesNormal, delay, playMode, repeatCount);
        this.setAnimateContent(imagesFocused, HVisible.FOCUSED_STATE);
        init();
    }
    // constructors end //

    private void init() {
        helper = new HNavigableHelper(this);
    }

    public static void setDefaultLook(HAnimateLook defaultHLook) {
        HAnimation.defaultHLook = defaultHLook;
    }

    public static HAnimateLook getDefaultLook() {
        return HAnimation.defaultHLook;
    }

    @Override
    public void setMove(int keyCode, HNavigable target) {
        helper.setMove(keyCode, target);
    }

    @Override
    public HNavigable getMove(int keyCode) {
        return helper.getMove(keyCode);
    }

    @Override
    public void setFocusTraversal(HNavigable up, HNavigable down, HNavigable left, HNavigable right) {
        helper.setFocusTraversal(up, down, left, right);
    }

    @Override
    public boolean isSelected() {
        return helper.isSelected();
    }

    @Override
    public void setGainFocusSound(HSound sound) {
        helper.setGainFocusSound(sound);
    }

    @Override
    public void setLoseFocusSound(HSound sound) {
        helper.setLoseFocusSound(sound);
    }

    @Override
    public HSound getGainFocusSound() {
        return helper.getGainFocusSound();
    }

    @Override
    public HSound getLoseFocusSound() {
        return helper.getLoseFocusSound();
    }

    @Override
    public synchronized void addHFocusListener(org.havi.ui.event.HFocusListener listener) {
        helper.addHFocusListener(listener);
    }

    @Override
    public synchronized void removeHFocusListener(org.havi.ui.event.HFocusListener listener) {
        helper.removeHFocusListener(listener);
    }

    @Override
    public int[] getNavigationKeys() {
        return helper.getNavigationKeys();
    }

    /*
     Overloaded from HVisible, is true for HNavigable
     */
    @Override
    public boolean isFocusTraversable() {
        return true;
    }

    /**
     * Since the Component will not get focus unless there is
     * a FocusListener registered we "secretly" add one in the
     * helper.
     * We don't want this secret one to be returned when someone
     * asks for the FocusListener objects.
     * This mehod overrides Component.getFocusListeners()
     * and takes care of that.
     */
    @Override
    public synchronized FocusListener[] getFocusListeners() {
        return helper.getFocusListeners();
    }


    @Override
    public void processFocusEvent(FocusEvent e) {
        super.processFocusEvent(e);
        HFocusEvent event = new HFocusEvent(this, e.getID());
        processHFocusEvent(event);

    }


    @Override
    public void processHFocusEvent(HFocusEvent evt) {
        int state = getInteractionState();
        int newState = helper.getHFocusEventResult(evt);

        if (state != newState) {
            setInteractionState(newState);
        }
    }


    @Override
    protected void setInteractionState(int state) {
        super.setInteractionState(state);
        super.setPosition(0);
        if (isAnimated()) {
            stop();
            start();
        }
    }

}
