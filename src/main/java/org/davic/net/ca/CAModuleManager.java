/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.net.ca;
import org.davic.mpeg.Service;
import org.davic.resources.ResourceServer;
import org.davic.resources.ResourceStatusListener;
	
public class CAModuleManager implements ResourceServer {

	private CAModuleManager() {
	}

	public static CAModuleManager getInstance() {
	    return null;
	}
	
	public int numberOfModules() {
	    return 0;
	}
  
	public CAModule[] getModules() {
	    return null;
	}
  
	public CAModule[] getModules(Service s) {
	    return null;
	}
  
	public void addCAListener(CAListener l) {
	}

	public void removeCAListener(CAListener l) {
	}
  
	public void addMMIListener(MMIListener listener) throws CAException {
    }
  
	public void removeMMIListener(MMIListener listener) {
	}
  
	public void addResourceStatusEventListener(ResourceStatusListener l) {
	}
  
	public void removeResourceStatusEventListener(ResourceStatusListener l) {
	}
  
}
