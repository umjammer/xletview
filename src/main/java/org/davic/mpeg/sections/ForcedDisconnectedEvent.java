/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.mpeg.sections;

import org.davic.resources.ResourceStatusEvent;


/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class ForcedDisconnectedEvent extends ResourceStatusEvent{

    public ForcedDisconnectedEvent(SectionFilterGroup sectionFilterGroup){
        super(sectionFilterGroup);
    }

    public Object getSource(){
        return super.getSource();
    }
}
