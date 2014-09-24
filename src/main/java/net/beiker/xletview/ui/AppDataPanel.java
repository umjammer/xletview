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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.beiker.cake.Log;
import net.beiker.cake.Logger;
import net.beiker.xletview.app.App;
import net.beiker.xletview.app.AppManager;
import net.beiker.xletview.remotecontrol.RemoteControl;
import net.beiker.xletview.util.Util;
import net.beiker.xletview.window.AppTreeWindow;
import net.beiker.xletview.window.ClassWindow;
import net.beiker.xletview.window.DirectoryExplorer;

/**
 * @author Martin Sveden
 */
public class AppDataPanel extends JPanel implements ActionListener, KeyListener {

	private static final Logger log = Log.getLogger(RemoteControl.class);
	
    private AppTreeWindow appWin;
    private App app;

    public final static int NAME = 0;
    public final static int CLASSPATH = 1;
    public final static int XLETNAME = 2;

    private Container content;
    private JTextField[] fields;
    private JButton[] fieldButtons;
    private JLabel[] fieldLabels;

    public AppDataPanel(AppTreeWindow appWin) {
        this.appWin = appWin;
        content = new Container();
        content.setLayout(new BorderLayout());

        Container inputs = new Container();
        inputs.setLayout(new FlowLayout());

        Box container = new Box(BoxLayout.Y_AXIS);
        Box[] rows = new Box[4];

        // input fields
        fields = new JTextField[3];
        fieldButtons = new JButton[3];
        fieldLabels = new JLabel[3];

        fieldLabels[NAME] = new JLabel("Name: ", JLabel.RIGHT);
        fieldLabels[NAME].setPreferredSize(new Dimension(60, 20));
        fields[NAME] = new JTextField(20);
        fields[NAME].addKeyListener(this);
        rows[0] = new Box(BoxLayout.X_AXIS);
        rows[0].add(fieldLabels[NAME]);
        rows[0].add(fields[NAME]);
        container.add(rows[0]);

        fieldLabels[CLASSPATH] = new JLabel("Path: ", JLabel.RIGHT);
        fieldLabels[CLASSPATH].setPreferredSize(new Dimension(60, 20));
        fields[CLASSPATH] = new JTextField(20);
        fieldButtons[CLASSPATH] = new JButton("..");
        fieldButtons[CLASSPATH].setActionCommand("classpath");
        fieldButtons[CLASSPATH].addActionListener(this);
        rows[1] = new Box(BoxLayout.X_AXIS);
        rows[1].add(fieldLabels[CLASSPATH]);
        rows[1].add(fields[CLASSPATH]);
        rows[1].add(fieldButtons[CLASSPATH]);
        container.add(rows[1]);

        fieldLabels[XLETNAME] = new JLabel("Xlet: ", JLabel.RIGHT);
        fieldLabels[XLETNAME].setPreferredSize(new Dimension(60, 20));
        fields[XLETNAME] = new JTextField(20);
        fieldButtons[XLETNAME] = new JButton("..");
        fieldButtons[XLETNAME].setActionCommand("xletname");
        fieldButtons[XLETNAME].addActionListener(this);
        rows[2] = new Box(BoxLayout.X_AXIS);
        rows[2].add(fieldLabels[XLETNAME]);
        rows[2].add(fields[XLETNAME]);
        rows[2].add(fieldButtons[XLETNAME]);
        container.add(rows[2]);

        if (app != null) {
            fields[NAME].setText(app.getName());
            fields[CLASSPATH].setText(app.getPath());
            fields[XLETNAME].setText(app.getXletName());
        }

        //content.add(BorderLayout.NORTH, container);
        inputs.add(container);
        content.add(BorderLayout.CENTER, inputs);

        // buttons
        Container buttonCont = new Container();
//        buttonCont.setLayout(new BorderLayout());
//        Box buttonBox = new Box(BoxLayout.X_AXIS);
//        JButton cancel = new JButton("CANCEL");
//        cancel.setActionCommand("cancel");
//        cancel.addActionListener(this);
//        buttonBox.add(cancel);
//        JButton ok = new JButton("          OK          ");
//        ok.setActionCommand("ok");
//        ok.addActionListener(this);
//        buttonBox.add(ok);
//        buttonCont.add(BorderLayout.EAST, buttonBox);
//        content.add(BorderLayout.SOUTH, buttonCont);

        add(content);

    }

//    public AppDataPanel() {
//        this(null);
//    }

    /**
     * Saves the data for previous App and displays the data for the new one.
     * @param app the new App
     */
    public void setApp(App app) {
        save();
        fields[NAME].setText(app.getName());
        fields[CLASSPATH].setText(app.getPath());
        fields[XLETNAME].setText(app.getXletName());
        this.app = app;
    }
    
    /**
     * Saves the data to the active App
     *
     */
    public void save(){
        if (this.app != null) {
            this.app.setName(fields[NAME].getText());
            this.app.setPath(fields[CLASSPATH].getText());
            this.app.setXletName(fields[XLETNAME].getText());
        }        
    }

    //    public void setValues(String appName, String path, String xlet){
    //        fields[NAME].setText(appName);
    //        fields[CLASSPATH].setText(path);
    //        fields[XLETNAME].setText(xlet);
    //    }

    public String getValue(int i) {
        return fields[i].getText();
    }

    // implementing ActionListener -->
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("classpath")) {
            
            String fieldText = fields[CLASSPATH].getText();
            //String[] treeData = fieldText.split(File.separator + File.separator);
            String[] treeData;
            if(File.separator.equals("\\")){
                treeData = fieldText.split("\\\\");
            }
            else{
                treeData = fieldText.split("/");
            }
            log.debug("### " + treeData.length);
            
            DirectoryExplorer dirWin = dirWin = new DirectoryExplorer(Util.getParentFrame(this), treeData);
            
            
            if ( dirWin != null && dirWin.getPath().length() > 0) {
                fields[CLASSPATH].setText(dirWin.getPath());
                log.debug(fields[CLASSPATH].getText());
            }
        }
        else if (command.equals("xletname")) {
            if (fields[CLASSPATH].getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "You must specify a directory!", "Alert", JOptionPane.ERROR_MESSAGE);
            }
            else {
                ClassWindow classWindow = new ClassWindow(Util.getParentFrame(this), new File(fields[CLASSPATH].getText().trim()));
                log.debug("value=" + classWindow.getValue());
                fields[XLETNAME].setText(classWindow.getValue());
            }

            //            JFileChooser fc = new JFileChooser(fields[CLASSPATH].getText());
            //            FileFilterImpl filter = new FileFilterImpl(".class");
            //            fc.setFileFilter(filter);
            //            File dir = new File(fields[CLASSPATH].getText());
            //            Debug.write(this, "** " + dir.isDirectory());
            //            fc.setCurrentDirectory( dir );
            //            fc.setDialogType(JFileChooser.OPEN_DIALOG);            
            //            fc.showOpenDialog(this);
            //            String selectedPath = fc.getSelectedFile().getAbsolutePath();
            //            Debug.write(this, "1 " + fc.getSelectedFile().getPath());
            //            Debug.write(this, "2 " + fc.getSelectedFile().getAbsolutePath());
            //
            //            String className = ""; 
            //            className = selectedPath.substring(fields[CLASSPATH].getText().length());
            //            className = className.replace(File.separatorChar, '.');
            //            className = className.replaceAll(".class", "");
            //            className = className.replaceAll(".CLASS", "");
            //            if(className.length() > 0){                
            //                fields[XLETNAME].setText(className);                
            //            }
        }
        else if (command.equals("ok")) {
            if (isOk()) {
                String name = fields[NAME].getText().trim();
                String path = fields[CLASSPATH].getText().trim();
                String xlet = fields[XLETNAME].getText().trim();
                App app = new App(name, path, xlet);
                AppManager.getInstance().getDefaultGroup().addApp(app);
                AppManager.getInstance().update();
                AppMenu.getInstance().update();
                log.debug("name=" + name + ", path=" + path + ", xlet=" + xlet);

            }
        }
        else if (command.equals("cancel")) {

        }
    }
    // implementing ActionListener //

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
        if (fields[CLASSPATH].getText().trim().equals("")) {
            String s = fieldLabels[CLASSPATH].getText();
            s = s.substring(0, s.lastIndexOf(":"));
            message += "- " + s + "\n";
            ok = false;
        }
        if (fields[XLETNAME].getText().trim().equals("")) {
            String s = fieldLabels[XLETNAME].getText();
            s = s.substring(0, s.lastIndexOf(":"));
            message += "- " + s + "\n";
            ok = false;
        }
        if (!ok) {
            JOptionPane.showMessageDialog(null, message, "Alert", JOptionPane.ERROR_MESSAGE);
            return false;
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
