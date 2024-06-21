package net.beiker.xletview.classloader;

import java.io.File;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

import javassist.ClassPool;
import javassist.NotFoundException;

import static java.lang.System.getLogger;


/**
 * Have methods for creating instances of javassist.ClassPool
 *
 * @author Martin Sveden
 */
class ClassPoolFactory {

    /** Debugging facility. */
    private final static Logger logger = getLogger(ClassPoolFactory.class.getName());

    /**
     * Creates and returns a javassist.ClassPool
     *
     * @param classpath The classpaths to add to the ClassPool
     * @return A new ClassPool
     */
    public static ClassPool getPool(String classpath) {
        String[] s = classpath.split(File.pathSeparator);
        return getPool(s);
    }

    /**
     * Creates and returns a javassist.ClassPool
     *
     * @param paths The classpaths to add to the ClassPool
     * @return A new ClassPool
     */
    public static ClassPool getPool(String[] paths) {
        ClassPool pool = new ClassPool(null);

        for (String path : paths) {
            try {
                pool.insertClassPath(path);
            } catch (NotFoundException e) {
                logger.log(Level.WARNING, "The extra classpath " + path + " was not found");

            }
        }

        return pool;
    }
}
