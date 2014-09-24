/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.net.ca;

import org.davic.mpeg.ElementaryStream;
import org.davic.mpeg.Service;
import org.davic.mpeg.TransportStream;

public abstract class CAModule {

	public CAModule() {}
  
	public final static int CA0 = 0x00;

	public final static int CA1 = 0x01;

	public final static int PROPRIETARY = 0xFF;
  
	public final static int ENTITLEMENT_UNKNOWN = 0x00;

	public final static int ENTITLEMENT_AVAILABLE = 0x01;

	public final static int ENTITLEMENT_NOT_AVAILABLE = 0x02;

	public final static int MMI_DIALOGUE_REQUIRED = 0x03;
  
	public int queryEntitlement(org.davic.net.Locator locator) throws CAException,	org.davic.net.InvalidLocatorException {
		return 0;
	}
  
	public int buyEntitlement(org.davic.net.Locator locator) throws CAException {
		return 0;
	}
  
	public String[] listEntitlements() throws CAException {
	    return null;
	}
  
	public boolean isConnectable(TransportStream ts) throws CAException {
	    return false;
	}
  
	public int getSlotNumber() throws CAException {
		return 0;
	}

	public boolean isDescramblable(Service s) throws CAException {
		return false;
	}	
  
	public boolean isDescramblable(ElementaryStream[] streams) throws CAException {
		return false;
    }
  
	
	public int[] getCASystemIDs() throws CAException {
		return null;
	}

	public int getModuleType() throws CAException {
		return 0;
	}
  
	public int openMessageSession(MessageListener listener) throws CAException {
		return 0;
    }

	public void closeMessageSession(int session_id) throws CAException {
	}
    
	public void sendToModule(int session_id, CAMessage msg) throws CAException {
	}

	public String getApplicationTitle() throws ModuleUnavailableException{return null;}

	public void enterApplication() throws ModuleUnavailableException{};

    public void closeMMI() throws ModuleUnavailableException{}
}




