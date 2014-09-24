/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Sveden
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package net.beiker.xletview.ui.tree;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

import net.beiker.xletview.app.App;
import net.beiker.xletview.app.AppGroup;
import net.beiker.xletview.util.Constants;

/*
 * From an example that you can find at:
 * http://manning.com/sbe/files/uts2/Chapter17html/Chapter17.htm
 */
public class CellRenderer extends JLabel implements TreeCellRenderer {
    protected Color m_textSelectionColor;
    protected Color m_textNonSelectionColor;
    protected Color m_bkSelectionColor;
    protected Color m_bkNonSelectionColor;
    protected Color m_borderSelectionColor;

    protected boolean m_selected;

    public CellRenderer() {
        super();
        m_textSelectionColor = UIManager.getColor("Tree.selectionForeground");
        m_textNonSelectionColor = UIManager.getColor("Tree.textForeground");
        m_bkSelectionColor = UIManager.getColor("Tree.selectionBackground");
        m_bkNonSelectionColor = UIManager.getColor("Tree.textBackground");
        m_borderSelectionColor = UIManager.getColor("Tree.selectionBorderColor");
        setOpaque(false);
    }

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        //BeikerTreeNode node = (BeikerTreeNode) value;
        Object obj = node.getUserObject();
        setText(obj.toString());

        if (obj instanceof Boolean)
            setText("Retrieving data...");

        if (obj instanceof AppGroup) {
            if (expanded){
                setIcon(Constants.ICON_EXPANDEDFOLDER);
            }
            else{
                setIcon(Constants.ICON_FOLDER);
            }
        }
        else if (obj instanceof App) {
                setIcon(Constants.ICON_XLET);
        }
        else if (obj instanceof UserObjectImpl) {
            if (expanded){
                setIcon(Constants.ICON_EXPANDEDFOLDER);
            }
            else{
                setIcon(Constants.ICON_FOLDER);
            }
        }
        else {
            setIcon(null);
        }

        setFont(tree.getFont());
        setForeground(sel ? m_textSelectionColor : m_textNonSelectionColor);
        setBackground(sel ? m_bkSelectionColor : m_bkNonSelectionColor);
        m_selected = sel;
        return this;
    }

    public void paintComponent(Graphics g) {
        Color bColor = getBackground();
        Icon icon = getIcon();

        g.setColor(bColor);
        int offset = 0;
        if (icon != null && getText() != null)
            offset = (icon.getIconWidth() + getIconTextGap());
        g.fillRect(offset, 0, getWidth() - 1 - offset, getHeight() - 1);

        if (m_selected) {
            g.setColor(m_borderSelectionColor);
            g.drawRect(offset, 0, getWidth() - 1 - offset, getHeight() - 1);
        }
        super.paintComponent(g);
    }
}