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

package org.dvb.test;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

import static java.lang.System.getLogger;


public class DVBTest {

    private static final Logger logger = getLogger(DVBTest.class.getName());

    public final static int PASS = 0x00;
    public final static int FAIL = -0x01;
    public final static int OPTION_UNSUPPORTED = -0x02;
    public final static int HUMAN_INTERVENTION = -0x03;
    public final static int UNRESOLVED = -0x04;
    public final static int UNTESTED = -0x05;

    private DVBTest() {
    }

    public static void log(String id, String message) throws IOException {
    }

    public static void log(String id, int no) throws IOException {
    }

    public static void terminate(String id, int terminationCondition) throws java.io.IOException {
logger.log(Level.DEBUG, id);
        switch (terminationCondition) {
            case PASS:
logger.log(Level.DEBUG, "PASSED");
                break;
            case FAIL:
logger.log(Level.DEBUG, "FAILED");
                break;
            default:
logger.log(Level.DEBUG, "UNKNOWN EXIT CONDITION(" + terminationCondition + ")");
                break;
        }
    }

    public static void prompt(String id, int controlCode, String message) throws IOException {
    }
}


