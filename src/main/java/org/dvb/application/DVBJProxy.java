/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.application;

public interface DVBJProxy extends AppProxy {

    int LOADED = 5;

    void load();

    void init();
}

