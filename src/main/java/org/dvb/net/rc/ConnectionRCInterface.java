/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Svedén

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.


*/

package org.dvb.net.rc;

import java.io.IOException;
import java.util.Vector;

import net.beiker.cake.Log;
import net.beiker.cake.Logger;

import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;

/**
 * 
 *
 * @version  7.11.03
 * @author 	 Bengt Skogvall
 * @author Martin Sveden
 * @statuscode 4
 */
public class ConnectionRCInterface extends RCInterface implements ResourceProxy, Runnable{

	/** Debugging facility. */
	private final static Logger logger = Log.getLogger(ConnectionRCInterface.class);
	
    private boolean connected;
    private Vector listenerObjects;
    private static final ConnectionParameters defaultTarget;
    private ConnectionParameters currentTarget;
    private ResourceClient resourceClient; //only one client...
    private long starttime;
    
    /** To fake the time it takes to make a connection with a modem */
    public static int FAKED_CONNECION_TIME = 1000;

    static{
    	defaultTarget = new ConnectionParameters("12345", "user", "pw");
    }
    
    protected ConnectionRCInterface() {
        this.connected = false;
        this.listenerObjects = new Vector();
        this.currentTarget = defaultTarget;
    }

    public boolean isConnected() {
        return this.connected;
    }

    public float getSetupTimeEstimate() {
        return 10.0f; //immediate connection
    }

    public void reserve(ResourceClient c, Object requestData) throws PermissionDeniedException {
        if (this.resourceClient == null) {
            this.resourceClient = c;
            RCInterfaceManager.getInstance().fireResorceStatusChanged(new RCInterfaceReservedEvent(this));
        }
        else{
        	boolean releaseOk = this.resourceClient.requestRelease(this, null);
        	/*
        	 * We don't really care about if the ResourceClient
        	 * wants to give up the resource or not, if another
        	 * ResourceClient needs it we give it to that one 
        	 * instead.
        	 */
        	
        	// tell the ResourceClient that it's about to lose the resource
        	this.resourceClient.release(this);
        	
        	// tell the ResourceClient that it has lost the resource
        	this.resourceClient.notifyRelease(this);
        	
        	// give the resource to the new ResourceClient
        	this.resourceClient = c;
        }
        /*
        // not used since we always give permission
        else {
            throw new PermissionDeniedException("ConnectionRCInterface already reserved");
        }
        */
    }

    public void release() {    	
    	if(this.resourceClient != null){
    		this.resourceClient = null;        
    		RCInterfaceManager.getInstance().fireResorceStatusChanged(new RCInterfaceReleasedEvent(this));
    	}
    }

    public void connect() throws IOException, PermissionDeniedException {
        Thread th = new Thread(this);
        th.start();
    }

    public void disconnect() throws PermissionDeniedException {
        if(this.connected){
        	this.connected = false;
        	fireConnectionEvent(new ConnectionTerminatedEvent(this));
        }
        else{
        	logger.warn("ConnectionRCInterface: was not connected");
        }
    }

    /**
     * Get the current target for connections. 
     *
     * @return the current set of connection target parameters
     * @throws IncompleteTargetException if the current target is not completely configured
     * @throws SecurityException if the application is not allowed to read the current target
     * as defined by the security policy of the platform
     */
    public ConnectionParameters getCurrentTarget() throws IncompleteTargetException {
        return this.currentTarget;
    }

    public void setTarget(ConnectionParameters target) throws IncompleteTargetException, PermissionDeniedException {
        if (target.getTarget() == null || target.getUsername() == null || target.getPassword() == null) {
            throw new IncompleteTargetException("Incomplete Target");
        }
        this.currentTarget = target;
    }

    /**
     * Set the target for connections to the default. 
     *
     * @throws PermissionDeniedException if this application does not own the resource
     * @throws SecurityException if the application is not allowed to connect to the default target
     */
    public void setTargetToDefault() throws PermissionDeniedException {
    	this.currentTarget = defaultTarget;
    }

    public int getConnectedTime() {
        if (this.connected) {
            return (int) (System.currentTimeMillis() - this.starttime) / 1000;
        }
        else
            return -1;
    }

    public ResourceClient getClient() {
        return this.resourceClient;
    }

    public void addConnectionListener(ConnectionListener l) {
        if (!this.listenerObjects.contains(l)) {
            this.listenerObjects.add(l);
        }
    }

    public void removeConnectionListener(ConnectionListener l) {
        this.listenerObjects.remove(l);
    }

    private void fireConnectionEvent(ConnectionRCEvent e) {
        // backwards so we get the last added
        for (int i = this.listenerObjects.size() - 1; i > -1; i--) {
            ConnectionListener ali = (ConnectionListener) this.listenerObjects.get(i);
            ali.connectionChanged(e);
        }
    }

    public void run() {
        try {
            Thread.sleep(FAKED_CONNECION_TIME);
        }
        catch (InterruptedException ex) {
            logger.warn("XleTView: Exception in Timer Thread");            
            ex.printStackTrace();
        }
        this.starttime = System.currentTimeMillis();
        this.connected = true;
        fireConnectionEvent(new ConnectionEstablishedEvent(this));
    }

}
