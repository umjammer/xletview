/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

public interface HTextValue extends HNavigable, HKeyboardInputPreferred{

	public void addHKeyListener(org.havi.ui.event.HKeyListener l);

	public void removeHKeyListener(org.havi.ui.event.HKeyListener l);

	public void addHTextListener(org.havi.ui.event.HTextListener l);

	public void removeHTextListener(org.havi.ui.event.HTextListener l);

}



