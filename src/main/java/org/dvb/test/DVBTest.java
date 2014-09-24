/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.test;

import java.io.IOException;

public class DVBTest {

	private DVBTest(){ 
	}

	public final static int PASS = 0x00; 

	public final static int FAIL = -0x01; 

	public final static int OPTION_UNSUPPORTED = -0x02; 

	public final static int HUMAN_INTERVENTION = -0x03; 

	public final static int UNRESOLVED = -0x04; 

	public final static int UNTESTED = -0x05; 

	public static void log(String id, String message) throws IOException{
	}

	public static void log(String id, int no) throws IOException{
	}

	public static void terminate(String id, int terminationCondition) throws java.io.IOException{
		System.out.println(id);
		switch(terminationCondition){
			case PASS:
			System.out.println("PASSED");
			break;
			case FAIL:
			System.out.println("FAILED");
			break;
			default:
			System.out.println("UNKNOWN EXIT CONDITION(" + terminationCondition + ")");
			break;
		}
	}

    public static void prompt(String id, int controlCode, String message) throws IOException{
	}

}


