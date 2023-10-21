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
 * @author Martin Sveden
 * @statuscode 4
 */
public class TimeOutEvent extends EndOfFilteringEvent {

    public TimeOutEvent(SectionFilter sectionFilter, Object appData) {
        super(sectionFilter, appData);
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }

}


