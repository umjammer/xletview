/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Sveden

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package net.beiker.xletview.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import net.beiker.xletview.app.App;
import net.beiker.xletview.app.AppGroup;
import net.beiker.xletview.app.AppManager;
import net.beiker.xletview.util.Constants;
import net.beiker.xletview.window.AppTreeWindow;
import net.beiker.xletview.xlet.XletManager;


/**
 * @author Martin Sveden
 */
public class AppMenu extends JMenu implements ActionListener{

    private static final Logger log = Logger.getLogger(AppMenu.class.getName());

    private static AppMenu THE_INSTANCE;

    private AppMenu(){
        super("Applications");
        update();
    }

    public static AppMenu getInstance(){
        if(THE_INSTANCE == null){
            THE_INSTANCE = new AppMenu();
        }
        return THE_INSTANCE;
    }

    public void update(){
        buildAppMenu();
    }

    private void buildAppMenu(){
        JMenuItem menuItem;

        removeAll();

        AppManager.getInstance().update();
        AppGroup defGroup = AppManager.getInstance().getDefaultGroup();
        List<?> applications = defGroup.getApps();
        log.fine("projects.size() = " + applications.size());


//        menuItem = new JMenuItem("Add new...");
//        menuItem.setActionCommand("new");
//        menuItem.addActionListener(this);
//        add(menuItem);

        menuItem = new JMenuItem("Manage applications...");
        menuItem.setActionCommand("config");
        menuItem.addActionListener(this);
        add(menuItem);

        addSeparator();

        menuItem = new JMenuItem("Reload Current");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,KeyEvent.CTRL_DOWN_MASK));
        menuItem.setActionCommand("reload");
        menuItem.addActionListener(this);
        add(menuItem);

        addSeparator();

        buildAppMenu(this, defGroup);


    }

  private JMenu buildAppMenu(JMenu menu, AppGroup group){
      AppMenuItem item;
      JMenu submenu;
      List<?> subGroups = group.getSubGroups();
      for(int i = 0; i < subGroups.size(); i++){
          AppGroup subGroup = (AppGroup)subGroups.get(i);
          submenu = new JMenu(subGroup.getName());
          submenu.setIcon(Constants.ICON_FOLDER);
          menu.add(submenu);
          buildAppMenu(submenu, subGroup);
          //menu.addSeparator();
      }
      List<?> apps = group.getApps();
//      if(apps.size() > 0){
//        menu.addSeparator();
//      }

      for (int i = 0; i < apps.size(); i++) {
          App app = (App) apps.get(i);
          item = new AppMenuItem(app);
          item.setIcon(Constants.ICON_XLET);
          item.addActionListener(this);
          menu.add(item);
      }
      if(apps.size() == 0 && subGroups.size() == 0 && group != AppManager.getInstance().getDefaultGroup()){
          JMenuItem emptyItem = new JMenuItem("(empty)");
          menu.add(emptyItem);
      }
      return menu;
  }
//    private void buildAppMenu(AppGroup group){
//        Debug.write(this, group.getName());
//        AppMenuItem item;
//        JMenu submenu;
//        List subGroups = group.getChildren();
//        for(int i = 0; i < subGroups.size(); i++){
//            AppGroup subGroup = (AppGroup)subGroups.get(i);
//            submenu = new JMenu(subGroup.getName());
//            add(submenu);
//            buildAppMenu(subGroup);
//        }
//        addSeparator();
//        List apps = group.getApps();
//        for (int i = 0; i < apps.size(); i++) {
//            App app = (App) apps.get(i);
//            item = new AppMenuItem(app);
//            item.addActionListener(this);
//            add(item);
//        }
//    }

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (event.getSource() instanceof AppMenuItem) {
            AppMenuItem item = (AppMenuItem) event.getSource();
            App app = item.getApp();
            log.fine(app.getPath());
            XletManager.getInstance().setXlet(app.getPath(), app.getXletName());
        }
        else if (command.equals("reload")) {
            XletManager.getInstance().reloadActiveXlet();
        }
        else if (command.equals("config")) {
            //new AppWizardWindow();
            new AppTreeWindow();
        }

    }

}
