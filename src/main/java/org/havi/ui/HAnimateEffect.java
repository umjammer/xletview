/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

public interface HAnimateEffect{

    public static final int PLAY_REPEATING   = 1;
    public static final int PLAY_ALTERNATING = 2;
    public static final int REPEAT_INFINITE  = -1;

    public void start();

    public void stop();

    public boolean isAnimated();

    public void setPosition(int position);

    public int getPosition();

    public void setRepeatCount(int count);

    public int getRepeatCount();

    public void setDelay(int count);

    public int getDelay();

    public void setPlayMode(int mode);

    public int getPlayMode();
}








