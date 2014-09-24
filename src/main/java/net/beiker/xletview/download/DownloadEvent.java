/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Sveden
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package net.beiker.xletview.download;

/**
 * 
 * @author Martin Sveden
 */
public class DownloadEvent {

    private Downloader dwnLoader;
    private int procentLoaded;
    private String fileName;
    
    public DownloadEvent(Downloader dwnLoader, int procent, String fileName){
        this.dwnLoader = dwnLoader;
        this.procentLoaded = procent;
        this.fileName = fileName;
    }
    
    public Downloader getDownloader(){
        return dwnLoader;
    }
    
    public int getProcent(){
        return procentLoaded;
    }
    
    public String getFileName(){
        return fileName;
    }
    
}
