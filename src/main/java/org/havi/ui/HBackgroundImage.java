/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

import java.awt.Component;
import java.awt.Image;
import java.awt.MediaTracker;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import net.beiker.xletview.media.IframeDecoder;

import org.havi.ui.event.HBackgroundImageListener;

/**
 * 
 * 
 * @author Martin Sveden
 * @statuscode 2
 * @comment not quite finished
 */
public class HBackgroundImage extends Component{

	private static final net.beiker.cake.Logger log = net.beiker.cake.Log.getLogger(HBackgroundImage.class);
	
    private Image image;
    private int width;
    private int height;

    private static final IframeDecoder decoder = new IframeDecoder();
    
	public HBackgroundImage(String filename){
        
//        if(filename.indexOf(".mpg") > -1){
//            log.info("Display of .mpg is not yet supported.\n" +
//                "A workaround for now is to use a .jpg with the same name.");
//            filename = filename.substring(0, filename.length() - 4) + ".jpg";
//        }
//		image = loadImage(filename, null, this);
		
		log.debug(filename);  

		IframeDecoder decoder = new IframeDecoder();
        
        xjava.io.XFile virtualFile = new xjava.io.XFile(filename);
        File iframeFile = null;
        
        try {
        	iframeFile = xjava.io.FileSystem.getFile(virtualFile);
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        }

        decoder.decodeFile(iframeFile);

        image = decoder.getImage();
        
        net.beiker.xletview.media.BackgroundLayer bl = net.beiker.xletview.media.BackgroundLayer.getInstance();
        bl.setBgImage(image);
        bl.repaint();

	}

	public HBackgroundImage(byte pixels[]){
	}

	public HBackgroundImage(URL contents){
	}

	public void load(HBackgroundImageListener hbackgroundimagelistener){
	}

	public int getHeight(){
		return super.getHeight();
	}

	public int getWidth(){
		return super.getWidth();
	}

	public void flush(){
	}
    
    private Image loadImage(String name, URL url, Component component){
        MediaTracker mediatracker = new MediaTracker(component);
        xjava.awt.Toolkit toolkit = xjava.awt.Toolkit.getDefaultToolkit();
        Image image = null;
        if(name != null){
            
            // to see if the path is correct
            try{
                xjava.io.XFile f = new xjava.io.XFile(name);
                xjava.io.FileReader fr = new xjava.io.FileReader(f);
                image = toolkit.getImage(name);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(url != null){
            image = toolkit.getImage(url);
        }

        mediatracker.addImage(image, 0);
        try{
            mediatracker.waitForID(0);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return image;
    }    

    public void setBounds(HScreenRectangle r){
        int x = (int) r.x;
        int y = (int) r.y;
        int width = (int) r.width;
        int height = (int) r.height;
        super.setBounds(x, y, width, height);
    }

//    public void paint(Graphics g){        
//        if(image != null){
//            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
//        }
//        
//    }
    
}
