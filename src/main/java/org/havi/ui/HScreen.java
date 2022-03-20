/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class HScreen{
    private static final HScreen DEFAULT_HSCREEN = new HScreen();

    private static List<HScreen> hScreens;
    private HVideoDevice hVideoDevice;
    private HVideoDevice[] hVideoDevices;
    private HGraphicsDevice hGraphicsDevice;
    private HGraphicsDevice[] hGraphicsDevices;
    private HBackgroundDevice hBackgroundDevice;
    private HBackgroundDevice[] hBackgroundDevices;

    private HScreen(){
        //hScreens = new HScreen[1];
        //hScreens[0] = this;

        hVideoDevice = new HVideoDevice();
        hVideoDevices = new HVideoDevice[1];
        hVideoDevices[0] = hVideoDevice;

        hGraphicsDevice = new HGraphicsDevice();
        hGraphicsDevices = new HGraphicsDevice[1];
        hGraphicsDevices[0] = hGraphicsDevice;

        hBackgroundDevice = new HBackgroundDevice();
        hBackgroundDevices = new HBackgroundDevice[1];
        hBackgroundDevices[0] = hBackgroundDevice;
        hScreens = new ArrayList<>();
        hScreens.add(this);
    }

    public static HScreen[] getHScreens(){
        HScreen[] screens = new HScreen[hScreens.size()];
        for(int i = 0; i < screens.length; i++){
            screens[i] = (HScreen) hScreens.get(i);
        }
        return screens;
    }

    public static HScreen getDefaultHScreen(){
        return DEFAULT_HSCREEN;
    }

    public HVideoDevice[] getHVideoDevices(){
        return hVideoDevices;
    }

    public HVideoDevice getDefaultHVideoDevice(){
        return hVideoDevice;
    }

    public HVideoConfiguration getBestConfiguration(HVideoConfigTemplate[] hvcta){
        return hVideoDevice.getBestConfiguration(hvcta);
    }

    public HGraphicsDevice[] getHGraphicsDevices(){
        return hGraphicsDevices;
    }

    public HGraphicsDevice getDefaultHGraphicsDevice(){
        return hGraphicsDevice;
    }

    public HGraphicsConfiguration getBestConfiguration(HGraphicsConfigTemplate[] hgcta){
        return hGraphicsDevice.getBestConfiguration(hgcta);
    }

    public HBackgroundDevice[] getHBackgroundDevices(){
        return hBackgroundDevices;
    }

    public HBackgroundDevice getDefaultHBackgroundDevice(){
        return hBackgroundDevice;
    }

    public HBackgroundConfiguration getBestConfiguration(HBackgroundConfigTemplate[] hbcta){
        return hBackgroundDevice.getBestConfiguration(hbcta);
    }

    public HScreenConfiguration[] getCoherentScreenConfigurations(HScreenConfigTemplate[] hscta){
        return (null);
    }

    public boolean setCoherentScreenConfigurations(HScreenConfiguration[] hsca) throws java.lang.SecurityException,
           org.havi.ui.HPermissionDeniedException,
           org.havi.ui.HConfigurationException{
        return (false);
    }
}
