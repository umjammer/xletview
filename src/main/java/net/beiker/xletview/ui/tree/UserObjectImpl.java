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
 *
 * Beiker
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UserObjectImpl implements UserObject{

    private Object object;
    private String name;
    private File[] children;
    private boolean isRoot;
//    public UserObjectImpl(String object){
//        this.object = object;
//        name = object;
//    }

    public UserObjectImpl(Object object){
        this.object = object;
        if(object instanceof File){
            File file = (File)object;

            isRoot = (file.getName().length() != 0)? false: true;
            name = (file.getName().length() != 0)? file.getName(): file.getPath();
            name = name.replaceAll("\\\\", "");
            name = name.replaceAll("/", "");
            //Debug.write(this, name);
        }
    }

    public boolean hasChildren(){
        boolean result = false;
        if(object instanceof File){
            File file = (File)object;
            if(isRoot){
                result = true;
            }
            else if(file.isDirectory()){
                File[] files = file.listFiles();
                if(files != null){
                    children = getDirs(files);
                    if(children != null && children.length > 0){
                        result = true;
                    }
                }
            }
        }

        return result;
    }

    public Object[] getChildren(){
        if(object instanceof File){
            File file = (File)object;
            if(file.isDirectory()){
                File[] files = file.listFiles();
                if(files != null){
                    children = getDirs(files);
                }
            }
        }

        return children;
    }

    public File[] getDirs(File[] files){
        List<File> v = new ArrayList<>();
        for(int i = 0; i < files.length; i++){
            if(files[i].isDirectory()){
                v.add(files[i]);
            }
        }
        File[] dirs = new File[v.size()];
        for(int i = 0; i < v.size(); i++){
            dirs[i] = (File)v.get(i);
        }
        return dirs;
    }

    public Object getObject() {
        return object;
    }

    public String toString(){
        return name;
    }

    /* (non-Javadoc)
     * @see net.beiker.xletview.ui.tree.UserObject#isLeaf()
     */
    public boolean isBranch() {
        return true;
    }

}
