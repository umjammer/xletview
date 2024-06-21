/*
 * This file is part of XleTView
 * Copyright (C) 2003 Martin Sveden
 *
 * This is free software, and you are
 * welcome to redistribute it under
 * certain conditions;
 *
 * See LICENSE document for details.
 */

package net.beiker.xletview.app;

import java.io.InputStream;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.URL;
import java.util.List;

import net.beiker.xletview.util.Settings;
import net.beiker.xletview.util.Util;
import net.n3.nanoxml.IXMLElement;
import net.n3.nanoxml.IXMLParser;
import net.n3.nanoxml.IXMLReader;
import net.n3.nanoxml.StdXMLReader;
import net.n3.nanoxml.XMLParserFactory;

import static java.lang.System.getLogger;


/**
 * AppManager
 *
 * @author Martin Sveden
 */
public class AppManager {

    private static final Logger logger = getLogger(AppManager.class.getName());
    private final static String FILE_APPLICATIONS = "file.applications";
    private static AppManager THE_INSTANCE;
    private final URL appURL;
    private final AppGroup defaultGroup;

    private AppManager() {
        this.appURL = Util.getURL(AppManager.class, Settings.getProperty(FILE_APPLICATIONS));
        this.defaultGroup = new AppGroup("Default group");
        parse();
    }

    public static AppManager getInstance() {
        if (THE_INSTANCE == null) {
            THE_INSTANCE = new AppManager();
        }
        return THE_INSTANCE;
    }

    public static void main(String[] args) {
        AppManager.getInstance().parse();
        AppGroup defaultGroup = AppManager.getInstance().getDefaultGroup();

        for (int i = 0; i < defaultGroup.getApps().size(); i++) {
            App app = defaultGroup.getApps().get(i);
        }
        for (int i = 0; i < defaultGroup.getSubGroups().size(); i++) {
            AppGroup app = defaultGroup.getSubGroups().get(i);
        }
//logger.log(Level.DEBUG, defaultGroup.getName());
//logger.log(Level.DEBUG, defaultGroup.getSubGroups().size());
    }

    private void parse() {
        IXMLElement xml;
        try {
            IXMLParser parser = XMLParserFactory.createDefaultXMLParser();
//            FileInputStream in = new FileInputStream(new File("config/applications.xml"));

//            FileInputStream in = new FileInputStream(this.appFile);
            InputStream in = AppManager.class.getClassLoader().getResourceAsStream(Settings.getProperty(FILE_APPLICATIONS));
            IXMLReader reader = new StdXMLReader(in);
            parser.setReader(reader);
            xml = (IXMLElement) parser.parse();
            if (xml != null) {
                resolve(xml, this.defaultGroup);
            }
        } catch (Exception e) {
            logger.log(Level.DEBUG, e.toString(), e);
//logger.log(Level.DEBUG, "####");
//logger.log(Level.DEBUG, "Error reading " + appFile.getPath());
        }
    }

    private void resolve(IXMLElement element, AppGroup group) {

        // get the subgroups of this group
        List<?> subGroups = element.getChildrenNamed("GROUP");
        for (Object subGroup : subGroups) {
            IXMLElement elm = (IXMLElement) subGroup;
            AppGroup newGroup = new AppGroup(elm.getAttribute("NAME", null));
            group.addChild(newGroup);
            resolve(elm, newGroup);
        }

        // get the applications in this group
        List<?> apps = element.getChildrenNamed("APPLICATION");
        for (Object o : apps) {

            App app;
            IXMLElement elm = (IXMLElement) o;
            String name = "";
            String path = "";
            String xlet = "";
            try {
                name = ((IXMLElement) elm.getChildrenNamed("NAME").get(0)).getContent();
                path = ((IXMLElement) elm.getChildrenNamed("PATH").get(0)).getContent();
                xlet = ((IXMLElement) elm.getChildrenNamed("XLET").get(0)).getContent();

                app = new App(name, path, xlet);
                group.addApp(app);
//                projects.add(project);
            } catch (Exception e) {
                // we will have exceptions, the above is made that way so don't output the errors
            }
        }
    }

    public AppGroup getDefaultGroup() {
        return this.defaultGroup;
    }

    public void update() {
        AppWriter.write(this.appURL, this.defaultGroup);
    }
}
