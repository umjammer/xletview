/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package net.beiker.xletview.media;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.RealizeCompleteEvent;
import javax.media.Time;
import javax.swing.JFrame;

import net.beiker.cake.Log;
import net.beiker.cake.Logger;
import net.beiker.xletview.ui.XContainer;

public class VideoPlayer extends JFrame implements ControllerListener{
    
	/** Debugging facility. */
	private static final Logger logger = Log.getLogger(VideoPlayer.class);
	
	private static int count;
    public static final int WIDTH = 720;
    public static final int HEIGHT = 576;
    public static final char FS = File.separatorChar;

    private Player player;
    private Container cont;
    private XContainer cont2;
    private XContainer xcont;
    
    public VideoPlayer(){
        this.setTitle("VideoPlayer");
        this.cont = getContentPane();
        logger.debug(this.toString() + this.cont.getClass().getName());
        this.xcont = new XContainer();
        this.cont2 = new XContainer();
        this.cont2.setLayout(new BorderLayout());
        this.cont2.setBounds(0,0,400,400);
        this.setContentPane(this.cont2);
        
        createPlayer();
        if(this.player != null){
            this.player.realize();
            this.player.start();
        }
        else{
            logger.warn(this+toString() + "player is null");
        }
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
            public void windowDeactivated(WindowEvent we) {
            }
            public void windowGainedFocus(WindowEvent e) {
            }
        });
        setSize(400,400);
        show();
    }

    public void createPlayer() {
        String fileName = "file:///C:/myDocs/dev/java/myriam.avi";
        MediaLocator mediaLocator = null;

        try {
            mediaLocator = new MediaLocator(fileName);
            Manager.setHint(Manager.LIGHTWEIGHT_RENDERER, new Boolean(true));
            this.player = Manager.createPlayer(mediaLocator);
            this.player.addControllerListener(this);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

   public synchronized void controllerUpdate(ControllerEvent event) {
      logger.debug(this+toString() + "event = " + event);
      if (event instanceof RealizeCompleteEvent) {
         Component comp;
         if ((comp = this.player.getVisualComponent()) != null){

//             JPanel jp = new JPanel();
//             jp.setBounds(20, 40, 10, 10);
//             jp.setBackground(Color.cyan);
//             this.add(jp);
//             this.repaint();

            //Debug.write(this, "**** " + comp.getClass().getName());
            comp.setBounds(0,0,this.getSize().width, this.getSize().height);
            this.cont2.add(comp);
            logger.debug(this + "RealizeCompleteEvent");

         }
         validate();
      }
      else if (event instanceof EndOfMediaEvent){
        // We've reached the end of the media; rewind and
        // start over
        this.player.setMediaTime(new Time(0));
        this.player.start();
        logger.debug(this.toString() + "count = " + (count++));
      }
   }
   
   public static void main(String[] args){
       new VideoPlayer();
   }
}
