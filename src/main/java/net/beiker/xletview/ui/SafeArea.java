/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package net.beiker.xletview.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;


public class SafeArea extends Component{

    private int x, y, width, height, border;
    private Color color;

    public SafeArea(int x, int y, int width, int height, int border, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.border = border;
        this.color = color;
        setBounds(x-border, y-border, width+border*2, height+border*2);
    }

    public void paint(Graphics g){

        g.setColor(color);

        // top
        g.fillRect(border, 0, width+border, border);

        // right
        //g.fillRect(width+border, 0, border, height*2);
        g.fillRect(width+border, 0, border, height + border*2);

        // bottom
        g.fillRect(border, height+border, width+border, border);

        // left
        g.fillRect(0, 0, border, height+border*2);



//        // top
//        g.fillRect(x - border, y - border, width+border, border);
//
//        // right
//        g.fillRect(x + width, y - border, border, height + border*2);
//
//        // bottom
//        g.fillRect(x - border, y + height, width+border, border);
//
//        // left
//        g.fillRect(x - border, y - border, border, height+border*2);

    }

}
