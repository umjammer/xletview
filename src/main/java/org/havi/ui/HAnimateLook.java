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
 * @author Cristian Suazo
 * @author Martin Sveden
 * @statuscode 4
 */
public class HAnimateLook implements HLook {

    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(HAnimateLook.class.getName());

    /* PLATFORM SPECIFIC */
    private static Insets insets = new Insets(2, 2, 2, 2);

    public HAnimateLook() {
    }

    public void showLook(java.awt.Graphics g, HVisible hVisible, int state) {
//        logger.fine("Repaiting animation");


        HStaticAnimation animation = (HStaticAnimation)hVisible;



        Dimension dimension = animation.getSize();

        if (animation.getBackgroundMode() == HVisible.BACKGROUND_FILL) {
            Color bg = animation.getBackground();
            if (bg != null) {
                g.setColor(bg);
                g.fillRect(0, 0, dimension.width, dimension.height);
            }
        }

        // image to display
        Image[] images = animation.getAnimateContent(state);

        if (images != null) {

            int position = 0;
            Image currentImage = null;

            /*
             * If the image does not exist it should
             * draw the next one. Make sure it breaks
             * the loop if all images are null.
             */
            int count = 0;
            while(count < images.length){
                position = animation.getPosition();
                currentImage = images[position];

                boolean ok = HGraphicLook.drawImage(g, currentImage, hVisible);

                if(ok){
                    break;
                }
                else{
                    log.info("image for position " + position + " is not drawable");
                    count++;
                    animation.setPosition(++position);
                }
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

    }

    public void widgetChanged(HVisible visible, HChangeData[] changes) {
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
        visible.repaint();
    }

    public Dimension getMinimumSize(HVisible hvisible) {
        return hvisible.getMinimumSize();
    }

    public Dimension getPreferredSize(HVisible hvisible) {
        return hvisible.getPreferredSize();
    }

    public Dimension getMaximumSize(HVisible hvisible) {
        return hvisible.getMaximumSize();
    }

    public boolean isOpaque(HVisible visible) {
        return visible.isOpaque();
    }

    public java.awt.Insets getInsets(HVisible visible) {
        return insets;
    }
}
