/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Sveden
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package net.beiker.xletview.media;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import net.beiker.cake.Log;
import net.beiker.cake.Logger;

/**
 * Media that can be "played" as video, like a video file or an image
 * @author Martin Sveden
 */
public class Media {
	
	/** Debugging facility */
	private final static Logger logger = Log.getLogger(Media.class);
	
    public static final int TYPE_VIDEO = 0;
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_INVALID = 2;
        
    //private String path;
    private URL media;
    private int type;
    
    private String[] validImageTypes = {".jpg"};
    private String[] validVideoTypes = {".avi", ".mov"};
    
    public Media(String path){
        try {
			//this.path = path;
			this.media = new URL("file:"+path);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        this.type = resolveType(path);
    }
    
    /**
	 * @param inputStream
	 */
	public Media(URL url) {	
		
		this.media = url;
		this.type = resolveType(url);		
	}

	/**
	 * @param connection
	 * @return
	 */
	private int resolveType(URL url) {
		String type = "application/octet-stream";
		try{
			type = url.openConnection().getContentType();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
		if (type.substring(0, 5).equals("image")){
			return TYPE_IMAGE;
		}
		else if (type.substring(0, 5).equals("video")){
			return TYPE_VIDEO;
		}
		else {
			logger.warn("Could not understand content type '"+type+"'.\nWARNING: 'invalid' CONTENT TYPE RETURNED.");			
			// TODO: This is fake.
			return TYPE_INVALID;
		}		
	}

	/**
     * Resolves if the media type is video or image
     */
    private int resolveType(String path){
        String s = path.toLowerCase();
//        if (s.indexOf(filters[i]) == s.length() - filters[i].length()) {
        for(int i = 0; i < this.validImageTypes.length; i++){
            if (s.indexOf(this.validImageTypes[i]) == s.length() - this.validImageTypes[i].length()) {
                return TYPE_IMAGE;
            }
        }
        for(int i = 0; i < this.validVideoTypes.length; i++){
            if (s.indexOf(this.validVideoTypes[i]) == s.length() - this.validVideoTypes[i].length()) {
                return TYPE_VIDEO;
            }
        }
        return TYPE_INVALID;
    }
    
    //public String getPath(){
    //    return this.path;
    //}
    
    public int getType(){
        return this.type;        
    }
    
    public String toString(){
        return "[Media] type=" + this.type + ", media InputStream=" + this.media;
    }

	/**
	 * @return
	 */
	public URL getURL() {
		return this.media;
	}
}
