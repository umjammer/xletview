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

/**
 * 
 *
 * @version  14.9.03
 * @author 	 Bengt Skogvall
 * @statuscode 4
 */
public class ConnectionParameters {
  private String target;
  private String userName;
  private String passWord;

	public ConnectionParameters(String number, String username, String password){
          target=number;
          userName=username;
          passWord=password;
	}

	public ConnectionParameters(String number, String username, String password, InetAddress[] dns)	{
          target=number;
          userName=username;
          passWord=password;
          //ignore dns
	}

	public String getTarget(){
		return target;
	}

	public String getUsername()	{
		return userName;
	}

	public String getPassword() {
		return passWord;
	}

	public InetAddress[] getDNSServer() {
		return null;   //not implemented
	}
}
