/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.media;

import java.awt.Rectangle;

import org.havi.ui.HScreenPoint;


/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class VideoTransformation{

    private Rectangle clipRegion;
    private float horizontalScalingFactor;
    private float verticalScalingFactor;
    private HScreenPoint location;

    public VideoTransformation(){
        this(new Rectangle(720,576), 1.0f, 1.0f, new HScreenPoint(0,0));
    }

    public VideoTransformation(Rectangle clipRect, float horizontalScalingFactor, float verticalScalingFactor, HScreenPoint location){
        this.clipRegion = clipRect;
        this.horizontalScalingFactor = horizontalScalingFactor;
        this.verticalScalingFactor = verticalScalingFactor;
        this.location = location;
    }

    public void setClipRegion(Rectangle clipRect){
        this.clipRegion = clipRect;
    }

    public Rectangle getClipRegion(){
        return clipRegion;
    }

    public void setScalingFactors(float horizontalScalingFactor, float verticalScalingFactor){
        this.horizontalScalingFactor = horizontalScalingFactor;
        this.verticalScalingFactor = verticalScalingFactor;
    }

    public float[] getScalingFactors(){
        float[] scalingFactors = { horizontalScalingFactor, verticalScalingFactor };
        return scalingFactors;
    }

    public void setVideoPosition(HScreenPoint location)    {
        this.location = location;
    }

    public HScreenPoint getVideoPosition(){
        return location;
    }

    public boolean isPanAndScan(){
        return false;
    }
}
