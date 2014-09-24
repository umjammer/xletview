package net.beiker.xletview.classloader;

import javassist.ClassMap;

/**
 *
 * @author Martin Sveden
 */
public class XletClassMap extends ClassMap{

	public XletClassMap(){
		put("java.io.File", "xjava.io.XFile");
		put("java.io.FileInputStream", "xjava.io.FileInputStream");
		put("java.io.FileOutputStream", "xjava.io.FileOutputStream");
		put("java.io.FileReader", "xjava.io.FileReader");
		put("java.io.FileWriter", "xjava.io.FileWriter");
		put("java.awt.Toolkit", "xjava.awt.Toolkit");
		put("java.lang.System", "xjava.lang.System");
		
	}

	public Object get(Object jvmClassName) {
		String name = toJavaName((String)jvmClassName);
		//System.out.println("checking " + name);
		if (name.startsWith("javax.tv.")){
			return toJvmName("xjavax.tv." + name.substring(9));
		}
		else{
			return super.get(jvmClassName);
		}
	}


}
