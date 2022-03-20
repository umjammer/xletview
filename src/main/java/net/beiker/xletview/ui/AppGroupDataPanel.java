/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Sveden

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package net.beiker.xletview.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;

import net.beiker.xletview.app.AppGroup;
import net.beiker.xletview.app.AppManager;
import net.beiker.xletview.window.AppTreeWindow;

/**
 * @author Martin Sveden
 */
public class AppGroupDataPanel extends JPanel implements KeyListener {

    public final static int NAME = 0;

    private AppTreeWindow appWin;

    private AppGroup group;
    private DefaultMutableTreeNode node;

    private Container content;
    private JTextField[] fields;
    private JButton[] fieldButtons;
    private JLabel[] fieldLabels;

    public AppGroupDataPanel(AppTreeWindow appWin) {
        this.appWin = appWin;
        content = new Container();
        content.setLayout(new BorderLayout());

        Container inputs = new Container();
        inputs.setLayout(new FlowLayout());

        Box container = new Box(BoxLayout.Y_AXIS);
        Box[] rows = new Box[4];

        // input fields
        fields = new JTextField[1];
        fieldButtons = new JButton[1];
        fieldLabels = new JLabel[1];

        fieldLabels[NAME] = new JLabel("Name: ", JLabel.RIGHT);
        fieldLabels[NAME].setPreferredSize(new Dimension(60, 20));
        fields[NAME] = new JTextField(20);
        fields[NAME].addKeyListener(this);
        rows[0] = new Box(BoxLayout.X_AXIS);
        rows[0].add(fieldLabels[NAME]);
        rows[0].add(fields[NAME]);
        container.add(rows[0]);



        //content.add(BorderLayout.NORTH, container);
        inputs.add(container);
        content.add(BorderLayout.CENTER, inputs);

        add(content);

    }

//    public AppGroupDataPanel() {
//        this(null);
//    }

//    public void setNode(DefaultMutableTreeNode node) {
//        save();
//        Object userObject = node.getUserObject();
//        if (userObject instanceof IconData) {
//            Object object = ((IconData) userObject).getObject();
//            if (object instanceof AppGroup) {
//                this.group = (AppGroup) object;
//                fields[NAME].setText(group.getName());
//            }
//        }
//
//    }


    /**
     * Saves the data for previous App and displays the data for the new one.
     * @param app the new App
     */
    public void setAppGroup(AppGroup group) {
        save();
        if(group == AppManager.getInstance().getDefaultGroup()){
            fields[NAME].setEditable(false);
        }
        else{
            fields[NAME].setEditable(true);
        }
        fields[NAME].setText(group.getName());
        this.group = group;
    }

    /**
     * Saves the data to the active App
     *
     */
    public void save(){
        if (this.group != null) {
            //node.setUserObject(new IconData(null, null, group, group.getName()));
            this.group.setName(fields[NAME].getText());
        }
    }


    public boolean isOk() {
        //int option = JOptionPane.showConfirmDialog(this, "nu blev det fel", "Remove", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
        String message = "The following field(s) can not be empty:\n";
        boolean ok = true;
        if (fields[NAME].getText().trim().equals("")) {
            String s = fieldLabels[NAME].getText();
            s = s.substring(0, s.lastIndexOf(":"));
            message += "- " + s + "\n";
            ok = false;
        }
        return true;
    }

    public void keyTyped(KeyEvent arg0) {

    }

    public void keyPressed(KeyEvent arg0) {

    }

    public void keyReleased(KeyEvent arg0) {
        save();
        appWin.updateNodeText();
    }

}
