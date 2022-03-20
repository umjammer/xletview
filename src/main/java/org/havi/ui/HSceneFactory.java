/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

import net.beiker.xletview.media.ScreenContainer;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 2
 * @comment always returns the same kind of HScene
 */
public class HSceneFactory extends Object{

    private static final HSceneFactory THEINSTANCE = new HSceneFactory();

    private HSceneFactory(){
    }

    private HScene createScene(){
        HScene scene = new HScene();
        scene.setBounds(0, 0, ScreenContainer.SCREEN_WIDTH, ScreenContainer.SCREEN_HEIGHT);
        return scene;
    }

    public static HSceneFactory getInstance(){
        return THEINSTANCE;
    }

    public HSceneTemplate getBestSceneTemplate(HSceneTemplate hst){
        return (null);
    }

    public HScene getBestScene(HSceneTemplate hst){
        return createScene();
    }

    public HSceneTemplate resizeScene(HScene hs, HSceneTemplate hst) throws java.lang.IllegalStateException{
        return (null);
    }

    public HScene getDefaultHScene(HScreen screen){
        return createScene();
    }

    public HScene getDefaultHScene(){
        return createScene();
    }

    public HScene getFullScreenScene(HGraphicsDevice device){
        return createScene();
    }

    public void dispose(HScene scene){
        scene.setVisible(false);
    }
}
