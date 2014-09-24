/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.dsmcc ;

import java.io.InterruptedIOException;
import java.security.cert.X509Certificate;

//public class DSMCCObject extends java.io.File {
/**
 * Due to the byte manipulation this has to extend
 * our xjava.io.XFile object, otherwise there will
 * be a java.lang.VerifyError during the 
 * classloading
 * 
 * @author 
 */
public class DSMCCObject extends xjava.io.XFile {
  
    public static final int FROM_CACHE = 1;
    public static final int FROM_CACHE_OR_STREAM = 2;
    public static final int FROM_STREAM_ONLY = 3;  
   
	public DSMCCObject (String path) {
		super(path);
    }
   
	public DSMCCObject (String path, String name) {
		super(path, name);
    }
   
	public DSMCCObject (DSMCCObject dir, String name) {
		super(dir, name);
	}
   
	public boolean isLoaded() { 
		return true;
	}

	public boolean  isStream() {return true;}
   
	public boolean  isStreamEvent() {return true;}
   
	public boolean isObjectKindKnown() {return true;}

	public void synchronousLoad()
      throws InvalidFormatException, InterruptedIOException, MPEGDeliveryException, ServerDeliveryException,
		InvalidPathNameException, NotEntitledException, ServiceXFRException {
    }
   
	public void asynchronousLoad (AsynchronousLoadingEventListener l) throws InvalidPathNameException {
	}
   
	public void abort() throws NothingToAbortException {
    }

	public static boolean prefetch(String path, byte priority) {
		return true;
	}

	public static boolean prefetch(DSMCCObject dir, String path, byte priority) {
		return true;
	}
   
    public void unload() throws NotLoadedException {
    }
   
    public java.net.URL  getURL() {return null;
    }
   
	public void addObjectChangeEventListener(ObjectChangeEventListener listener) throws InsufficientResourcesException {
	}
   
	public void removeObjectChangeEventListener(ObjectChangeEventListener listener) {
    } 
   
	public void loadDirectoryEntry (AsynchronousLoadingEventListener l) throws InvalidPathNameException {
	}

	public void setRetrievalMode( int retrieval_mode ) {}


	public X509Certificate[][] getSigners() { 
		return null; 
	}


}


