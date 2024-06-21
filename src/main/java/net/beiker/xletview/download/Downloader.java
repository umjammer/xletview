/*
 * This file is part of XleTView
 * Copyright (C) 2003 Martin SvedÈn
 *
 * This is free software, and you are
 * welcome to redistribute it under
 * certain conditions;
 *
 * See LICENSE document for details.
 */

package net.beiker.xletview.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.getLogger;


/**
 * Downloads files from one source directory to a destination directory.
 *
 * @author Martin Sveden
 */
public class Downloader {

    private static final Logger logger = getLogger(Downloader.class.getName());
    private static final long maxByteSize = 8000000;
//    private URL url;
    private File source;
    private final File destination;
    private final List<RelFile> relFiles;
//    private final String destinationPath;
    private long byteLength;
    private final List<DownloadEventListener> listeners;

//    public Downloader(URL url) {
//        this.url = url;
//        String protocol = url.getProtocol();
//logger.log(Level.DEBUG, "protocol=" + protocol);
//        if (protocol.equals("file")) {
//            String file = url.getFile();
//            String host = url.getHost();
//            String path = host + url.getFile().replace('/', File.separatorChar);
//
//logger.log(Level.DEBUG, "host=" + host);
//logger.log(Level.DEBUG, "file=" + file);
//logger.log(Level.DEBUG, "path=" + path);
//
//            File f = new File(path);
//logger.log(Level.DEBUG, path + ", exist? " + f.exists());
//
//            path = host + ":" + url.getFile().replace('/', File.separatorChar);
//            f = new File(path);
//logger.log(Level.DEBUG, path + ", exist? " + f.exists());
//        }
//    }

    /**
     * Creates the folder to download if it doesn't exit.
     * Deletes all the content in the folder to download to.
     */
    public Downloader(String destinationPath) throws IOException {
        synchronized (this) {
//            this.destinationPath = destinationPath;
            listeners = new ArrayList<>();
            relFiles = new ArrayList<>();
            destination = new File(destinationPath);
            logger.log(Level.DEBUG, "dest exist? " + destination.exists());
            if (!destination.exists()) {
                destination.mkdirs();
                if (!destination.exists()) {
                    throw new IOException(destination.getAbsolutePath() + " does not exist");
                }
            }
            if (!destination.exists()) {
                throw new IOException("File " + destination.getAbsolutePath() + " does not exist");
            }
        }
    }

    public void addDownloadEventListener(DownloadEventListener listener) {
        listeners.add(listener);
    }

    public void removeDownloadEventListener(DownloadEventListener listener) {
        listeners.remove(listener);
    }

    /**
     * Downloads everything under the specified path to the destination directory.
     *
     * @param rootPath The directory which content we want.
     * @throws IOException If the directory doesn't exist.
     */
    public void download(URL rootPath) throws IOException {
        synchronized (this) {
            flush();
            File f = new File(rootPath.getFile());
            if (!f.exists() || !f.isDirectory()) {
                throw new IOException("File " + f.toURI().toURL() + " does not exist or is not a valid resource directory");
            } else {
                source = f;
                logger.log(Level.INFO, "checking resources...");
                resolveSource(source);
                copy();
            }
        }
    }

//    public Downloader(String rootPath) throws IOException {
//        this();
//        File f = new File(rootPath);
//        if (!f.exists()) {
//            throw new IOException("File " + f.toURL() + " does not exist");
//        } else {
//            source = f;
//            resolveSource(source);
//            copy();
//        }
//    }

    /**
     * @return The folder which is the destination where the
     * applications are downloaded to.
     */
    public File getDestination() {
        return destination;
    }

    /**
     * Deletes all content from the destination directory
     */
    public void flush() {
        synchronized (this) {
            // delete all previous content
            File[] files = getDirContent(destination, new ArrayList<>());
            deleteFiles(files);
        }
    }

    /**
     * Resolves a directory
     *
     * @param dir The directory to resolve
     */
    private void resolveSource(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                String relPath = file.getAbsolutePath().substring(source.getAbsolutePath().length());
//logger.log(Level.DEBUG, this, relPath);
                relFiles.add(new RelFile(file, relPath));
                if (file.isDirectory()) {
                    resolveSource(file);
                }
            }
        }
    }

    /**
     * Copies the files from source to destination
     */
    private void copy() throws AppSizeExceededException {
logger.log(Level.INFO, "downloading resources...");
        for (int i = 0; i < relFiles.size(); i++) {
            RelFile relFile = relFiles.get(i);
            File file = relFile.getFile();
            String path = relFile.getRelPath();
            File newFile = new File(destination.getAbsolutePath() + path);
            if (file.isDirectory()) {
                newFile.mkdirs();
            } else {
                try {
                    newFile.createNewFile();
                    try (InputStream is = new FileInputStream(file);
                         FileOutputStream os = new FileOutputStream(newFile)) {
                        byte[] bytes = new byte[is.available()];
                        byteLength += bytes.length;
//logger.log(Level.DEBUG, this, file.getName() + ", byteLength = " + byteLength + " > " + bytes.length + " = " + (byteLength > bytes.length));
                        if (byteLength > maxByteSize) {
                            throw new AppSizeExceededException("Application's size is too big![> " + maxByteSize + " bytes]");
                        }
                        is.read(bytes);
                        os.write(bytes);
                    }
                    notifyListeners(new DownloadEvent(this, getProcent(i), file.getName()));
                } catch (IOException e) {
                    logger.log(Level.TRACE, e.getMessage(), e);
                }
            }
        }
logger.log(Level.INFO, "download finished");
    }

    /**
     * Gets the content of a direcory
     *
     * @param dir The directory to get the content for
     * @param v   An empty vector
     * @return All the files that was in the directory
     */
    private File[] getDirContent(File dir, List<File> v) {
        File[] files = dir.listFiles();
        for (File file : files) {
            v.add(file);
            if (file.isDirectory()) {
                getDirContent(file, v);
            }
        }
        File[] f = new File[v.size()];
        for (int i = 0; i < v.size(); i++) {
            f[i] = v.get(i);
        }
//        return (File[]) v.toArray();
        return f;
    }

    /**
     * Deletes files
     *
     * @param files The files to delete
     */
    private void deleteFiles(File[] files) {
logger.log(Level.INFO, "unloading any previous application...");
        boolean success = true;
        // do it backwards, because it will not delete non empty directories
        for (int i = files.length - 1; i >= 0; i--) {
            boolean deleted = files[i].delete();
            if (deleted) {
                // file deleted
//logger.log(Level.DEBUG, this, files[i].getAbsolutePath() + " was deleted");
            } else {
                //could not delete
                success = false;
logger.log(Level.DEBUG, files[i].getAbsolutePath() + " could not be removed");
            }
        }
        if (!success) {
logger.log(Level.INFO, "some resources of the previous application could not be unloaded");
        } else {
logger.log(Level.INFO, "unloading successful");
        }
    }

    private int getProcent(double index) {
        double tot = relFiles.size();

        // we add 1 to the index and use the relFiles.size()
        // so there will not be a division by zero if there is
        // only one file

        double procent = (index + 1) / tot * 100;
//logger.log(Level.DEBUG, this, index + "/" + tot + " * 100 = " + procent);
        return (int) procent;
    }

    private void notifyListeners(DownloadEvent e) {
        for (DownloadEventListener listener : listeners) {
            listener.downloadUpdate(e);
        }
    }
}
