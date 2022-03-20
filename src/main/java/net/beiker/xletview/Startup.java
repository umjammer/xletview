/*
 *
 * This file is part of XleTView Copyright (C) 2003 Martin Sveden
 *
 * This is free software, and you are welcome to redistribute it under certain
 * conditions;
 *
 * See LICENSE document for details.
 *
 */

package net.beiker.xletview;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.beiker.xletview.classloader.MainClassLoader;
import net.beiker.xletview.util.CommandLine;
import net.beiker.xletview.util.Constants;
import net.beiker.xletview.util.Settings;
import net.beiker.xletview.util.Util;
import net.beiker.xletview.window.SplashWindow;
import net.beiker.xletview.window.TvWindow;
import net.beiker.xletview.xlet.XletManager;
import net.sourceforge.mlf.metouia.MetouiaLookAndFeel;


public class Startup {

    SplashWindow splash;
    protected int minSplashMs = 0;//2000;
    protected long start;
    protected long end;

    /** Debugging facility. */
    private final static Logger logger = Logger.getLogger(Startup.class.getName());

    public Startup(String[] args) {

        try {
            UIManager.setLookAndFeel(new MetouiaLookAndFeel());
            UIManager.getLookAndFeelDefaults().put("ClassLoader", this.getClass().getClassLoader());
        }
        catch (UnsupportedLookAndFeelException exception) {
            exception.printStackTrace();
        }


        String xPath = "";
        String[] xExtraPaths = null;
        String xName = "";

        int command = CommandLine.check(args);
        if (command == CommandLine.XLET_IS_SET) {
            xPath = CommandLine.getXletPath();
            xExtraPaths = CommandLine.getXletExtraPaths();
            xName = CommandLine.getXletName();
        }

        // create splash
        createSplash();

        // do the following on the gui thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showSplash();
                Startup.this.start = System.currentTimeMillis();
            }
        });


        this.splash.setMessage("Setting system variables...");

        setProperties();

        this.splash.setMessage("Initializing windows...");

        final TvWindow mainFrame = new TvWindow();

        if (xPath.length() > 0 && xName.length() > 0) {
            this.splash.setMessage("Setting xlet from command line...");

            URL url = pathString2URL(xPath);

            if (url != null){
                Startup.logger.fine("Xlet URL is '"+url.toExternalForm()+"'");
            }

            if (xExtraPaths != null){

                int numExtraPaths = xExtraPaths.length;
                Startup.logger.fine("Xlet has '"+numExtraPaths+"' extra paths...");

                URL[] xExtraPathURLs = new URL[numExtraPaths];
                for (int i=0; i<numExtraPaths; i++){
                    Startup.logger.fine("Processing extra path '"+xExtraPaths[i]+"'.");
                    xExtraPathURLs[i] = pathString2URL(xExtraPaths[i]);
                }
                Startup.logger.fine("Processed all extra paths.");
                XletManager.getInstance().setXlet(url, xExtraPathURLs, xName);
            }
            else { // no Extra paths
                Startup.logger.fine("Xlet has NO extra paths.");
                XletManager.getInstance().setXlet(url, xName);
            }
        }

        this.splash.setMessage("Loading finished, starting...");

        // show prog and hide splash
        SwingUtilities.invokeLater(() -> {
            Startup.this.end = System.currentTimeMillis();
            long diff = Startup.this.minSplashMs - (Startup.this.end - Startup.this.start);
            if (diff > 0) {
                try {
                    Thread.sleep(diff);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

				mainFrame.show();
				mainFrame.toFront();

            hideSplash();
        });
    }

    /**
     * @param path
     * @return
     */
    // TODO: Move somewhere appropriate
    public static URL pathString2URL(String path) {
        URL url = null;
        try{
            url = new URL(path);
        }
        catch (MalformedURLException mue){
            Startup.logger.fine("Xlet Path is not an URL, trying to prefix with 'file:'.");
            try {
                url = new URL("file:"+path);
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return url;
    }

    protected void createSplash() {
        this.splash = new SplashWindow();
    }

    protected void showSplash() {
        this.splash.setVisible(true);
    }

    protected void hideSplash() {
        this.splash.hideSplash();
        this.splash = null;
    }

    private void setProperties() {
        try {
            Startup.logger.fine("setting properties...");
            //String settingsPath = Util.getURLConnection(Startup.class, Constants.PATH_SETTINGS);
            //File settingsFile = new File(settingsPath);
            //Settings.load(settingsFile);

            InputStream settingsInputStream = Util.getURLConnection(Startup.class, Constants.PATH_SETTINGS).getInputStream();
            Settings.load(settingsInputStream);


            /*
             * I removed the file name normalization here because I found that the Win32 version would not
             * longer be able to find the resources. [Enver <enver.haase@gmx.de> on 07-Jan-2004]
             * See ChannelManager's
             * "media = new Media(Util.getURL(ChannelManager.class, Settings.getProperty("file.defaultbg")));"
             * which would result in "config\defaultbg.jpg" NOT to be found, but "config/defaultbg.jpg" is okay
             * even on a Win32 platform.
             * Funny thing is that under Linux, both variants would be found. Maybe it's an error in the JDK.
             */
            Settings.setProperty("path.home", new File("").getAbsolutePath() + File.separator);
            /*
            Settings.setProperty("path.home", Util.normalizePath(new File("").getAbsolutePath() + File.separator));
            Settings.setProperty("file.settings", Util.normalizePath(Settings.getProperty("file.settings")));
            Settings.setProperty("file.defaultbg", Util.normalizePath(Settings.getProperty("file.defaultbg")));
            */

            String extraClassPath = Settings.getProperty("extra.classpath");

            ClassLoader classLoader = getClass().getClassLoader();

            if(classLoader instanceof MainClassLoader && extraClassPath != null){
                ((MainClassLoader) classLoader ).addClassPath(extraClassPath);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        try {
            // set Font size offest for Xlets
            String s = Settings.getProperty("font.sizeoffset");
            xjava.awt.Font.setOffset(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
