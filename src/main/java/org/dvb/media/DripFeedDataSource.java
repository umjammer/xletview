/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.media;

import java.io.IOException;

import javax.media.Time;

public class DripFeedDataSource extends javax.media.protocol.DataSource{

    public DripFeedDataSource() {}

    public void feed(byte[] clip_part) {}

    @Override
    public java.lang.String getContentType() {return null;}

    @Override
    public void connect() throws IOException {}

    @Override
    public void disconnect() {}

    @Override
    public void start() throws IOException {}

    @Override
    public void stop() throws IOException {}

    @Override
    public  Time getDuration() {return DURATION_UNKNOWN;}

    @Override
    public Object[] getControls() {return null;}

    @Override
    public Object getControl(String controlType) { return null;}

}

