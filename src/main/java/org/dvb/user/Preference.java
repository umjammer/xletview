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

package org.dvb.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @author Martin Sveden
 * @statuscode 4
 */
public abstract class Preference {

    private String name;
    private List<String> values;

    protected Preference() {
        values = new ArrayList<>();
    }

    public Preference(String name, String value) {
        this();
        this.name = name;
        if (value != null && !value.isEmpty()) {
            values.add(value);
        }
    }

    public Preference(String name, String[] value) {
        this();
        this.name = name;
        Collections.addAll(values, value);
    }

    public void add(String value) {
        values.add(value);
    }

    public void add(String[] value) {
        for (String s : value) {
            values.remove(s);
            values.add(s);
        }
    }

    public void add(int position, String value) {
        values.remove(value);

        if (position <= 0) {
            values.add(0, value);
        } else {
            values.add(value);
        }

    }

    public String[] getFavourites() {
        Object[] o = values.toArray();
        String[] s = new String[o.length];
        System.arraycopy(o, 0, s, 0, o.length);

        return s;
    }

    public String getMostFavourite() {
        String result = null;

        if (!values.isEmpty()) {
            result = values.get(0);
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public int getPosition(String value) {
        return values.indexOf(value);
    }

    public boolean hasValue() {
        return !values.isEmpty();
    }

    public void remove(String value) {
        values.remove(value);
    }

    public void removeAll() {
        values.clear();
    }

    public void setMostFavourite(String value) {
        values.remove(value);
        values.add(0, value);
    }

    public String toString() {
        StringBuilder result = new StringBuilder(name + " [");
        for (int i = 0; i < values.size(); i++) {
            result.append(values.get(i));
            if (i < values.size() - 1) {
                result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }


}






