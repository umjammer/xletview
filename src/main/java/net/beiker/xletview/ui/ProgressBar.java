/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Sveden
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/
package net.beiker.xletview.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
/**
 * @author Martin
 * 
 */
public class ProgressBar extends JPanel{
    
    private int width;
    private int height;
    private Color foreground;
    private Color background;
    private int procent;

    public ProgressBar(int width, int height, Color foreground, Color background){
        this.width = width;
        this.height = height;
        setSize(width, height);
        this.foreground = foreground;
        this.background = background;  
        setVisible(false);           
    }
    
    public Dimension getPreferredSize(){
        return new Dimension(getSize().width, height);
    }
    
    
    public void update(int procent){
        this.procent = procent;
        repaint();
    }
    
    public void paint(Graphics g){
        int width = getWidth();
        
        
        if(background != null){
            g.clearRect(0, 0, getSize().width, getSize().height);
            g.setColor(background);
            g.fillRect(0, 0, getSize().width, getSize().height);
        }
        
        
        g.setColor(foreground);
        g.fillRect(0, 0, width * procent / 100, getSize().height);
    }

}
