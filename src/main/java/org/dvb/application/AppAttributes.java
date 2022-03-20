/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.application;


public interface AppAttributes{

    public static final int DVB_J_application = 1;

    public static final int DVB_HTML_application = 2;

    public int getType();

    public String getName();

    public String getName(String iso639code) throws LanguageNotAvailableException;

    public String[][] getNames () ;

    public String[] getProfiles();

    public int[] getVersions(String profile) throws IllegalProfileParameterException ;

    public boolean getIsServiceBound () ;

    public boolean isStartable () ;

    public AppID getIdentifier () ;

    public AppIcon getAppIcon () ;

    public int getPriority();

    public org.davic.net.Locator getServiceLocator();

    public Object getProperty (String index) ;
}
