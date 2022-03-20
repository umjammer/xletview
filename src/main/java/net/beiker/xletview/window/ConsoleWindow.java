/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package net.beiker.xletview.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import net.beiker.xletview.util.Console;
import net.beiker.xletview.util.Constants;
import net.beiker.xletview.util.Settings;
import net.beiker.xletview.util.Util;

public class ConsoleWindow extends JFrame implements ActionListener{

	private static final net.beiker.cake.Logger log = net.beiker.cake.Log.getLogger(ConsoleWindow.class);

    private static ConsoleWindow THE_INSTANCE;

    private Container content;
    private JButton toggleButton;
    private JButton clearButton;
    private static int STOP  = 0;
    private static int START = 1;
    private String[] toggleText = {"STOP OUTPUT", "START OUTPUT"};
    private Color[] toggleColor = {Color.RED, new Color(0, 80, 0)};

    public static void main(String[] args){
//        new ConsoleWindow();
    }

    public static ConsoleWindow getInstance(){
        if(THE_INSTANCE == null){
            THE_INSTANCE = new ConsoleWindow();
        }
        return THE_INSTANCE;
    }

    private ConsoleWindow(){
        content = this.getContentPane();
        content.setLayout(new BorderLayout());
        Console console = new Console();
        content.add(console, BorderLayout.CENTER);

        Container topCont  = new Container();
        GridLayout topGrid = new GridLayout(1, 2);
        topCont.setLayout(topGrid);

        toggleButton = new JButton(toggleText[STOP]);
        toggleButton.setActionCommand("toggleOutput");
        toggleButton.addActionListener(this);
        toggleButton.setForeground(Color.WHITE);
        toggleButton.setBackground(toggleColor[STOP]);
        topCont.add(toggleButton);

        clearButton = new JButton("CLEAR");
        clearButton.setActionCommand("CLEAR");
        clearButton.addActionListener(this);
        clearButton.setForeground(Color.BLACK);
        clearButton.setBackground(Color.YELLOW);
        topCont.add(clearButton);

        content.add(topCont, BorderLayout.NORTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                hide();
                //System.exit(0);
            }
        });

        this.setIconImage(Constants.ICON_CONSOLE);
        setTitle(Constants.TITLE_CONSOLE);
        pack();

        int x = Util.parseInt(Settings.getProperty("console.x"));
        int y = Util.parseInt(Settings.getProperty("console.y"));
        int width = Util.parseInt(Settings.getProperty("console.width"));
        int height = Util.parseInt(Settings.getProperty("console.height"));
        setLocation(x, y);
        setSize(width, height);
    }

    /**
     * show/hides the window
     *
     */
    public void toggle(){
        if(isVisible()){
            hide();
        }
        else{
            show();
        }
    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("toggleOutput")){
            if(toggleButton.getText().equals(toggleText[START])){
                toggleButton.setText(toggleText[STOP]);
                toggleButton.setBackground(toggleColor[STOP]);
                Console.setPrinting(true);
            }
            else if(toggleButton.getText().equals(toggleText[STOP])){
                toggleButton.setText(toggleText[START]);
                toggleButton.setBackground(toggleColor[START]);
                Console.setPrinting(false);
            }
        }
        else if(e.getActionCommand().equals("CLEAR")){
            Console.clear();
        }
    }

}
