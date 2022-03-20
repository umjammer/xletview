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
 * @statuscode 4
 */
public class HBackgroundConfiguration extends HScreenConfiguration{

    private HBackgroundConfigTemplate template;
    private HBackgroundDevice backgroundDevice;

    protected HBackgroundConfiguration(){
        // the template associated with this
        template = new HBackgroundConfigTemplate();
    }

    /* added this constructor to make the "connection" to the HBackgroundDevice */
    protected HBackgroundConfiguration(HBackgroundDevice bgDevice){
        this();
        backgroundDevice = bgDevice;
    }

    public HBackgroundDevice getDevice(){
        return backgroundDevice;
    }

    public HBackgroundConfigTemplate getConfigTemplate(){
        return template;
    }

    public java.awt.Color getColor(){
        return java.awt.Color.BLACK;
    }

    public void setColor(java.awt.Color color) throws org.havi.ui.HPermissionDeniedException, org.havi.ui.HConfigurationException{
        throw new HPermissionDeniedException("The HBackgroundDevice does not have the right to control the background");
    }
}
