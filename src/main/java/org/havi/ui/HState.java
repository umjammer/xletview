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

public interface HState {

    int FOCUSED_STATE_BIT = 0x01; // 1
    int ACTIONED_STATE_BIT = 0x02; // 2
    int DISABLED_STATE_BIT = 0x04; // 4

    int FIRST_STATE = 0x80; // 128

    int NORMAL_STATE = 0x80; // 128
    int FOCUSED_STATE = 0x81; // 129
    int ACTIONED_STATE = 0x82; // 130
    int ACTIONED_FOCUSED_STATE = 0x83; // 131

    int DISABLED_STATE = 0x84; // 132
    int DISABLED_FOCUSED_STATE = 0x85; // 133
    int DISABLED_ACTIONED_STATE = 0x86; // 134
    int DISABLED_ACTIONED_FOCUSED_STATE = 0x87; // 135

    int ALL_STATES = 0x07; // 7
    int LAST_STATE = 0x87; // 135


}



