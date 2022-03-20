/*

 This file is part of XleTView
 Copyright (C) 2003 Martin Sveden

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package net.beiker.xletview.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;

public class Constants{

    private static final Constants THE_INSTANCE = new Constants();

    public static final String VERSION = "0.3.6.2";


    public static final String DISCLAIMER_MESSAGE = "" +
         "********************************************************\n" +
         "XleTView, Copyright (C) 2003 - 2004 Martin Sveden \n" +
         "XleTView comes with ABSOLUTELY NO WARRANTY.\n" +
         "This is free software, and you are welcome to redistribute \n" +
         "it under certain conditions; \n" +
         "see license document for details.\n" +
         "********************************************************";

    private static Toolkit toolkit;
    public static Image ICON_DEFAULT;
    public static Image ICON_CONSOLE;
    public static Image ICON_TVWINDOW;
    public static Image ICON_TVLOGO;
    public static Image IMAGE_SPLASH;

    public static Image IMAGE_TVGUI_TITLE;
    public static Image IMAGE_TVGUI_MINIMIZE;
    public static Image IMAGE_TVGUI_MAXIMIZE;
    public static Image IMAGE_TVGUI_RESTORE;
    public static Image IMAGE_TVGUI_CLOSE;

    public static ImageIcon ICON_COMPUTER;
    public static ImageIcon ICON_DISK;
    public static ImageIcon ICON_FOLDER;
    public static ImageIcon ICON_EXPANDEDFOLDER;
    public static ImageIcon ICON_XLET;
    public static ImageIcon ICON_J;


    public static URL URL_LOGO_WIZARD_TOP;

    public static final String PATH_PROJECT_FILE   = "config/projects.xml";
    //public static final String PATH_CONFIG_FILE   = "config/settings.xml";
    public static final String PATH_SETTINGS   = "config/settings.txt";
    public static final String DEFAULT_BG     = "config/defaultbg.jpg";
    public static final String PATH_APPDIR    = "application/";

    public static final String TITLE          = "XleTView";
    public static final String TITLE_LAUNCHER = "XleTView";
    public static final String TITLE_CONSOLE  = "Console - XleTView";
    public static final String TITLE_TVWINDOW = "TV - XleTView";


//    public static final String TVGUI_TITLE    = "img/xletview.png";
//    public static final String TVGUI_MINIMIZE = "img/window_minimize.png";
//    public static final String TVGUI_MAXIMIZE = "img/window_maximize.png";
//    public static final String TVGUI_RESTORE  = "img/window_restore.png";
//    public static final String TVGUI_CLOSE    = "img/window_close.png";


    /*
     * Fonts
     */
    public static final Font FONT_HEADER_NORMAL = new Font("Arial", Font.BOLD, 22);
    public static final Font FONT_NORMAL        = new Font("Arial", Font.PLAIN, 16);

    /*
     * Colors
     */
     public static final Color COLOR_DEFAULT_BG = new Color(239, 239, 231);

    // default value of some settings
//    public static final int TVSCREEN_DEFAULT_WIDTH  = 720;
//    public static final int TVSCREEN_DEFAULT_HEIGHT = 576;

    public static String EMULATOR_HOME;


    private Constants(){
        toolkit = Toolkit.getDefaultToolkit();
        ICON_DEFAULT  = toolkit.getImage(this.getClass().getResource("/img/icon_32.png"));
        ICON_CONSOLE  = toolkit.getImage(this.getClass().getResource("/img/icon_32.png"));
        ICON_TVWINDOW = toolkit.getImage(this.getClass().getResource("/img/icon_32.png"));
        ICON_TVLOGO = toolkit.getImage(this.getClass().getResource("/img/window_logo.png"));

        IMAGE_TVGUI_TITLE = toolkit.getImage(this.getClass().getResource("/img/xletview.png"));
        IMAGE_TVGUI_MINIMIZE = toolkit.getImage(this.getClass().getResource("/img/window_minimize.png"));
        IMAGE_TVGUI_MAXIMIZE = toolkit.getImage(this.getClass().getResource("/img/window_maximize.png"));
        IMAGE_TVGUI_RESTORE = toolkit.getImage(this.getClass().getResource("/img/window_restore.png"));
        IMAGE_TVGUI_CLOSE = toolkit.getImage(this.getClass().getResource("/img/window_close.png"));

        ICON_COMPUTER = new ImageIcon(this.getClass().getResource("/img/icon_computer.png"));
        ICON_DISK = new ImageIcon(this.getClass().getResource("/img/icon_drive.png"));
        ICON_FOLDER = new ImageIcon(this.getClass().getResource("/img/icon_folder_closed.png"));
        ICON_EXPANDEDFOLDER = new ImageIcon(this.getClass().getResource("/img/icon_folder_open.png"));
        //ICON_XLET = new ImageIcon(this.getClass().getResource("/img/icon_xlet.png"));
        ICON_XLET = new ImageIcon(this.getClass().getResource("/img/icon_16_border.png"));
        ICON_J = new ImageIcon(this.getClass().getResource("/img/icon_j.png"));

        IMAGE_SPLASH = toolkit.getImage(this.getClass().getResource("/img/splash.png"));

        URL_LOGO_WIZARD_TOP = this.getClass().getResource("/img/logo_x_black_transp.png");


    }

}
