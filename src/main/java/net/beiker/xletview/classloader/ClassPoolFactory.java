package net.beiker.xletview.classloader;

import java.io.File;

import net.beiker.cake.Log;
import net.beiker.cake.Logger;

import javassist.ClassPool;
import javassist.NotFoundException;

/**
 * Have methods for creating instances of javassist.ClassPool
 * @author Martin Sveden
 */
class ClassPoolFactory {

	/** Debugging facility. */
	private final static Logger logger = Log.getLogger(ClassPoolFactory.class);
	
	/**
	 * Creates and returns a javassist.ClassPool
	 * @param classpath The classpaths to add to the ClassPool
	 * @return A new ClassPool
	 */
	public static final ClassPool getPool(String classpath){
		String[] s = classpath.split(File.pathSeparator);
		return getPool(s);
	}
	
	/**
	 * Creates and returns a javassist.ClassPool
	 * @param paths The classpaths to add to the ClassPool
	 * @return A new ClassPool
	 */
	public static final ClassPool getPool(String[] paths){
		ClassPool pool = new ClassPool(null);
		
		for (int i = 0; i < paths.length; i++) {
			try {
				pool.insertClassPath(paths[i]);
			} catch (NotFoundException e) {
				logger.warn("The extra classpath " + paths[i] + " was not found");

			}
		}	
		
		return pool;
	}

}
