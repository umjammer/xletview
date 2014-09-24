/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

public class HGraphicsDevice extends HScreenDevice{

    private HGraphicsConfiguration hGraphicsConfiguration;
    private HGraphicsConfiguration[] hGraphicsConfigurations;

    protected HGraphicsDevice(){
        hGraphicsConfiguration = new HGraphicsConfiguration();
        hGraphicsConfigurations = new HGraphicsConfiguration[1];
        hGraphicsConfigurations[0] = hGraphicsConfiguration;
    }

    public HGraphicsConfiguration[] getConfigurations(){
        return hGraphicsConfigurations;
    }

    public HGraphicsConfiguration getDefaultConfiguration(){
        return hGraphicsConfiguration;
    }

    public HGraphicsConfiguration getBestConfiguration(HGraphicsConfigTemplate hgct){
        return hGraphicsConfiguration;
    }

    public HGraphicsConfiguration getBestConfiguration(HGraphicsConfigTemplate hgcta[]){
        return hGraphicsConfiguration;
    }

    public HGraphicsConfiguration getCurrentConfiguration(){
        return hGraphicsConfiguration;
    }

    public boolean setGraphicsConfiguration(HGraphicsConfiguration hgc) throws SecurityException,
           org.havi.ui.HPermissionDeniedException,
           org.havi.ui.HConfigurationException{
        return (false);
    }
}
