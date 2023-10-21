/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.application;

public interface DVBHTMLProxy extends AppProxy {

    int LOADING = 6;
    int KILLED = 7;

    void prefetch();

    void startTrigger(java.util.Date starttime);

    void trigger(java.util.Date time, Object triggerPayload);
}

