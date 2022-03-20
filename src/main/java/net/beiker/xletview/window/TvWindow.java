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
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.io.File;
//import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import net.beiker.xletview.ShutDown;
import net.beiker.xletview.app.App;
import net.beiker.xletview.event.EventManager;
import net.beiker.xletview.media.ChannelManager;
import net.beiker.xletview.media.ScreenContainer;
import net.beiker.xletview.remotecontrol.RemoteControl;
import net.beiker.xletview.ui.AppMenu;
import net.beiker.xletview.ui.AppMenuItem;
import net.beiker.xletview.ui.CenterLayout;
import net.beiker.xletview.util.Constants;
import net.beiker.xletview.util.Settings;
import net.beiker.xletview.util.Util;
import net.beiker.xletview.xlet.XletManager;
import net.n3.nanoxml.IXMLElement;
import net.n3.nanoxml.IXMLParser;
import net.n3.nanoxml.IXMLReader;
import net.n3.nanoxml.StdXMLReader;
import net.n3.nanoxml.XMLParserFactory;

/**
 * This is the main window of the emulator
 * @author Martin Sveden
 *
 */
public class TvWindow extends JFrame implements ActionListener {

    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(TvWindow.class.getName());


    public TvWindow() {
        super();

        createMenu();
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        int screenWidth;
        int screenHeight;
        int x = 0;
        int y = 0;

        boolean doCenter = true;

        try {
            String strWidth = Settings.getProperty("tv.screenwidth");
            screenWidth = Integer.parseInt(strWidth);
            String strHeight = Settings.getProperty("tv.screenheight");
            screenHeight = Integer.parseInt(strHeight);
            String strX = Settings.getProperty("tv.x");
            String strY = Settings.getProperty("tv.y");
            doCenter = (Settings.getProperty("tv.center").equals("true")) ? true : false;
            x = Integer.parseInt(strX);
            y = Integer.parseInt(strY);
        }
        catch (Exception e) {
            log.severe(e.toString());
            screenWidth = Util.parseInt(Settings.getProperty("tv.screenwidth"));
            screenHeight = Util.parseInt(Settings.getProperty("tv.screenheight"));
            doCenter = true;
        }

        ScreenContainer tv = ScreenContainer.getInstance();
        tv.setSize(screenWidth, screenHeight);

        // center the tv screen
        JPanel centerCont = new JPanel(new CenterLayout());
        centerCont.setBackground(Color.black);
        centerCont.add(tv);
        container.add(centerCont, BorderLayout.CENTER);

        //container.add(tv, BorderLayout.CENTER);

        if(Settings.getProperty("remote.show").equalsIgnoreCase("true")){


            try {
                InputStream in = Util.getURLConnection(ChannelManager.class, "config/remote_control.xml").getInputStream();
                IXMLReader reader = new StdXMLReader(in);
                IXMLParser parser = XMLParserFactory.createDefaultXMLParser();
                parser.setReader(reader);
                IXMLElement xml = (IXMLElement) parser.parse();
                RemoteControl remote = RemoteControl.getInstance();
                remote.make(xml);
                container.add(remote, BorderLayout.EAST);

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        this.pack();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                // save properties
                doClose();
            }


        });

        this.addComponentListener(new ComponentAdapter(){
            public void componentResized(ComponentEvent e){
                ScreenContainer.getInstance().repaint();
            }
        });

        addWindowFocusListener(new WindowAdapter() {
            public void windowLostFocus(WindowEvent we) {
                EventManager.getInstance().setEventEnabled(false);
            }
            public void windowGainedFocus(WindowEvent e) {
                EventManager.getInstance().setEventEnabled(true);
            }
        });

        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {

            }
        });

        this.setIconImage(Constants.ICON_TVWINDOW);
        this.setTitle(Constants.TITLE);
        this.setResizable(true);


        if (doCenter) {
            Util.center(this);
        }
        else{
            setLocation(x, y);
        }

        // set the first channel
        ChannelManager.getInstance().setChannel(0);
        //System.out.println("<end log file>");
        //ConsoleWindow.getInstance();

        // visibility is set in the startup class

    }


    public void doClose() {
        setVisible(false);
        ShutDown.exit();
    }

    private void createMenu() {
        // menu
        //        menuItems = new Map();
        JMenuBar menuBar = null;
        JMenu menu = null;
        JMenuItem menuItem = null;

        menuBar = new JMenuBar();

        menu = new JMenu("Menu");

//        menuItem = new JMenuItem("About");
//        menuItem.setActionCommand("about");
//        menuItem.addActionListener(this);
//        menu.add(menuItem);

        menuItem = new JMenuItem("Exit");
        menuItem.setActionCommand("exit");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,KeyEvent.ALT_DOWN_MASK));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuBar.add(menu);

//        menu = new JMenu("View");
//
//        menuItem = new JMenuItem("Console Window");
//        menuItem.setActionCommand("console");
//        menuItem.addActionListener(this);
//        menu.add(menuItem);
//        menuBar.add(menu);

        menu = AppMenu.getInstance();

        menuBar.add(menu);

        this.setJMenuBar(menuBar);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (e.getSource() instanceof AppMenuItem) {
            AppMenuItem item = (AppMenuItem) e.getSource();
            App app = item.getApp();
            XletManager.getInstance().setXlet(app.getPath(), app.getXletName());
        }
        else if (command.equals("about")) {
            new AboutWindow(this);
        }
        else if (command.equals("exit")) {
            doClose();
        }
        else if (command.equals("console")) {
            ConsoleWindow.getInstance().setVisible(true);
        }
    }



}
