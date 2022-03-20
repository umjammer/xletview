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
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;




public class FileBrowser extends GenDialogComponent implements MouseListener, ActionListener{

    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(FileBrowser.class.getName());

    private static final int FOLDER = 0;
    private static final int FILE   = 1;
    private int width;
    private int height;
    private JComboBox<String> combo;
    private JList<String> fileList;
    private File currentFolder;
    private JScrollPane scroll;
    private File[] files;
    private JLabel pathLabel;
    private String value; // the value that this class generates, the path
    private File[] roots;
    private FileFilter filter;


    public FileBrowser(int width, int height, FileFilter filter){
        this(width, height);
        this.filter = filter;
    }

    public FileBrowser(int width, int height){
        this.width = width;
        this.height = height;

        // drive combo
        Container top = new Container();
        top.setLayout(new GridLayout(2, 1));
        roots = File.listRoots();
        List<String> rootPaths = new ArrayList<>();
        for(int i = 0; i < roots.length; i++){
            if(roots[i].isDirectory()){
                log.fine(roots[i].getPath());
                rootPaths.add(roots[i].getPath());
            }
        }
        combo = new JComboBox<>(rootPaths.toArray(new String[rootPaths.size()]));
        combo.setActionCommand("changeDrive");
        combo.addActionListener(this);
        top.add(combo);

        // label for the path
        pathLabel = new JLabel();
        pathLabel.setHorizontalAlignment(JLabel.LEFT);
        top.add(pathLabel);

        // list for files
        fileList = new JList<>();
        scroll = new JScrollPane(fileList);
        setPreferredSize(new Dimension(width, height));
        scroll.setPreferredSize(new Dimension(width,height));

        setLayout(new BorderLayout());
        add(top, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    public void openFolder(String path){
        currentFolder = new File(path);

        //if(!currentFolder.isDirectory()){
            //currentFolder = roots[0];
        //}

            try {
                files = getFiles(currentFolder);
            } catch (Exception e) {
                for(int i = 0; i < roots.length; i++){
                    try {
                        files = getFiles(roots[i]);
                        currentFolder = roots[i];
                        break;
                    } catch (Exception e2) {
                        //Debug.severe(e2);
                    }

                }
                //Debug.severe(e);
            }

            log.fine("opened folder: " + currentFolder.getPath());

        int totFiles = files.length;
        String[] names = new String[totFiles];

        for(int i = 0; i < names.length; i++){
            names[i] = files[i].getName();
            //Debug.write(this, names[i]);
            if(i == 0 && currentFolder.getParentFile() != null){
                // it's the parent folder
                names[i] = "..";
            }

        }

        pathLabel.setText(currentFolder.getPath());
        fileList.setListData(names);
        fileList.addMouseListener(this);
        scroll.revalidate();

    }

    /**
     * Returns an Array with the directories and files of a directory, with the
     * parent if there is one and directories first.
     */
    private File[] getFiles(File folder) throws NullPointerException{
        File[] filesInFolder;

        if(filter != null){
            filesInFolder = folder.listFiles(filter);
        }
        else{
            filesInFolder = folder.listFiles();
        }

        List<File> dir   = new ArrayList<>();
        List<File> file  = new ArrayList<>();
        File parentFolder = folder.getParentFile();
        if(parentFolder != null){
            dir.add(parentFolder);
        }
        for(int i = 0; i < filesInFolder.length; i++){
            if(filesInFolder[i].isDirectory() && !filesInFolder[i].isHidden()){
                dir.add(filesInFolder[i]);
            }
            else{
                file.add(filesInFolder[i]);
            }
        }
        File[] totFiles = new File[dir.size() + file.size()];
        int i=0;
        for (int j = 0; j < dir.size(); j++){
            totFiles[i++] = (File)dir.get(j);
        }
        for (int j = 0; j <  file.size(); j++){
            totFiles[i++] = (File) file.get(j);
        }
        return totFiles;
    }

    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        if(command.equals("changeDrive")){
            JComboBox<?> cb = (JComboBox<?>)e.getSource();
            String path = (String)cb.getSelectedItem();
            openFolder(path);
        }

    }

    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseClicked(MouseEvent e){
        int selIndex = fileList.getSelectedIndex();
        if(selIndex != -1){
            File selectedFile = files[selIndex];
            value = selectedFile.getPath();
            //Debug.write(this, "" + selectedFile.getPath());
            if(e.getClickCount() == 2){
                if(selectedFile.isDirectory()){
                    openFolder(value);
                }
            }
        }

    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}

    public String getValue(){
        return value;
    }

    public void setFilter(FileFilter filter){
        this.filter = filter;
    }

    public boolean isOk(){
        return true;
    }

    public static void main(String[] args){
        FileBrowser b = new FileBrowser(300, 250);
        b.openFolder("C:\\");
        new GenDialog(b, null, "File Browser");


    }
}
