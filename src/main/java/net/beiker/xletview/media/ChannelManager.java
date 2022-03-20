/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Sveden

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/
package net.beiker.xletview.media;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import net.beiker.xletview.util.Settings;
import net.beiker.xletview.util.Util;
import net.n3.nanoxml.IXMLElement;
import net.n3.nanoxml.IXMLParser;
import net.n3.nanoxml.IXMLReader;
import net.n3.nanoxml.StdXMLReader;
import net.n3.nanoxml.XMLParserFactory;

/**
 * @author Martin Sveden
 */
public class ChannelManager {

    private static final Logger log = Logger.getLogger(ChannelManager.class.getName());

    private static ChannelManager THE_INSTANCE;

    private int currentChannelNumber;
    private List<Channel> channels;

    private ChannelManager(){
        this.channels = new ArrayList<>();

        parse();

        // if there is no channels, add the default one
        if(this.channels.size() == 0){
            //Media media = new Media(Util.getURLConnection(ChannelManager.class, Settings.getProperty("file.defaultbg")) );

            Media media;
            try {
                media = new Media(Util.getURL(ChannelManager.class, Settings.getProperty("file.defaultbg")));
                Channel channel = new Channel("XleTView Channel", media);
                this.channels.add(channel);
            }
            catch (RuntimeException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        this.currentChannelNumber = 0;
    }

    public static ChannelManager getInstance(){
        if(THE_INSTANCE == null){
            THE_INSTANCE = new ChannelManager();
        }
        return THE_INSTANCE;
    }

    public void setChannel(int channel){
        // check if it is a valid channel number
        if(isValidNumber(channel)){
            log.fine("current channel is now " + ((Channel)this.channels.get(channel)).getName());
            this.currentChannelNumber = channel;
            Media media = ((Channel)this.channels.get(channel)).getMedia();
            MediaPlayer.getInstance().setMedia(media);
        }
        else{
            log.fine("not a valid channel number");
        }
    }

    public void nextChannel(){
        this.currentChannelNumber++;
        if(this.currentChannelNumber == this.channels.size()){
            this.currentChannelNumber = 0;
        }
        setChannel(this.currentChannelNumber);
    }

    public void previousChannel(){
        this.currentChannelNumber--;
        if(this.currentChannelNumber < 0){
            this.currentChannelNumber = this.channels.size() - 1;
        }
        setChannel(this.currentChannelNumber);
    }

    /*
     * / checks if it is a valid channel number
     */
    private boolean isValidNumber(int i){
        boolean result = false;
        if(i > -1 && i < this.channels.size()){
            result = true;
        }
        return result;
    }

    public int getCurrentChannel(){
        return this.currentChannelNumber;
    }

    /**
     * @return a list of avaliable channels, convenient for debugging
     */
    public String getChannelList(){
        String s = "";
        for(int i = 0; i < this.channels.size(); i++){
            Channel ch = (Channel) this.channels.get(i);
            s += "name=" + ch.getName() + ", media=" + ch.getMedia();
        }
        if(s.length() == 0){
            s = "no channels avaliable";
        }
        return s;
    }

    public void parse(){
        IXMLElement xml = null;
        try{
            IXMLParser parser = XMLParserFactory.createDefaultXMLParser();
            InputStream in = Util.getURLConnection(ChannelManager.class, "config/channels.xml").getInputStream();
            IXMLReader reader = new StdXMLReader(in);
            parser.setReader(reader);
            xml = (IXMLElement) parser.parse();

            List<?> v = xml.getChildren();
            for(int i = 0; i < v.size(); i++){
                IXMLElement element = (IXMLElement) v.get(i);
                String name = "";
                String path = "";
                try {
                    name = ((IXMLElement) element.getChildrenNamed("NAME").get(0)).getContent();
                    path = ((IXMLElement) element.getChildrenNamed("MEDIA").get(0)).getContent();

                    if(name != null && path != null && name.length() > 0 && path.length() > 0){
                        Media media = new Media(path);
                        Channel channel = new Channel(name, media);
                        this.channels.add(channel);
                    }

                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                log.fine(element.getName());
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
