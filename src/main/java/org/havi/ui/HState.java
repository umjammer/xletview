/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

public interface HState{

    public static final int FOCUSED_STATE_BIT   				= 0x01; // 1
    public static final int ACTIONED_STATE_BIT  				= 0x02; // 2
    public static final int DISABLED_STATE_BIT  				= 0x04; // 4
    
    public static final int FIRST_STATE 						= 0x80; // 128

	public static final int NORMAL_STATE  						= 0x80; // 128
    public static final int FOCUSED_STATE  						= 0x81; // 129
    public static final int ACTIONED_STATE  					= 0x82; // 130
    public static final int ACTIONED_FOCUSED_STATE  			= 0x83; // 131

	public static final int DISABLED_STATE  					= 0x84; // 132
    public static final int DISABLED_FOCUSED_STATE  			= 0x85; // 133
    public static final int DISABLED_ACTIONED_STATE  			= 0x86; // 134
    public static final int DISABLED_ACTIONED_FOCUSED_STATE  	= 0x87; // 135

	public static final int ALL_STATES 							= 0x07; // 7
    public static final int LAST_STATE 							= 0x87; // 135

   
}



