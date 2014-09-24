/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package org.havi.ui;

/*
 * Copyright 2002 by HAVi, Inc. Java is a trademark of Sun
 * Microsystems, Inc. All rights reserved.  
 */

import org.havi.ui.event.HScreenLocationModifiedListener;

public class HVideoComponent
    extends HComponent
{    
    protected HVideoComponent()
    {
    }

    public HVideoDevice getVideoDevice()
    {
        return (null);
    }

    public void addOnScreenLocationModifiedListener(HScreenLocationModifiedListener slml)
    {
    }

    public void removeOnScreenLocationModifiedListener(HScreenLocationModifiedListener slml)
    {
    }
}
