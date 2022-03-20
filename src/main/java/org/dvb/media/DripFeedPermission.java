/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.media;

public class DripFeedPermission extends java.security.BasicPermission{

  public DripFeedPermission(String name) {super(name);}

  public DripFeedPermission(String name, String actions) {super(name,actions);}

  public boolean implies (java.security.Permission p) {
     return false;
  }

}

