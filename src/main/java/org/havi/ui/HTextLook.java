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
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class HTextLook implements HLook{


    // platform specific


    private static Insets insets = new Insets(2, 2, 2, 2);

    public HTextLook(){
    }


    public void showLook(Graphics g, HVisible hVisible, int state){

        Dimension dimension = hVisible.getSize();

        // fix: check clip issues



        if(hVisible.getBackgroundMode() == HVisible.BACKGROUND_FILL){
            Color bg = hVisible.getBackground();
            if(bg != null){
                g.setColor(bg);
                g.fillRect(0, 0, dimension.width, dimension.height);
            }
        }

        // border
        if(hVisible.getInteractionState() == HState.FOCUSED_STATE){
            Color fg = hVisible.getForeground();
            if(fg != null){
                g.setColor(fg);

                // top
                g.fillRect(0, 0, dimension.width, insets.top);

                // right
                g.fillRect(dimension.width - insets.right, 0, insets.right, dimension.height);

                // bottom
                g.fillRect(0, dimension.height - insets.bottom, dimension.width, insets.bottom);

                // left
                g.fillRect(0, 0, insets.left, dimension.height);
            }
        }

        // let the HTextLayoutManager render the text...

        // the text in this state
        String string = hVisible.getTextContent(state);
        if(string != null){
            hVisible.getTextLayoutManager().render(string, g, hVisible, insets);
        }
    }

    public void widgetChanged(HVisible hVisible, HChangeData changes[]){
        /*
            " Note that implementations of HLook may not actually implement more efficient
            drawing code for a given hint. In particular, simply repainting the entire
            HVisible is a valid implementation option. "

            " The implementation of this method should work out which graphical areas of
            the HVisible have changed and make any relevant calls to trigger the repainting of those areas.

            A minimum implementation of this method could simply call

             visible.repaint()
            "

        */
        // so... at the moment we don't care about the HChangeData;
        // we're not allowed to call anything else than the hVisible repaint() method
        hVisible.repaint();
    }

    public Dimension getMinimumSize(HVisible hVisible){
        return hVisible.getSize();
    }

    public Dimension getPreferredSize(HVisible hVisible){
        return hVisible.getSize();
    }

    public Dimension getMaximumSize(HVisible hVisible){
        return hVisible.getSize();
    }

    public boolean isOpaque(HVisible hVisible){
        return hVisible.isOpaque();
    }

    public Insets getInsets(HVisible hVisible){
        return insets;
    }
}
