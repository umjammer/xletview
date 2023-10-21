/*
 * This file is part of XleTView
 * Copyright (C) 2003 Martin SvedÈn
 *
 * This is free software, and you are
 * welcome to redistribute it under
 * certain conditions;
 *
 * See LICENSE document for details.
 */

package net.beiker.xletview.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class Constants {

    private Constants() {}

    public static final String VERSION = "0.3.6.2";

    public static final String DISCLAIMER_MESSAGE = """
            ********************************************************
            XleTView, Copyright (C) 2003 - 2004 Martin Sveden\s
            XleTView comes with ABSOLUTELY NO WARRANTY.
            Constants is free software, and you are welcome to redistribute\s
            it under certain conditions;\s
            see license document for details.
            ********************************************************""";

    public static final Image ICON_DEFAULT;
    public static final Image ICON_CONSOLE;
    public static final Image ICON_TVWINDOW;
    public static final Image ICON_TVLOGO;
    public static final Image IMAGE_SPLASH;

    public static final Image IMAGE_TVGUI_TITLE;
    public static final Image IMAGE_TVGUI_MINIMIZE;
    public static final Image IMAGE_TVGUI_MAXIMIZE;
    public static final Image IMAGE_TVGUI_RESTORE;
    public static final Image IMAGE_TVGUI_CLOSE;

    public static final ImageIcon ICON_COMPUTER;
    public static final ImageIcon ICON_DISK;
    public static final ImageIcon ICON_FOLDER;
    public static final ImageIcon ICON_EXPANDEDFOLDER;
    public static final ImageIcon ICON_XLET;
    public static final ImageIcon ICON_J;


    public static URL URL_LOGO_WIZARD_TOP;

    public static final String PATH_PROJECT_FILE = "config/projects.xml";
    //public static final String PATH_CONFIG_FILE   = "config/settings.xml";
    public static final String PATH_SETTINGS = "config/settings.txt";
    public static final String DEFAULT_BG = "config/defaultbg.jpg";
    public static final String PATH_APPDIR = "application/";

    public static final String TITLE = "XleTView";
    public static final String TITLE_LAUNCHER = "XleTView";
    public static final String TITLE_CONSOLE = "Console - XleTView";
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
    public static final Font FONT_NORMAL = new Font("Arial", Font.PLAIN, 16);

    /*
     * Colors
     */
    public static final Color COLOR_DEFAULT_BG = new Color(239, 239, 231);

    // default value of some settings
//    public static final int TVSCREEN_DEFAULT_WIDTH  = 720;
//    public static final int TVSCREEN_DEFAULT_HEIGHT = 576;

    public static String EMULATOR_HOME;

    static {
        try {
            ICON_DEFAULT = ImageIO.read(Constants.class.getResource("/img/icon_32.png"));
            ICON_CONSOLE = ImageIO.read(Constants.class.getResource("/img/icon_32.png"));
            ICON_TVWINDOW = ImageIO.read(Constants.class.getResource("/img/icon_32.png"));
            ICON_TVLOGO = ImageIO.read(Constants.class.getResource("/img/window_logo.png"));

            IMAGE_TVGUI_TITLE = ImageIO.read(Constants.class.getResource("/img/xletview.png"));
            IMAGE_TVGUI_MINIMIZE = ImageIO.read(Constants.class.getResource("/img/window_minimize.png"));
            IMAGE_TVGUI_MAXIMIZE = ImageIO.read(Constants.class.getResource("/img/window_maximize.png"));
            IMAGE_TVGUI_RESTORE = ImageIO.read(Constants.class.getResource("/img/window_restore.png"));
            IMAGE_TVGUI_CLOSE = ImageIO.read(Constants.class.getResource("/img/window_close.png"));

            ICON_COMPUTER = new ImageIcon(Constants.class.getResource("/img/icon_computer.png"));
            ICON_DISK = new ImageIcon(Constants.class.getResource("/img/icon_drive.png"));
            ICON_FOLDER = new ImageIcon(Constants.class.getResource("/img/icon_folder_closed.png"));
            ICON_EXPANDEDFOLDER = new ImageIcon(Constants.class.getResource("/img/icon_folder_open.png"));
            //ICON_XLET = new ImageIcon(Constants.class.getResource("/img/icon_xlet.png"));
            ICON_XLET = new ImageIcon(Constants.class.getResource("/img/icon_16_border.png"));
            ICON_J = new ImageIcon(Constants.class.getResource("/img/icon_j.png"));

            IMAGE_SPLASH = ImageIO.read(Constants.class.getResource("/img/splash.png"));

            URL_LOGO_WIZARD_TOP = Constants.class.getResource("/img/logo_x_black_transp.png");
        } catch (IOException | IllegalArgumentException e) {
            throw new IllegalStateException(e);
        }
    }
}
