/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.dsmcc;

import java.io.IOException;

public class DSMCCStream {


    public DSMCCStream(DSMCCObject aDSMCCObject) throws NotLoadedException, IllegalObjectTypeException{
    }

    public DSMCCStream(String path) throws IOException, IllegalObjectTypeException{
    }

    public DSMCCStream(String path, String name) throws IOException, IllegalObjectTypeException    {
    }


    public long getDuration() {
        return 0;
    }



    public long getNPT() throws MPEGDeliveryException{
        return 0;
    }

    public org.davic.net.Locator getStreamLocator()    {
        return null;
    }

    public boolean isMPEGProgram(){
        return true;
    }

    public boolean isAudio(){
        return false ;
    }

    public boolean isVideo(){
        return false;
    }

    public boolean isData() {return true; }

    public NPTRate getNPTRate() throws MPEGDeliveryException { return null; }

    public void addNPTListener(NPTListener l){};

    public void removeNPTListener(NPTListener l) {};
}
