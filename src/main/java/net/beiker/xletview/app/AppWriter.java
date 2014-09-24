/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package net.beiker.xletview.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Vector;

import net.beiker.cake.Log;
import net.beiker.cake.Logger;
import net.beiker.xletview.util.Util;
import net.n3.nanoxml.XMLElement;
import net.n3.nanoxml.XMLWriter;

/**
 * Parses the project xml file
 */
public class AppWriter{

	/** Debugging facility. */
	private static final Logger logger = Log.getLogger(AppWriter.class); 
	
//    public static void write(Vector projects, File file){
//         XMLElement root = new XMLElement("PROJECTS");
//         for(int i = 0; i < projects.size(); i++){
//            App project = (App) projects.get(i);
//
//            XMLElement projectElement = new XMLElement("PROJECT");
//
//            XMLElement nameElement = new XMLElement("NAME");
//            nameElement.setContent(project.getName());
//            XMLElement pathElement = new XMLElement("PATH");
//            pathElement.setContent(project.getPath());
//            XMLElement xletElement = new XMLElement("XLET");
//            xletElement.setContent(project.getXletName());
//                        
//            projectElement.addChild(nameElement);
//            projectElement.addChild(pathElement);
//            projectElement.addChild(xletElement);
//            root.addChild(projectElement);
//         }
//        try {
//            FileOutputStream out = new FileOutputStream(file);
//            XMLWriter writer = new XMLWriter(out);
//            writer.write(root, true, 0, false);
//            out.close();
//         } catch (Exception e) {
//            e.printStackTrace();
//         }
//    }
    
    public static void write(URL url, AppGroup group){
        XMLElement root = new XMLElement("APPLICATIONS");
         
        build(group, root);
        
        OutputStream out = null;
        try {	
            out = new FileOutputStream(new File(url.getFile()));
        }
        catch (Exception e1){
        	try{
        		out = url.openConnection().getOutputStream();
        	}
        	catch (Exception e2) {
         	    logger.warn(url.toExternalForm() + Util.getStackTrace(e1) + "*** AND ***" + Util.getStackTrace(e2));               
         	    return;
        	}
         }
        	
        XMLWriter writer = new XMLWriter(out);
        try {
			writer.write(root, true, 0, false);
			out.close();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    private static void build(AppGroup group, XMLElement parent){

//        String name = group.getName();
//        XMLElement element = new XMLElement("GROUP");
//        element.setAttribute("NAME", name);
//        parent.addChild(element);

        // get the subgroups of this group
        Vector subGroups = group.getSubGroups();
        logger.debug(group.getName() + ", children = " +subGroups.size());
        for(int i = 0; i < subGroups.size(); i++){
            AppGroup subGroup = (AppGroup)subGroups.get(i);
            String name = subGroup.getName();
            XMLElement child = new XMLElement("GROUP");
            child.setAttribute("NAME", name);
            parent.addChild(child);
            logger.debug(subGroup.getName());
            // make a recursive call to this method
            build(subGroup, child);
        }
        
        // get the applications in this group
        Vector apps = group.getApps();
        for(int i = 0; i < apps.size(); i++){
            App app = (App) apps.get(i);
            //Debug.info(app.getName());
            XMLElement appElement = new XMLElement("APPLICATION");
            
            XMLElement nameElement = new XMLElement("NAME");
            nameElement.setContent(app.getName());
            XMLElement pathElement = new XMLElement("PATH");
            pathElement.setContent(app.getPath());
            XMLElement xletElement = new XMLElement("XLET");
            xletElement.setContent(app.getXletName());
                        
            appElement.addChild(nameElement);
            appElement.addChild(pathElement);
            appElement.addChild(xletElement);
            parent.addChild(appElement);
            
        }
        
        
    }
    

}
