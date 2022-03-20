/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.davic.mpeg.sections;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 2
 */
public class Section implements java.lang.Cloneable{

    private byte[] data;

    Section(){
    }

    public byte[] getData()    throws NoDataAvailableException    {
        if(data == null){
            throw new NoDataAvailableException("no data avaliable");
        }
        return data;
    }

    public byte[] getData(int index, int length) throws NoDataAvailableException, java.lang.IndexOutOfBoundsException{
        if(data == null){
            throw new NoDataAvailableException("no data avaliable");
        }
        byte[] newData = new byte[length];
        System.arraycopy(data, index, newData, 0, length);
        return newData;
    }

    public byte getByteAt(int index) throws NoDataAvailableException, java.lang.IndexOutOfBoundsException{
        if(data == null){
            throw new NoDataAvailableException("no data avaliable");
        }
        return data[index];
    }

    public int table_id() throws NoDataAvailableException{
        return 0;
    }

    public boolean section_syntax_indicator() throws NoDataAvailableException{
        return false;
    }

    public boolean private_indicator() throws NoDataAvailableException    {
        return false;
    }

    public int section_length()    throws NoDataAvailableException    {
        return 0;
    }

    public int table_id_extension()    throws NoDataAvailableException    {
        return 0;
    }

    public short version_number() throws NoDataAvailableException{
        return 0;
    }

    public boolean current_next_indicator()    throws NoDataAvailableException{
        return false;
    }

    public int section_number()    throws NoDataAvailableException    {
        return 0;
    }

    public int last_section_number() throws NoDataAvailableException{
        return 0;
    }

    public boolean getFullStatus(){
        return false;
    }

    public void setEmpty()    {
    }

    public Object clone() {
        return null;
    }
}
