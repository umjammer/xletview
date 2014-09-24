/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Sveden
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.event ;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import net.beiker.xletview.xlet.XletManager;

import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceServer;
import org.davic.resources.ResourceStatusEvent;
import org.davic.resources.ResourceStatusListener;
import org.havi.ui.HScene;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 4
 */
public class EventManager implements ResourceServer{

    private static EventManager THE_INSTANCE;
    
    private Vector listenerObjects;
    private Vector awtListenerObjects;
    private Vector resourceStatusListeners;
        
	private EventManager(){
        listenerObjects = new Vector();
        awtListenerObjects = new Vector();
        resourceStatusListeners = new Vector();
       	
	}

    public static EventManager getInstance () {
        if(THE_INSTANCE == null){
            THE_INSTANCE = new EventManager();
        }	
        return THE_INSTANCE;
    }

	public boolean addUserEventListener(UserEventListener listener, ResourceClient client, UserEventRepository userEvents)
    throws IllegalArgumentException{ 
        if(client == null){
        	throw new IllegalArgumentException("ResourceClient was null");
        }
	
        listenerObjects.add(new ListenerItem(listener, userEvents.getUserEvent(), client));
        fireResourceStatusEvent();
        return true;
    }
   
    public void addUserEventListener(UserEventListener listener, UserEventRepository userEvents) {
        listenerObjects.add(new ListenerItem(listener, userEvents.getUserEvent()));
    }
    
    /**
     * Removes all listeners. Not in the spec but used
     * by XleTView to not keep listeners from destroyed
     * Xlets. Quick and dirty solution for now.
     *
     */
    public void removeAllUserEventListeners(){
    	listenerObjects.clear();
    }
    
    public boolean addExclusiveAccessToAWTEvent (ResourceClient client, UserEventRepository userEvents)  
    throws java.lang.IllegalArgumentException{
        if(client == null){
            throw new IllegalArgumentException("ResourceClient was null");            
        }
        
        awtListenerObjects.add(new AwtListenerItem(client, userEvents.getUserEvent()));
        
        fireResourceStatusEvent();

        return true;
    }
    
    public void removeUserEventListener(UserEventListener listener){
        for(int i = 0; i <listenerObjects.size(); i++){
            ListenerItem li = (ListenerItem) listenerObjects.get(i);
            UserEventListener ul = li.getListener();
            if(ul == listener){
                listenerObjects.remove(i);
            }
        }
    }
   
    public void removeExclusiveAccessToAWTEvent(ResourceClient client) {
        for(int i = 0; i < awtListenerObjects.size(); i++){
            AwtListenerItem li = (AwtListenerItem) listenerObjects.get(i);
            ResourceClient rc = li.getResourceClient();
            if(rc == client){
                awtListenerObjects.remove(i);
                fireResourceStatusEvent();
            }
        }   	   
    }
   	
    public void addResourceStatusEventListener(ResourceStatusListener listener) {
    	if(!resourceStatusListeners.contains(listener)){
			resourceStatusListeners.add(listener);		
    	}
    }

    public void removeResourceStatusEventListener(ResourceStatusListener listener) {
		resourceStatusListeners.remove(listener);
    }



    /**
     * All key events are passed to this method that fires them 
     * @param source
     * @param keyEvent
     */
    public void fireUserEvent(Object source, KeyEvent keyEvent){
        Component focusOwner = null;
        int keyCode = keyEvent.getKeyCode(); 
        char keyChar = keyEvent.getKeyChar();

        // user event
        for(int i = listenerObjects.size()-1; i > -1; i--){
        	ListenerItem li = (ListenerItem) listenerObjects.get(i);
        	UserEvent[] userEvents = li.getEvents();
        	for(int k = 0; k < userEvents.length; k++){
        		if(userEvents[k].getCode() == keyCode){
        			UserEvent ue = new UserEvent(source, UserEvent.UEF_KEY_EVENT, keyEvent.getID(), keyCode, -1, System.currentTimeMillis());
        			li.getListener().userEventReceived(ue);
        		}
        	}
        }
        
        HScene scene = XletManager.getInstance().getScene();        
        
        if(scene != null){
            focusOwner = scene.getFocusOwner();
        }
        if(focusOwner != null){
            //Debug.write(this, "focusOwner = " + focusOwner);
            
           
            // awt event
            KeyListener[] kl = focusOwner.getKeyListeners();
            for(int i = 0; i < kl.length; i++){
                if(keyEvent.getID() == KeyEvent.KEY_PRESSED){
                    kl[i].keyPressed(new KeyEvent(focusOwner,KeyEvent.KEY_PRESSED, 0L, 0, keyCode, keyChar));
                }
                else if(keyEvent.getID() == KeyEvent.KEY_RELEASED){
                    kl[i].keyReleased(new KeyEvent(focusOwner,KeyEvent.KEY_RELEASED, 0L, 0, keyCode, keyChar));
                }
                 
                 
            }
        }
        else{
            //Debug.write(this, "focus owner is null");
        }
    }

    /* Fired when there is a change in resouce clients */
	private void fireResourceStatusEvent(){
		for(int i = 0; i < resourceStatusListeners.size(); i++){
			ResourceStatusListener listener = (ResourceStatusListener) resourceStatusListeners.get(i);
			listener.statusChanged(new ResourceStatusEvent(this));
		}
	}
	
    
    /*
     * Class that makes it easier to handle the listener/events-from-repository
     * 
     * */
    private class ListenerItem{
        private UserEventListener listener;
        private UserEvent[] events;
        private ResourceClient client;

        private ListenerItem(UserEventListener listener, UserEvent[] events, ResourceClient client){
            this(listener, events);
            this.client = client;
        }

        private ListenerItem(UserEventListener listener, UserEvent[] events){
            this.listener = listener;
            this.events = events;
//            Debug.write(this, "events.length = " + events.length);
        }
        
        private UserEventListener getListener(){
            return listener;
        }
        
        private UserEvent[] getEvents(){
            return events;
        }    
        
        private ResourceClient getClient(){
            return client;
        }    
    }
    
    private class AwtListenerItem{
        private ResourceClient resourceClient;
        private UserEvent[] events;
        
        private AwtListenerItem(ResourceClient resourceClient, UserEvent[] events){
            this.resourceClient = resourceClient;
            this.events = events;
        }   
        
        private ResourceClient getResourceClient(){
            return resourceClient;
        }
        
        private UserEvent[] getEvents(){
            return events;
        }
    }
    
    
//	public void toString(){
//		String s = "" +
//		"EventManager: UserEventListeners=" + u
//	}


}



