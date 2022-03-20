/*
 * Created on Nov 18, 2003
 *
 */
package net.beiker.xletview.ui.tree;

import java.util.logging.Logger;

import javax.swing.tree.DefaultMutableTreeNode;

import net.beiker.xletview.app.AppGroup;

/**
 * @author Martin Sveden
 *
 */
public class BeikerTreeNode extends DefaultMutableTreeNode{

    private static final Logger log = Logger.getLogger(BeikerTreeNode.class.getName());

    private UserObject userObject;
    private boolean childrenDefined;
//    private int childCount = 3;

    public BeikerTreeNode(UserObject userObject){
        super(userObject);
        this.userObject = userObject;
    }

    public int getChildCount(){
        int i = super.getChildCount();

        return i;
    }

    public void expand(){
        //if(!childrenDefined){
        this.removeAllChildren();
            log.fine("expand");

            log.fine("is UserObject");

            Object[] objects = userObject.getChildren();
            if(userObject instanceof UserObjectImpl && objects != null){
                for(int i = 0; i < objects.length; i++){
                    add(new BeikerTreeNode(new UserObjectImpl(objects[i])));
                }
            }
            else if(userObject instanceof AppGroup){
                for(int i = 0; i < objects.length; i++){
                    add(new BeikerTreeNode((UserObject)objects[i]));
                }
            }


            childrenDefined = true;

        //}
    }

//    public void reload(){
//        childrenDefined = false;
//        this.removeAllChildren();
//        expand();
//    }

    public Object getUserObject(){
        return userObject;
    }

    public boolean isLeaf() {
      return !userObject.hasChildren();
    }

}
