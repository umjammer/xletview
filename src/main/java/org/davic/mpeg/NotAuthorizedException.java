/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.mpeg;

public class NotAuthorizedException extends java.lang.Exception implements NotAuthorizedInterface{

    public NotAuthorizedException() {
    }

    public NotAuthorizedException(String s) {
    }

    @Override
    public int getType(){
       return 0;
    }

    @Override
    public Service getService(){
        return null;
    }

    @Override
    public ElementaryStream[] getElementaryStreams(){
        return null;
    }

    @Override
    public int[] getReason(int index) throws java.lang.IndexOutOfBoundsException {
        return null;
    }

}










