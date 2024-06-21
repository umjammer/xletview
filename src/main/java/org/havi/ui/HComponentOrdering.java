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

public interface HComponentOrdering {

    java.awt.Component addBefore(java.awt.Component component, java.awt.Component behind);

    java.awt.Component addAfter(java.awt.Component component, java.awt.Component front);

    boolean popToFront(java.awt.Component component);

    boolean pushToBack(java.awt.Component component);

    boolean pop(java.awt.Component component);

    boolean push(java.awt.Component component);

    boolean popInFrontOf(java.awt.Component move, java.awt.Component behind);

    boolean pushBehind(java.awt.Component move, java.awt.Component front);
}
