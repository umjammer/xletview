/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.mpeg;

public interface NotAuthorizedInterface{
    public final static int POSSIBLE_UNDER_CONDITIONS = 0;

    public final static int NOT_POSSIBLE = 1;

    public final static int COMMERCIAL_DIALOG = 1;

    public final static int MATURITY_RATING_DIALOG = 2;

    public final static int TECHNICAL_DIALOG = 3;

    public final static int FREE_PREVIEW_DIALOG = 4;

    public final static int NO_ENTITLEMENT = 1;

    public final static int MATURITY_RATING = 2;

    public final static int TECHNICAL = 3;

    public final static int GEOGRAPHICAL_BLACKOUT = 4;

    public final static int OTHER = 5;

    public final static int SERVICE = 0;

    public final static int ELEMENTARY_STREAM = 1;

    public int getType();

    public Service getService();

    public ElementaryStream[] getElementaryStreams();

    public int[] getReason(int index) throws java.lang.IndexOutOfBoundsException;
}







