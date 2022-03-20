/*

This file is part of XleTView
Copyright (C) 2003 Martin Sved?

This is free software, and you are
welcome to redistribute it under
certain conditions;

See LICENSE document for details.

*/


package org.havi.ui;

import java.awt.Dimension;
import java.awt.Insets;

/**
*
* @author Cristian Suazo, Martin Sveden
* @statuscode 1
*
*/
public class HListGroupLook implements HAdjustableLook{

    private Insets insets;

    private Insets elementInsets;


    public HListGroupLook(){

        insets = new Insets(2, 2, 2, 2);

        elementInsets = new Insets(2, 2, 2, 2);

   }

   public void showLook(java.awt.Graphics g, HVisible visible, int state){
       return;
   }

   public void widgetChanged (HVisible visible, HChangeData[] changes){
       return;
   }

   public Dimension getMinimumSize(HVisible visible){

       int width = insets.left + insets.top;
       int height = insets.bottom + insets.top;

       Dimension itemDim = getItemDimension((HListGroup) visible);

       return new Dimension(width + itemDim.width, height + itemDim.height);
   }

   public Dimension getPreferredSize(HVisible visible){


       //         doing some work here, check


       // get all sizes that are needed
       HListGroup hGroup = (HListGroup) visible;
       Dimension min = getMinimumSize(visible);
       Dimension defaultSize = hGroup.getDefaultSize();
       Dimension preferredSize = new Dimension();


       if (defaultSize == HVisible.NO_DEFAULT_SIZE ){
           preferredSize = min;
       }
       else{


           int orientation = hGroup.getOrientation();
           int sizeToNextElement;
           int sizeToPrevElement;

           preferredSize = defaultSize;

           // adjust size in the case that the width or the height hasn't been set
           // minimun size should be 5 elemeents in the orientation that is set if there is no default value
           // set for the hlist group


           //
            // width
           //
            if (defaultSize.width == HVisible.NO_DEFAULT_WIDTH ){

                if (orientation == HOrientable.ORIENT_LEFT_TO_RIGHT || orientation == HOrientable.ORIENT_RIGHT_TO_LEFT ){
                    // horisontal orientation
                    preferredSize.width = min.width * 5;
                }
                else{
                    preferredSize.width = min.width;
                }

            }
            else{


                // check so that atleast 1 element is with the size
                if (preferredSize.width < min.width ){
                    preferredSize.width = min.width;
                }
                else{


                    // round to the nearest element
                    sizeToPrevElement = preferredSize.width % min.width;
                    if (sizeToPrevElement != 0){
                        sizeToNextElement = min.width - sizeToPrevElement;
                        if (sizeToPrevElement < sizeToNextElement ){
                            preferredSize.width = preferredSize.width - sizeToPrevElement;
                        }
                        else{
                            preferredSize.width = preferredSize.width + sizeToNextElement;
                        }
                    }

                }


            }


            //
            // height
            //
            if (defaultSize.height == HVisible.NO_DEFAULT_HEIGHT ){

                if (orientation == HOrientable.ORIENT_TOP_TO_BOTTOM || orientation == HOrientable.ORIENT_BOTTOM_TO_TOP ){
                    // vertical orientation
                   preferredSize.height = min.height * 5;
               }
                else{
                    preferredSize.height = min.height;
                }

            }
            else{


                // check so that atleast 1 element is with the size
                if (preferredSize.height < min.height ){
                    preferredSize.height = min.height;
                }
                else{
                    // round to the nearest element
                    sizeToPrevElement = preferredSize.height % min.height;
                    if (sizeToPrevElement != 0){
                        sizeToNextElement = min.height - sizeToPrevElement;
                        if (sizeToPrevElement < sizeToNextElement ){
                            preferredSize.height = preferredSize.height - sizeToPrevElement;
                        }
                        else{
                            preferredSize.height = preferredSize.height + sizeToNextElement;
                        }
                    }

                }


            }



       }



       return(null);
   }

   public Dimension getMaximumSize(HVisible visible){

       HListGroup hGroup = (HListGroup) visible;
       HListElement[] elements = hGroup.getListContent();

       int width = insets.left + insets.top;
       int height = insets.bottom + insets.top;

       Dimension itemDim = getItemDimension(hGroup);

       if(hGroup.getOrientation() == HOrientable.ORIENT_TOP_TO_BOTTOM || hGroup.getOrientation() == HOrientable.ORIENT_BOTTOM_TO_TOP  ){
           // this handles vertical orientation

           height += itemDim.height * elements.length;
           width  += itemDim.width;
       }
       else{
           // this handles horizontal orientation
           height += itemDim.height;
           width  += itemDim.width * elements.length;
       }


       return new Dimension(width, height);
   }

   /**
    * Calculates the Dimension of one element.
    * @param hGroup The HListGroup
    * @return the Dimension of one element
    */
   private Dimension getItemDimension(HListGroup hGroup){

       Dimension iconDim = hGroup.getIconSize();
       Dimension labelDim = hGroup.getLabelSize();

       int itemWidth = elementInsets.left + elementInsets.right + iconDim.width + labelDim.width;
       int itemHeight = elementInsets.top + elementInsets.bottom;

        if(hGroup.getIconSize().height > hGroup.getLabelSize().height ){

            itemHeight += hGroup.getIconSize().height;

        }
        else{

            itemHeight += hGroup.getLabelSize().height;

        }

        return new Dimension(itemWidth, itemHeight);
   }


   public boolean isOpaque(HVisible visible){
       return(false);
   }

   public java.awt.Insets getInsets(HVisible visible){
       return insets;
   }

   public int hitTest(HOrientable component, java.awt.Point pt){
       return(0);
   }

   public java.lang.Integer getValue(HOrientable component, java.awt.Point pt){
       return(null);
   }

   public java.awt.Insets getElementInsets(){
        return elementInsets;
   }

   public int getNumVisible(HVisible visible){
        return (0);
   }
}