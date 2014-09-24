/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Svedén

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.


*/


package org.dvb.net.rc;

/**
 * 
 *
 * @version  7.11.03
 * @author 	 Bengt Skogvall
 * @author 	 Martin Sveden
 * @statuscode 4
 */
public class RCInterface
{

	public static final int TYPE_PSTN=1;

	public static final int TYPE_ISDN=2;

	public static final int TYPE_DECT=3;

	public static final int TYPE_CATV=4;

	public static final int TYPE_LMDS=5;

	public static final int TYPE_MATV=6;

	public static final int TYPE_RCS=7;

    private int type;
    
    /**
     * Added method so we can make different RCInterfaces from 
     * the RCInterfaceManager
     */
    protected void setType(int type) {
        this.type = type;
    }

	public int getType(){
		return type;
	}

	protected RCInterface()	{
	}

	public int getDataRate() {
		return 28;  // as in a 28k Modem
	}
}

