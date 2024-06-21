/*
 * This file is part of XleTView
 * Copyright (C) 2003 Martin SvedÈn
 *
 * This is free software, and you are
 * welcome to redistribute it under
 * certain conditions;
 *
 * See LICENSE document for details.
 */

package org.davic.mpeg;

public interface NotAuthorizedInterface {

    int POSSIBLE_UNDER_CONDITIONS = 0;

    int NOT_POSSIBLE = 1;

    int COMMERCIAL_DIALOG = 1;

    int MATURITY_RATING_DIALOG = 2;

    int TECHNICAL_DIALOG = 3;

    int FREE_PREVIEW_DIALOG = 4;

    int NO_ENTITLEMENT = 1;

    int MATURITY_RATING = 2;

    int TECHNICAL = 3;

    int GEOGRAPHICAL_BLACKOUT = 4;

    int OTHER = 5;

    int SERVICE = 0;

    int ELEMENTARY_STREAM = 1;

    int getType();

    Service getService();

    ElementaryStream[] getElementaryStreams();

    int[] getReason(int index) throws java.lang.IndexOutOfBoundsException;
}







