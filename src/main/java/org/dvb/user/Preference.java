/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.user ;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public abstract class Preference {

    private String name;
    private List<String> values;

    protected Preference(){
        values = new ArrayList<>();
    }

    public Preference (String name, String value) {
        this();
        this.name = name;
        if(value != null && value.length() > 0){
            values.add(value);
        }
    }

    public Preference (String name, String value[]) {
        this();
        this.name = name;
        for (int i = 0; i < value.length; i++) {
            values.add(value[i]);
        }
    }

    public void add (String value) {
        values.add(value);
    }

    public void add( String value[]){
        for (int i = 0; i < value.length; i++) {
            values.remove(value[i]);
            values.add(value[i]);
        }
    }

    public void add (int position, String value) {
        values.remove(value);

        if(position <= 0){
            values.add(0, value);
        }
        else{
            values.add(value);
        }

    }

    public String[] getFavourites () {
        Object[] o = values.toArray();
        String[] s = new String[o.length];
        System.arraycopy(o, 0, s, 0, o.length);

        return s;
    }

    public String getMostFavourite () {
        String result = null;

        if(values.size() > 0){
            result = (String) values.get(0);
        }
        return result;
    }

    public String getName () {
        return name;
    }

    public int getPosition (String value) {
        return values.indexOf(value);
    }

    public boolean hasValue () {
        return values.size() > 0;
    }

    public void remove (String value){
        values.remove(value);
    }

    public void removeAll(){
        values.clear();
    }

    public void setMostFavourite (String value) {
        values.remove(value);
        values.add(0, value);
    }

    public String toString() {
        String result = name + " [";
        for (int i = 0; i < values.size(); i++) {
            result += values.get(i);
            if(i < values.size() - 1){
                result += ",";
            }
        }
        result += "]";
        return result;
    }



}






