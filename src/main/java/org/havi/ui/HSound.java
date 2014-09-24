/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/



package org.havi.ui;

import java.net.URL;

import javax.media.Controller;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.StartEvent;
import javax.media.Time;


/**
 * 
 * @author Cristian Suazo
 * @statuscode 4
 * @comment bugfixed
 *  
 */
public class HSound extends java.lang.Object{
	
	private boolean isLooping;	
	private Player player;
	
	private static net.beiker.cake.Logger logger = net.beiker.cake.Log.getLogger(HSound.class);	
	private MediaControllerListner playerListner;
	
	// Handles events that are created by the mediaplayer
	private class MediaControllerListner implements ControllerListener{		
		public void controllerUpdate(ControllerEvent event){				
			logger.debug(event.toString());			
			if (event instanceof EndOfMediaEvent){			
				// check if the sound clip should be looped
				if (isLooping){
					player.setMediaTime(new Time(0));
					player.start();
				}
				else{
					stop();					
				}
			}
			else if (event instanceof StartEvent){
				if(player.getState() == Controller.Started){
					player.setMediaTime(new Time(0));
				}
			}
			
		}
	}
	
	public HSound(){
		logger.debug("Constructor");
		isLooping = false; // used for when the method loop() is called.		
		
		// create listner for the player
		playerListner = new MediaControllerListner();		
	}

	public void load(String location) throws java.io.IOException, java.lang.SecurityException{
		load(new URL(location));
	}
	
	// SecurityException has not been implemented.
	public void load(java.net.URL contents) throws java.io.IOException, java.lang.SecurityException{
		dispose();
		// create the new player 
		try{
			player = Manager.createPlayer(contents);    		
		}
		catch(NoPlayerException e){
			logger.debug(e.getMessage());
			e.printStackTrace();
		}
		player.addControllerListener(playerListner);
	}
	
	public void set(byte data[]){
		logger.info("Has no implementation, so calling this will not do anything." );
	}

	public void play(){
		this.isLooping = false;
		if (player != null){    		    		        	   
			player.start();	
		}    	   
	}

	public void stop(){    	
		if (player != null){    		
			player.stop();
			player.deallocate();        	
		}    	
	}       

	public void loop(){
		this.isLooping = true;
		if (player != null){    		    		        	   
			player.start();	
		}
	}

	public void dispose(){
		logger.debug("dispose");
		if (player != null){
			player.removeControllerListener(playerListner);
			player.stop();
			player.close();
			player.deallocate();	
		} 
	}
	
}
