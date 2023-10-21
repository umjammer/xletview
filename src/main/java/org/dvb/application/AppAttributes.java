/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.application;


public interface AppAttributes {

    int DVB_J_application = 1;

    int DVB_HTML_application = 2;

    int getType();

    String getName();

    String getName(String iso639code) throws LanguageNotAvailableException;

    String[][] getNames();

    String[] getProfiles();

    int[] getVersions(String profile) throws IllegalProfileParameterException;

    boolean getIsServiceBound();

    boolean isStartable();

    AppID getIdentifier();

    AppIcon getAppIcon();

    int getPriority();

    org.davic.net.Locator getServiceLocator();

    Object getProperty(String index);
}
