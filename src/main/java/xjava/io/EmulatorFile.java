package xjava.io;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.getLogger;


/**
 * @author Martin Sveden
 */
public class EmulatorFile {

    private static final Logger logger = getLogger(EmulatorFile.class.getName());

    private static EmulatorFile ROOT = getRoot();

    private List<EmulatorFile> children;

    private EmulatorFile parent;

    /*
     * The name of this file
     */
    private String name;

    /*
     * The virtual absolute path
     */
    private String absolutePath;

    /*
     * The physical file we map to
     */
    private java.io.File realFile;


    private EmulatorFile() {
        children = new ArrayList<>();
    }

    static EmulatorFile getRoot() {
        if (ROOT == null) {
            ROOT = new EmulatorFile();
            ROOT.name = "";
            ROOT.absolutePath = "/";
        }
        return ROOT;
    }

    EmulatorFile(String name, java.io.File realFile) {
        this();
        this.parent = ROOT;
        this.name = name;
        this.realFile = realFile;

        this.absolutePath = FileSystem.separatorChar + name;

        java.io.File[] files = realFile.listFiles();
        if (files != null) {
            for (java.io.File file : files) {
//                addChild(new EmulatorFile(this, files[i]));
                new EmulatorFile(this, file);
            }
        }
        parent.addChild(this);
    }

    EmulatorFile(EmulatorFile parent, java.io.File realFile) throws IllegalArgumentException {
        this();
        if (parent == null || realFile == null || !realFile.exists()) {
            throw new IllegalArgumentException("the file did not exist");
        }

        this.parent = parent;

        this.name = realFile.getName();
        this.realFile = realFile;
        this.absolutePath = parent.getAbsolutePath() + FileSystem.separatorChar + realFile.getName();

        java.io.File[] files = realFile.listFiles();
        if (files != null) {
            for (java.io.File file : files) {
//                addChild(new EmulatorFile(this, files[i]));
                new EmulatorFile(this, file);
            }
        }
        parent.addChild(this);
    }


    /**
     * One file can only be added one time.
     *
     * @param file
     */
    void addChild(EmulatorFile file) {
        logger.log(Level.DEBUG, "addChild(" + file.getAbsolutePath() + ")");
        if (children.contains(file)) {
//            logger.log(Level.DEBUG, "child already exist");
            try {
                throw new IOException("child already exist");
            } catch (IOException e) {
                logger.log(Level.ERROR, e.getMessage(), e);
            }
        }

        children.add(file);

    }

    void removeChild(EmulatorFile file) {
        children.remove(file);
    }

    void removeAllChildren() {
        children.clear();
    }

//    void setParent(EmulatorFile parent){
//        this.parent = parent;
//    }

    EmulatorFile getParent() {
        return parent;
    }

    List<EmulatorFile> getChildren() {
        return children;
    }

    EmulatorFile getChild(String name) {
        EmulatorFile result = null;
        logger.log(Level.DEBUG, this.name + ", children.size() = " + children.size());
        for (EmulatorFile child : children) {
            EmulatorFile ef = child;
            String s = ef.getName();
            logger.log(Level.DEBUG, "checking in " + getName() + " if there is a child with the name " + name + ", child has name " + s);
            if (s.equals(name)) {
                result = ef;
                break;
            }
        }

        return result;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public String getName() {
        return name;
    }

//    void setRealFile(java.io.File file){
//        realFile = file;
//    }

    java.io.File getRealFile() {
        return realFile;
    }


}



