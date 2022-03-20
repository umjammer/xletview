/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.mpeg.sections;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class SectionFilterEvent extends java.util.EventObject{

    private Object appData;

    public SectionFilterEvent(SectionFilter sectionFilter, Object appData){
        super(sectionFilter) ;
        this.appData = appData;
    }

    public Object getSource(){
        return super.getSource();
    }

    public Object getAppData(){
        return appData;
    }

}
