/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

import java.awt.Graphics;
import java.awt.Insets;

public interface HTextLayoutManager{
	public abstract void render(String s, Graphics g, HVisible hvisible, Insets insets);
}
