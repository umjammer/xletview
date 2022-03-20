/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.media;

public interface LanguageControl extends javax.media.Control{

    public String[] listAvailableLanguages();

    public void selectLanguage(String lang) throws LanguageNotAvailableException, org.davic.media.NotAuthorizedException;

    public String getCurrentLanguage();

    public String selectDefaultLanguage() throws org.davic.media.NotAuthorizedException;
}

