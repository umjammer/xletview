/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import net.beiker.cake.Log;
import net.beiker.cake.Logger;


/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class HVisible extends HComponent implements HState{
	/** Debugging facility. */
	private static final Logger logger = Log.getLogger(HVisible.class);
	
    public static final int HALIGN_LEFT                         = 0;
    public static final int HALIGN_CENTER                       = 1;
    public static final int HALIGN_RIGHT                        = 2;
    public static final int HALIGN_JUSTIFY                      = 3;
    
    public static final int VALIGN_TOP                          = 0;
    public static final int VALIGN_CENTER                       = 4;
    public static final int VALIGN_BOTTOM                       = 8;
    public static final int VALIGN_JUSTIFY                      = 12;
    
    public final static int RESIZE_NONE                         = 0;
    public static final int RESIZE_PRESERVE_ASPECT              = 1;
    public static final int RESIZE_ARBITRARY                    = 2;
    
    public static final int NO_BACKGROUND_FILL                  = 0;
    public static final int BACKGROUND_FILL                     = 1;
    
    public static final int FIRST_CHANGE                        = 0;
    
    public static final int TEXT_CONTENT_CHANGE                 = 0;
    public static final int GRAPHIC_CONTENT_CHANGE              = 1;
    public static final int ANIMATE_CONTENT_CHANGE              = 2;
    public static final int CONTENT_CHANGE                      = 3;
    public static final int STATE_CHANGE                        = 4;
    public static final int CARET_POSITION_CHANGE               = 5;
    public static final int ECHO_CHAR_CHANGE                    = 6;
    public static final int EDIT_MODE_CHANGE                    = 7;
    public static final int MIN_MAX_CHANGE                      = 8;
    public static final int THUMB_OFFSETS_CHANGE                = 9;
    public static final int ADJUSTMENT_VALUE_CHANGE             = 13;
    public static final int ORIENTATION_CHANGE                  = 10;
    public static final int TEXT_VALUE_CHANGE                   = 11;
    public static final int ITEM_VALUE_CHANGE                   = 12;
    public static final int LIST_CONTENT_CHANGE                 = 14;
    public static final int LIST_ICONSIZE_CHANGE                = 15;
    public static final int LIST_LABELSIZE_CHANGE               = 16;
    public static final int LIST_MULTISELECTION_CHANGE          = 17;
    public static final int LIST_SCROLLPOSITION_CHANGE          = 18;
    public static final int SIZE_CHANGE                         = 19;
    public static final int BORDER_CHANGE                       = 20;
    public static final int REPEAT_COUNT_CHANGE                 = 21;
    public static final int ANIMATION_POSITION_CHANGE           = 22;
    public static final int LIST_SELECTION_CHANGE               = 23;
    public static final int UNKNOWN_CHANGE                      = 24;
    public static final int LAST_CHANGE                         = UNKNOWN_CHANGE;
    
    public static final int NO_DEFAULT_WIDTH                    = -1;
    public static final int NO_DEFAULT_HEIGHT                   = -1;

    private HLook hLook;
    private Dimension defaultSize;
    private int backgroundMode;
    private HTextLayoutManager hTextLayoutManager;
    private HMatte hMatte;
    private int horizontalAlignment;
    private int verticalAlignment;
    private int resizeMode;
    private int state;
    private boolean bordersEnabled;

    private Object[] contents;
    private String[] textContents;
    private Image[] graphicContents;
    private Image[][] animateContents;


    public static final java.awt.Dimension NO_DEFAULT_SIZE =
                                        new java.awt.Dimension(NO_DEFAULT_WIDTH, NO_DEFAULT_HEIGHT);

    public HVisible(){
        this(null, 0, 0, 0, 0);
    }

    public HVisible(HLook hLook){
        this(hLook, 0, 0, 0, 0);
    }

    public HVisible(HLook hLook, int x, int y, int width, int height){
        setDefaultSize(new Dimension(width, height));
        this.hLook = hLook;

        // set init values
        this.resizeMode             = HVisible.RESIZE_NONE;
        this.hTextLayoutManager     = new HDefaultTextLayoutManager();
        this.backgroundMode         = HVisible.NO_BACKGROUND_FILL;
        this.horizontalAlignment    = HVisible.HALIGN_CENTER;
        this.verticalAlignment      = HVisible.VALIGN_CENTER;
        this.bordersEnabled = true;

        this.contents = new Object[8];
        this.textContents = new String[8];
        this.graphicContents = new Image[8];
        this.animateContents = new Image[8][];

        setInteractionState(HVisible.NORMAL_STATE);
        setBounds(x, y, width, height);

        //Debug.write(this, "default fontsize = " + getFont().getSize());
        
        //hMatte = null; // set in HComponent
        callWidgetChanged();
    }

    /**
     *    Checks that the hLook is not null and if not it calls widgetChanged
     */
    private void callWidgetChanged(){
        if(this.hLook != null){
        	/*
        	 * Since we pass null as the second argument
        	 * instead of a HChangeData[] a full repaint
        	 * will be made
        	 */
            this.hLook.widgetChanged(this, null);
        }
    }

    /*
        By default an HVisible component is not focus-traversable.
    */
    public boolean isFocusTraversable(){    	
        return false;
    }

    /**
     * Check the state argument
     * @param state 
     */
    private void checkStateArgument(int state){
    	boolean result = true;
    	switch (state) {
			case HState.FOCUSED_STATE_BIT :
			case HState.ACTIONED_STATE_BIT :
			case HState.DISABLED_STATE_BIT :
				result = false;
				break;
		}
    	if(result == false){
    		throw new java.lang.IllegalArgumentException("argument is STATE_BIT rather than a STATE");
    	}
    }
        
    public void setTextContent(String string, int state){

    	checkStateArgument(state);    	
    	if(state == HState.ALL_STATES){
    		for(int i = this.textContents.length - 1; i > -1 ; i--){
    			this.textContents[i] = string;
    		}
    	}
    	else{
    		this.textContents[state - HState.NORMAL_STATE] = string;
    	}
        callWidgetChanged();        
    }

    public void setGraphicContent(Image image, int state){
    	if(state == HState.ALL_STATES){
    		for(int i = this.graphicContents.length - 1; i > -1 ; i--){
    			this.graphicContents[i] = image;
    		}
    	}
    	else{
    		this.graphicContents[state - HState.NORMAL_STATE] = image;
    	}
    	callWidgetChanged();
    }

    public void setAnimateContent(Image[] imageArray, int state){
    	if(state == HState.ALL_STATES){
    		for(int i = this.animateContents.length - 1; i > -1 ; i--){
    			this.animateContents[i] = imageArray;
    		}
    	}
    	else{
    		this.animateContents[state - HState.NORMAL_STATE] = imageArray;
    	}
    	callWidgetChanged();
    }

    public void setContent(Object object, int state){
    	if(state == HState.ALL_STATES){
    		for(int i = this.contents.length - 1; i > -1 ; i--){
    			this.contents[i] = object;
    		}
    	}
    	else{
    		this.contents[state - HState.NORMAL_STATE] = object;
    	}
    	callWidgetChanged();
    }

    private Object getForNearestMatchingState(int state, Object[] contents){
    	Object result = contents[state - HState.NORMAL_STATE];

    	if(result == null){
    		switch (state) {
    			case HState.FOCUSED_STATE :
    				result = getForNearestMatchingState(HState.NORMAL_STATE, contents);
    				break;
    			case HState.ACTIONED_STATE :
    				result = getForNearestMatchingState(HState.FOCUSED_STATE, contents);
    				break;
    			case HState.ACTIONED_FOCUSED_STATE :
    				result = getForNearestMatchingState(HState.FOCUSED_STATE, contents);
    				break;
    			case HState.DISABLED_STATE :
    				result = getForNearestMatchingState(HState.NORMAL_STATE, contents);
    				break;
    			case HState.DISABLED_FOCUSED_STATE :
    				result = getForNearestMatchingState(HState.DISABLED_STATE, contents);
    				break;
    			case HState.DISABLED_ACTIONED_STATE :
    				result = getForNearestMatchingState(HState.ACTIONED_STATE, contents);
    				break;
    			case HState.DISABLED_ACTIONED_FOCUSED_STATE :
    				result = getForNearestMatchingState(HState.DISABLED_STATE, contents);
    				break;
    		}
    	}    	
    	
    	return result;
    }
    
    public String getTextContent(int state){
    	checkStateArgument(state);
    	String str = (String)getForNearestMatchingState(state, this.textContents);
        return str;
    }

    public Image getGraphicContent(int state){
    	checkStateArgument(state);
    	Image img = (Image) getForNearestMatchingState(state, this.graphicContents);
        return img;
    }

    public Image[] getAnimateContent(int state){
    	checkStateArgument(state);
    	Image[] imgs = (Image[])getForNearestMatchingState(state, this.animateContents);
        
    	return imgs;
    }

    public Object getContent(int state){
    	checkStateArgument(state);
    	Object obj = getForNearestMatchingState(state, this.contents);
        return obj;
    }

    public void setLook(HLook hLook) throws HInvalidLookException{
        this.hLook = hLook;
    }

    public HLook getLook(){
        return this.hLook;
    }

    public Dimension getPreferredSize(){
        Dimension dimension = null;
        if(this.hLook != null){
            dimension = this.hLook.getPreferredSize(this);
        }
        else{
            dimension = this.getSize();
        }
        return dimension;
    }

    public Dimension getMaximumSize(){
        Dimension dimension = null;
        if(this.hLook != null){
            dimension = this.hLook.getMaximumSize(this);
        }
        else{
            dimension = this.getSize();
        }
        return dimension;
    }

    public Dimension getMinimumSize(){
        Dimension dimension = null;
        if(this.hLook != null){
            dimension = this.hLook.getMinimumSize(this);
        }
        else{
            dimension = this.getSize();
        }
        return dimension;
    }

    protected void setInteractionState(int state) throws java.lang.IllegalArgumentException{
    	checkStateArgument(state);
    	this.state = state;
        callWidgetChanged();
    }

    public int getInteractionState(){
        return this.state;
    }

    public void setTextLayoutManager(HTextLayoutManager manager){
        this.hTextLayoutManager = manager;
    }

    public HTextLayoutManager getTextLayoutManager(){
        return this.hTextLayoutManager;
    }

    public int getBackgroundMode(){
        return this.backgroundMode;
    }

    public void setBackgroundMode(int mode){
        this.backgroundMode = mode;
    }

    public boolean isOpaque(){
        /*
            Normally the associated HLook does not paint the background of the HVisible,
            allowing for non-rectangular components and text overlaying bitmaps.
            However, HVisible provides for components which require their background
            to be painted through the setBackgroundMode method. Note that if the mode
            is set to BACKGROUND_FILL the return value of the isOpaque method may
            be true, depending on whether the current background color of the HVisible
            is opaque. If the background mode is set to NO_BACKGROUND_FILL the isOpaque
            method must return false.
        */
        if(this.backgroundMode == HVisible.NO_BACKGROUND_FILL){
            return false;
        }
        else{
            return true;
        }
    }

    public void setDefaultSize(Dimension defaultSize){
        this.defaultSize = defaultSize;
    }

    public java.awt.Dimension getDefaultSize(){
        return this.defaultSize;
    }


    public java.lang.Object getLookData(java.lang.Object key){
        /*
            " Use of this mechanism is an implementation option. If this mechanism is not used
            by an implementation, getLookData shall always return null and setLookData shall
            do nothing. Interoperable systems shall not assume that this mechanism is implemented. "
        */
        return null;
    }

    public void setLookData(java.lang.Object key, java.lang.Object data){
        /*
            " Use of this mechanism is an implementation option. If this mechanism is not used
            by an implementation, getLookData shall always return null and setLookData shall
            do nothing. Interoperable systems shall not assume that this mechanism is implemented. "
        */
    }

    public void setHorizontalAlignment(int hAlign){
        /*
            " Set the horizontal alignment of any state-based content rendered by an associated HLook.
            If content is not used in the rendering of this HVisible calls to this method shall
            change the current alignment mode, but this will not affect the rendered representation "
        */
        this.horizontalAlignment = hAlign;
    }

    public void setVerticalAlignment(int vAlign){
        /*
            " Set the vertical alignment of any state-based content rendered by an associated HLook.
            If content is not used in the rendering of this HVisible calls to this method shall
            change the current alignment mode, but this will not affect the rendered representation. "
        */
        this.verticalAlignment = vAlign;
        callWidgetChanged();
    }

    public int getHorizontalAlignment(){
        /*
            " Get the horizontal alignment of any state-based content rendered by an associated HLook. If content is not used in the rendering of this HVisible the value returned shall be valid, but has no affect on the rendered representation. "
        */
        return this.horizontalAlignment;
    }

    public int getVerticalAlignment(){
        /*
            " Get the vertical alignment of any state-based content rendered by an associated HLook.
            If content is not used in the rendering of this HVisible the value returned shall be valid,
            but has no affect on the rendered representation."
        */
        return this.verticalAlignment;
    }

    public void setResizeMode(int resize){
        /*
            " Scaling support is optional, however all implementations must support the
            RESIZE_NONE scaling mode. Platforms are not required to support scaling of
            textual content by default. "
        */
        if(resize != HVisible.RESIZE_NONE){
            String msg  = "\nScaling support is optional, however all implementations must support the RESIZE_NONE scaling mode. Platforms are not required to support scaling of textual content by default.";
            logger.warn("setResizeMode(" + resize + ") is not supported, only HVisible.RESIZE_NONE is." + msg);
        }
    }

    public int getResizeMode(){
        return this.resizeMode;
    }

    public void setEnabled(boolean b){
        super.setEnabled(b);
        if(b == false){
            if(getInteractionState() >= HState.NORMAL_STATE || getInteractionState() <= HState.ACTIONED_FOCUSED_STATE){
                this.setInteractionState(getInteractionState() - 4);
            }
        }
        else{
            if(getInteractionState() >= HState.DISABLED_STATE || getInteractionState() <= HState.DISABLED_ACTIONED_FOCUSED_STATE){
                this.setInteractionState(getInteractionState() + 4);
            }
        }
        callWidgetChanged();
    }

    public void setBordersEnabled(boolean enable){
        this.bordersEnabled = enable;
        callWidgetChanged();
    }


    public boolean getBordersEnabled() {
          return this.bordersEnabled;
    }

    /*
        Draws the current state of the component, by calling the showLook method of
        the associated HLook. If no HLook is associated with the
        component, (i.e. the HVisible was created with a null HLook or the look
        has been set to null using setLook) then the paint method should do nothing.
        This mechanism may be used for components that wish to extend HVisible,
        and override the paint method, without supporting the HLook interface.

    */
    public void paint(Graphics g){
        if(this.hLook != null){
            this.hLook.showLook(g, this, this.getInteractionState());
        }
    }

    /*
        The update() method in HVisible overrides that in Component and does not
        clear the background of the component, it simply modifies the current
        Color of the Graphics object to match that of the components background
        Color, and calls the paint() method.
    */
    public void update(java.awt.Graphics g){
        g.setColor(this.getBackground());
        paint(g);
    }

}
