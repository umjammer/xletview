/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Sveden

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package net.beiker.xletview.window;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import net.beiker.xletview.app.App;
import net.beiker.xletview.app.AppGroup;
import net.beiker.xletview.app.AppManager;
import net.beiker.xletview.ui.AppDataPanel;
import net.beiker.xletview.ui.AppGroupDataPanel;
import net.beiker.xletview.ui.AppMenu;
import net.beiker.xletview.ui.AppTreePanel;
import net.beiker.xletview.ui.tree.TreeListener;
import net.beiker.xletview.ui.tree.UserObject;
import net.beiker.xletview.util.Constants;
import net.beiker.xletview.util.Util;
import net.sourceforge.mlf.metouia.MetouiaLookAndFeel;

/**
 *
 */
public class AppTreeWindow extends JFrame implements ActionListener, TreeListener {

    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(AppTreeWindow.class.getName());

    //private AppTree tree;
    private AppTreePanel tree;
    private JTextField currentSelectionField;
    private JPopupMenu popup;
    private Container content;

    private JButton newGroupButton;
    private JButton newAppButton;
    private JButton deleteButton;

    private AppDataPanel appPanel;
    private AppGroupDataPanel groupPanel;

    public AppTreeWindow() {
        content = getContentPane();

        AppManager manager = AppManager.getInstance();
        //manager.parse();
        AppGroup defaultGroup = manager.getDefaultGroup();

        //tree = new AppTree(defaultGroup);
        tree = new AppTreePanel(defaultGroup);
        tree.setPreferredSize(new Dimension(300, 300));
        tree.addTreeListener(this);
        content.setLayout(new BorderLayout());
        content.add(tree, BorderLayout.CENTER);

        content.add(getButtonPanel(), BorderLayout.EAST);

        content.add(BorderLayout.SOUTH, getSouthPanel());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                //System.exit(0);
                doClose();
            }
        });

        setIconImage(Constants.ICON_DEFAULT);
        setTitle(Constants.TITLE_LAUNCHER);
        setSize(640, 400);

        Util.center(this);

        show();
    }

    public Container getButtonPanel() {
        Container cont = new Container();
        cont.setLayout(new BorderLayout());


        //Box buttonBox = new Box(BoxLayout.Y_AXIS);
        JPanel buttonCont = new JPanel();
        buttonCont.setPreferredSize(new Dimension(350, 60));
        //buttonCont.setLayout(new FlowLayout());
        buttonCont.setLayout(new GridLayout(3, 1));

        newGroupButton = new JButton("New Group");
        newGroupButton.setActionCommand("newgroup");
        newGroupButton.addActionListener(this);
        buttonCont.add(newGroupButton);

        newAppButton = new JButton("New Application");
        newAppButton.setActionCommand("newapp");
        newAppButton.addActionListener(this);
        buttonCont.add(newAppButton);

        deleteButton = new JButton("Delete");
        deleteButton.setActionCommand("delete");
        deleteButton.addActionListener(this);
        buttonCont.add(deleteButton);

        cont.add(BorderLayout.NORTH, buttonCont);

        Container dataCont = new Container();
        dataCont.setLayout(new FlowLayout());

        appPanel = new AppDataPanel(this);
        appPanel.setVisible(false);
        appPanel.setPreferredSize(new Dimension(320, 400));
        dataCont.add(appPanel);

        groupPanel = new AppGroupDataPanel(this);
        groupPanel.setVisible(false);
        groupPanel.setPreferredSize(new Dimension(320, 400));
        dataCont.add(groupPanel);

        cont.add(BorderLayout.CENTER, dataCont);

        return cont;
    }

    private Container getSouthPanel() {
        // buttons
        Container buttonCont = new Container();
        buttonCont.setLayout(new BorderLayout());
        Box buttonBox = new Box(BoxLayout.X_AXIS);
//        JButton cancel = new JButton("CANCEL");
//        cancel.setActionCommand("cancel");
//        cancel.addActionListener(this);
//        buttonBox.add(cancel);
        JButton ok = new JButton("          SAVE & CLOSE          ");
        ok.setActionCommand("ok");
        ok.addActionListener(this);
        buttonBox.add(ok);
        buttonCont.add(BorderLayout.EAST, buttonBox);

        return buttonCont;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("newgroup")) {
            AppGroup group = new AppGroup(null);
            tree.insertGroup(group);

        }
        else if (command.equals("newapp")) {
            App app = new App(null, null, null);
            tree.insertApp(app);
        }
        else if (command.equals("delete")) {
            log.fine("delete");
            tree.removeSelected();
        }
        else if (command.equals("ok")) {
            appPanel.save();
            groupPanel.save();
            AppManager.getInstance().update();
            AppMenu.getInstance().update();
            doClose();

        }
        else if (command.equals("cancel")) {
            log.fine("cancel");

        }
    }

    public void updateNodeText() {
        Object userObject = tree.getSelectedNode().getUserObject();
        if (userObject instanceof UserObject) {
            Object object = ((UserObject) userObject).getObject();
            if (object instanceof AppGroup) {
                AppGroup group = (AppGroup) object;
                tree.getSelectedNode().setUserObject(group);
                tree.getModel().nodeStructureChanged(tree.getSelectedNode());
                //tree.getModel().reload();
            }
            else if (object instanceof App) {
                App app = (App) object;
                tree.getSelectedNode().setUserObject(app);
                tree.getModel().nodeStructureChanged(tree.getSelectedNode());
                //tree.getModel().reload();
            }
        }
    }

    public void pathChanged(TreePath path) {

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
        Object userObject = node.getUserObject();
        if (userObject instanceof UserObject) {
            Object object = ((UserObject) userObject).getObject();

            if (object instanceof AppGroup) {
                AppGroup group = (AppGroup) object;
                if(group == AppManager.getInstance().getDefaultGroup()){
                    deleteButton.setEnabled(false);
                }
                else{
                    deleteButton.setEnabled(true);
                }
                newAppButton.setEnabled(true);
                newGroupButton.setEnabled(true);
                appPanel.setVisible(false);
                groupPanel.setVisible(true);
                groupPanel.setAppGroup(group);
            }
            else if (object instanceof App) {
                App app = (App) object;
                deleteButton.setEnabled(true);
                newAppButton.setEnabled(false);
                newGroupButton.setEnabled(false);
                appPanel.setVisible(true);
                groupPanel.setVisible(false);
                appPanel.setApp(app);
            }
        }

    }

    private void doClose() {
        this.dispose();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new MetouiaLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException exception) {
            exception.printStackTrace();
        }
        new AppTreeWindow();
    }

}
