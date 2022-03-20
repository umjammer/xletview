/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.application ;

import net.beiker.xletview.service.ServiceManager;
import xjavax.tv.locator.Locator;



/**
 * A filter that only accepts applications that are signalled in the current service.
 * @author Martin Sveden
 * @statuscode 2
 * @comment cannot be completed yet(dependencies)
 */
public class CurrentServiceFilter extends AppsDatabaseFilter {

    private static final net.beiker.cake.Logger log = net.beiker.cake.Log.getLogger(CurrentServiceFilter.class);

    public CurrentServiceFilter() {
        super();
    }

    public boolean accept(AppID appId) {

        // get the AppsDatabase
        AppsDatabase db = AppsDatabase.getAppsDatabase();

        // get the Service Locator of the app
        Locator appServiceLocator = db.getAppAttributes(appId).getServiceLocator();

        // get the Locator of the current Service
        Locator currentServiceLocator = ServiceManager.getInstance().getCurrentService().getLocator();

        // check if the app is in the current service
        try{
            //TODO this will throw a nullpointer, implement the rest to make it work
            currentServiceLocator.equals(appServiceLocator);
        }
        catch(NullPointerException e){
	        log.debug("accept(AppID) not implemented");
        }

        return false;
    }

}
