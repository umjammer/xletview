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
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import net.beiker.xletview.io.FileFilterImpl;
import net.beiker.xletview.util.Util;



/**
 * @author Martin Sveden
 *
 */
public class ClassWindow extends JDialog implements ActionListener {

    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(ClassWindow.class.getName());

    private Container content;
    private JList<String> list;
    private int dirCount;
    private List<String> classes;
    private File homeDir;

    public ClassWindow(Frame owner, File dir) {
        super(owner, true);
        homeDir = dir;
        if(!dir.isDirectory()){
            JOptionPane.showMessageDialog(null, dir.getPath() + "\nDoes not exist!", "Alert", JOptionPane.ERROR_MESSAGE);
        }
        classes = new ArrayList<>();
        list = new JList<>();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        resolve(dir);

        list.setListData(classes.toArray(new String[classes.size()]));


        content = getContentPane();
        content.setLayout(new BorderLayout());

        JScrollPane scroll = new JScrollPane(list);
        scroll.setSize(new Dimension(200, 200));
        content.add(scroll, BorderLayout.CENTER);

        // buttons
        Container buttonCont = new Container();
        buttonCont.setLayout(new BorderLayout());
        Box buttonBox = new Box(BoxLayout.X_AXIS);
        JButton cancel = new JButton("CANCEL");
        cancel.setActionCommand("cancel");
        cancel.addActionListener(this);
        buttonBox.add(cancel);
        JButton ok = new JButton("          OK          ");
        ok.setActionCommand("ok");
        ok.addActionListener(this);
        buttonBox.add(ok);
        buttonCont.add(BorderLayout.EAST, buttonBox);
        content.add(BorderLayout.SOUTH, buttonCont);



        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                doClose();
            }
        });

        setTitle("");
        setSize(400, 400);
        Util.center(this);
        setVisible(true);
    }

    /**
     * Works through a directory recursivly to find all class files
     * @param dir
     */
    private void resolve(File dir){
            File[] files = dir.listFiles(new FileFilterImpl(".class"));
            if(files != null){
                for(int i = 0; i < files.length; i++){
                    if(files[i].isDirectory()){
                        dirCount++;
                        if(dirCount > 50){
                            JOptionPane.showMessageDialog(null, "\nUnable to resolve the application in this directory:\n" + homeDir.getPath(), "Alert", JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                        else{
                            resolve(files[i]);
                        }
                    }
                    else{
                        String unformattedClassName = files[i].getPath().substring(homeDir.getPath().length()+1);
                        String formattedClassName = getClassName(unformattedClassName);
                        classes.add(formattedClassName);
                        log.fine("" + formattedClassName);
                    }
                }
            }

    }

    private String getClassName(String path){
        String className;
        className = path.replace(File.separatorChar, '.');
        className = className.replaceAll(".class", "");
        className = className.replaceAll(".CLASS", "");
        return className;
    }

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.equals("cancel")) {
            doClose();
        }
        else if (command.equals("ok")) {
            if(list.getSelectedValue() != null){
                doClose();
            }
            else{
                JOptionPane.showMessageDialog(null, "You have not selected any class yet", "Alert", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public String getValue(){
        return (String)list.getSelectedValue();
    }

    private void doClose() {
        dispose();
    }

    public static void main(String[] args) {
        File f = new File("C:\\myIconDocs\\projects\\Mediaset\\Peugeot\\classes");
        new ClassWindow(null, f);
    }

}
