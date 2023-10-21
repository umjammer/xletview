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

package net.beiker.xletview.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import net.beiker.xletview.ui.tree.UserObject;


/**
 * AppGroup
 *
 * @author Martin Sveden
 */
public class AppGroup implements UserObject /*, Transferable*/ {

//    final public static DataFlavor DATAFLAVOR = new DataFlavor(AppGroup.class, "Application Group");
//    static DataFlavor[] flavors = { DATAFLAVOR };

    private List<AppGroup> subGroups;
    private List<App> apps;
    private String name;
    private static int count;

    private AppGroup() {
        subGroups = new ArrayList<>();
        apps = new ArrayList<>();
    }

    public AppGroup(String name) {
        this();
        this.name = Objects.requireNonNullElseGet(name, () -> "new group " + (count++));
    }

    public void addChild(AppGroup subGroup) {
        subGroups.add(subGroup);
        sortGroups();
    }

    public void removeChild(AppGroup subGroup) {
        subGroups.remove(subGroup);
        sortGroups();
    }

    public List<AppGroup> getSubGroups() {
        return subGroups;
    }

    @Override
    public boolean hasChildren() {
        return (subGroups.size() + apps.size()) > 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addApp(App app) {
        apps.add(app);
        sortApps();
    }

    public void removeApp(App app) {
        apps.remove(app);
        sortApps();
    }

    public List<App> getApps() {
        return apps;
    }

    public boolean hasApps() {
        return !apps.isEmpty();
    }

    /**
     * Sorts sub groups alphabetically
     */
    private void sortGroups() {
        for (int i = 0; i < subGroups.size(); i++) {
            AppGroup p1 = subGroups.get(i);
            for (int k = i; k < subGroups.size(); k++) {
                AppGroup p2 = subGroups.get(k);
                String s1 = p1.getName().toLowerCase();
                String s2 = p2.getName().toLowerCase();
                int compare = s1.compareTo(s2);

                if (compare > 0) {
                    subGroups.set(i, p2);
                    subGroups.set(k, p1);
                }
            }
//            p1.sortGroups();
        }
    }

    /**
     * Sorts all apps alphabetically
     */
    private void sortApps() {
        for (int i = 0; i < apps.size(); i++) {
            for (int k = i; k < apps.size(); k++) {
                App p1 = apps.get(i);
                App p2 = apps.get(k);
                String s1 = p1.getName().toLowerCase();
                String s2 = p2.getName().toLowerCase();
                int compare = s1.compareTo(s2);

                if (compare > 0) {
                    apps.set(i, p2);
                    apps.set(k, p1);
                }
            }
        }
    }

    @Override
    public Object getObject() {
        return this;
    }

    @Override
    public Object[] getChildren() {
        List<UserObject> v = new ArrayList<>();
        v.addAll(subGroups);
        v.addAll(apps);
        return v.toArray();
    }

    public String toString() {
        return name;
    }

    @Override
    public boolean isBranch() {
        return true;
    }

    // Drag n Drop not yet implemented

//    @Override
//    public DataFlavor[] getTransferDataFlavors() {
//        return flavors;
//    }
//
//    @Override
//    public boolean isDataFlavorSupported(DataFlavor df) {
//        return df.equals(DATAFLAVOR);
//    }
//
//    @Override
//    public Object getTransferData(DataFlavor df) throws UnsupportedFlavorException, IOException {
//        if (df.equals(DATAFLAVOR)) {
//            return this;
//        } else {
//            throw new UnsupportedFlavorException(df);
//        }
//    }
}
