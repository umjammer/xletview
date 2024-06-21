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

package org.havi.ui.event;

import java.util.EventListener;


public interface HBackgroundImageListener extends EventListener {

    void imageLoaded(HBackgroundImageEvent e);

    void imageLoadFailed(HBackgroundImageEvent e);

}
