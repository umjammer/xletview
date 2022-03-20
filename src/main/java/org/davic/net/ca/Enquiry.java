/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.net.ca;

public class Enquiry extends Text {

    Enquiry() {}

    public boolean getBlindAnswer() {
        return false;
    }

    public short getAnswerLength() {
        return (short) 0;
    }

    final public void setAnswer(String answer) throws CAException {
    }
}
