/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.mpeg.sections;

public abstract class SectionFilter{

    SectionFilter()    {
    }

    public void startFiltering( Object appData, int pid ) throws FilterResourceException, org.davic.mpeg.NotAuthorizedException,  IllegalFilterDefinitionException,    ConnectionLostException    {
    }

    public void startFiltering( Object appData, int pid, int table_id ) throws FilterResourceException, org.davic.mpeg.NotAuthorizedException, ConnectionLostException, IllegalFilterDefinitionException{
    }

    public void startFiltering( Object appData, int pid, int table_id, byte posFilterDef[],  byte posFilterMask[]  ) throws FilterResourceException, IllegalFilterDefinitionException, org.davic.mpeg.NotAuthorizedException, ConnectionLostException{
    }

    public void startFiltering( Object appData, int pid, int table_id, int offset, byte  posFilterDef[], byte posFilterMask[] ) throws FilterResourceException, IllegalFilterDefinitionException, org.davic.mpeg.NotAuthorizedException, ConnectionLostException{
    }

    public void startFiltering( Object appData, int pid, int table_id, byte posFilterDef[],  byte posFilterMask[], byte negFilterDef[], byte negFilterMask[]) throws FilterResourceException, IllegalFilterDefinitionException, org.davic.mpeg.NotAuthorizedException, ConnectionLostException{
    }

    public void startFiltering( Object appData, int pid, int table_id, int offset, byte posFilterDef[], byte posFilterMask[], byte negFilterDef[], byte negFilterMask[]) throws FilterResourceException, IllegalFilterDefinitionException, org.davic.mpeg.NotAuthorizedException, ConnectionLostException{
    }

    public void stopFiltering(){
    }

    public void setTimeOut(long milliseconds) throws IllegalArgumentException{
    }

    public void addSectionFilterListener( SectionFilterListener listener){
    }

    public void removeSectionFilterListener( SectionFilterListener listener){
    }
}
