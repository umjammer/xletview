/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui.event;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class HActionEvent extends java.awt.event.ActionEvent{


    public HActionEvent(org.havi.ui.HActionInputPreferred source, int id, String command){
        super(source, id, command);
    }

    public String getActionCommand(){
        return super.getActionCommand();
    }

    public int getModifiers(){
        return super.getModifiers();
    }
}

