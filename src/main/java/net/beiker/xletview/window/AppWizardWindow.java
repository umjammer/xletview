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
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.beiker.xletview.io.FileFilterImpl;
import net.beiker.xletview.ui.Img;
import net.beiker.xletview.util.Constants;
import net.sourceforge.mlf.metouia.MetouiaLookAndFeel;

/**
 * @author Martin Sveden
 */
public class AppWizardWindow  extends JFrame implements ActionListener{
    
	private static final net.beiker.cake.Logger log = net.beiker.cake.Log.getLogger(AppWizardWindow.class);
	
    private static final int STATE_INIT = 0;
    private static final int STATE_CHOOSE_PATH = 1;
    private static final int STATE_CHOOSE_XLET = 2;
    private static final int STATE_FINNISHED = 3;
    
    private Container content;
    private JButton continueLabel;
    private JButton cancelLabel;
    private JButton backLabel;
    private JPanel mainPanel;
    private JPanel[] mainPanels;    
    private int state;
    
    private JTextField nameField;
    private JTextField pathField;
    private JTextField xletField;
    
    public AppWizardWindow(){
        content = getContentPane();
        content.setLayout(new BorderLayout());
        content.setBackground(null);
        
        JPanel top = new JPanel();
        top.setBackground(null);
        top.setLayout(new GridLayout(1,1));
        Img topImg = new Img(Constants.URL_LOGO_WIZARD_TOP);        
        top.add(topImg);
        content.add(top, BorderLayout.NORTH);
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.YELLOW);
        content.add(mainPanel, BorderLayout.CENTER);
        
        mainPanels = new JPanel[4];
        setInit();

        JPanel navPanel = new JPanel();
        navPanel.setLayout(new GridLayout());
        
        continueLabel = new JButton("NEXT >>");
        continueLabel.setActionCommand("next");
        continueLabel.addActionListener(this);        
        
        cancelLabel = new JButton("CANCEL");
        cancelLabel.setActionCommand("cancel");
        cancelLabel.addActionListener(this);
        
        backLabel = new JButton("<< BACK");
        backLabel.setActionCommand("back");
        backLabel.addActionListener(this);
        backLabel.setEnabled(false);
        
        navPanel.add(cancelLabel);
        navPanel.add(backLabel);
        navPanel.add(continueLabel);

        content.add(navPanel, BorderLayout.SOUTH);


        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                doClose();
            }
        });
        
        setIconImage(Constants.ICON_DEFAULT);
        setTitle(Constants.TITLE_LAUNCHER);
        setSize(400, 400);
        show();
    
    }
    
    private void setInit(){
        mainPanel.removeAll();
        if(mainPanels[STATE_INIT] == null){
            mainPanels[STATE_INIT] = new JPanel();
            JPanel cont = new JPanel(new BorderLayout());
            
            JPanel top = new JPanel(new BorderLayout());
            JLabel header = new JLabel("Add a new application", JLabel.LEFT);
            header.setFont(Constants.FONT_HEADER_NORMAL); 
            JTextPane text = new JTextPane();
            text.setFont(Constants.FONT_NORMAL);
            text.setBackground(null);
            text.setPreferredSize(new Dimension(300, 100));
            text.setEditable(false);
            text.setText("Click through this 'wizard' to add a new application to XleTView.\n\nNavigate by clicking the buttons at the bottom of this window.");
            top.add(header, BorderLayout.NORTH);
            top.add(text, BorderLayout.CENTER);
            cont.add(top, BorderLayout.CENTER);
                         
            mainPanels[STATE_INIT].add(cont);     
            
                  
        }
        mainPanel.add(mainPanels[STATE_INIT]);
        mainPanel.validate();
        mainPanel.repaint();
    }
    
    private void setChoosePath(){
        mainPanel.removeAll();
        if(mainPanels[STATE_CHOOSE_PATH] == null){
            mainPanels[STATE_CHOOSE_PATH] = new JPanel();
            
            JPanel cont = new JPanel(new BorderLayout());
            
            JPanel top = new JPanel(new BorderLayout());                        
            JLabel header = new JLabel("Choose path", JLabel.LEFT);     
            header.setFont(Constants.FONT_HEADER_NORMAL); 
            JTextPane text = new JTextPane();
            text.setFont(Constants.FONT_NORMAL);
            text.setBackground(null);
            text.setPreferredSize(new Dimension(300, 100));
            text.setEditable(false);
            text.setText("Specify the root directory for the classes of your application.");
            top.add(header, BorderLayout.NORTH);
            top.add(text, BorderLayout.CENTER);
            
            JPanel row = new JPanel();
            JLabel pathLabel = new JLabel("Path: ", JLabel.RIGHT);
            pathField = new JTextField(20);
            JButton pathButton = new JButton("..");
            pathButton.setActionCommand("classpath");
            pathButton.addActionListener(this);
            row.add(pathLabel);
            row.add(pathField);
            row.add(pathButton);            
            
            cont.add(top, BorderLayout.NORTH);
            cont.add(row, BorderLayout.CENTER);
            mainPanels[STATE_CHOOSE_PATH].add(cont);
            
            //mainPanels[STATE_CHOOSE_PATH].add(box);          
//            mainPanels[STATE_CHOOSE_PATH] = new JPanel();
//            Box box = new Box(BoxLayout.Y_AXIS);
//            JLabel label = new JLabel("choose path", JLabel.RIGHT);      
//            label.setSize(400, 300);
//            label.setBackground(Color.pink);                                    
//            Box[] rows = new Box[2];
//            
//            JLabel pathLabel = new JLabel("Path: ", JLabel.RIGHT);
//            pathLabel.setPreferredSize(new Dimension(60, 20));
//            JTextField pathField = new JTextField(20);
//            JButton pathButton = new JButton("..");
//            pathButton.setActionCommand("classpath");
//            pathButton.addActionListener(this);
//            
//            rows[0] = new Box(BoxLayout.X_AXIS);
//            rows[0].add(label);
//            rows[1] = new Box(BoxLayout.X_AXIS);
//            rows[1].add(pathLabel);
//            rows[1].add(pathField);
//            rows[1].add(pathButton);
//                       
//            box.add(rows[0]);
//            box.add(rows[1]);
//            mainPanels[STATE_CHOOSE_PATH].add(box);
                  
        }
        mainPanel.add(mainPanels[STATE_CHOOSE_PATH]);  
        mainPanel.validate(); 
        mainPanel.repaint();     
    }

    private void setChooseXlet(){
        mainPanel.removeAll();
        if(mainPanels[STATE_CHOOSE_XLET] == null){
            mainPanels[STATE_CHOOSE_XLET] = new JPanel();
            
            JPanel cont = new JPanel(new BorderLayout());
            
            JPanel top = new JPanel(new BorderLayout());                        
            JLabel header = new JLabel("The Xlet's name", JLabel.LEFT);     
            header.setFont(Constants.FONT_HEADER_NORMAL); 
            JTextPane text = new JTextPane();
            text.setFont(Constants.FONT_NORMAL);
            text.setBackground(null);
            text.setPreferredSize(new Dimension(300, 100));
            text.setEditable(false);
            text.setText("Specify the fully qualified name of the Xlet.\n");
            top.add(header, BorderLayout.NORTH);
            top.add(text, BorderLayout.CENTER);

                  
            JPanel row = new JPanel();
            JLabel xletLabel = new JLabel("Xlet: ", JLabel.RIGHT);
            //pathLabel.setPreferredSize(new Dimension(60, 20));
            xletField = new JTextField(20);
            JButton xletButton = new JButton("..");
            xletButton.setActionCommand("xlet");
            xletButton.addActionListener(this);
            row.add(xletLabel);
            row.add(xletField);
            row.add(xletButton);   
            
            cont.add(top, BorderLayout.NORTH);
            cont.add(row, BorderLayout.CENTER);
                        
            mainPanels[STATE_CHOOSE_XLET].add(cont);         
        }
        mainPanel.add(mainPanels[STATE_CHOOSE_XLET]);
        mainPanel.validate();     
        mainPanel.repaint();   
    }
    
    private void setFinnished(){
        mainPanel.removeAll();
        if(mainPanels[STATE_FINNISHED] == null){
            mainPanels[STATE_FINNISHED] = new JPanel();
            JPanel cont = new JPanel(new BorderLayout());
            
            JPanel top = new JPanel(new BorderLayout());                        
            JLabel header = new JLabel("The Xlet's name", JLabel.LEFT);     
            header.setFont(Constants.FONT_HEADER_NORMAL); 
            JTextPane text = new JTextPane();
            text.setFont(Constants.FONT_NORMAL);
            text.setBackground(null);
            text.setPreferredSize(new Dimension(300, 100));
            text.setEditable(false);
            text.setText("Check that the info about your Xlet is correct, if not you can step back and correct.\nWhen you click on 'FINISH' this window will close and the data will be written to a file. If everything went well you should be able to run the Xlet from the menu.");
            top.add(header, BorderLayout.NORTH);
            top.add(text, BorderLayout.CENTER);
                  
            cont.add(top, BorderLayout.NORTH);
                        
            mainPanels[STATE_FINNISHED].add(cont);     
        }
        mainPanel.add(mainPanels[STATE_FINNISHED]);
        mainPanel.validate();      
        mainPanel.repaint();  
    }
    
    private void next(){
        switch(state){
            case STATE_INIT:
                log.debug("time to choose path");
                backLabel.setEnabled(true);
                setChoosePath();
                state = STATE_CHOOSE_PATH; 
            break;
            case STATE_CHOOSE_PATH:
            	log.debug("time to choose xlet");
                setChooseXlet();                
                state = STATE_CHOOSE_XLET;                                 
            break;
            case STATE_CHOOSE_XLET:
            	log.debug("finnished");
                setFinnished();
                continueLabel.setText("CLOSE");
                cancelLabel.setEnabled(false);                
                state = STATE_FINNISHED;
            break;
        }
    }

    private void back(){
        switch(state){
            case STATE_CHOOSE_PATH:
            	log.debug("init");
                backLabel.setEnabled(false);
                setInit();
                state = STATE_INIT; 
            break;
            case STATE_CHOOSE_XLET:
            	log.debug("choose path");
                setChoosePath();
                state = STATE_CHOOSE_PATH;
            break;
            case STATE_FINNISHED:
            	log.debug("choose xlet");
                setChooseXlet();
                cancelLabel.setEnabled(true);
                continueLabel.setText("NEXT >>");
                state = STATE_CHOOSE_XLET;
            break;
        }
    }


    public void actionPerformed(ActionEvent event) {    
        String command = event.getActionCommand();
        if(command.equals("cancel")){
            doClose();
        }
        else if(command.equals("next")){
            if(state == STATE_FINNISHED){
                doClose();
            }
            else{
                next();
            }
        }
        else if(command.equals("back")){
            back();
        }
        else if(command.equals("classpath")){
            File[] roots = File.listRoots();
//            DirectoryWindow dirWin = new DirectoryWindow(this, roots, false);            
//            if(dirWin.getPath().length() > 0){
//                pathField.setText(dirWin.getPath());
//                Debug.write(this, pathField.getText());
//            }   
        }
        else if(command.equals("xlet")){
            
            JFileChooser fc = new JFileChooser(pathField.getText());
            FileFilterImpl filter = new FileFilterImpl(".class");
            fc.setFileFilter(filter);
            fc.setCurrentDirectory( new File(pathField.getText()) );
            fc.setDialogType(JFileChooser.OPEN_DIALOG);            
            fc.showOpenDialog(this);
            String selectedPath = fc.getSelectedFile().getAbsolutePath();
            log.debug("chosen file " + fc.getSelectedFile());

            String className = ""; 
            className = selectedPath.substring(pathField.getText().length());
            className = className.replace(File.separatorChar, '.');
            className = className.replaceAll(".class", "");
            className = className.replaceAll(".CLASS", "");
            if(className.length() > 0){                
                xletField.setText(className);                
            }

            /*
            File[] files = new File[1];
            files[0] = new File(pathField.getText());
            Debug.write(this, pathField.getText() + ", exist? " + files[0].exists());
            DirectoryWindow dirWin = new DirectoryWindow(this, files, true);            
            String className = dirWin.getPath(); 
            className = className.replaceAll(".class", "");
            className = className.replaceAll(".CLASS", "");
            if(className.length() > 0){                
                xletField.setText(className);
                
            } */  
        }
    }
    
    private String resolveXletName(String dir, String fullPath){
        String name = "";
        name = fullPath.replaceAll(dir, "");
        if(name.lastIndexOf("\\") == name.length() - 1 || name.lastIndexOf("/") == name.length() - 1){
            name = name.substring(0, name.length() - 2);
        }
        return name;
    }
    
    private void doClose(){
        System.exit(0);
    }
    

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new MetouiaLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException exception) {
            exception.printStackTrace();
        }
        new AppWizardWindow();
    }
}
