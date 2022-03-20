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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.logging.Logger;

import org.havi.ui.event.HFocusEvent;
import org.havi.ui.event.HFocusListener;
import org.havi.ui.event.HKeyEvent;
import org.havi.ui.event.HKeyListener;
import org.havi.ui.event.HTextEvent;
import org.havi.ui.event.HTextListener;

import net.beiker.xletview.helper.HNavigableHelper;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 * @comment needs testing
 */
public class HSinglelineEntry extends HVisible implements HTextValue{

	private static final Logger log = Log.getLogger(HSinglelineEntry.class);

    private int caretPosition;
    private int maxChars = 16;
    private int inputType = HKeyboardInputPreferred.INPUT_ANY;
    private char[] validInputChars;
    private char echoChar = '\0';
    private boolean edit;

    private HNavigableHelper navHelper;

    transient HKeyListener hKeyListener;
    transient HTextListener hTextListener;

    private static HSinglelineEntryLook defaultHLook = new HSinglelineEntryLook();

    public HSinglelineEntry(){
        super(defaultHLook);
        init();
    }

    public HSinglelineEntry(String text, int x, int y, int width, int height, int maxChars, Font font, Color color){
        super(defaultHLook, x, y, width, height );
        this.setTextContent (text, HState.ALL_STATES);
        this.maxChars = maxChars;
        this.setFont(font);
        this.setForeground(color);

        init();
    }

    public HSinglelineEntry(int x, int y, int width, int height, int maxChars){
        super(defaultHLook, x, y, width, height );
        this.setTextContent ("", HState.ALL_STATES);
        this.maxChars = maxChars;
        init();
    }

    public HSinglelineEntry(String text, int maxChars, Font font, Color color){
        super(defaultHLook);
        this.setTextContent (text, HState.ALL_STATES);
        this.maxChars = maxChars;
        this.setFont(font);
        this.setForeground(color);
        init();
    }

    public HSinglelineEntry(int maxChars){
        super(defaultHLook);
        this.setTextContent ("", HState.ALL_STATES);
        this.maxChars = maxChars;
        init();
    }

    // constructors end //

    private void init(){
        navHelper = new HNavigableHelper(this);
    }

    public void setTextContent(String string, int state){
        super.setTextContent(string, HState.ALL_STATES);
    }

    public String getTextContent(int state){
        return super.getTextContent(HState.NORMAL_STATE);
    }

    public void setType(int type){
        this.inputType = type;
    }

    public boolean echoCharIsSet(){
        return (echoChar != '\0');
    }

    public char getEchoChar(){
        return echoChar;
    }

    public void setEchoChar(char c){
        echoChar = c;
    }

    public static void setDefaultLook(HSinglelineEntryLook look){
        HSinglelineEntry.defaultHLook = look;
    }

    public static HSinglelineEntryLook getDefaultLook(){
        return HSinglelineEntry.defaultHLook;
    }

    public void setLook(HLook hLook) throws HInvalidLookException{
        if(hLook instanceof HSinglelineEntryLook || hLook == null){
            super.setLook(hLook);
        }
        else {
            throw new HInvalidLookException("HLook was not an instance of HSinglelineEntryLook");
        }
    }


    /**
     * Insert a character at the current caret position, subject to the maximum number of input characters.
     * @param c the character to insert
     * @return true if the character was inserted, false otherwise.
     */
    public boolean insertChar(char c){
        /*
         * While in the editing mode, the component will generate an HTextEvent event with an
         * id of TEXT_CHANGE whenever the text content of the HSinglelineEntry changes
         * (e.g. a character is inserted).
         */
        char[] chars = this.getTextContent(HState.NORMAL_STATE).toCharArray();

        if(chars.length < this.maxChars && edit){
            char[] newChars = new char[chars.length + 1];

            // the part before the caret position
            System.arraycopy(chars, 0, newChars, 0, caretPosition);

            // the new char
            newChars[caretPosition] = c;

            // the part after the caret position
            System.arraycopy(chars, caretPosition, newChars, caretPosition + 1, chars.length - caretPosition);

            setTextContent(new String(newChars), HState.NORMAL_STATE);

            repaint();

//            |x|x|x|x|
//            |x|o|x|x|x|

            HTextEvent eChanged = new HTextEvent(this, HTextEvent.TEXT_CHANGE);
            if(hTextListener != null){
                hTextListener.textChanged(eChanged);
            }

            return true;
        }
        else{
            return false;
        }
    }

    private boolean deleteCharAt(int index){
        char[] chars = this.getTextContent(HState.NORMAL_STATE).toCharArray();

        if(chars.length > 0 && index > -1 && index < chars.length && edit){
            char[] newChars = new char[chars.length - 1];

            for (int i = 0, k = 0; i < chars.length; i++) {
                if(index != i){
                    newChars[k] = chars[i];
                    k++;
                }
            }

            setTextContent(new String(newChars), HState.NORMAL_STATE);

            repaint();

            HTextEvent eChanged = new HTextEvent(this, HTextEvent.TEXT_CHANGE);
            if(hTextListener != null){
                hTextListener.textChanged(eChanged);
            }

            return true;
        }
        else{
            return false;
        }
    }

    public boolean deletePreviousChar(){
        if(edit){
            boolean b = deleteCharAt(caretPosition - 1);
            if(b){
                caretPreviousCharacter();
            }
            return b;
        }
        else{
            return false;
        }
    }

    public boolean deleteNextChar(){
        if(edit){
            boolean b = deleteCharAt(caretPosition + 1);
            return b;
        }
        else{
            return false;
        }
    }

    public void caretNextCharacter(){
        if(edit){
            this.setCaretCharPosition(++caretPosition);
        }
    }

    public void caretPreviousCharacter(){
        if(edit){
            this.setCaretCharPosition(--caretPosition);
        }
    }

    public int getCaretCharPosition(){
        return caretPosition;
    }

    public int setCaretCharPosition(int position){

            if(position > getTextContent(HState.ALL_STATES).length()){
                caretPosition = getTextContent(HState.ALL_STATES).length();
            }
            else if(position < 0){
                caretPosition = 0;
            }
            else{
                caretPosition = position;
            }
            repaint();

        return caretPosition;
    }

    public void setMaxChars(int maxChars){
        this.maxChars = maxChars;
    }

    public int getMaxChars(){
        return maxChars;
    }

    public void setMove(int keyCode, HNavigable target){
        navHelper.setMove(keyCode, target);
    }

    public HNavigable getMove(int keyCode){
        return navHelper.getMove(keyCode);
    }

    public void setFocusTraversal(HNavigable up, HNavigable down, HNavigable left, HNavigable right){
        navHelper.setFocusTraversal(up, down, left, right);
    }

    public boolean isSelected(){
        return navHelper.isSelected();
    }

    public void setGainFocusSound(HSound sound){
        navHelper.setGainFocusSound(sound);
    }

    public void setLoseFocusSound(HSound sound){
        navHelper.setLoseFocusSound(sound);
    }

    public HSound getGainFocusSound(){
        return navHelper.getGainFocusSound();
    }

    public HSound getLoseFocusSound(){
        return navHelper.getLoseFocusSound();
    }

    public void addHFocusListener(HFocusListener listener){
        navHelper.addHFocusListener(listener);
    }


    public void removeHFocusListener(HFocusListener listener){
        navHelper.removeHFocusListener(listener);
    }

    public int[] getNavigationKeys(){
        return navHelper.getNavigationKeys();
    }

    /*
     Overloaded from HVisible, is true for HNavigable
     */
    public boolean isFocusTraversable() {
        return true;
    }

    /**
     * Since the Component will not get focus unless there is
     * a FocusListener registered we "secretly" add one in the
     * helper.
     * We don't want this secret one to be returned when someone
     * asks for the FocusListener objects.
     * This mehod overrides Component.getFocusListeners()
     * and takes care of that.
     */
    public synchronized FocusListener[] getFocusListeners(){
        return navHelper.getFocusListeners();
    }


    public void processFocusEvent(FocusEvent e){
        super.processFocusEvent(e);
        HFocusEvent event = new HFocusEvent(this, e.getID());
        processHFocusEvent(event);

    }

    public void processHFocusEvent(HFocusEvent evt) {
        int state = getInteractionState();
        int newState = navHelper.getHFocusEventResult(evt);

        if(state != newState){
            setInteractionState(newState);
        }
    }


    public void addHKeyListener(HKeyListener listener){
        if (listener == null) {
            return;
        }
        hKeyListener = HEventMulticaster.add(hKeyListener, listener);
    }


    public void removeHKeyListener(HKeyListener listener){
        if (listener == null) {
            return;
        }
        hKeyListener = HEventMulticaster.remove(hKeyListener, listener);
    }

    public void addHTextListener(HTextListener listener){
        if (listener == null) {
            return;
        }
        hTextListener = HEventMulticaster.add(hTextListener, listener);
    }

    public void removeHTextListener(HTextListener listener){
        if (listener == null) {
            return;
        }
        hTextListener = HEventMulticaster.remove(hTextListener, listener);
    }

    public boolean getEditMode(){
        return edit;
    }

    public void setEditMode(boolean edit){
        this.edit = edit;
        repaint();
    }

    public int getType(){
        return this.inputType;
    }


    /**
     * Defines the set of the characters which are valid for customized keyboard input,
     * i.e. when the input type is set to HKeyboardInputPreferred.INPUT_CUSTOMIZED.
     * @param inputChars
     */
    public void setValidInput(char[] inputChars){
        this.validInputChars = inputChars;
    }

    /**
     * Retrieve the customized input character range. The return value of this method
     * should reflect the range of input keys which the component wishes to see, should
     * getType return a value with the INPUT_CUSTOMIZED bit set. This method may return
     * null if customized input is not requested.
     *
     * Specified by:
     *      getValidInput in interface HKeyboardInputPreferred
     *@return an array containing the characters which this component expects the platform to provide, or null
     */
    public char[] getValidInput(){
        return this.validInputChars;
    }

    public void processHTextEvent(HTextEvent evt){
        Object source = evt.getSource();
        switch (evt.getID()) {
            case HTextEvent.TEXT_START_CHANGE :
                /*
                 * switch into edit mode and accept key presses
                 *
                 * On entering its editable mode the component will send an HTextEvent
                 * event with an id of TEXT_START_CHANGE to all registered HTextListener listeners.
                 * The HSinglelineEntry will then respond to key events by inserting characters
                 * into the text string or positioning the insertion point (caret) via further
                 * HTextEvent events.
                 */

                this.setEditMode(true);

                HTextEvent eStart = new HTextEvent(this, HTextEvent.TEXT_START_CHANGE);
                if(hTextListener != null){
                    hTextListener.textChanged(eStart);
                }

                break;
            case HTextEvent.TEXT_END_CHANGE:
                /*
                 * On receiving an HTextEvent event with an id of TEXT_END_CHANGE the component
                 * shall leave its editable mode and send an HTextEvent event with an id of
                 * TEXT_END_CHANGE to all registered HTextListener listeners. The user can then
                 * navigate out of the HSinglelineEntry.
                 */

                this.setEditMode(false);

                HTextEvent eEnd = new HTextEvent(this, HTextEvent.TEXT_END_CHANGE);

                if(hTextListener != null){
                    hTextListener.textChanged(eEnd);
                }

                break;

            case HTextEvent.TEXT_CHANGE :
                break;

//            case HTextEvent.TEXT_CARET_CHANGE :
//                break;
//
            case HTextEvent.CARET_NEXT_CHAR :
                this.caretNextCharacter();
                break;
//
//            case HTextEvent.CARET_NEXT_LINE :
//                break;
//
//            case HTextEvent.CARET_NEXT_PAGE :
//                break;
//
            case HTextEvent.CARET_PREV_CHAR :
                this.caretPreviousCharacter();
                break;
//
//            case HTextEvent.CARET_PREV_LINE :
//                break;
//
//            case HTextEvent.CARET_PREV_PAGE :
//                break;
        }

    }

    public void processHKeyEvent(HKeyEvent evt){
        return;
    }

}

