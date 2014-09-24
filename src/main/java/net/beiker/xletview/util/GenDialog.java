/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Svedén
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/


package net.beiker.xletview.util;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

public class GenDialog extends JDialog implements ActionListener{

    private Frame owner;
    private boolean isOk;
    private GenDialogComponent component;

    public GenDialog(GenDialogComponent component, Frame owner, String title) {
        super(owner, true);
        this.component = component;
        this.owner = owner;
        
        Container content = this.getContentPane();


        // buttons
        Box buttonBox = new Box(BoxLayout.X_AXIS);
        JButton ok = new JButton("OK");
        ok.setActionCommand("ok");
        ok.addActionListener(this);
        buttonBox.add(ok);
        JButton cancel = new JButton("CANCEL");
        cancel.setActionCommand("cancel");
        cancel.addActionListener(this);
        buttonBox.add(cancel);

        content.setLayout(new BorderLayout());
        content.add(component, BorderLayout.CENTER);
        content.add(buttonBox, BorderLayout.SOUTH);

        addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent we) {
                    doClose();
                }
            });
        setTitle(title);
        pack();

        GraphicsConfiguration gc = this.getGraphicsConfiguration();
        Rectangle bounds = gc.getBounds();
        int x = (int) (bounds.getWidth() - this.getWidth()) / 2;
        int y = (int) (bounds.getHeight() - this.getHeight()) / 2;
        setLocation(x, y);

        show();
    }

    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        if(command.equals("cancel")){
            isOk = false;
            doClose();
        }
        else if(command.equals("ok")){
            if(component.isOk()){
                isOk = true;
                doClose();
            }            
        }
    }

    public boolean isOk(){
        return isOk;
    }

    public void doClose() {
        dispose();        
        //System.exit(0);
    }
}
