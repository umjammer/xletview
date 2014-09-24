/*
 This file is part of XleTView
 Copyright (C) 2003 Martin Svedén
 This is free software, and you are
 welcome to redistribute it under
 certain conditions;
 See LICENSE document for details.


 */

package org.dvb.net.rc;

import java.net.InetAddress;
import java.net.Socket;
import java.net.URLConnection;
import java.util.Vector;

import net.beiker.cake.Log;
import net.beiker.cake.Logger;

import org.davic.resources.ResourceStatusEvent;
import org.davic.resources.ResourceStatusListener;

/**
 * 
 *
 * @version  7.11.03
 * @author 	 Bengt Skogvall
 * @statuscode 4
 */
public class RCInterfaceManager implements org.davic.resources.ResourceServer {

	/** Debugging facility. */
	private static final Logger logger = Log.getLogger(RCInterfaceManager.class); 
	
    private static RCInterfaceManager THE_INSTANCE;
    private RCInterface[] rcInterfaces;
    private Vector resourceStatusEventObjects;

    private RCInterfaceManager() {
        System.out.println("XleTView: instanciate RCInterfaceManager");
        
        /*
         * One interface for every kind to not break
         * any box specific Xlet code.
         */
        
        this.rcInterfaces = new RCInterface[7];
        this.rcInterfaces[0] = new ConnectionRCInterface();
        this.rcInterfaces[0].setType(RCInterface.TYPE_PSTN);
        this.rcInterfaces[1] = new ConnectionRCInterface();
        this.rcInterfaces[1].setType(RCInterface.TYPE_ISDN);
        this.rcInterfaces[2] = new ConnectionRCInterface();
        this.rcInterfaces[2].setType(RCInterface.TYPE_DECT);
        this.rcInterfaces[3] = new ConnectionRCInterface();
        this.rcInterfaces[3].setType(RCInterface.TYPE_CATV);
        this.rcInterfaces[4] = new ConnectionRCInterface();
        this.rcInterfaces[4].setType(RCInterface.TYPE_LMDS);
        this.rcInterfaces[5] = new ConnectionRCInterface();
        this.rcInterfaces[5].setType(RCInterface.TYPE_MATV);
        this.rcInterfaces[6] = new ConnectionRCInterface();
        this.rcInterfaces[6].setType(RCInterface.TYPE_RCS);  
        this.resourceStatusEventObjects = new Vector();
    }

    public static RCInterfaceManager getInstance() {
        System.out.println("XleTView: RCInterfaceManager getInstance");
        if (THE_INSTANCE == null) {
            THE_INSTANCE = new RCInterfaceManager();
        }
        return THE_INSTANCE;
    }

    public RCInterface[] getInterfaces() {
        System.out.println("XleTView: getInterfaces");
        return this.rcInterfaces;
    }

    public RCInterface getInterface(InetAddress addr) {
        return this.rcInterfaces[0];
    }

    public RCInterface getInterface(Socket s) {
        return this.rcInterfaces[0];
    }

    public RCInterface getInterface(URLConnection u) {
        return this.rcInterfaces[0];
    }

    public void addResourceStatusEventListener(ResourceStatusListener listener) {
        if (!this.resourceStatusEventObjects.contains(listener)) {
            this.resourceStatusEventObjects.add(listener);
        }
    }

    public void removeResourceStatusEventListener(ResourceStatusListener listener) {
        this.resourceStatusEventObjects.remove(listener);
    }

    protected void fireResorceStatusChanged(ResourceStatusEvent po) {
        // backwards so we get the last added
        for (int i = this.resourceStatusEventObjects.size() - 1; i > -1; i--) {
            ResourceStatusListener li = (ResourceStatusListener) this.resourceStatusEventObjects.get(i);
            li.statusChanged(po);
        }
    }
}