/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;


public class HVideoDevice extends HScreenDevice{

    public static final HVideoConfiguration NOT_CONTRIBUTING = new HVideoConfiguration();
    private HVideoConfiguration hVideoConfiguration;
    private HVideoConfiguration[] hVideoConfigurations;

    protected HVideoDevice(){
        hVideoConfiguration = new HVideoConfiguration();
        hVideoConfigurations = new HVideoConfiguration[1];
        hVideoConfigurations[0] = hVideoConfiguration;
    }

    public HVideoConfiguration[] getConfigurations(){
        return hVideoConfigurations;
    }

    public HVideoConfiguration getDefaultConfiguration(){
        return hVideoConfiguration;
    }

    public HVideoConfiguration getBestConfiguration(HVideoConfigTemplate hvct){
        return hVideoConfiguration;
    }

    public HVideoConfiguration getBestConfiguration(HVideoConfigTemplate hvcta[]){
        return hVideoConfiguration;
    }

    public HVideoConfiguration getCurrentConfiguration(){
        return hVideoConfiguration;
    }

    public boolean setVideoConfiguration(HVideoConfiguration hvc) throws SecurityException,
           org.havi.ui.HPermissionDeniedException,
           org.havi.ui.HConfigurationException{
        return (false);
    }

    public Object getVideoSource() throws SecurityException,
           org.havi.ui.HPermissionDeniedException{
        return (null);
    }

    public Object getVideoController() throws SecurityException, org.havi.ui.HPermissionDeniedException{
        return (null);
    }
}
