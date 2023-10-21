package net.beiker.xletview.classloader;

import java.io.File;
import java.util.logging.Logger;

import javassist.ClassPool;
import javassist.NotFoundException;

/**
 * Have methods for creating instances of javassist.ClassPool
 * @author Martin Sveden
 */
class ClassPoolFactory {

    /** Debugging facility. */
    private final static Logger logger = Logger.getLogger(ClassPoolFactory.class.getName());

    /**
     * Creates and returns a javassist.ClassPool
     * @param classpath The classpaths to add to the ClassPool
     * @return A new ClassPool
     */
    public static ClassPool getPool(String classpath){
        String[] s = classpath.split(File.pathSeparator);
        return getPool(s);
    }

    /**
     * Creates and returns a javassist.ClassPool
     * @param paths The classpaths to add to the ClassPool
     * @return A new ClassPool
     */
    public static ClassPool getPool(String[] paths){
        ClassPool pool = new ClassPool(null);

        for (String path : paths) {
            try {
                pool.insertClassPath(path);
            } catch (NotFoundException e) {
                logger.warning("The extra classpath " + path + " was not found");

            }
        }

        return pool;
    }

}
