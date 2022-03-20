/*
 * Created on Nov 18, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package net.beiker.xletview.ui.tree;

/**
 * @author beiker
 *
 * Beiker
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface UserObject {

    public Object getObject();

    public boolean hasChildren();

    public boolean isBranch();

    public Object[] getChildren();
}
