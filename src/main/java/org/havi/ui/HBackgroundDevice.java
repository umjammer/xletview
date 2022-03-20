/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;


/**
 *
 *
 * @author Martin Sveden
 * @statuscode 2
 * @comment not quite finished
 */
public class HBackgroundDevice extends HScreenDevice{

    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(HBackgroundDevice.class.getName());

    private HBackgroundConfiguration hBackgroundConfiguration;
    private HBackgroundConfiguration[] hBackgroundConfigurations;

    protected HBackgroundDevice(){
        hBackgroundConfiguration = new HBackgroundConfiguration(this);
        hBackgroundConfigurations = new HBackgroundConfiguration[1];
        hBackgroundConfigurations[0] = hBackgroundConfiguration;
    }

    public HBackgroundConfiguration[] getConfigurations(){
        return hBackgroundConfigurations;
    }

    public HBackgroundConfiguration getDefaultConfiguration(){
        return hBackgroundConfiguration;
    }

    public HBackgroundConfiguration getBestConfiguration(HBackgroundConfigTemplate hbc){
        /* At the moment we always return a HStillImageBackgroundConfiguration */
        log.info("\n---\nAt the moment XleTView always return a HStillImageBackgroundConfiguration here\n---");
        return new HStillImageBackgroundConfiguration();
    }

    public HBackgroundConfiguration getBestConfiguration(HBackgroundConfigTemplate hbcta[]){
        return hBackgroundConfiguration;
    }

    public HBackgroundConfiguration getCurrentConfiguration(){
        return hBackgroundConfiguration;
    }

    public boolean setBackgroundConfiguration(HBackgroundConfiguration hbc) throws SecurityException,
           org.havi.ui.HPermissionDeniedException,
           org.havi.ui.HConfigurationException{
        return (false);
    }
}
