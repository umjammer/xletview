/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

public interface HComponentOrdering{
    
    public java.awt.Component addBefore(java.awt.Component component, java.awt.Component behind);

    public java.awt.Component addAfter(java.awt.Component component, java.awt.Component front);
    
    public boolean popToFront(java.awt.Component component);
    
    public boolean pushToBack(java.awt.Component component);
    
    public boolean pop(java.awt.Component component);
    
    public boolean push(java.awt.Component component);
    
    public boolean popInFrontOf(java.awt.Component move, java.awt.Component behind);
    
    public boolean pushBehind(java.awt.Component move, java.awt.Component front);
}
