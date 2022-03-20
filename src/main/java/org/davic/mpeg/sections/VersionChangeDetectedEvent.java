/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.mpeg.sections;

public class VersionChangeDetectedEvent extends SectionFilterEvent{

    public VersionChangeDetectedEvent(SectionFilter sectionFilter, Object appData)    {
        super(sectionFilter, appData);
    }

    public Object getSource(){
        return super.getSource();
    }

    public int getOriginalVersion()    {
        return 0;
    }

    public int getNewVersion(){
        return 0;
    }

}


