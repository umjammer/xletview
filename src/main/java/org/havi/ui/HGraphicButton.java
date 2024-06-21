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
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

import net.beiker.xletview.helper.HActionableHelper;

import static java.lang.System.getLogger;


/**
 * @author Martin Sveden
 * @statuscode 4
 */
public class HGraphicButton extends HIcon implements HActionable {

    private static final Logger logger = getLogger(HGraphicButton.class.getName());
    private static HGraphicLook defaultHLook = new HGraphicLook();
    private HActionableHelper helper;

    public HGraphicButton() {
        super();
        init();
    }

    public HGraphicButton(Image image) {
        super(image);
        init();
    }

    public HGraphicButton(Image image, int x, int y, int width, int height) {
        super(image, x, y, width, height);
        init();
    }

    public HGraphicButton(Image imageNormal, Image imageFocused, Image imageActioned, int x, int y, int width, int height) {
        super(imageNormal, x, y, width, height);
        setGraphicContent(imageFocused, HVisible.FOCUSED_STATE);
        setGraphicContent(imageActioned, HVisible.ACTIONED_STATE);
        init();
    }

    public HGraphicButton(Image imageNormal, Image imageFocused, Image imageActioned) {
        this(imageNormal, imageFocused, imageActioned, 0, 0, 0, 0);
    }

    // constructors end

    public static HGraphicLook getDefaultLook() {
        return HGraphicButton.defaultHLook;
    }

    public static void setDefaultLook(HGraphicLook hlook) {
        HGraphicButton.defaultHLook = hlook;
    }

    private void init() {
        helper = new HActionableHelper(this);
        logger.log(Level.DEBUG, "HGraphicButton - init");
    }

    @Override
    public void addHActionListener(org.havi.ui.event.HActionListener listener) {
        helper.addHActionListener(listener);
    }

    @Override
    public void removeHActionListener(org.havi.ui.event.HActionListener listener) {
        helper.removeHActionListener(listener);
    }

    @Override
    public HSound getActionSound() {
        return helper.getActionSound();
    }

    @Override
    public void setActionSound(HSound sound) {
        helper.setActionSound(sound);
    }

    @Override
    public void processHActionEvent(org.havi.ui.event.HActionEvent evt) {
//logger.log(Level.TRACE, this, "processHActionEvent");
        int state = getInteractionState();
        int newState = helper.getHActionEventResult(evt);

        if (state != newState) {
            setInteractionState(newState);
        }
    }

    @Override
    public java.lang.String getActionCommand() {
        return helper.getActionCommand();
    }

    @Override
    public void setActionCommand(String command) {
        helper.setActionCommand(command);
    }
}
