/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

import java.awt.Component;
import java.awt.Container;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class HContainer extends Container{

    private HMatte hMatte;
    private boolean grouped;

    public HContainer(){
        hMatte     = null;
        setLayout(null);
        grouped = false;
    }

    public HContainer(int x, int y, int width, int height){
        this();
        setBounds(x, y, width, height);
    }

    public java.awt.Component addAfter(java.awt.Component component, java.awt.Component front){
        int i = getComponentIndex(front);

        if(i != -1){
            add(component, i+1);
            return component;
        }
        else{
            return null;
        }
    }

    public java.awt.Component addBefore(java.awt.Component component, java.awt.Component behind) {
        int i = getComponentIndex(behind);

        if(i != -1){
            remove(i);
            add(component, i);
            add(behind, i+1);
            return component;
        }
        else{
            return null;
        }
    }

    public boolean isDoubleBuffered(){
        return false;
    }

    public boolean isOpaque(){
        return false;
    }

    private int getComponentIndex(Component component){
        Component components[] = getComponents();
        for(int i = 0; i < components.length; i++)
            if(components[i] == component)
                return i;

        return -1;
    }

    /**
     * Brings the component to the front.
     */
    public boolean popToFront(Component component){
        int i = getComponentIndex(component);
        if(i != -1){
            remove(i);
            add(component, 0);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Brings the component one step more to the front.
     * It changes order with the component before.
     */
    public boolean pop(Component component){
        int i = getComponentIndex(component);
        if(i != -1 && --i != -1){
            remove(i + 1);
            add(component, i);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Pushes the component one step back.
     */
    public boolean push(Component component){
        int i = getComponentIndex(component);
        if(i != -1 && ++i < getComponentCount()){
            remove(i - 1);
            add(component, i);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Pushes the component to the back.
     */
    public boolean pushToBack(Component component){
        int i = getComponentIndex(component);
        if(i != -1){
            remove(i);
            add(component);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean popInFrontOf(Component component, Component component1){
        int i = getComponentIndex(component1);
        int j = getComponentIndex(component);
        if(i != -1 && j != -1){
            remove(j);
            add(component, i);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean pushBehind(Component component, Component component1){
        int i = getComponentIndex(component1);
        int j = getComponentIndex(component);
        if(i != -1 && j != -1){
            remove(j);
            if(i < getComponentCount())
                add(component, i + 1);
            else
                add(component);
            return true;
        }
        else{
            return false;
        }
    }


    public void setMatte(HMatte m){
        hMatte = m;
    }

    public HMatte getMatte(){
        return hMatte;
    }

    public void group(){
        grouped = true;
    }

    public void ungroup(){
        grouped = false;
    }

    public boolean isGrouped(){
        return grouped;
    }

}

