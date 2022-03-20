/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Sveden

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package net.beiker.xletview.window;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

import net.beiker.xletview.ui.Img;
import net.beiker.xletview.util.Constants;
/**
 * @author Martin Sveden
 */
public class SplashWindow extends JWindow implements Runnable{

    /** Debugging facility. */
    private static final Logger logger = Logger.getLogger(SplashWindow.class.getName());

    private JLabel label;
    private ImageIcon icon;
    private static boolean doRun;
    private int maxWait = 2400000;
    private long start;
    private long end;
    private String message;
    private static boolean success;


    public void showSplash(){
        new SplashWindow();
    }

    public void hideSplash(){
        dispose();
        success = true;
    }

    public SplashWindow() {
        Img img = new Img(Constants.IMAGE_SPLASH);

        setBackground(Color.white);
        getContentPane().add(img);

        setSize(237, 175);
        setLocationRelativeTo(null);
        new Thread(this).start();
    }

    public void setMessage(String s){
        this.message = s;
        repaint();
    }

    public void paint(Graphics g){
        super.paint(g);
        if(this.message != null){
            g.drawString(this.message, 10, 20);
        }
    }

    public void run() {
        try {
            Thread.sleep(this.maxWait);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(!success){
            logger.severe("The program failed to start after " + this.maxWait + " ms and will now exit");
            System.exit(0);
        }
    }
}