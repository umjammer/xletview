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

public interface HAnimateEffect {

    int PLAY_REPEATING = 1;
    int PLAY_ALTERNATING = 2;
    int REPEAT_INFINITE = -1;

    void start();

    void stop();

    boolean isAnimated();

    int getPosition();

    void setPosition(int position);

    int getRepeatCount();

    void setRepeatCount(int count);

    int getDelay();

    void setDelay(int count);

    int getPlayMode();

    void setPlayMode(int mode);
}








