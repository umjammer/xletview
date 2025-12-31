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

package xjava.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;

import static java.lang.System.getLogger;


/**
 * Represents a file or directory in the filesystem.
 *
 * @author Martin Sveden
 */
public class XFile extends java.io.File {

    // The reason why this class is not called File is because there are some classes that
    // uses both java.io.File and this one and if both were called File it might create
    // unnecessary confusion.

    /** Debugging facility */
    private static final Logger logger = getLogger(XFile.class.getName());

    private static final String NULL_STRING = null;

    private String name;

    private String path;

    private String absolutePath;

    private String parentPath;

    /**
     * Overrides constructor in java.io.File
     */
    public XFile(java.io.File parent, String child) {
        super(parent, child);
        init(parent, child);
    }

    public XFile(XFile parent, String path) {
        this(parent.getAbsoluteFile(), path);
    }

    /**
     * Overrides constructor in java.io.File
     */
    public XFile(String parent, String child) {
        super("", "");
        init(parent, child);
    }

    /**
     * Overrides constructor in java.io.File
     */
    public XFile(String path) {
        super(path);
        init(NULL_STRING, path);
    }

    /**
     * Overrides constructor in java.io.File
     */
    public XFile(URI uri) {
        super("");
        // TODO fix
    }

    public static java.io.File[] listRoots() {
        return FileSystem.listRoots();
    }

    public static java.io.File createTempFile(String prefix, String suffix, java.io.File directory) throws IOException {
logger.log(Level.DEBUG, "createTempFile");
        return null;
    }

    // java.io.File stuff -->

    public static java.io.File createTempFile(String prefix, String suffix) throws IOException {
logger.log(Level.DEBUG, "createTempFile");
        return null;
    }

    private void init(java.io.File parent, String path) {
        if (parent != null) {
            init(parent.getPath(), path);
        } else {
            init(NULL_STRING, path);
        }
    }

    private void init(String parent, String path) {
        logger.log(Level.DEBUG, "parent=" + parent + " path=" + path);
        if (parent != null) {
            this.path = FileSystem.fixPath(parent + separatorChar + path);
        } else {
            this.path = FileSystem.fixPath(path);
        }
    }

    /**
     * The path is the same path that was used creating the file but
     * with the slashes fixed in a platform dependent way.
     */
    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public String getAbsolutePath() {
//logger.log(Level.DEBUG, "getAbsolutePath");
        return FileSystem.resolveAbsolutePath(getParent(), getName());
    }

    @Override
    public boolean exists() {
        return FileSystem.exists(this);
    }

    /**
     * Returns the name of the file or directory denoted by this abstract
     * pathname.  This is just the last name in the pathname's name
     * sequence.  If the pathname's name sequence is empty, then the empty
     * string is returned.
     *
     * @return The name of the file or directory denoted by this abstract
     * pathname, or the empty string if this pathname's name sequence
     * is empty
     */
    @Override
    public String getName() {
        int index = this.path.lastIndexOf(FileSystem.separatorChar);
        if (index < 0) return this.path;
        return this.path.substring(index + 1);
    }

    @Override
    public String getParent() {
        String result = null;
logger.log(Level.DEBUG, "getParent(), start");

        int index = this.path.lastIndexOf(FileSystem.separatorChar);
logger.log(Level.DEBUG, "index=" + index + ", path=" + this.path + " separatorChar = " + FileSystem.separatorChar);
        if (index > 1) {
            result = this.path.substring(0, index);
        }

//        if (parentPath == null) {
//            result = FileSystem.resolveParent(path);
//        } else {
//            result = parentPath;
//        }
logger.log(Level.DEBUG, "getParent(), result=" + result);
        return result;
    }

    @Override
    public java.io.File getParentFile() {
        return null;
    }

    @Override
    public boolean isAbsolute() {
logger.log(Level.DEBUG, "isAbsolute");
        return false;
    }

    @Override
    public java.io.File getAbsoluteFile() {
        return new XFile(getAbsolutePath());
    }

    @Override
    public String getCanonicalPath() throws IOException {
        return FileSystem.getCanonicalPath(this);
    }

    @Override
    public java.io.File getCanonicalFile() throws IOException {
        return FileSystem.getCanonicalFile(this);
    }

    @Override
    public URL toURL() throws MalformedURLException {
        return FileSystem.toURL(this);
    }

    @Override
    public URI toURI() {
        return FileSystem.toURI(this);
    }

    @Override
    public boolean canRead() {
        return FileSystem.canRead(this);
    }

    @Override
    public boolean canWrite() {
        return FileSystem.canWrite(this);
    }

    @Override
    public boolean isDirectory() {
        return FileSystem.isDirectory(this);
    }

    @Override
    public boolean isFile() {
        return FileSystem.isFile(this);
    }

    @Override
    public boolean isHidden() {
        return FileSystem.isHidden(this);
    }

    @Override
    public long lastModified() {
        return FileSystem.lastModified(this);
    }

    @Override
    public long length() {
        return FileSystem.getLength(this);
    }

    @Override
    public boolean createNewFile() throws IOException {
logger.log(Level.DEBUG, "createNewFile");
        return false;
    }

    @Override
    public boolean delete() {
logger.log(Level.DEBUG, "delete");
        return false;
    }

    @Override
    public void deleteOnExit() {
        logger.log(Level.DEBUG, "deleteOnExit");
    }

    @Override
    public String[] list() {
        return FileSystem.list(this);
    }

    @Override
    public String[] list(FilenameFilter filter) {
logger.log(Level.DEBUG, "list");
        return null;
    }

    @Override
    public XFile[] listFiles() {
logger.log(Level.DEBUG, "listFiles");
        return Arrays.stream(FileSystem.list(this)).map(XFile::new).toArray(XFile[]::new);
    }

    @Override
    public XFile[] listFiles(FilenameFilter filter) {
logger.log(Level.DEBUG, "listFiles");
        return Arrays.stream(FileSystem.list(this)).filter(f -> filter.accept(this, f)).map(XFile::new).toArray(XFile[]::new);
    }

    @Override
    public XFile[] listFiles(FileFilter filter) {
logger.log(Level.DEBUG, "listFiles");
        return Arrays.stream(FileSystem.list(this)).filter(f -> filter.accept(new File(this.getPath() + FileSystem.separatorChar + f))).map(XFile::new).toArray(XFile[]::new);
    }

    @Override
    public boolean mkdir() {
logger.log(Level.DEBUG, "mkdir");
        return false;
    }

    @Override
    public boolean mkdirs() {
logger.log(Level.DEBUG, "mkdirs");
        return false;
    }

    @Override
    public boolean renameTo(java.io.File dest) {
logger.log(Level.DEBUG, "renameTo");
        return false;
    }

    public boolean renameTo(XFile dest) {
        logger.log(Level.DEBUG, "renameTo");
        return false;
    }

    @Override
    public boolean setLastModified(long time) {
logger.log(Level.DEBUG, "setLastModified");
        return false;
    }

    @Override
    public boolean setReadOnly() {
logger.log(Level.DEBUG, "setReadOnly");
        return false;
    }

    @Override
    public int compareTo(File o) {
logger.log(Level.DEBUG, "compareTo");
        return 0;
    }

    public boolean equals(Object obj) {
logger.log(Level.DEBUG, "equals");
        return false;
    }

    public int hashCode() {
logger.log(Level.DEBUG, "hashCode");
        return 0;
    }

    public String toString() {
logger.log(Level.DEBUG, "toString");
        return null;
    }
}
