/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Sveden

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package net.beiker.xletview.event;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.event.AWTEventListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;

import org.havi.ui.HActionable;
import org.havi.ui.HNavigable;
import org.havi.ui.event.HActionEvent;
import org.havi.ui.event.HFocusEvent;
import org.havi.ui.event.HRcEvent;

import net.beiker.xletview.media.ChannelManager;
import net.beiker.xletview.media.ScreenContainer;
import net.beiker.xletview.remotecontrol.RemoteControl;
import net.beiker.xletview.util.Util;
import net.beiker.xletview.xlet.XletManager;


/**
 *
 * @author Martin Sveden
 */
public class EventManager implements AWTEventListener{

    private static final Logger log = Logger.getLogger(EventManager.class.getName());

    private static EventManager THE_INSTANCE;
    private boolean eventEnabled;
    private Component focusOwner;


//    private KeyboardFocusManager kfm;

    /**
     *
     */
    public static EventManager getInstance() {
        if (THE_INSTANCE == null) {
            THE_INSTANCE = new EventManager();
        }
        return THE_INSTANCE;
    }

    /**
     *
     */
    private EventManager() {
//        kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();

    }

    /**
     * Returns a new key code that is mapped with the
     * incoming or the same as the incoming if it
     * was not mapped.
     * @param incoming The key code to convert
     * @return a key code
     */
    public int convertCode(int incoming){
        int outgoing;
        switch(incoming){
            case 112: // F1
                outgoing = 403;
            break;
            case 113: // F1
                outgoing = 404;
            break;
            case 114: // F1
                outgoing = 405;
            break;
            case 115: // F1
                outgoing = 406;
            break;
            default:
                outgoing = incoming;
        }
        return outgoing;
    }

    /**
     *
     * 1. Passes event to org.dvb.event.EventManager that is in charge of processing
     *    all java.awt.KeyEvent and org.dvb.event.UserEvent
     *
     * 2. Fires HFocusEvent
     *
     * 3. Handles emulator specific events from the "remote control" or other
     *    input devices such as keyboard or mouse etc.
     */
    public void fireEvents(KeyEvent event) {
        if(event != null){

            // first trigger UserEvent and java.awt.KeyEvent
            org.dvb.event.EventManager.getInstance().fireUserEvent(event.getSource(), event);

            int keyCode = event.getKeyCode();

            // do HFocusEvent
            if(focusOwner != null && focusOwner instanceof HNavigable  && event.getID() == KeyEvent.KEY_PRESSED){
                //logger.fine("focusOwner=" + focusOwner);
                HNavigable nav = (HNavigable) focusOwner;


                HNavigable transferTo = nav.getMove(keyCode);
                HFocusEvent hEvent = null;
                if(transferTo != null){
                    hEvent = new HFocusEvent(focusOwner, HFocusEvent.FOCUS_TRANSFER, keyCode);
                }
                else{
                    hEvent = new HFocusEvent(focusOwner, HFocusEvent.FOCUS_TRANSFER, HFocusEvent.NO_TRANSFER_ID);
                }
                //Debug.write(this, "hEvent=" + hEvent);

                nav.processHFocusEvent(hEvent);
//                Debug.write(this, "is HIcon? " + (focusOwner instanceof HIcon) + ", nav=" + nav);

                if(focusOwner instanceof HActionable){
                    HActionable act = (HActionable) focusOwner;
                    HActionEvent haEvent = new HActionEvent(act, HActionEvent.ACTION_PERFORMED, act.getActionCommand());
                    act.processHActionEvent(haEvent);
                }

            }


            // do emulator specific stuff
            if(event.getID() == KeyEvent.KEY_PRESSED){

                RemoteControl.getInstance().setPressed(keyCode);

                if(keyCode == HRcEvent.VK_CHANNEL_UP){
                    log.fine("channel up");
                    ChannelManager.getInstance().nextChannel();
                }
                else if(keyCode == HRcEvent.VK_CHANNEL_DOWN){
                    log.fine("channel down");
                    ChannelManager.getInstance().previousChannel();
                }
                else if(event.getModifiers() == HRcEvent.CTRL_MASK && keyCode == HRcEvent.VK_R){
                    XletManager.getInstance().reloadActiveXlet();
                }
                else if(event.getModifiers() == HRcEvent.ALT_MASK && keyCode == HRcEvent.VK_F4){
                    System.exit(0);
                }

            }
            else if(event.getID() == KeyEvent.KEY_RELEASED){

                RemoteControl.getInstance().setReleased(keyCode);
            }

        }
    }

    public void fireRemoteEvent(KeyEvent event){
        if(focusOwner != null){
            //Debug.write(this, "keyCode:" + keyCode + ", focusOwner:" + focusOwner.getClass().getName());
            fireEvents(new KeyEvent(focusOwner,event.getID(), 0L, 0, event.getKeyCode(), event.getKeyChar()));
        }
        else{
            fireEvents(event);
        }
    }

    /**
     * Sets the current focus owner in the screen.
     */
    private void setFocusOwner(Component c){
        /*
         * The focus owner has to be a child of the "tv screen".
         */
        boolean ok = Util.isChildOf(ScreenContainer.getInstance(), c);
        if(ok){
            log.fine("new focus owner: " + c.toString());
            focusOwner = c;
        }
    }

    public Component getFocusOwner(){
        return focusOwner;
    }

    public boolean isEventEnabled() {
        return eventEnabled;
    }

    public void setEventEnabled(boolean b) {
        eventEnabled = b;
    }

    public void eventDispatched(AWTEvent e) {

        //Component fo = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();

        //Debug.write(this, "fo=" + fo);
        Object source = e.getSource();





        if (e instanceof KeyEvent) {
            KeyEvent ke = (KeyEvent) e;

            int keyCode = ke.getKeyCode();

            int newKeyCode = convertCode(keyCode);
            ke.setKeyCode(newKeyCode);


            // consume if it's the focus owner
            if(source == focusOwner){
                ke.consume();
            }

            fireEvents(ke);

        }
        if (e instanceof FocusEvent) {
            //Debug.write(this, "event=" + e);
            //Debug.write(this, "eventDispatched-" + e);
            FocusEvent fe = (FocusEvent) e;
            Component c = fe.getComponent();

            if(fe.getID() == FocusEvent.FOCUS_GAINED && c != null){
                setFocusOwner(c);
            }
        }

    }

}
