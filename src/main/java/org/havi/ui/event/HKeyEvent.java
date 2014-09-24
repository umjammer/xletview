/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui.event;


import java.awt.Component;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class HKeyEvent extends HRcEvent{

  public HKeyEvent(Component source, int id, long when, int modifiers,int keyCode, char keyChar) {
    super(source, id, when, modifiers, keyCode, keyChar);
  }
  
  public HKeyEvent(Component source, int id, long when, int modifiers, int keyCode) {
    super(source, id, when, modifiers, keyCode);
  }
}

