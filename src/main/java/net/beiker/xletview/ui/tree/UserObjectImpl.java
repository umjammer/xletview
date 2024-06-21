/*
 * Created on Nov 18, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

package net.beiker.xletview.ui.tree;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * @author beiker
 * <p>
 * Beiker
 * <p>
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UserObjectImpl implements UserObject {

    private final Object object;
    private String name;
    private File[] children;
    private boolean isRoot;
//    public UserObjectImpl(String object){
//        this.object = object;
//        name = object;
//    }

    public UserObjectImpl(Object object) {
        this.object = object;
        if (object instanceof File file) {

            isRoot = (!file.getName().isEmpty()) ? false : true;
            name = (!file.getName().isEmpty()) ? file.getName() : file.getPath();
            name = name.replaceAll("\\\\", "");
            name = name.replaceAll("/", "");
            //logger.log(Level.DEBUG, this, name);
        }
    }

    @Override
    public boolean hasChildren() {
        boolean result = false;
        if (object instanceof File file) {
            if (isRoot) {
                result = true;
            } else if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    children = getDirs(files);
                    if (children != null && children.length > 0) {
                        result = true;
                    }
                }
            }
        }

        return result;
    }

    @Override
    public Object[] getChildren() {
        if (object instanceof File file) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    children = getDirs(files);
                }
            }
        }

        return children;
    }

    public File[] getDirs(File[] files) {
        List<File> v = new ArrayList<>();
        for (File file : files) {
            if (file.isDirectory()) {
                v.add(file);
            }
        }
        File[] dirs = new File[v.size()];
        for (int i = 0; i < v.size(); i++) {
            dirs[i] = v.get(i);
        }
        return dirs;
    }

    @Override
    public Object getObject() {
        return object;
    }

    public String toString() {
        return name;
    }

    @Override
    public boolean isBranch() {
        return true;
    }
}
