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


public interface HTextListener extends java.util.EventListener {

    void textChanged(org.havi.ui.event.HTextEvent e);

    void caretMoved(org.havi.ui.event.HTextEvent e);

}
