/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package net.beiker.xletview.util;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.io.PrintStream;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.beiker.xletview.io.OutputPrinter;
import net.beiker.xletview.io.OutputRedirector;


public class Console extends Container implements OutputPrinter{

	private static final net.beiker.cake.Logger log = net.beiker.cake.Log.getLogger(Console.class);

    //JTextArea textArea;
    private static JTextArea ta;
    private static JScrollPane scroll;
    private static boolean isPrinting;
    private static String[] string;
    private static int size = 10;


    public Console(){
        setSize(500,300);
        setLayout(new BorderLayout());

        ta = new JTextArea(10, 80);
        ta.setEditable(false);

        try{
            String font = Settings.getProperty("console.font");
            String strFontSize = Settings.getProperty("console.fontsize");
            int fontSize = Integer.parseInt(strFontSize);
            ta.setFont(new Font(font, Font.PLAIN, fontSize));
        }
        catch(Exception e){
            log.error("The font properties for the console is not working");
        }



        scroll = new JScrollPane(ta);
        add(scroll, BorderLayout.CENTER);

        isPrinting = true;
        setVisible( true );

        string = new String[size];

        hookStandards();
    }

    public static void setPrinting(boolean b){
        isPrinting = b;
    }

    public static void clear(){
        ta.setText(null);
    }

//    public static void print(Object o){
//        if(isPrinting == true){
//             ta.append(s);
//             ta.setCaretPosition(ta.getDocument().getLength());
//         }
//    }

//    private static String append(String s){
//        String newStr = "";
//        for(int i = 0; i < size-1; i++){
//            string[i] = string[i+1];
//            newStr += string[i];
//        }
//        string[size-1] = s;
//        return newStr;
//    }

    private void hookStandards() {
//        ConsoleOutputStream os = new ConsoleOutputStream();
        OutputRedirector or = new OutputRedirector(this);
        PrintStream out = new PrintStream( or );
        System.setOut( out );
        System.setErr( out );
    }

    /* (non-Javadoc)
     * @see net.beiker.xletview.io.OutputPrinter#print(java.lang.String)
     */
    public void print(String s) {
        if(isPrinting == true){
             ta.append(s);
             ta.setCaretPosition(ta.getDocument().getLength());
         }

    }
}
