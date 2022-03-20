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
import java.awt.Image;
import java.awt.Insets;


/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class HGraphicLook implements HLook{

    private static Insets insets = new Insets(2, 2, 2, 2);

    public HGraphicLook(){
    }


    public void showLook(java.awt.Graphics g, HVisible hVisible, int state){
        Dimension dimension = hVisible.getSize();

        if(hVisible.getBackgroundMode() == HVisible.BACKGROUND_FILL){
            Color bg = hVisible.getBackground();
            if(bg != null){
                g.setColor(bg);
                g.fillRect(0, 0, dimension.width, dimension.height);
            }
        }

        // this is the image to be drawn in the state
        Image imageToDraw = hVisible.getGraphicContent(state);
        if(imageToDraw != null){
            drawImage(g, imageToDraw, hVisible);

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

    }

    /**
     * Draws an Image.
     * Used also by other looks.
     * @param g The graphics object used to draw the image
     * @param imageToDraw The Image to draw
     * @param hVisible The HVisible that owns the Image
     * @return The boolean value of Graphics.drawImage(..
     */
    protected static boolean drawImage(java.awt.Graphics g, Image imageToDraw, HVisible hVisible){
        /*
         This implementation only supports HVisible.RESIZE_NONE,
         which is minimum for an implementation...
         so, we don't even bother to check the resize mode
         // hVisible.getResizeMode();
         */

        int hAlign    = hVisible.getHorizontalAlignment();
        int vAlign    = hVisible.getVerticalAlignment();

        int vWidth    = hVisible.getWidth();
        int vHeight   = hVisible.getHeight();

        int imgWidth  = imageToDraw.getWidth(hVisible);
        int imgHeight = imageToDraw.getHeight(hVisible);

        /*
         "Note that the results of applying the VALIGN_JUSTIFY and HALIGN_JUSTIFY
         alignment modes for graphical content are defined to identical to VALIGN_CENTER
         and HALIGN_CENTER modes respectively, as justification is meaningless in this context. "
         */

        int drawX = 0;
        int drawY = 0;

        // horizontal
        if(hAlign == HVisible.HALIGN_CENTER || hAlign == HVisible.HALIGN_JUSTIFY){
            drawX = (vWidth/2 ) - (imgWidth/2);
        }
        else if(hAlign == HVisible.HALIGN_LEFT){
            drawX = 0;
        }
        else if(hAlign == HVisible.HALIGN_RIGHT){
            drawX = vWidth - imgWidth;
        }

        // vertical
        if(vAlign == HVisible.VALIGN_CENTER || vAlign == HVisible.HALIGN_JUSTIFY){
            drawY = (vHeight/2 ) - (imgHeight/2);
        }
        else if(vAlign == HVisible.VALIGN_TOP){
            drawY = 0;
        }
        else if(vAlign == HVisible.VALIGN_BOTTOM){
            drawY = vHeight - imgHeight;
        }

    	//logger.debug("imageToDraw=" + imageToDraw + "drawX=" + drawX + ", drawY=" + drawY + ", hVisible=" + hVisible);
        return g.drawImage(imageToDraw, drawX, drawY, hVisible);
    }

    public void widgetChanged (HVisible hVisible, HChangeData[] changes){
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







