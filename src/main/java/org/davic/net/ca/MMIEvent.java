/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.net.ca;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public abstract class MMIEvent extends java.util.EventObject {

    private int dialogueId;

    MMIEvent(Object source, int dialogueId) {
        super(source);
        this.dialogueId = dialogueId;
    }

    public int getDialogueId() {
        return dialogueId;
    }

    public Object getSource() {
        return super.getSource();
    }

}
