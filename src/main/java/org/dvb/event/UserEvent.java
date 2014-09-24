/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Sveden
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.event ;

import java.awt.event.KeyEvent;
import java.util.EventObject;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class UserEvent extends EventObject {
    
    public static final int UEF_KEY_EVENT = 1 ;
    private int family;
    private int type;
    private int code;
    private int modifiers;
    private long when;
    private char keyChar;

    public UserEvent(Object source, int family, int type, int code, int modifiers, long when) {
        super(source);      
        this.family = family;
        this.type = type;
        this.code = code;
        this.modifiers = modifiers;
        this.when = when;
    }  
    
    public UserEvent(Object source, int family, char keyChar, long when) {  
        super(source);
        this.family = family;
        this.keyChar = keyChar;
        this.when = when;
    }  

    public int getFamily(){
        return family;
    }

    public int getType(){
        return type;
    }

    public int getCode(){
        return code;
    }    

    public char getKeyChar(){ 
        return keyChar;
    }

    public int getModifiers(){ 
        return modifiers;
    }

    public boolean isShiftDown() { 
        boolean is = (KeyEvent.SHIFT_DOWN_MASK == modifiers)? true:false;
        return is;
    }

    public boolean isControlDown(){
        boolean is = (KeyEvent.CTRL_DOWN_MASK == modifiers)? true:false;
        return is;
    }

    public boolean isMetaDown(){
        boolean is = (KeyEvent.META_DOWN_MASK == modifiers)? true:false;
        return is;
    }

    public boolean isAltDown(){
        boolean is = (KeyEvent.ALT_DOWN_MASK == modifiers)? true:false;
        return is;
    }

    public long getWhen(){
        return when;
    }

}
