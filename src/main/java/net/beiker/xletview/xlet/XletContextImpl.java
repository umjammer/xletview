/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package net.beiker.xletview.xlet;


import net.beiker.xletview.media.ScreenContainer;
import xjava.io.EmulatorFile;
import xjavax.tv.service.selection.ServiceContextImpl;
import xjavax.tv.xlet.Xlet;
import xjavax.tv.xlet.XletContext;

public class XletContextImpl implements XletContext{
	
	/**
	 * Debugging
	 */	
	private static final net.beiker.cake.Logger log = net.beiker.cake.Log.getLogger(XletContextImpl.class);
	
	// javaTV
	public static final String CONTAINER = "javax.tv.xlet.container";
	public static final String SERVICE_CONTEXT = "javax.tv.xlet.service_context";
	
	// xletview specific
	
//	public static final String ROOT_CONTAINER = "javax.tv.xlet.root_container";
	public static final String APP_DIR         = "app.dir";
	
	// spec 11.7
	private static final String PROPERTY_ORG_ID = "dvb.org.id";
	private static final String PROPERTY_APP_ID = "dvb.app.id";
	private static final String PROPERTY_CALLER_PARAMS = "dvb.caller.parameters";

    public static final int INITIALIZED = 0;
    public static final int ACTIVE     = 2;
    public static final int PAUSED      = 3;
    public static final int DESTROYED   = -1;
    private int state;
    
    private XletManager manager;
    private Xlet xlet;
    private ClassLoader classLoader;
    
    private EmulatorFile applicationDirectory;
    
    /*
     * The array of strings returned by XletContext.getXletProperty(XletContext.ARGS) shall be the array of
     * strings de?ned in the DVB-J application descriptor (see 10.9.1 on page 95) in the same order as speci?ed in the
     * signalling. Each entry in the loop of that descriptor shall be presented as one string in the array returned by this method,
     * interpreted using the encoding as speci?ed in 10.4.8, "Text encoding in AIT" on page 80. Zero-length strings in the
     * signalling shall be represented as the empty string.
     */
    private String[] xletArgs = new String[0];
    
    /* 
     * The "dvb.caller.parameters" XletProperty contains the array of Strings that was passed into the AppProxy.
     * start(String[]) method by the application that started this application. If this application was started by the
     * system or by another application using the AppProxy.start() method without parameters, an empty array with
     * length 0 is returned as the value of this XletProperty.
     */
    private String[] callerArgs = new String[0];

    public XletContextImpl(XletManager manager, Xlet xlet, EmulatorFile appDir){
        this.manager = manager;
        this.xlet    = xlet;              
        this.applicationDirectory = appDir;
    }
    


    /* (non-Javadoc)
     * @see xjavax.tv.xlet.XletContext#getXletProperty(java.lang.String)
     */
    public Object getXletProperty(String key){
        log.debug("getXletProperty(" + key + ")");
        if(key.equals(XletContext.ARGS)){
        	return xletArgs;        	
        }
        else if(key.equals(PROPERTY_CALLER_PARAMS)){
        	return callerArgs;
        }
        else if(key.equals(CONTAINER)){
            return ScreenContainer.getInstance().getXletContainer();
        }
        else if(key.equals(SERVICE_CONTEXT)){
            return ServiceContextImpl.getInstance();
        }
        else if(key.equals(APP_DIR)){
        	return applicationDirectory;
        }
        else if(key.equals(PROPERTY_APP_ID)){
        	log.debug("NOT IMPLEMENTED - RETURNING '0' AS APP_ID STRING.");
        	return "0";
        }
        else if(key.equals(PROPERTY_ORG_ID)){
        	log.debug("NOT IMPLEMENTED - RETURNING '0' AS ORG_ID STRING.");
        	return "0";
        }
        else{
        	log.debug("getXletProperty() for a key '"+key+"' that is unknown. Returning null.");
            return null;
        }
    }

    /* (non-Javadoc)
     * @see xjavax.tv.xlet.XletContext#notifyDestroyed()
     */
    public void notifyDestroyed(){
        setState(DESTROYED);
        manager.notifyDestroyed(this);
    }
    
    /* (non-Javadoc)
     * @see xjavax.tv.xlet.XletContext#notifyPaused()
     */
    public void notifyPaused(){
        setState(PAUSED);
        manager.notifyPaused(this);
    }
    
    /* (non-Javadoc)
     * @see xjavax.tv.xlet.XletContext#resumeRequest()
     */
    public void resumeRequest(){
        manager.resumeRequest(this);
    }
    
    int getState() {
        return state;
    }

    void setState(int state) {
        this.state = state;
    }
    
    Xlet getXlet(){
    	log.debug("xlet=" + xlet);
        return xlet;
    }
    

}
