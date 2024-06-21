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

import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

import net.beiker.xletview.helper.HNavigableHelper;
import org.havi.ui.event.HFocusEvent;

import static java.lang.System.getLogger;


/**
 * @author Martin Sveden
 * @statuscode 4
 */
public class HIcon extends HStaticIcon implements HNavigable {

    private static final Logger logger = getLogger(HIcon.class.getName());


    private HNavigableHelper helper;


    private static HGraphicLook defaultHLook = new HGraphicLook();


    public HIcon() {
        super();
        init();
    }

    public HIcon(Image image) {
        super(image);
        init();
    }

    public HIcon(Image image, int x, int y, int width, int height) {
        super(image, x, y, width, height);
        init();
    }

    public HIcon(Image imageNormal, Image imageFocus, int x, int y, int width, int height) {
        super(imageNormal, x, y, width, height);
        setGraphicContent(imageFocus, HVisible.FOCUSED_STATE);
        init();

    }
    // constructors end //

    private void init() {
        helper = new HNavigableHelper(this);
        logger.log(Level.DEBUG, "HIcon - init");
    }

    public static void setDefaultLook(HGraphicLook hGraphicLook) {
        HIcon.defaultHLook = hGraphicLook;
    }

    public static HGraphicLook getDefaultLook() {
        return HIcon.defaultHLook;
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

    /**
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
        //super.processFocusEvent(e);
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
}
