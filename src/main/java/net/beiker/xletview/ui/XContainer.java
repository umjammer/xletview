/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package net.beiker.xletview.ui;

import java.awt.Container;
import java.awt.Dimension;

/**
 * A Container to be used as is or extended, just for the possibility to change behaviour of the instances. 
 */
public class XContainer extends Container{

    private Dimension prefSize;

    public XContainer(){
    }
    
    public XContainer(int x, int y, int width, int height){
        setBounds(x, y, width, height);
    }
    
    public void setPrefSize(int width, int height){
        prefSize = new Dimension(width, height);
    }
    
    public void setPrefSize(Dimension dimension){
        prefSize = dimension;        
    }
    
    public Dimension getPreferredSize(){
        Dimension d = null;
        if(prefSize == null){
            d = getSize();
        }
        else{   
            d = prefSize;
        }
        return d;
    }
    
    public Dimension getMinimumsize(){
        return getPreferredSize();
    }
    
    public Dimension getMaximumsize(){
        return getPreferredSize();
    }
    
//    public void update(Graphics g){
//    	paint(g);
//    }
        
//    public void paint(Graphics g){
//        for(int i = 0; i < getComponentCount(); i++){
//            getComponent(i).paint(g);
//        } 
//    } 
    


}
