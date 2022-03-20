/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

import java.awt.Color;
import java.awt.Font;


/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class HStaticText extends HVisible implements HNoInputPreferred{

    private static HTextLook defaultHLook = new HTextLook();

    public HStaticText(){
        this("", 0, 0, 0, 0);
    }

    public HStaticText(String textNormal, int x, int y, int width, int height){
        super(defaultHLook , x, y, width, height);
        this.setTextContent(textNormal, HVisible.NORMAL_STATE);
        this.setTextLayoutManager(new HDefaultTextLayoutManager());
        this.setBackgroundMode(HVisible.BACKGROUND_FILL);

        //logger.debug("constructor");
    }

    public HStaticText(String textNormal, int x, int y, int width, int height, Font font, Color foreground, Color background, HTextLayoutManager tlm){
            this(textNormal, x, y, width, height);
            this.setTextLayoutManager(tlm);
            this.setFont(font);
            this.setBackground(background);
            this.setForeground(foreground);
    }

    public HStaticText(String textNormal){
        this(textNormal, 0, 0, 0, 0);
    }

    public HStaticText(String textNormal, Font font, Color foreground, Color background, HTextLayoutManager tlm){
        this(textNormal, 0, 0, 0, 0, font, foreground, background, tlm);
    }

    public void setLook(HLook hLook) throws HInvalidLookException{
        if(hLook instanceof HTextLook || hLook == null){
            super.setLook(hLook);
        }
        else{
            throw new HInvalidLookException("HLook was not a org.havi.ui.HTextLook");
        }
    }

    public static void setDefaultLook(HTextLook defaultHLook){
        HStaticText.defaultHLook = defaultHLook;
    }

    public static HTextLook getDefaultLook(){
        return HStaticText.defaultHLook;
    }

    public String toString(){
        return super.toString() + " text:" + getTextContent(getInteractionState());
    }
}
