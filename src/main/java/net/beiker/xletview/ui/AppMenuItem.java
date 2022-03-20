/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Sveden

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package net.beiker.xletview.ui;

import javax.swing.JMenuItem;

import net.beiker.xletview.app.App;

/**
 * @author Martin Sveden
 */
public class AppMenuItem extends JMenuItem{

    private App app;

    public AppMenuItem(App app){
        super(app.getName());
        this.app = app;
    }

    public App getApp(){
        return app;
    }
}
